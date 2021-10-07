/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.area.bonarea.bonarea.mvc.database.dao;

import com.area.bonarea.bonarea.mvc.database.models.Direccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.enterprise.context.Dependent;

/**
 *
 * @author xavier.verges
 */
@Dependent
public class DireccionDaoImpl extends BaseDao<Direccion, Long> implements DireccionDao {

    private static final String TABLE = "direccion_verges";
    private static final String KEY_NAME = "id";
    private static final String INSERT_STATEMENT = "INSERT INTO " + TABLE
            + "(calle, poblacion, provincia) VALUES(?,?,?)";

    @Override
    protected Direccion getFromResultSet(ResultSet rs) throws SQLException {
        Direccion direccion = new Direccion();
        direccion.setId(rs.getLong("id"));
        direccion.setCalle(rs.getString("calle"));
        direccion.setPoblacion(rs.getString("poblacion"));
        direccion.setProvincia(rs.getString("provincia"));
        return direccion;
    }

    @Override
    public Direccion add(Direccion direccion) throws SQLException {
        long generatedKey = 0;
        try ( Connection con = this.getConnection();  PreparedStatement preparedInsert = con.prepareStatement(INSERT_STATEMENT,
                PreparedStatement.RETURN_GENERATED_KEYS)) {

            preparedInsert.setString(1, direccion.getCalle());
            preparedInsert.setString(2, direccion.getPoblacion());
            preparedInsert.setString(3, direccion.getProvincia());

            preparedInsert.executeUpdate();
            try ( ResultSet resultset = preparedInsert.getGeneratedKeys()) {
                while (resultset.next()) {
                    generatedKey = resultset.getLong(1);
                    direccion.setId(generatedKey);
                    System.out.println("Clave generada = " + generatedKey);
                }
            }
        }
        return this.getById(generatedKey);
    }

    @Override
    protected String getTableName() {
        return TABLE;
    }

    @Override
    protected String getKeyName() {
        return KEY_NAME;
    }
}
