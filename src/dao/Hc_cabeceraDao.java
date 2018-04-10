package dao;

import database.DataAccess;
import entity.Hc_cabecera;
import entity.Hc_cabeceraVista;
import entity.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Hc_cabeceraDao implements Intermetodos<Hc_cabecera> {

	@Override
	public void Grabar(Hc_cabecera o) throws Exception {
		
		Connection cn = null;
		
		try {
			
			cn = DataAccess.getConnection();
			
			cn.setAutoCommit(false);
			
			String sql = " insert into hc_cabecera("
					+ " paciente_id, antecedente_raza,raza_id, antecedente_familiar,descripcion_familiar, antecedente_genes, antecedente_alimentacion, "
					+ " antecedente_obesidad,imc, antecedente_exposicion_trabajo, antecedente_exposicion_trabajo_detalle,"
					+ " antecedente_its, antecedente_sustancia, sustancia_descripcion, antecedente_prostatitis, antecedente_neoplasia, antecedente_neoplasia_cieo, "
					+ " psa_debut, histologia_id, histologia_especificacion, fecha_diagnostico_histologico, tipo_diagnostico_id, grupo_riesgo_id, gleason_mayor, "
					+ " gleason_menor, gleason_total, categoria_t, categoria_t_patologico, categoria_n, categoria_m, categoria_n_patologico,categoria_m_patologico,estadio,tratamiento_inicial,tratamiento_inicial_otros ,eco_paciente, "
					+ " fecha_ultimo_control, fecha_falla_bioquimica, psa_falla_bioquimica, tratamiento_falla_bioquimica, fecha_enfermedad_metastasica, "
					+ " psa_enfermedad_metastasica, sintomatico_enfermedad_metastasica, enfermedad_metastasica_oligometastasico, organo_enfermedad_metastasica, "
					+ " tratamiento_enfermedad_metastasica, tecnica_radioterapia_enfermedad_metastasica, dosis_radioterapia_enfermedad_metastasica, "
					+ " fecha_segunda_enfermedad_progresiva, psa_segunda_enfermedad_progresiva, sintomatico_segunda_enfermedad_progresiva, "
					+ " segunda_enfermedad_progresiva_oligometastasico, organo_segunda_enfermedad_progresiva, tratamiento_segunda_enfermedad_progresiva, "
					+ " tecnica_radioterapia_segunda_enfermedad_progresiva, dosis_radioterapia_segunda_enfermedad_progresiva, fecha_tercera_enfermedad_progresiva, "
					+ " psa_tercera_enfermedad_progresiva, sintomatico_tercera_enfermedad_progresiva, tercera_enfermedad_progresiva_oligometastasico, "
					+ " organo_tercera_enfermedad_progresiva, tratamiento_tercera_enfermedad_progresiva, tecnica_radioterapia_tercera_enfermedad_progresiva, "
					+ " dosis_radioterapia_tercera_enfermedad_progresiva, fecha_cuarta_enfermedad_progresiva, psa_cuarta_enfermedad_progresiva, "
					+ " sintomatico_cuarta_enfermedad_progresiva, cuarta_enfermedad_progresiva_oligometastasico, organo_cuarta_enfermedad_progresiva, "
					+ " tratamiento_cuarta_enfermedad_progresiva, tecnica_radioterapia_cuarta_enfermedad_progresiva, dosis_radioterapia_cuarta_enfermedad_progresiva, "
					+ " usuario,fecha_registro)  "
					+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate()) ";

			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setInt(1, o.getPaciente_id());
			pstm.setInt(2, o.getAntecedente_raza());
			pstm.setInt(3, o.getRaza_id());
			pstm.setInt(4, o.getAntecedente_familiar());
			pstm.setString(5, o.getDescripcion_familiar());
			pstm.setInt(6, o.getAntecedente_genes());
			pstm.setInt(7, o.getAntecedente_alimentacion());
			pstm.setInt(8, o.getAntecedente_obesidad());
			pstm.setDouble(9, o.getImc());
			pstm.setInt(10, o.getAntecedente_exposicion_trabajo());
			pstm.setInt(11, o.getAntecedente_exposicion_trabajo_detalle());
			pstm.setInt(12, o.getAntecedente_its());
			pstm.setInt(13, o.getAntecedente_sustancia());
			pstm.setString(14, o.getSustancia_descripcion());
			pstm.setInt(15, o.getAntecedente_prostatitis());
			pstm.setInt(16, o.getAntecedente_neoplasia());
			pstm.setString(17, o.getAntecedente_neoplasia_cieo());
			pstm.setDouble(18, o.getPsa_debut());
			pstm.setInt(19, o.getHistologia_id());
			pstm.setString(20, o.getHistologia_especificacion());
			pstm.setString(21, o.getFecha_diagnostico_histologico());
			pstm.setInt(22, o.getTipo_diagnostico_id());
			pstm.setInt(23, o.getGrupo_riesgo_id());
			pstm.setDouble(24, o.getGleason_mayor());
			pstm.setDouble(25, o.getGleason_menor());
			pstm.setDouble(26, o.getGleason_total());
			pstm.setString(27, o.getCategoria_t());
			pstm.setString(28, o.getCategoria_t_patologico());
			pstm.setString(29, o.getCategoria_n());
			pstm.setString(30, o.getCategoria_m());
			pstm.setString(31, o.getCategoria_n_patologico());
			pstm.setString(32, o.getCategoria_m_patologico());
			pstm.setString(33, o.getEstadio());
			pstm.setInt(34, o.getTratamiento_inicial());
			pstm.setString(35, o.getTratamiento_inicial_otros());			
			pstm.setInt(36, o.getEco_paciente());
			pstm.setString(37, o.getFecha_ultimo_control());
			pstm.setString(38, o.getFecha_falla_bioquimica());
			pstm.setDouble(39, o.getPsa_falla_bioquimica());
			pstm.setInt(40, o.getTratamiento_falla_bioquimica());
			pstm.setString(41, o.getFecha_enfermedad_metastasica());
			pstm.setDouble(42, o.getPsa_enfermedad_metastasica());
			pstm.setInt(43, o.getSintomatico_enfermedad_metastasica());
			pstm.setInt(44, o.getEnfermedad_metastasica_oligometastasico());
			pstm.setInt(45, o.getOrgano_enfermedad_metastasica());
			pstm.setInt(46, o.getTratamiento_enfermedad_metastasica());
			pstm.setInt(47, o.getTecnica_radioterapia_enfermedad_metastasica());
			pstm.setDouble(48, o.getDosis_radioterapia_enfermedad_metastasica());
			pstm.setString(49, o.getFecha_segunda_enfermedad_progresiva());
			pstm.setDouble(50, o.getPsa_segunda_enfermedad_progresiva());
			pstm.setInt(51, o.getSintomatico_segunda_enfermedad_progresiva());
			pstm.setInt(52, o.getSegunda_enfermedad_progresiva_oligometastasico());
			pstm.setInt(53, o.getOrgano_segunda_enfermedad_progresiva());
			pstm.setInt(54, o.getTratamiento_segunda_enfermedad_progresiva());
			pstm.setInt(55, o.getTecnica_radioterapia_segunda_enfermedad_progresiva());
			pstm.setDouble(56, o.getDosis_radioterapia_segunda_enfermedad_progresiva());
			pstm.setString(57, o.getFecha_tercera_enfermedad_progresiva());
			pstm.setDouble(58, o.getPsa_tercera_enfermedad_progresiva());
			pstm.setInt(59, o.getSintomatico_tercera_enfermedad_progresiva());
			pstm.setInt(60, o.getTercera_enfermedad_progresiva_oligometastasico());
			pstm.setInt(61, o.getOrgano_tercera_enfermedad_progresiva());
			pstm.setInt(62, o.getTratamiento_tercera_enfermedad_progresiva());
			pstm.setInt(63, o.getTecnica_radioterapia_tercera_enfermedad_progresiva());
			pstm.setDouble(64, o.getDosis_radioterapia_tercera_enfermedad_progresiva());
			pstm.setString(65, o.getFecha_cuarta_enfermedad_progresiva());
			pstm.setDouble(66, o.getPsa_cuarta_enfermedad_progresiva());
			pstm.setInt(67, o.getSintomatico_cuarta_enfermedad_progresiva());
			pstm.setInt(68, o.getCuarta_enfermedad_progresiva_oligometastasico());
			pstm.setInt(69, o.getOrgano_cuarta_enfermedad_progresiva());
			pstm.setInt(70, o.getTratamiento_cuarta_enfermedad_progresiva());
			pstm.setInt(71, o.getTecnica_radioterapia_cuarta_enfermedad_progresiva());
			pstm.setDouble(72, o.getDosis_radioterapia_cuarta_enfermedad_progresiva());
			
			pstm.setString(73, o.getUsuario());

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
	public void Modificar(Hc_cabecera o) throws Exception {
 
		Connection cn = null;

		try {
			cn = DataAccess.getConnection();

			cn.setAutoCommit(false);

			String sql = "update hc_cabecera set "
					+"antecedente_raza = ?, "
					+"raza_id = ?, "
					+"antecedente_familiar = ?, "
					+"descripcion_familiar = ?, "
					+"antecedente_genes = ?, "
					+"antecedente_alimentacion = ?, "
					+"antecedente_obesidad = ?, "
					+"imc = ?, "
					+"antecedente_exposicion_trabajo = ?, "
					+"antecedente_exposicion_trabajo_detalle = ?, "
					+"antecedente_its = ?, "
					+"antecedente_sustancia = ?, "
					+"sustancia_descripcion = ?, "
					+"antecedente_prostatitis = ?, "
					+"antecedente_neoplasia = ?, "
					+"antecedente_neoplasia_cieo = ?, "
					+"psa_debut = ?, "
					+"histologia_id = ?,"
					+"histologia_especificacion = ?,"
					+"fecha_diagnostico_histologico = ?, "
					+"tipo_diagnostico_id = ?, "
					+"grupo_riesgo_id = ?, "
					+"gleason_mayor = ?, "
					+"gleason_menor = ?, "
					+"gleason_total = ?, "
					+"categoria_t = ?,"
					+"categoria_t_patologico = ?,"
					+"categoria_n = ?, "
					+"categoria_m = ?, "
					+"categoria_n_patologico = ?, "
					+"categoria_m_patologico = ?, "
					+"estadio = ?,"
					+"tratamiento_inicial = ?, "
					+"tratamiento_inicial_otros = ?,"
					+"eco_paciente = ?, "
					+"fecha_ultimo_control = ?, "
					+"fecha_falla_bioquimica = ?,"
					+"psa_falla_bioquimica = ?, "
					+"tratamiento_falla_bioquimica = ?, "
					+"fecha_enfermedad_metastasica = ?, "
					+"psa_enfermedad_metastasica = ?,"
					+"sintomatico_enfermedad_metastasica = ?, "
					+"enfermedad_metastasica_oligometastasico = ?, "
					+"organo_enfermedad_metastasica = ?, "
					+"tratamiento_enfermedad_metastasica = ?, "
					+"tecnica_radioterapia_enfermedad_metastasica = ?, "
					+"dosis_radioterapia_enfermedad_metastasica = ?,"
					+"fecha_segunda_enfermedad_progresiva = ?, "
					+"psa_segunda_enfermedad_progresiva = ?, "
					+"sintomatico_segunda_enfermedad_progresiva = ?, "
					+"segunda_enfermedad_progresiva_oligometastasico = ?,"
					+"organo_segunda_enfermedad_progresiva = ?,"
					+"tratamiento_segunda_enfermedad_progresiva = ?,"
					+"tecnica_radioterapia_segunda_enfermedad_progresiva =?, "
					+"dosis_radioterapia_segunda_enfermedad_progresiva = ?,"
					+"fecha_tercera_enfermedad_progresiva = ?, "
					+"psa_tercera_enfermedad_progresiva = ?, "
					+"sintomatico_tercera_enfermedad_progresiva = ?, "
					+"tercera_enfermedad_progresiva_oligometastasico = ?, "
					+"organo_tercera_enfermedad_progresiva = ?, "
					+"tratamiento_tercera_enfermedad_progresiva = ?, "
					+"tecnica_radioterapia_tercera_enfermedad_progresiva = ?,"
					+"dosis_radioterapia_tercera_enfermedad_progresiva = ?,"
					+"fecha_cuarta_enfermedad_progresiva = ?, "
					+"psa_cuarta_enfermedad_progresiva = ?, "
					+"sintomatico_cuarta_enfermedad_progresiva = ?, "
					+"cuarta_enfermedad_progresiva_oligometastasico = ?,"
					+"organo_cuarta_enfermedad_progresiva = ?, "
					+"tratamiento_cuarta_enfermedad_progresiva = ?, "
					+"tecnica_radioterapia_cuarta_enfermedad_progresiva = ?, "
					+"dosis_radioterapia_cuarta_enfermedad_progresiva = ? ,"
					+"usuario = ?,"
					+"fecha_ultima_actualizacion = sysdate() "
					+" where hc_cabecera_id = ? and activo = 1 ";
					

			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setInt(1, o.getAntecedente_raza());
			pstm.setInt(2, o.getRaza_id());
			pstm.setInt(3, o.getAntecedente_familiar());
			pstm.setString(4, o.getDescripcion_familiar());
			pstm.setInt(5, o.getAntecedente_genes());
			pstm.setInt(6, o.getAntecedente_alimentacion());
			pstm.setInt(7, o.getAntecedente_obesidad());
			pstm.setDouble(8, o.getImc());
			pstm.setInt(9, o.getAntecedente_exposicion_trabajo());
			pstm.setInt(10, o.getAntecedente_exposicion_trabajo_detalle());
			pstm.setInt(11, o.getAntecedente_its());
			pstm.setInt(12, o.getAntecedente_sustancia());
			pstm.setString(13, o.getSustancia_descripcion());
			pstm.setInt(14, o.getAntecedente_prostatitis());
			pstm.setInt(15, o.getAntecedente_neoplasia());
			pstm.setString(16, o.getAntecedente_neoplasia_cieo());
			pstm.setDouble(17, o.getPsa_debut());
			pstm.setInt(18, o.getHistologia_id());
			pstm.setString(19, o.getHistologia_especificacion());
			pstm.setString(20, o.getFecha_diagnostico_histologico());
			pstm.setInt(21, o.getTipo_diagnostico_id());
			pstm.setInt(22, o.getGrupo_riesgo_id());
			pstm.setDouble(23, o.getGleason_mayor());
			pstm.setDouble(24, o.getGleason_menor());
			pstm.setDouble(25, o.getGleason_total());
			pstm.setString(26, o.getCategoria_t());
			pstm.setString(27, o.getCategoria_t_patologico());
			pstm.setString(28, o.getCategoria_n());
			pstm.setString(29, o.getCategoria_m());
			pstm.setString(30, o.getCategoria_n_patologico());
			pstm.setString(31, o.getCategoria_m_patologico());
			pstm.setString(32, o.getEstadio());
			pstm.setInt(33, o.getTratamiento_inicial());
			pstm.setString(34, o.getTratamiento_inicial_otros());
			pstm.setInt(35, o.getEco_paciente());
			pstm.setString(36, o.getFecha_ultimo_control());
			pstm.setString(37, o.getFecha_falla_bioquimica());
			pstm.setDouble(38, o.getPsa_falla_bioquimica());
			pstm.setInt(39, o.getTratamiento_falla_bioquimica());
			pstm.setString(40, o.getFecha_enfermedad_metastasica());
			pstm.setDouble(41, o.getPsa_enfermedad_metastasica());
			pstm.setInt(42, o.getSintomatico_enfermedad_metastasica());
			pstm.setInt(43, o.getEnfermedad_metastasica_oligometastasico());
			pstm.setInt(44, o.getOrgano_enfermedad_metastasica());
			pstm.setInt(45, o.getTratamiento_enfermedad_metastasica());
			pstm.setInt(46, o.getTecnica_radioterapia_enfermedad_metastasica());
			pstm.setDouble(47, o.getDosis_radioterapia_enfermedad_metastasica());
			pstm.setString(48, o.getFecha_segunda_enfermedad_progresiva());
			pstm.setDouble(49, o.getPsa_segunda_enfermedad_progresiva());
			pstm.setInt(50, o.getSintomatico_segunda_enfermedad_progresiva());
			pstm.setInt(51, o.getSegunda_enfermedad_progresiva_oligometastasico());
			pstm.setInt(52, o.getOrgano_segunda_enfermedad_progresiva());
			pstm.setInt(53, o.getTratamiento_segunda_enfermedad_progresiva());
			pstm.setInt(54, o.getTecnica_radioterapia_segunda_enfermedad_progresiva());
			pstm.setDouble(55, o.getDosis_radioterapia_segunda_enfermedad_progresiva());
			pstm.setString(56, o.getFecha_tercera_enfermedad_progresiva());
			pstm.setDouble(57, o.getPsa_tercera_enfermedad_progresiva());
			pstm.setInt(58, o.getSintomatico_tercera_enfermedad_progresiva());
			pstm.setInt(59, o.getTercera_enfermedad_progresiva_oligometastasico());
			pstm.setInt(60, o.getOrgano_tercera_enfermedad_progresiva());
			pstm.setInt(61, o.getTratamiento_tercera_enfermedad_progresiva());
			pstm.setInt(62, o.getTecnica_radioterapia_tercera_enfermedad_progresiva());
			pstm.setDouble(63, o.getDosis_radioterapia_tercera_enfermedad_progresiva());
			pstm.setString(64, o.getFecha_cuarta_enfermedad_progresiva());
			pstm.setDouble(65, o.getPsa_cuarta_enfermedad_progresiva());
			pstm.setInt(66, o.getSintomatico_cuarta_enfermedad_progresiva());
			pstm.setInt(67, o.getCuarta_enfermedad_progresiva_oligometastasico());
			pstm.setInt(68, o.getOrgano_cuarta_enfermedad_progresiva());
			pstm.setInt(69, o.getTratamiento_cuarta_enfermedad_progresiva());
			pstm.setInt(70, o.getTecnica_radioterapia_cuarta_enfermedad_progresiva());
			pstm.setDouble(71, o.getDosis_radioterapia_cuarta_enfermedad_progresiva());
			pstm.setString(72, o.getUsuario());
						
			pstm.setInt(73, o.getHc_cabecera_id());
			
			pstm.executeUpdate();

			pstm.close();

			cn.commit();

		} catch (Exception e) {
			try {
				cn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			throw e;
		} finally {
			try {
				cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
	
		
	}

	@Override
	public void Eliminar(Hc_cabecera o) throws Exception {
		
		Connection cn = null;
		
		try {
			
			cn = DataAccess.getConnection();

			cn.setAutoCommit(false);

			String sql = "update hc_cabecera set activo = 0, usuario = ?, fecha_ultima_modificacion = sysdate() where hc_cabecera_id = ? ";

			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setString(1, o.getUsuario());
			pstm.setInt(2, o.getHc_cabecera_id());

			pstm.executeUpdate();

			pstm.close();

			cn.commit();

		} catch (Exception e) {
			try {
				cn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			throw e;
		} finally {
			try {
				cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}														
	}

	@Override
	public List<Hc_cabecera> Listar() throws Exception {
		return null;
	}

	public List<Hc_cabeceraVista> ListarVista() throws Exception {
		Connection cn = null;
		List<Hc_cabeceraVista> lista = new ArrayList<Hc_cabeceraVista>();
		try {
			// conexion a la base de datos
			cn = DataAccess.getConnection();
			// comando sql
			String sql = " select hc_cabecera.hc_cabecera_id,paciente.paciente_id,  "
					+ " paciente.numero_documento, paciente.nombres, paciente.apellido_paterno,"
					+ " paciente.apellido_materno, paciente.codigo_cieo, "
					+ " diagnostico.descripcion, hc_cabecera.fecha_ultimo_control,hc_cabecera.usuario "
					+ " from hc_cabecera, paciente, diagnostico "
					+ " where hc_cabecera.paciente_id = paciente.paciente_id and "
					+ " paciente.codigo_cieo = diagnostico.codigo_cieo and "
					+ " paciente.eliminado = 0 order by hc_cabecera_id asc ";
			// crear statement
			Statement stm = cn.createStatement();
			// ejecutar comando y obtener resultados
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Hc_cabeceraVista hc_cabeceraVista = new Hc_cabeceraVista();
				// asignar valores al objeto r
				hc_cabeceraVista.setHc_cabecera_id(rs.getInt("hc_cabecera_id"));
				hc_cabeceraVista.setPaciente_id(rs.getInt("paciente_id"));
				hc_cabeceraVista.setNumero_documento(rs.getString("numero_documento"));
				hc_cabeceraVista.setNombres(rs.getString("nombres"));
				hc_cabeceraVista.setApellido_paterno(rs.getString("apellido_paterno"));
				hc_cabeceraVista.setApellido_materno(rs.getString("apellido_materno"));
				hc_cabeceraVista.setCodigo_cieo(rs.getString("codigo_cieo"));
				hc_cabeceraVista.setDescripcion(rs.getString("descripcion"));
				hc_cabeceraVista.setFecha_ultimo_control(rs.getString("fecha_ultimo_control"));
				hc_cabeceraVista.setUsuario(rs.getString("usuario"));

				lista.add(hc_cabeceraVista);
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
	public List<Hc_cabecera> Filtrar(Hc_cabecera o) throws Exception {
		throw new UnsupportedOperationException("Not supported yet."); 
	}

	@Override
    public Hc_cabecera Buscar(Hc_cabecera o) throws Exception {
        Connection cn = null;
        Hc_cabecera hc = new Hc_cabecera();
        try {
            cn = DataAccess.getConnection();

            String sql = "select hc_cabecera_id, "
						+"paciente_id, "
						+"antecedente_raza, "
						+"raza_id, "
						+"antecedente_familiar, "
						+"descripcion_familiar,"
						+"antecedente_genes,"
						+"antecedente_alimentacion, "
						+"antecedente_obesidad, "
						+"imc, "
						+"antecedente_exposicion_trabajo, "
						+"antecedente_exposicion_trabajo_detalle, "
						+"antecedente_its, "
						+"antecedente_sustancia, "
						+"sustancia_descripcion, "
						+"antecedente_prostatitis, "
						+"antecedente_neoplasia, "
						+"antecedente_neoplasia_cieo, "
						+"psa_debut, "
						+"histologia_id, "
						+"histologia_especificacion, "
						+"date_format(fecha_diagnostico_histologico, '%m/%d/%Y') as fecha_diagnostico_histologico, "
						+"tipo_diagnostico_id, "
						+"grupo_riesgo_id, "
						+"gleason_mayor, "
						+"gleason_menor, "
						+"gleason_total, "
						+"categoria_t, "
						+"categoria_t_patologico, "
						+"categoria_n, "
						+"categoria_m, "
						+"categoria_n_patologico, "
						+"categoria_m_patologico, "
						+"estadio, "
						+"tratamiento_inicial, "
						+"tratamiento_inicial_otros, "
						+"eco_paciente, "
						+"date_format(fecha_ultimo_control, '%m/%d/%Y') as  fecha_ultimo_control, "
						+"date_format(fecha_falla_bioquimica, '%m/%d/%Y') as fecha_falla_bioquimica, "
						+"psa_falla_bioquimica, "
						+"tratamiento_falla_bioquimica, "
						+"date_format(fecha_enfermedad_metastasica, '%m/%d/%Y') as fecha_enfermedad_metastasica, "
						+"psa_enfermedad_metastasica, "
						+"sintomatico_enfermedad_metastasica,"
						+"enfermedad_metastasica_oligometastasico, "
						+"organo_enfermedad_metastasica, "
						+"tratamiento_enfermedad_metastasica, "
						+"tecnica_radioterapia_enfermedad_metastasica, "
						+"dosis_radioterapia_enfermedad_metastasica, "
						+"date_format(fecha_segunda_enfermedad_progresiva, '%m/%d/%Y') as fecha_segunda_enfermedad_progresiva, "
						+"psa_segunda_enfermedad_progresiva, "
						+"sintomatico_segunda_enfermedad_progresiva, "
						+"segunda_enfermedad_progresiva_oligometastasico, "
						+"organo_segunda_enfermedad_progresiva, "
						+"tratamiento_segunda_enfermedad_progresiva, "
						+"tecnica_radioterapia_segunda_enfermedad_progresiva, "
						+"dosis_radioterapia_segunda_enfermedad_progresiva, "
						+"date_format(fecha_tercera_enfermedad_progresiva, '%m/%d/%Y') as fecha_tercera_enfermedad_progresiva, "
						+"psa_tercera_enfermedad_progresiva, "
						+"sintomatico_tercera_enfermedad_progresiva, "
						+"tercera_enfermedad_progresiva_oligometastasico, "
						+"organo_tercera_enfermedad_progresiva, "
						+"tratamiento_tercera_enfermedad_progresiva, "
						+"tecnica_radioterapia_tercera_enfermedad_progresiva, "
						+"dosis_radioterapia_tercera_enfermedad_progresiva, "
						+"date_format(fecha_cuarta_enfermedad_progresiva, '%m/%d/%Y') as fecha_cuarta_enfermedad_progresiva, "
						+"psa_cuarta_enfermedad_progresiva, "
						+"sintomatico_cuarta_enfermedad_progresiva, "
						+"cuarta_enfermedad_progresiva_oligometastasico, "
						+"organo_cuarta_enfermedad_progresiva, "
						+"tratamiento_cuarta_enfermedad_progresiva, "
						+"tecnica_radioterapia_cuarta_enfermedad_progresiva, "
						+"dosis_radioterapia_cuarta_enfermedad_progresiva  from "
						+ " hc_cabecera where hc_cabecera_id = ? and activo = 1";
            
 
            PreparedStatement pstm = cn.prepareStatement(sql);
            
            pstm.setInt(1, o.getHc_cabecera_id());
            
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {

                hc.setHc_cabecera_id(rs.getInt("hc_cabecera_id"));
                hc.setPaciente_id(rs.getInt("paciente_id"));
                hc.setAntecedente_raza(rs.getInt("antecedente_raza")); 
                hc.setRaza_id(rs.getInt("raza_id")); 
                hc.setAntecedente_familiar(rs.getInt("antecedente_familiar"));
                hc.setDescripcion_familiar(rs.getString("descripcion_familiar"));
                hc.setAntecedente_genes(rs.getInt("antecedente_genes"));
                hc.setAntecedente_alimentacion(rs.getInt("antecedente_alimentacion"));
                hc.setAntecedente_obesidad(rs.getInt("antecedente_obesidad"));
                hc.setImc(rs.getDouble("imc"));
                hc.setAntecedente_exposicion_trabajo(rs.getInt("antecedente_exposicion_trabajo"));
                hc.setAntecedente_exposicion_trabajo_detalle(rs.getInt("antecedente_exposicion_trabajo_detalle"));
                hc.setAntecedente_its(rs.getInt("antecedente_its"));
                hc.setAntecedente_sustancia(rs.getInt("antecedente_sustancia"));
                hc.setSustancia_descripcion(rs.getString("sustancia_descripcion"));
                hc.setAntecedente_prostatitis(rs.getInt("antecedente_prostatitis"));
                hc.setAntecedente_neoplasia(rs.getInt("antecedente_neoplasia"));
                hc.setAntecedente_neoplasia_cieo(rs.getString("antecedente_neoplasia_cieo"));
                hc.setPsa_debut(rs.getDouble("psa_debut"));
                hc.setHistologia_id(rs.getInt("histologia_id"));
                hc.setHistologia_especificacion(rs.getString("histologia_especificacion"));
                hc.setFecha_diagnostico_histologico(rs.getString("fecha_diagnostico_histologico"));
                hc.setTipo_diagnostico_id(rs.getInt("tipo_diagnostico_id"));
                hc.setGrupo_riesgo_id(rs.getInt("grupo_riesgo_id"));
                hc.setGleason_mayor(rs.getDouble("gleason_mayor"));
                hc.setGleason_menor(rs.getDouble("gleason_menor"));
                hc.setGleason_total(rs.getDouble("gleason_total"));
                hc.setCategoria_t(rs.getString("categoria_t")); 
                hc.setCategoria_t_patologico(rs.getString("categoria_t_patologico")); 
                hc.setCategoria_n(rs.getString("categoria_n")); 
                hc.setCategoria_m(rs.getString("categoria_m")); 
                hc.setCategoria_n_patologico(rs.getString("categoria_n_patologico"));
                hc.setCategoria_m_patologico(rs.getString("categoria_m_patologico"));
                hc.setEstadio(rs.getString("estadio"));
                hc.setTratamiento_inicial(rs.getInt("tratamiento_inicial")); 
                hc.setTratamiento_inicial_otros(rs.getString("tratamiento_inicial_otros")); 
                hc.setEco_paciente(rs.getInt("eco_paciente")); 
                hc.setFecha_ultimo_control(rs.getString("fecha_ultimo_control")); 
                hc.setFecha_falla_bioquimica(rs.getString("fecha_falla_bioquimica")); 
                hc.setPsa_falla_bioquimica(rs.getDouble("psa_falla_bioquimica")); 
                hc.setTratamiento_falla_bioquimica(rs.getInt("tratamiento_falla_bioquimica")); 
                hc.setFecha_enfermedad_metastasica(rs.getString("fecha_enfermedad_metastasica")); 
                hc.setPsa_enfermedad_metastasica(rs.getDouble("psa_enfermedad_metastasica")); 
                hc.setSintomatico_enfermedad_metastasica(rs.getInt("sintomatico_enfermedad_metastasica"));
                hc.setEnfermedad_metastasica_oligometastasico(rs.getInt("enfermedad_metastasica_oligometastasico")); 
                hc.setOrgano_enfermedad_metastasica(rs.getInt("organo_enfermedad_metastasica")); 
                hc.setTratamiento_enfermedad_metastasica(rs.getInt("tratamiento_enfermedad_metastasica")); 
                hc.setTecnica_radioterapia_enfermedad_metastasica(rs.getInt("tecnica_radioterapia_enfermedad_metastasica")); 
                hc.setDosis_radioterapia_enfermedad_metastasica(rs.getDouble("dosis_radioterapia_enfermedad_metastasica")); 
                hc.setFecha_segunda_enfermedad_progresiva(rs.getString("fecha_segunda_enfermedad_progresiva")); 
                hc.setPsa_segunda_enfermedad_progresiva(rs.getDouble("psa_segunda_enfermedad_progresiva")); 
                hc.setSintomatico_segunda_enfermedad_progresiva(rs.getInt("sintomatico_segunda_enfermedad_progresiva")); 
                hc.setSegunda_enfermedad_progresiva_oligometastasico(rs.getInt("segunda_enfermedad_progresiva_oligometastasico")); 
                hc.setOrgano_segunda_enfermedad_progresiva(rs.getInt("organo_segunda_enfermedad_progresiva")); 
                hc.setTratamiento_segunda_enfermedad_progresiva(rs.getInt("tratamiento_segunda_enfermedad_progresiva")); 
                hc.setTecnica_radioterapia_segunda_enfermedad_progresiva(rs.getInt("tecnica_radioterapia_segunda_enfermedad_progresiva")); 
                hc.setDosis_radioterapia_segunda_enfermedad_progresiva(rs.getDouble("dosis_radioterapia_segunda_enfermedad_progresiva")); 
                hc.setFecha_tercera_enfermedad_progresiva(rs.getString("fecha_tercera_enfermedad_progresiva")); 
                hc.setPsa_tercera_enfermedad_progresiva(rs.getDouble("psa_tercera_enfermedad_progresiva"));
                hc.setSintomatico_tercera_enfermedad_progresiva(rs.getInt("sintomatico_tercera_enfermedad_progresiva")); 
                hc.setTercera_enfermedad_progresiva_oligometastasico(rs.getInt("tercera_enfermedad_progresiva_oligometastasico")); 
                hc.setOrgano_tercera_enfermedad_progresiva(rs.getInt("organo_tercera_enfermedad_progresiva")); 
                hc.setTratamiento_tercera_enfermedad_progresiva(rs.getInt("tratamiento_tercera_enfermedad_progresiva")); 
                hc.setTecnica_radioterapia_tercera_enfermedad_progresiva(rs.getInt("tecnica_radioterapia_tercera_enfermedad_progresiva")); 
                hc.setDosis_radioterapia_tercera_enfermedad_progresiva(rs.getDouble("dosis_radioterapia_tercera_enfermedad_progresiva")); 
                hc.setFecha_cuarta_enfermedad_progresiva(rs.getString("fecha_cuarta_enfermedad_progresiva")); 
                hc.setPsa_cuarta_enfermedad_progresiva(rs.getDouble("psa_cuarta_enfermedad_progresiva")); 
                hc.setSintomatico_cuarta_enfermedad_progresiva(rs.getInt("sintomatico_cuarta_enfermedad_progresiva")); 
                hc.setCuarta_enfermedad_progresiva_oligometastasico(rs.getInt("cuarta_enfermedad_progresiva_oligometastasico")); 
                hc.setOrgano_cuarta_enfermedad_progresiva(rs.getInt("organo_cuarta_enfermedad_progresiva")); 
                hc.setTratamiento_cuarta_enfermedad_progresiva(rs.getInt("Tratamiento_cuarta_enfermedad_progresiva")); 
                hc.setTecnica_radioterapia_cuarta_enfermedad_progresiva(rs.getInt("tecnica_radioterapia_cuarta_enfermedad_progresiva")); 
                hc.setDosis_radioterapia_cuarta_enfermedad_progresiva(rs.getDouble("Dosis_radioterapia_cuarta_enfermedad_progresiva"));
                
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
        return hc;
    }

	public boolean ValidaExistencia(Paciente o) throws Exception {
		
		Connection cn = null;
		boolean val;
		
		try {
			cn = DataAccess.getConnection();
			String query = "select paciente_id  from hc_cabecera where paciente_id = ? and activo = 1 ";
			PreparedStatement stm = cn.prepareStatement(query);
			stm.setInt(1, o.getPaciente_id());

			ResultSet rset = stm.executeQuery();

			if (rset.next()) {
				val = true;
			} else {
				val = false;
			}
			rset.close();
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
		return val;
	}

}
