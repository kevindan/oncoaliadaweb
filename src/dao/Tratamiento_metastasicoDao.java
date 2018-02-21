package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.DataAccess;
import entity.Tratamiento_metastasico;

public class Tratamiento_metastasicoDao implements Intermetodos<Tratamiento_metastasico>{

	@Override
	public void Grabar(Tratamiento_metastasico o) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Eliminar(Tratamiento_metastasico o) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Modificar(Tratamiento_metastasico o) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Tratamiento_metastasico> Listar() throws Exception {
		
		 Connection cn = null;
		 List<Tratamiento_metastasico> lista = new ArrayList<Tratamiento_metastasico>();
		  
		  try {
	            
	            cn = DataAccess.getConnection();
	            
	            String sql = " select tratamiento_metastasico_id, tratamiento_metastasico from tratamiento_metastasico "
	                    + " where estado = 1 order by tratamiento_metastasico_id asc ";
	            
	            Statement stm = cn.createStatement();
	            
	            ResultSet rs = stm.executeQuery(sql);
	            while (rs.next()) {
	                Tratamiento_metastasico tm = new Tratamiento_metastasico();
	
	                tm.setTratamiento_metastasico_id(rs.getInt("tratamiento_metastasico_id"));
	                tm.setTratamiento_metastasico(rs.getString("tratamiento_metastasico"));
	                
	                lista.add(tm);
	            }
	            
	            rs.close();
	            stm.close();
	            
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
	public List<Tratamiento_metastasico> Filtrar(Tratamiento_metastasico o) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tratamiento_metastasico Buscar(Tratamiento_metastasico o) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
