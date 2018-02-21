/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import database.DataAccess;
import entity.HistoriaClinica_Pro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class HistoriaClinica_ProDao implements Intermetodos<HistoriaClinica_Pro> {

    @Override
    public void Grabar(HistoriaClinica_Pro o) throws Exception {
        Connection cn = null;
        try {
            cn = DataAccess.getConnection();
            cn.setAutoCommit(false);
            String sql = " insert into hc_prostata(paciente_id,fecha_diag_histologico, histologia_id, "
                    + " numero_sitios_metastasicos,psa,gleason,grupo_riesgo_id,tratamiento_inicial_id,localizacion_metastasis_id, "
                    + " fecha_ultimo_control) "
                    + " values(?,?,?,?,?,?,?,?,?,?) ";

            PreparedStatement pstm = cn.prepareStatement(sql);

            pstm.setInt(1, o.getPaciente_id());
            pstm.setString(2, o.getFecha_diag_histologico());
            pstm.setInt(3, o.getHistologia_id());
            pstm.setInt(4, o.getNumero_sitios_metastasicos());
            pstm.setInt(5, o.getPsa());
            pstm.setInt(6, o.getGleason());
            pstm.setInt(7, o.getGrupo_riesgo_id());
            pstm.setInt(8, o.getTratamiento_inicial_id());
            pstm.setInt(9, o.getLocalizacion_metastasis_id());
            pstm.setString(10, o.getFecha_ultimo_control());

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
    public void Modificar(HistoriaClinica_Pro o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Eliminar(HistoriaClinica_Pro o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HistoriaClinica_Pro> Listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HistoriaClinica_Pro> Filtrar(HistoriaClinica_Pro o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HistoriaClinica_Pro Buscar(HistoriaClinica_Pro o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
