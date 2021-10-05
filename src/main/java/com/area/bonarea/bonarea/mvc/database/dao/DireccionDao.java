/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.area.bonarea.bonarea.mvc.database.dao;

import com.area.bonarea.bonarea.mvc.database.models.Direccion;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author xavier.verges
 */
public interface DireccionDao {

    Direccion getById(Long direccionId) throws SQLException;

    List<Direccion> getAll() throws SQLException;

    Direccion add(Direccion direccion) throws SQLException;
}
