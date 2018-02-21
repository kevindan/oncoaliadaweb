package dao;

import database.DataAccess;
import entity.CategoriaCieo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoriaCieoDao implements Intermetodos<CategoriaCieo> {

    @Override
    public void Grabar(CategoriaCieo o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Modificar(CategoriaCieo o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Eliminar(CategoriaCieo o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CategoriaCieo> Listar() throws Exception {
        Connection cn = null;
        List<CategoriaCieo> lista = new ArrayList<CategoriaCieo>();
        try {
            // conexion a la base de datos
            cn = DataAccess.getConnection();
            //comando sql
            String sql = " select categoria_id, categoria from categoria_cieo "
                    + " where activo = 1 order by categoria_id asc ";
            // crear statement
            Statement stm = cn.createStatement();
            // ejecutar comando y obtener resultados
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                CategoriaCieo c = new CategoriaCieo();
                //asignar valores al objeto r
                c.setCategoria_id(rs.getString("categoria_id"));
                c.setCategoria(rs.getString("categoria"));
                lista.add(c);
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
    public List<CategoriaCieo> Filtrar(CategoriaCieo o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CategoriaCieo Buscar(CategoriaCieo o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
