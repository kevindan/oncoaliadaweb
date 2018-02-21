package dao;

import database.DataAccess;
import entity.Distrito;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DistritoDao implements Intermetodos<Distrito> {

    @Override
    public void Grabar(Distrito o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Modificar(Distrito o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Eliminar(Distrito o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Distrito> Listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Distrito> Filtrar(Distrito o) throws Exception {
        Connection cn = null;
        List<Distrito> lista = new ArrayList<Distrito>();
        try {
            // conexion a la base de datos
            cn = DataAccess.getConnection();
            //comando sql
            String sql = " select codigo_distrito, distrito from distrito "
                    + " where codigo_departamento = ? and codigo_provincia = ? order by codigo_distrito asc ";
            // crear statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            // crear parametro y asignar valor
            pstm.setString(1, o.getCodigo_departamento());
            pstm.setString(2, o.getCodigo_provincia());
            // ejecutar comando y obtener resultados
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Distrito d = new Distrito();
                //asignar valores al objeto r
                d.setCodigo_distrito(rs.getString("codigo_distrito"));
                d.setDistrito(rs.getString("distrito"));

                lista.add(d);
            }
            // cerrar cursor
            rs.close();
            pstm.close();
            cn.close();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                // cn.close();
            } catch (Exception e) {
            }
        }
        return lista;
    }

    @Override
    public Distrito Buscar(Distrito o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
