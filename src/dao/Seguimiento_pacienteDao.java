package dao;

import database.DataAccess;
import entity.Paciente;
import entity.Seguimiento_paciente;
import entity.Seguimiento_pacienteView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Seguimiento_pacienteDao implements Intermetodos<Seguimiento_paciente> {

    @Override
    public void Grabar(Seguimiento_paciente o) throws Exception {
        Connection cn = null;
        try {
            cn = DataAccess.getConnection();
            cn.setAutoCommit(false);
            String sql = " insert into seguimiento_paciente(paciente_id,tratamiento_id, "
                    + " fecha, respuesta_tratamiento_id, observacion) "
                    + " values(?,?,?,?,?) ";

            PreparedStatement pstm = cn.prepareStatement(sql);

            pstm.setInt(1, o.getPaciente_id());
            pstm.setInt(2, o.getTratamiento_id());
            pstm.setString(3, o.getFecha());
            pstm.setInt(4, o.getRespuesta_tratamiento_id());
            pstm.setString(5, o.getObservacion());

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
    public void Modificar(Seguimiento_paciente o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Eliminar(Seguimiento_paciente o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Seguimiento_paciente> Listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Seguimiento_pacienteView> ListarVista(Paciente o) throws Exception {

        Connection cn = null;
        List<Seguimiento_pacienteView> lista = new ArrayList<Seguimiento_pacienteView>();
        try {
            // conexion a la base de datos
            cn = DataAccess.getConnection();
            //comando sql
            String sql = " select seguimiento_paciente.seguimiento_paciente_id, "
                    + " tratamiento.tratamiento, respuesta_tratamiento.respuesta_tratamiento, "
                    + " seguimiento_paciente.fecha, seguimiento_paciente.observacion "
                    + " from seguimiento_paciente, tratamiento, respuesta_tratamiento,paciente "
                    + " where seguimiento_paciente.tratamiento_id = tratamiento.tratamiento_id and "
                    + " seguimiento_paciente.respuesta_tratamiento_id = respuesta_tratamiento.respuesta_tratamiento_id and "
                    + " seguimiento_paciente.paciente_id = paciente.paciente_id and "
                    + " seguimiento_paciente.activo = 1 and seguimiento_paciente.paciente_id = ? order by seguimiento_paciente.fecha asc ";

            // crear statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            // crear parametro y asignar valor
            pstm.setInt(1, o.getPaciente_id());
            // ejecutar comando y obtener resultados
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Seguimiento_pacienteView s = new Seguimiento_pacienteView();
                //asignar valores al objeto r
                s.setSeguimiento_id(rs.getInt("seguimiento_paciente_id"));
                s.setTratamiento(rs.getString("tratamiento"));
                s.setRespuesta_tratamiento(rs.getString("respuesta_tratamiento"));
                s.setFecha(rs.getString("fecha"));
                s.setObservacion(rs.getString("observacion"));

                lista.add(s);
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
    public List<Seguimiento_paciente> Filtrar(Seguimiento_paciente o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Seguimiento_paciente Buscar(Seguimiento_paciente o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
