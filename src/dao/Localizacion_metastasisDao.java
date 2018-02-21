/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import database.DataAccess;
import entity.Localizacion_metastasis;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class Localizacion_metastasisDao implements Intermetodos<Localizacion_metastasis> {

    @Override
    public void Grabar(Localizacion_metastasis o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Modificar(Localizacion_metastasis o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Eliminar(Localizacion_metastasis o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Localizacion_metastasis> Listar() throws Exception {
        Connection cn = null;
        List<Localizacion_metastasis> lista = new ArrayList<Localizacion_metastasis>();
        try {
            // conexion a la base de datos
            cn = DataAccess.getConnection();
            //comando sql
            String sql = " select localizacion_metastasis_id, localizacion_metastasis from localizacion_metastasis "
                    + " where eliminado = 0 order by localizacion_metastasis_id asc ";
            // crear statement
            Statement stm = cn.createStatement();
            // ejecutar comando y obtener resultados
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Localizacion_metastasis localizacion_metastasis = new Localizacion_metastasis();
                //asignar valores al objeto r
                localizacion_metastasis.setLocalizacion_metastasis_id(rs.getInt("localizacion_metastasis_id"));
                localizacion_metastasis.setLocalizacion_metastasis(rs.getString("localizacion_metastasis"));
                lista.add(localizacion_metastasis);
            }
            // cerrar cursor
            rs.close();
            stm.close();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
        return lista;
    }

    @Override
    public List<Localizacion_metastasis> Filtrar(Localizacion_metastasis o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Localizacion_metastasis Buscar(Localizacion_metastasis o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
