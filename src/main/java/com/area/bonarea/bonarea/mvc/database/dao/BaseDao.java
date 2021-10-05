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
public abstract class BaseDao<T> {
    
    private final static String CONNECTIONSTRING
            = "jdbc:mysql://ba60efaf494dd2:e757a8f8@eu-cdbr-west-01.cleardb.com/heroku_c2a7aa794927668?reconnect=true";
    private final static String USER = "ba60efaf494dd2";
    private final static String PWD = "e757a8f8";

    private static final Logger LOG = Logger.getLogger(BaseDao.class.getName());
    
    private final String GET_ALL_STATEMENT = "SELECT * FROM " + this.getTableName();

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            LOG.log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    protected abstract String getTableName();
    
    abstract protected T getFromResultSet(ResultSet rs) throws SQLException;
    
    public List<T> getAll() throws SQLException {
        List<T> llista = new ArrayList<>();
        try ( Connection cn = DriverManager.getConnection(CONNECTIONSTRING, USER, PWD);  PreparedStatement ps = cn.prepareStatement(GET_ALL_STATEMENT);  ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                llista.add(this.getFromResultSet(rs));
            }
        }
        return llista;
    }
}
