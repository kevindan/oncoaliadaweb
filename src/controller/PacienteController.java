package controller;

import java.io.IOException;
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
import dao.PacienteDao;
import entity.Paciente;
import entity.PacienteDiag;

/**
 * Servlet implementation class PacienteController
 */
@WebServlet("/PacienteController")
public class PacienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Paciente paciente;
	PacienteDao pacienteDao;	
	PacienteDiag pacienteDiag;
	Hc_cabeceraDao hc_cabeceraDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PacienteController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
		
		String opcion = request.getParameter("opcion");

		if (opcion.equals("listar_pacientes")) {

			try {

				pacienteDao = new PacienteDao();

				List<Paciente> pacientes = pacienteDao.Listar();

				String json = new Gson().toJson(pacientes);

				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}else if (opcion.equals("buscar")) {

			paciente = new Paciente();

			paciente.setPaciente_id(Integer.parseInt(request.getParameter("paciente_id")));

			try {

				pacienteDao = new PacienteDao();

				paciente = pacienteDao.Buscar(paciente);

				String json = new Gson().toJson(paciente);

				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		String opcion = request.getParameter("opcion");

		if (opcion.equals("guardar")) {

			paciente = new Paciente();
			
			if(!(request.getParameter("paciente_id").equals(""))){
				paciente.setPaciente_id(Integer.parseInt(request.getParameter("paciente_id")));	
			}
			
			
			paciente.setTipo_documento_id(Integer.parseInt(request.getParameter("tipo_documento_id")));
			paciente.setNumero_documento(request.getParameter("numero_documento"));
			paciente.setNombres(request.getParameter("nombres"));
			paciente.setApellido_paterno(request.getParameter("apellido_paterno"));
			paciente.setApellido_materno(request.getParameter("apellido_materno"));
			paciente.setSexo(request.getParameter("sexo"));
			paciente.setFecha_nacimiento(fechaToTexto(textoTofecha(request.getParameter("fecha_nacimiento"))));
			paciente.setDireccion(request.getParameter("direccion"));
			paciente.setTelefono(request.getParameter("telefono"));
			paciente.setTipo_paciente(Integer.parseInt(request.getParameter("tipo_paciente")));
			paciente.setBase_diagnostico_id(Integer.parseInt(request.getParameter("base_diagnostico_id")));
			paciente.setCodigo_cieo(request.getParameter("codigo_cieo"));
			paciente.setCodigo_ubigeo(request.getParameter("codigo_ubigeo"));
			paciente.setFecha_diagnostico(fechaToTexto(textoTofecha(request.getParameter("fecha_diagnostico"))));
			paciente.setObservacion(request.getParameter("observacion"));
			
			String operacion = request.getParameter("operacion");
			
			try {
				
				pacienteDao = new PacienteDao();
				
				if(operacion.equals("registrar")){
					
					Paciente pacienteTemp = new Paciente();					
					pacienteTemp = pacienteDao.ValidaDocumento(paciente);

					if (pacienteTemp.getNombres() == null) {

						pacienteDao.Grabar(paciente);
						response.getWriter().write("1");

					} else {
						response.getWriter().write("0");
					}					
					
				}else if(operacion.equals("actualizar")){
					pacienteDao.Modificar(paciente);
					response.getWriter().write("1");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (opcion.equals("buscar_paciente_diag")) {

			paciente = new Paciente();
			paciente.setPaciente_id(Integer.parseInt(request.getParameter("paciente_id")));

			try {
				
				hc_cabeceraDao = new Hc_cabeceraDao();
				
				boolean existe = hc_cabeceraDao.ValidaExistencia(paciente);
				
				if(existe == false){
					
					pacienteDao = new PacienteDao();
					pacienteDiag = new PacienteDiag();

					pacienteDiag = pacienteDao.BuscarPacienteDiag(paciente);

					String json = new Gson().toJson(pacienteDiag);

					response.setContentType("application/json");
					response.setCharacterEncoding("UTF-8");
					response.getWriter().write(json);
					
				}else{
					
					response.getWriter().write("0");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				response.getWriter().write("0");
			}

		} else if (opcion.equals("buscar_paciente_con_hc")) {

			paciente = new Paciente();
			paciente.setPaciente_id(Integer.parseInt(request.getParameter("paciente_id")));

			try {
					
					pacienteDao = new PacienteDao();
					pacienteDiag = new PacienteDiag();

					pacienteDiag = pacienteDao.BuscarPacienteDiag(paciente);

					String json = new Gson().toJson(pacienteDiag);

					response.setContentType("application/json");
					response.setCharacterEncoding("UTF-8");
					response.getWriter().write(json);
					
				
			} catch (Exception e) {
				e.printStackTrace();
				response.getWriter().write("0");
			}

		} else if(opcion.equals("eliminar")){
			
			paciente = new Paciente();
			paciente.setPaciente_id(Integer.parseInt(request.getParameter("paciente_id")));

			try {
				pacienteDao = new PacienteDao();				
				pacienteDao.Eliminar(paciente);
				
				response.getWriter().write("1");

			} catch (Exception e) {
				
				response.getWriter().write("0");
				e.printStackTrace();
			}
			
		}

	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
