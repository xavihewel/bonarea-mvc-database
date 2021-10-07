/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.area.bonarea.bonarea.mvc.database.dao;

import com.area.bonarea.bonarea.mvc.database.models.Persona;
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
public class PersonaDaoImpl extends BaseDao<Persona, Long> implements PersonaDao {

    private static final String TABLE = "persona_verges";
    private static final String KEY_NAME = "id";
    private static final String INSERT_STATEMENT = "INSERT INTO " + TABLE
            + "(nombre, apellidos, dni) VALUES(?,?,?)";

    @Override
    protected Persona getFromResultSet(ResultSet rs) throws SQLException {
        Persona persona = new Persona();
        persona.setId(rs.getLong("id"));
        persona.setNombre(rs.getString("nombre"));
        persona.setApellidos(rs.getString("apellidos"));
        persona.setDni(rs.getString("dni"));
        return persona;
    }

    @Override
    public Persona add(Persona persona) throws SQLException {
        long generatedKey = 0;
        try ( Connection con = this.getConnection();  PreparedStatement preparedInsert = con.prepareStatement(INSERT_STATEMENT,
                PreparedStatement.RETURN_GENERATED_KEYS)) {

            preparedInsert.setString(1, persona.getNombre());
            preparedInsert.setString(2, persona.getApellidos());
            preparedInsert.setString(3, persona.getDni());

            preparedInsert.executeUpdate();
            try ( ResultSet resultset = preparedInsert.getGeneratedKeys()) {
                while (resultset.next()) {
                    generatedKey = resultset.getLong(1);
                    persona.setId(generatedKey);
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
