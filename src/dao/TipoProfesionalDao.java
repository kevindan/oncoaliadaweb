package dao;

import database.DataAccess;
import entity.TipoProfesional;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TipoProfesionalDao implements Intermetodos<TipoProfesional> {

    @Override
    public void Grabar(TipoProfesional o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Modificar(TipoProfesional o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Eliminar(TipoProfesional o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoProfesional> Listar() throws Exception {
        Connection cn = null;
        List<TipoProfesional> lista = new ArrayList<TipoProfesional>();
        try {
            // conexion a la base de datos
            cn = DataAccess.getConnection();
            //comando sql
            String sql = " select tipo_profesional_id, descripcion from tipo_profesional "
                    + " where eliminado = 0 order by tipo_profesional_id asc ";
            // crear statement
            Statement stm = cn.createStatement();
            // ejecutar comando y obtener resultados
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                TipoProfesional tp = new TipoProfesional();
                //asignar valores al objeto r
                tp.setTipo_profesional_id(rs.getString("tipo_profesional_id"));
                tp.setDescripcion(rs.getString("descripcion"));
                lista.add(tp);
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
    public List<TipoProfesional> Filtrar(TipoProfesional o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipoProfesional Buscar(TipoProfesional o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
