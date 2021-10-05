/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.area.bonarea.bonarea.mvc.database.dao;

import com.area.bonarea.bonarea.mvc.database.models.Persona;
import java.sql.SQLException;
import java.util.List;
import javax.enterprise.context.Dependent;

/**
 *
 * @author xavier.verges
 */
@Dependent
public class PersonaDaoImpl implements PersonaDao {

    @Override
    public Persona getById(Long personaId) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Persona> getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Persona add(Persona persona) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
