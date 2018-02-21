/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import database.DataAccess;
import entity.Respuesta_tratamiento;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class Respuesta_tratamientoDao implements Intermetodos<Respuesta_tratamiento> {

    @Override
    public void Grabar(Respuesta_tratamiento o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Modificar(Respuesta_tratamiento o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Eliminar(Respuesta_tratamiento o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Respuesta_tratamiento> Listar() throws Exception {
        Connection cn = null;
        List<Respuesta_tratamiento> lista = new ArrayList<Respuesta_tratamiento>();
        try {
            // conexion a la base de datos
            cn = DataAccess.getConnection();
            //comando sql
            String sql = " select respuesta_tratamiento_id, respuesta_tratamiento from respuesta_tratamiento "
                    + " where activo = 1 order by respuesta_tratamiento_id asc ";
            // crear statement
            Statement stm = cn.createStatement();
            // ejecutar comando y obtener resultados
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Respuesta_tratamiento r = new Respuesta_tratamiento();
                //asignar valores al objeto r
                r.setRespuesta_tratamiento_id(rs.getInt("respuesta_tratamiento_id"));
                r.setRespuesta_tratamiento(rs.getString("respuesta_tratamiento"));
                lista.add(r);
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
            }
        }
        return lista;

    }

    @Override
    public List<Respuesta_tratamiento> Filtrar(Respuesta_tratamiento o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Respuesta_tratamiento Buscar(Respuesta_tratamiento o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
