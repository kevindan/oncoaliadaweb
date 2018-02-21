package dao;

import database.DataAccess;
import entity.Grupo_tumor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Grupo_tumorDao implements Intermetodos<Grupo_tumor> {

    @Override
    public void Grabar(Grupo_tumor o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Modificar(Grupo_tumor o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Eliminar(Grupo_tumor o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Grupo_tumor> Listar() throws Exception {
        Connection cn = null;
        List<Grupo_tumor> lista = new ArrayList<Grupo_tumor>();
        try {
            // conexion a la base de datos
            cn = DataAccess.getConnection();
            //comando sql
            String sql = " select grupo_tumor_id, grupo_tumor from grupo_tumor "
                    + " where estado = 1 order by grupo_tumor_id asc ";
            // crear statement
            Statement stm = cn.createStatement();
            // ejecutar comando y obtener resultados
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Grupo_tumor g = new Grupo_tumor();
                //asignar valores al objeto r
                g.setGrupo_tumor_id(rs.getInt("grupo_tumor_id"));
                g.setGrupo_tumor(rs.getString("grupo_tumor"));

                lista.add(g);
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
    public List<Grupo_tumor> Filtrar(Grupo_tumor o) throws Exception {
        return null;
    }

    @Override
    public Grupo_tumor Buscar(Grupo_tumor o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
