/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.area.bonarea.bonarea.mvc.database.services;

import com.area.bonarea.bonarea.mvc.database.models.Persona;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author xavier.verges
 */
public interface PersonaServices {

    Persona add(Persona persona) throws SQLException;

    Persona getById(long personaId) throws SQLException;

    List<Persona> getAll() throws SQLException;
}
