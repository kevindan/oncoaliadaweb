/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import database.DataAccess;
import entity.Paciente;
import entity.Psa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PsaDao implements Intermetodos<Psa> {

    @Override
    public void Grabar(Psa o) throws Exception {
        Connection cn = null;
        try {
            cn = DataAccess.getConnection();
            cn.setAutoCommit(false);
            String sql = " insert into psa(paciente_id,psa_valor,descripcion, "
                    + " observacion, fecha_resultado) "
                    + " values(?,?,?,?,?) ";

            PreparedStatement pstm = cn.prepareStatement(sql);

            pstm.setInt(1, o.getPaciente_id());
            pstm.setInt(2, o.getPsa_valor());
            pstm.setString(3, o.getDescripcion());
            pstm.setString(4, o.getObservacion());
            pstm.setString(5, o.getFecha_resultado());

            pstm.executeUpdate();

            pstm.close();

            cn.commit();

        } catch (Exception e) {
            try {
                cn.rollback();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            throw e;
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void Modificar(Psa o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Eliminar(Psa o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Psa> Listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Psa> Filtrar(Psa o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Psa> ListarVista(Paciente o) throws Exception {
        Connection cn = null;
        List<Psa> lista = new ArrayList<Psa>();
        try {
            // conexion a la base de datos
            cn = DataAccess.getConnection();
            //comando sql
            String sql = " select psa_id, psa_valor, descripcion, observacion, fecha_resultado "
                    + " from psa "
                    + " where paciente_id = ? and activo = 1 order by fecha_resultado asc ";

            // crear statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            // crear parametro y asignar valor
            pstm.setInt(1, o.getPaciente_id());
            // ejecutar comando y obtener resultados
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Psa psa = new Psa();
                //asignar valores al objeto r
                psa.setPsa_id(rs.getInt("psa_id"));
                psa.setPsa_valor(rs.getInt("psa_valor"));
                psa.setDescripcion(rs.getString("descripcion"));
                psa.setObservacion(rs.getString("observacion"));
                psa.setFecha_resultado(rs.getString("fecha_resultado"));

                lista.add(psa);
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
    public Psa Buscar(Psa o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
