/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.area.bonarea.bonarea.mvc.database.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author xavier.verges
 */
public abstract class BaseDao<T, S> {

    private final static String CONNECTIONSTRING
            = "jdbc:mysql://ba60efaf494dd2:e757a8f8@eu-cdbr-west-01.cleardb.com/heroku_c2a7aa794927668?reconnect=true";
    private final static String USER = "ba60efaf494dd2";
    private final static String PWD = "e757a8f8";

    private static final Logger LOG = Logger.getLogger(BaseDao.class.getName());

    private final String GET_ALL_STATEMENT = "SELECT * FROM " + this.getTableName();

    private final String GET_BY_ID_STATEMENT = "SELECT * FROM " + this.getTableName()
            + " WHERE " + this.getKeyName() + "=?";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            LOG.log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    protected abstract String getTableName();

    protected abstract String getKeyName();

    abstract protected T getFromResultSet(ResultSet rs) throws SQLException;

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CONNECTIONSTRING, USER, PWD);
    }

    public List<T> getAll() throws SQLException {
        List<T> llista = new ArrayList<>();
        try ( Connection cn = this.getConnection();  PreparedStatement ps = cn.prepareStatement(GET_ALL_STATEMENT);  ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                llista.add(this.getFromResultSet(rs));
            }
        }
        return llista;
    }

    private PreparedStatement getByIdPreparedStatement(Connection con, S id) throws SQLException {
        PreparedStatement ps = con.prepareStatement(GET_BY_ID_STATEMENT);
        if (id instanceof String) {
            ps.setString(1, (String) id);
        } else if (id instanceof Long) {
            ps.setLong(1, (Long) id);
        } else if (id instanceof Integer) {
            ps.setInt(1, (Integer) id);
        }
        return ps;
    }

    public T getById(S id) throws SQLException {
        T obj = null;
        try ( Connection cn = this.getConnection();  PreparedStatement ps = this.getByIdPreparedStatement(cn, id);  ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                obj = this.getFromResultSet(rs);
            }
        }
        return obj;
    }
}
