/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.area.bonarea.bonarea.mvc.database.services;

import com.area.bonarea.bonarea.mvc.database.dao.PersonaDao;
import com.area.bonarea.bonarea.mvc.database.models.Persona;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

/**
 *
 * @author xavier.verges
 */
@Dependent
public class PersonaServicesImpl implements PersonaServices {

    private static final Logger LOG = Logger.getLogger(PersonaServicesImpl.class.getName());

    @Inject
    private PersonaDao personaDao;

    @Override
    public Persona add(Persona persona) throws SQLException {
        return this.personaDao.add(persona);
    }

    @Override
    public Persona getById(long personaId) throws SQLException {
        return this.personaDao.getById(personaId);
    }

    @Override
    public List<Persona> getAll() throws SQLException {
        return this.personaDao.getAll();
    }
}
