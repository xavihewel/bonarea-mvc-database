/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.area.bonarea.bonarea.mvc.database.dao;

import com.area.bonarea.bonarea.mvc.database.models.Direccion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.enterprise.context.Dependent;

/**
 *
 * @author xavier.verges
 */
@Dependent
public class DireccionDaoImpl extends BaseDao<Direccion> implements DireccionDao {

    private static final String TABLE = "direccion_verges";
    private static final String SQL_GETBYID = "SELECT * FROM " + TABLE
            + "WHERE ID=?";
    private static final String SQL_GETALL = "SELECT * FROM " + TABLE;
    private static final String SQL_ADD = "INSERT INTO " + TABLE
            + "(calle, poblacion, provincia) VALUES(?,?,?)";
    
    @Override
    protected Direccion getFromResultSet(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Direccion getById(Long direccionId) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Direccion> getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Direccion add(Direccion direccion) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    


}
