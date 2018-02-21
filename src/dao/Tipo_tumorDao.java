package dao;

import database.DataAccess;
import entity.Tipo_tumor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Tipo_tumorDao implements Intermetodos<Tipo_tumor> {

    @Override
    public void Grabar(Tipo_tumor o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Modificar(Tipo_tumor o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Eliminar(Tipo_tumor o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tipo_tumor> Listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tipo_tumor> Filtrar(Tipo_tumor o) throws Exception {
        Connection cn = null;
        List<Tipo_tumor> lista = new ArrayList<Tipo_tumor>();
        try {
            // conexion a la base de datos
            cn = DataAccess.getConnection();
            //comando sql
            String sql = " select tipo_tumor_id, tipo_tumor, grupo_tumor_id  "
                    + " from tipo_tumor where grupo_tumor_id = ? and estado = 1 order by tipo_tumor_id asc ";
            // crear statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            // crear parametro y asignar valor
            pstm.setInt(1, o.getGrupo_tumor_id());

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {

                Tipo_tumor t = new Tipo_tumor();
                //asignar valores al objeto r
                t.setTipo_tumor_id(rs.getInt("tipo_tumor_id"));
                t.setTipo_tumor(rs.getString("tipo_tumor"));
                t.setGrupo_tumor_id(rs.getInt("grupo_tumor_id"));

                lista.add(t);
            }
            // cerrar cursor
            rs.close();
            pstm.close();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return lista;
    }

    @Override
    public Tipo_tumor Buscar(Tipo_tumor o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
