package dao;

import database.DataAccess;
import entity.Provincia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProvinciaDao implements Intermetodos<Provincia> {

    @Override
    public void Grabar(Provincia o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Modificar(Provincia o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Eliminar(Provincia o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Provincia> Listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Provincia> Filtrar(Provincia o) throws Exception {
        Connection cn = null;
        List<Provincia> lista = new ArrayList<Provincia>();
        try {
            // conexion a la base de datos
            cn = DataAccess.getConnection();
            //comando sql
            String sql = " select codigo_provincia, provincia from provincia "
                    + " where codigo_departamento = ? order by codigo_provincia asc ";
            // crear statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            // crear parametro y asignar valor
            pstm.setString(1, o.getCodigo_departamento());
            // ejecutar comando y obtener resultados
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Provincia p = new Provincia();
                //asignar valores al objeto r
                p.setCodigo_provincia(rs.getString("codigo_provincia"));
                p.setProvincia(rs.getString("provincia"));

                lista.add(p);
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
    public Provincia Buscar(Provincia o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
