package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.DataAccess;
import entity.Tipo_diagnostico;

public class Tipo_diagnosticoDao implements Intermetodos<Tipo_diagnostico>{

	@Override
	public void Grabar(Tipo_diagnostico o) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Eliminar(Tipo_diagnostico o) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Modificar(Tipo_diagnostico o) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Tipo_diagnostico> Listar() throws Exception {
		
		Connection cn = null;
		List<Tipo_diagnostico> lista = new ArrayList<Tipo_diagnostico>();
		try {
			// conexion a la base de datos
			cn = DataAccess.getConnection();
			// comando sql
			String sql = " select tipo_diagnostico_id, tipo_diagnostico"
					+ " from tipo_diagnostico where eliminado = 0 order by tipo_diagnostico_id asc";
			// crear statement
			Statement stm = cn.createStatement();
			// ejecutar comando y obtener resultados
			ResultSet rs = stm.executeQuery(sql);
			
			while (rs.next()) {
				Tipo_diagnostico tp = new Tipo_diagnostico();
				// asignar valores al objeto r
				tp.setTipo_diagnostico_id(rs.getInt("tipo_diagnostico_id"));
				tp.setTipo_diagnostico(rs.getString("tipo_diagnostico"));
				
				lista.add(tp);
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
				e.printStackTrace();
			}
		}
		return lista;
	}

	@Override
	public List<Tipo_diagnostico> Filtrar(Tipo_diagnostico o) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tipo_diagnostico Buscar(Tipo_diagnostico o) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
