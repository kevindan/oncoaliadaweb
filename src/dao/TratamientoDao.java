/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import database.DataAccess;
import entity.Tratamiento;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class TratamientoDao implements Intermetodos<Tratamiento> {

    @Override
    public void Grabar(Tratamiento o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Modificar(Tratamiento o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Eliminar(Tratamiento o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @SuppressWarnings("finally")
	@Override
    public List<Tratamiento> Listar() throws Exception {
        Connection cn = null;
        List<Tratamiento> lista = new ArrayList<Tratamiento>();
        try {
            // conexion a la base de datos
            cn = DataAccess.getConnection();
            //comando sql
            String sql = " select tratamiento_id, tratamiento from tratamiento "
                    + " where estado = 1 order by tratamiento_id asc ";
            // crear statement
            Statement stm = cn.createStatement();
            // ejecutar comando y obtener resultados
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Tratamiento tratamiento = new Tratamiento();
                //asignar valores al objeto r
                tratamiento.setTratamiento_id(rs.getInt("tratamiento_id"));
                tratamiento.setTratamiento(rs.getString("tratamiento"));
                lista.add(tratamiento);
            }
            // cerrar cursor
            rs.close();
            stm.close();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                cn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return lista;
        }
    }

    @Override
    public List<Tratamiento> Filtrar(Tratamiento o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tratamiento Buscar(Tratamiento o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
