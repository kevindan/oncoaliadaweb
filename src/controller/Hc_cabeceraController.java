package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.Hc_cabeceraDao;
import entity.Hc_cabecera;
import entity.Hc_cabeceraVista;

/**
 * Servlet implementation class Hc_cabeceraController
 */
@WebServlet("/Hc_cabeceraController")
public class Hc_cabeceraController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Hc_cabecera hc_cabecera;
	Hc_cabeceraDao cabecera_dao;
	Hc_cabeceraVista hcVista;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hc_cabeceraController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		String opcion = request.getParameter("opcion");

		if (opcion.equals("listar_hc")) {

			try {

				cabecera_dao = new Hc_cabeceraDao();

				List<Hc_cabeceraVista> hc_pacientes = cabecera_dao.ListarVista();

				String json = new Gson().toJson(hc_pacientes);

				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}else if (opcion.equals("buscar")) {

			hc_cabecera = new Hc_cabecera();

			hc_cabecera.setHc_cabecera_id(Integer.parseInt(request.getParameter("hc_cabecera_id")));

			try {

				cabecera_dao = new Hc_cabeceraDao();

				hc_cabecera = cabecera_dao.Buscar(hc_cabecera);

				String json = new Gson().toJson(hc_cabecera);

				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();

		String opcion = request.getParameter("opcion");

		if (opcion.equals("guardar")) {

			hc_cabecera = new Hc_cabecera();
								
			if (!(request.getParameter("hc_cabecera_id").equals(""))) {

				hc_cabecera.setHc_cabecera_id(Integer.parseInt(request.getParameter("hc_cabecera_id")));
			}
			
			if (!(request.getParameter("paciente_id").equals(""))) {

				hc_cabecera.setPaciente_id(Integer.parseInt(request.getParameter("paciente_id")));
			}
			
			hc_cabecera.setAntecedente_raza(Integer.parseInt(request.getParameter("antecedente_raza")));
			
			if (!(request.getParameter("raza_id").equals(""))) {

				hc_cabecera.setRaza_id(Integer.parseInt(request.getParameter("raza_id")));
			}
			
			hc_cabecera.setAntecedente_familiar(Integer.parseInt(request.getParameter("antecedente_familiar")));
			hc_cabecera.setDescripcion_familiar(request.getParameter("descripcion_familiar"));
			hc_cabecera.setAntecedente_genes(Integer.parseInt(request.getParameter("antecedente_genes")));
			hc_cabecera.setAntecedente_alimentacion(Integer.parseInt(request.getParameter("antecedente_alimentacion")));
			hc_cabecera.setAntecedente_obesidad(Integer.parseInt(request.getParameter("antecedente_obesidad")));
			
			if (!(request.getParameter("imc").equals(""))) {

				hc_cabecera.setImc(Double.parseDouble(request.getParameter("imc")));
			}
			
			hc_cabecera.setAntecedente_exposicion_trabajo(Integer.parseInt(request.getParameter("antecedente_exposicion_trabajo")));
			
			if (!(request.getParameter("antecedente_exposicion_trabajo_detalle").equals(""))) {

				hc_cabecera.setAntecedente_exposicion_trabajo_detalle(Integer.parseInt(request.getParameter("antecedente_exposicion_trabajo_detalle")));
			}
			
			hc_cabecera.setAntecedente_its(Integer.parseInt(request.getParameter("antecedente_its")));
			hc_cabecera.setAntecedente_sustancia(Integer.parseInt(request.getParameter("antecedente_sustancia")));			
			hc_cabecera.setSustancia_descripcion(request.getParameter("sustancia_descripcion"));			
			hc_cabecera.setAntecedente_prostatitis(Integer.parseInt(request.getParameter("antecedente_prostatitis")));
			hc_cabecera.setAntecedente_neoplasia(Integer.parseInt(request.getParameter("antecedente_neoplasia")));
			hc_cabecera.setAntecedente_neoplasia_cieo(request.getParameter("antecedente_neoplasia_cieo"));
			
			if (!(request.getParameter("psa_debut").equals(""))) {

				hc_cabecera.setPsa_debut(Double.parseDouble(request.getParameter("psa_debut")));
			}
			
			if (!(request.getParameter("histologia_id").equals(""))) {

				hc_cabecera.setHistologia_id(Integer.parseInt(request.getParameter("histologia_id")));
			}
			
			hc_cabecera.setHistologia_especificacion(request.getParameter("histologia_especificacion"));
			
			if (!(request.getParameter("fecha_diagnostico_histologico").equals(""))) {

				hc_cabecera.setFecha_diagnostico_histologico(fechaToTexto(textoTofecha(request.getParameter("fecha_diagnostico_histologico"))));
			}
			
			hc_cabecera.setTipo_diagnostico_id(Integer.parseInt(request.getParameter("tipo_diagnostico_id")));
			hc_cabecera.setGrupo_riesgo_id(Integer.parseInt(request.getParameter("grupo_riesgo_id")));
			
			if (!(request.getParameter("gleason_mayor").equals(""))) {

				hc_cabecera.setGleason_mayor(Double.parseDouble(request.getParameter("gleason_mayor")));
			}
						
			if (!(request.getParameter("gleason_menor").equals(""))) {

				hc_cabecera.setGleason_menor(Double.parseDouble(request.getParameter("gleason_menor")));
			}
			
			if (!(request.getParameter("gleason_total").equals(""))) {

				hc_cabecera.setGleason_total(Double.parseDouble(request.getParameter("gleason_total")));
			}
			
			hc_cabecera.setCategoria_t(request.getParameter("categoria_t"));
			hc_cabecera.setCategoria_t_patologico(request.getParameter("categoria_t_patologico"));
			hc_cabecera.setCategoria_n(request.getParameter("categoria_n"));
			hc_cabecera.setCategoria_m(request.getParameter("categoria_m"));
			hc_cabecera.setCategoria_g(request.getParameter("categoria_g"));
			
			if (!(request.getParameter("tratamiento_inicial").equals(""))) {

				hc_cabecera.setTratamiento_inicial(Integer.parseInt(request.getParameter("tratamiento_inicial")));
			}
			
			if (!(request.getParameter("eco_paciente").equals(""))) {

				hc_cabecera.setEco_paciente(Integer.parseInt(request.getParameter("eco_paciente")));
			}
			
			if (!(request.getParameter("fecha_ultimo_control").equals(""))) {

				hc_cabecera.setFecha_ultimo_control(fechaToTexto(textoTofecha(request.getParameter("fecha_ultimo_control"))));
			}
			
			if (!(request.getParameter("fecha_falla_bioquimica").equals(""))) {

				hc_cabecera.setFecha_falla_bioquimica(fechaToTexto(textoTofecha(request.getParameter("fecha_falla_bioquimica"))));
			}
			
			if (!(request.getParameter("psa_falla_bioquimica").equals(""))) {

				hc_cabecera.setPsa_falla_bioquimica(Double.parseDouble(request.getParameter("psa_falla_bioquimica")));
			}
			
			if (!(request.getParameter("tratamiento_falla_bioquimica").equals(""))) {

				hc_cabecera.setTratamiento_falla_bioquimica(Integer.parseInt(request.getParameter("tratamiento_falla_bioquimica")));
			}
			
			if (!(request.getParameter("fecha_enfermedad_metastasica").equals(""))) {

				hc_cabecera.setFecha_enfermedad_metastasica(fechaToTexto(textoTofecha(request.getParameter("fecha_enfermedad_metastasica"))));
			}
			
			if (!(request.getParameter("psa_enfermedad_metastasica").equals(""))) {

				hc_cabecera.setPsa_enfermedad_metastasica(Double.parseDouble(request.getParameter("psa_enfermedad_metastasica")));
			}
			
			hc_cabecera.setSintomatico_enfermedad_metastasica(Integer.parseInt(request.getParameter("sintomatico_enfermedad_metastasica")));
			hc_cabecera.setEnfermedad_metastasica_oligometastasico(Integer.parseInt(request.getParameter("enfermedad_metastasica_oligometastasico")));
			
			if (!(request.getParameter("organo_enfermedad_metastasica").equals(""))) {

				hc_cabecera.setOrgano_enfermedad_metastasica(Integer.parseInt(request.getParameter("organo_enfermedad_metastasica")));
			}
			
			if (!(request.getParameter("tratamiento_enfermedad_metastasica").equals(""))) {

				hc_cabecera.setTratamiento_enfermedad_metastasica(Integer.parseInt(request.getParameter("tratamiento_enfermedad_metastasica")));
			}
			
			if (!(request.getParameter("tecnica_radioterapia_enfermedad_metastasica").equals(""))) {

				hc_cabecera.setTecnica_radioterapia_enfermedad_metastasica(Integer.parseInt(request.getParameter("tecnica_radioterapia_enfermedad_metastasica")));
			}
			
			if (!(request.getParameter("dosis_radioterapia_enfermedad_metastasica").equals(""))) {

				hc_cabecera.setDosis_radioterapia_enfermedad_metastasica(Double.parseDouble(request.getParameter("dosis_radioterapia_enfermedad_metastasica")));
			}
			
			/*---------------------------------------------------------------------------*/
						
			if (!(request.getParameter("fecha_segunda_enfermedad_progresiva").equals(""))) {

				hc_cabecera.setFecha_segunda_enfermedad_progresiva(fechaToTexto(textoTofecha(request.getParameter("fecha_segunda_enfermedad_progresiva"))));
			}
			
			if (!(request.getParameter("psa_segunda_enfermedad_progresiva").equals(""))) {

				hc_cabecera.setPsa_segunda_enfermedad_progresiva(Double.parseDouble(request.getParameter("psa_segunda_enfermedad_progresiva")));
			}
			
			hc_cabecera.setSintomatico_segunda_enfermedad_progresiva(Integer.parseInt(request.getParameter("sintomatico_segunda_enfermedad_progresiva")));
			hc_cabecera.setSegunda_enfermedad_progresiva_oligometastasico(Integer.parseInt(request.getParameter("segunda_enfermedad_progresiva_oligometastasico")));
			
			if (!(request.getParameter("organo_segunda_enfermedad_progresiva").equals(""))) {

				hc_cabecera.setOrgano_segunda_enfermedad_progresiva(Integer.parseInt(request.getParameter("organo_segunda_enfermedad_progresiva")));
			}
			
			if (!(request.getParameter("tratamiento_segunda_enfermedad_progresiva").equals(""))) {

				hc_cabecera.setTratamiento_segunda_enfermedad_progresiva(Integer.parseInt(request.getParameter("tratamiento_segunda_enfermedad_progresiva")));
			}
			
			if (!(request.getParameter("tecnica_radioterapia_segunda_enfermedad_progresiva").equals(""))) {

				hc_cabecera.setTecnica_radioterapia_segunda_enfermedad_progresiva(Integer.parseInt(request.getParameter("tecnica_radioterapia_segunda_enfermedad_progresiva")));
			}
			
			if (!(request.getParameter("dosis_radioterapia_segunda_enfermedad_progresiva").equals(""))) {

				hc_cabecera.setDosis_radioterapia_segunda_enfermedad_progresiva(Double.parseDouble(request.getParameter("dosis_radioterapia_segunda_enfermedad_progresiva")));
			}
						
			/*---------------------------------------------------------------------------*/
			
			if (!(request.getParameter("fecha_tercera_enfermedad_progresiva").equals(""))) {

				hc_cabecera.setFecha_tercera_enfermedad_progresiva(fechaToTexto(textoTofecha(request.getParameter("fecha_tercera_enfermedad_progresiva"))));
			}
			
			if (!(request.getParameter("psa_tercera_enfermedad_progresiva").equals(""))) {

				hc_cabecera.setPsa_tercera_enfermedad_progresiva(Double.parseDouble(request.getParameter("psa_tercera_enfermedad_progresiva")));
			}
			
			hc_cabecera.setSintomatico_tercera_enfermedad_progresiva(Integer.parseInt(request.getParameter("sintomatico_tercera_enfermedad_progresiva")));
			hc_cabecera.setTercera_enfermedad_progresiva_oligometastasico(Integer.parseInt(request.getParameter("tercera_enfermedad_progresiva_oligometastasico")));
			
			if (!(request.getParameter("organo_tercera_enfermedad_progresiva").equals(""))) {

				hc_cabecera.setOrgano_tercera_enfermedad_progresiva(Integer.parseInt(request.getParameter("organo_tercera_enfermedad_progresiva")));
			}
			
			if (!(request.getParameter("tratamiento_tercera_enfermedad_progresiva").equals(""))) {

				hc_cabecera.setTratamiento_tercera_enfermedad_progresiva(Integer.parseInt(request.getParameter("tratamiento_tercera_enfermedad_progresiva")));
			}
			
			if (!(request.getParameter("tecnica_radioterapia_tercera_enfermedad_progresiva").equals(""))) {

				hc_cabecera.setTecnica_radioterapia_tercera_enfermedad_progresiva(Integer.parseInt(request.getParameter("tecnica_radioterapia_tercera_enfermedad_progresiva")));
			}
			
			if (!(request.getParameter("dosis_radioterapia_tercera_enfermedad_progresiva").equals(""))) {

				hc_cabecera.setDosis_radioterapia_tercera_enfermedad_progresiva(Double.parseDouble(request.getParameter("dosis_radioterapia_tercera_enfermedad_progresiva")));
			}
			
			/*---------------------------------------------------------------------------*/
			
			if (!(request.getParameter("fecha_cuarta_enfermedad_progresiva").equals(""))) {

				hc_cabecera.setFecha_cuarta_enfermedad_progresiva(fechaToTexto(textoTofecha(request.getParameter("fecha_cuarta_enfermedad_progresiva"))));
			}
			
			if (!(request.getParameter("psa_cuarta_enfermedad_progresiva").equals(""))) {

				hc_cabecera.setPsa_cuarta_enfermedad_progresiva(Double.parseDouble(request.getParameter("psa_cuarta_enfermedad_progresiva")));
			}
			
			hc_cabecera.setSintomatico_cuarta_enfermedad_progresiva(Integer.parseInt(request.getParameter("sintomatico_cuarta_enfermedad_progresiva")));
			hc_cabecera.setCuarta_enfermedad_progresiva_oligometastasico(Integer.parseInt(request.getParameter("cuarta_enfermedad_progresiva_oligometastasico")));
			
			if (!(request.getParameter("organo_cuarta_enfermedad_progresiva").equals(""))) {

				hc_cabecera.setOrgano_cuarta_enfermedad_progresiva(Integer.parseInt(request.getParameter("organo_cuarta_enfermedad_progresiva")));
			}
			
			if (!(request.getParameter("tratamiento_cuarta_enfermedad_progresiva").equals(""))) {

				hc_cabecera.setTratamiento_cuarta_enfermedad_progresiva(Integer.parseInt(request.getParameter("tratamiento_cuarta_enfermedad_progresiva")));
			}
			
			if (!(request.getParameter("tecnica_radioterapia_cuarta_enfermedad_progresiva").equals(""))) {

				hc_cabecera.setTecnica_radioterapia_cuarta_enfermedad_progresiva(Integer.parseInt(request.getParameter("tecnica_radioterapia_cuarta_enfermedad_progresiva")));
			}
			
			if (!(request.getParameter("dosis_radioterapia_cuarta_enfermedad_progresiva").equals(""))) {

				hc_cabecera.setDosis_radioterapia_cuarta_enfermedad_progresiva(Double.parseDouble(request.getParameter("dosis_radioterapia_cuarta_enfermedad_progresiva")));
			}
			
			hc_cabecera.setUsuario(request.getParameter("usuario"));
			
			String operacion = request.getParameter("operacion");

			try {

				cabecera_dao = new Hc_cabeceraDao();

				if (operacion.equals("registrar")) {

					cabecera_dao.Grabar(hc_cabecera);

					out.println(1);

				} else if (operacion.equals("actualizar")) {

					cabecera_dao.Modificar(hc_cabecera);
					
					out.println(1);
				}

			} catch (Exception e) {

				out.println(0);

				e.printStackTrace();
			}

		}
				
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	public String fechaToTexto(Date d) {

		String fechaconvertida = "";
		SimpleDateFormat formato;

		try {
			formato = new SimpleDateFormat("yyyy-MM-dd");
			fechaconvertida = formato.format(d);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return fechaconvertida;
	}

	public Date textoTofecha(String d) {
		Date fechaconvertida = null;
		SimpleDateFormat formato = new SimpleDateFormat("MM/dd/yyyy");
		try {
			fechaconvertida = formato.parse(d);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fechaconvertida;
	}
	

}
