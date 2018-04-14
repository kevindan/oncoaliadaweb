package dao;

import database.DataAccess;
import entity.Diagnostico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DiagnosticoDao implements Intermetodos<Diagnostico> {

    @Override
    public void Grabar(Diagnostico o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Modificar(Diagnostico o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Eliminar(Diagnostico o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Diagnostico> Listar() throws Exception {
        Connection cn = null;
        List<Diagnostico> lista = new ArrayList<Diagnostico>();
        try {
            // conexion a la base de datos
            cn = DataAccess.getConnection();
            //comando sql
            String sql = " select codigo_cieo, descripcion, categoria_id from diagnostico "
                    + " where eliminado = 0 order by codigo_cieo asc ";
            // crear statement
            Statement stm = cn.createStatement();
            // ejecutar comando y obtener resultados
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Diagnostico d = new Diagnostico();
                //asignar valores al objeto r
                d.setCodigo_cieo(rs.getString("codigo_cieo"));
                d.setDescripcion(rs.getString("descripcion"));
                d.setCategoria_id(rs.getString("categoria_id"));
                lista.add(d);
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
    
    public List<Diagnostico> ListarCieoProstata() throws Exception {
        Connection cn = null;
        List<Diagnostico> lista = new ArrayList<Diagnostico>();
        try {
            // conexion a la base de datos
            cn = DataAccess.getConnection();
            //comando sql
            String sql = " select codigo_cieo, descripcion, categoria_id from diagnostico "
                    + " where codigo_cieo in ('C61.X','D07.5','D29.1','D40.0') " 
                    + "  and eliminado = 0 order by codigo_cieo asc ";
            // crear statement
            Statement stm = cn.createStatement();
            // ejecutar comando y obtener resultados
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Diagnostico d = new Diagnostico();
                //asignar valores al objeto r
                d.setCodigo_cieo(rs.getString("codigo_cieo"));
                d.setDescripcion(rs.getString("descripcion"));
                d.setCategoria_id(rs.getString("categoria_id"));
                lista.add(d);
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
    public List<Diagnostico> Filtrar(Diagnostico o) throws Exception {
        Connection cn = null;
        List<Diagnostico> lista = new ArrayList<Diagnostico>();
        try {
            // conexion a la base de datos
            cn = DataAccess.getConnection();
            //comando sql
            String sql = " select codigo_cieo, descripcion, categoria_id from diagnostico "
                    + " where descripcion like ? and eliminado = 0 ";
            // crear statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            // crear parametro y asignar valor
            pstm.setString(1, "%" + o.getDescripcion() + "%");
            // ejecutar comando y obtener resultados
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Diagnostico d = new Diagnostico();
                //asignar valores al objeto r
                d.setCodigo_cieo(rs.getString("codigo_cieo"));
                d.setDescripcion(rs.getString("descripcion"));
                d.setCategoria_id(rs.getString("categoria_id"));

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
    public Diagnostico Buscar(Diagnostico o) throws Exception {
        Connection cn = null;
        Diagnostico d = new Diagnostico();
        try {
            cn = DataAccess.getConnection();

            String sql = " select codigo_cieo,descripcion,categoria_id from diagnostico "
                    + " where codigo_cieo = ? and eliminado = 0 ";

            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, o.getCodigo_cieo());
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {

                d.setCodigo_cieo(rs.getString("codigo_cieo"));
                d.setDescripcion(rs.getString("descripcion"));
                d.setCategoria_id(rs.getString("categoria_id"));

            }
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
        return d;
    }

}
