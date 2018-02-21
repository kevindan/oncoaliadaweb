package dao;

import database.DataAccess;
import entity.Grupo_riesgo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Grupo_riesgoDao implements Intermetodos<Grupo_riesgo> {

    @Override
    public void Grabar(Grupo_riesgo o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Modificar(Grupo_riesgo o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Eliminar(Grupo_riesgo o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Grupo_riesgo> Listar() throws Exception {
       
    	return null;
    	
    }

    @Override
    public List<Grupo_riesgo> Filtrar(Grupo_riesgo o) throws Exception {
    	 Connection cn = null;
	        List<Grupo_riesgo> lista = new ArrayList<Grupo_riesgo>();
	        try {
	            // conexion a la base de datos
	            cn = DataAccess.getConnection();
	            //comando sql
	            String sql ="select "
	            		+ " grupo_riesgo_id, "
	            		+ "grupo_riesgo, "
	            		+ "tipo_diagnostico_id "
	            		+ "   from grupo_riesgo "
	            		+ " where tipo_diagnostico_id = ? "
	            		+ " and eliminado = 0 order by grupo_riesgo_id asc";
	       
	            PreparedStatement pstm = cn.prepareStatement(sql);
	        
	            pstm.setInt(1, o.getTipo_diagnostico_id());
	           
	            ResultSet rs = pstm.executeQuery();

	            while (rs.next()) {

	            	Grupo_riesgo g = new Grupo_riesgo();
		
					g.setGrupo_riesgo_id(rs.getInt("grupo_riesgo_id"));
					g.setGrupo_riesgo(rs.getString("grupo_riesgo"));
					g.setTipo_diagnostico_id(rs.getInt("tipo_diagnostico_id"));
								
					lista.add(g);
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
	        return lista;
    }

    @Override
    public Grupo_riesgo Buscar(Grupo_riesgo o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
