/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.area.bonarea.bonarea.mvc.database.dao;

import com.area.bonarea.bonarea.mvc.database.models.Persona;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author xavier.verges
 */
public interface PersonaDao {

    Persona getById(Long personaId) throws SQLException;

    List<Persona> getAll() throws SQLException;

    Persona add(Persona persona) throws SQLException;
}
