package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.Grupo_riesgoDao;
import entity.Grupo_riesgo;


/**
 * Servlet implementation class Grupo_riesgoController
 */
@WebServlet("/Grupo_riesgoController")
public class Grupo_riesgoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Grupo_riesgo grupo_riesgo;
	Grupo_riesgoDao grupo_riesgoDao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Grupo_riesgoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
		
		String opcion = request.getParameter("opcion");

		if (opcion.equals("listar_grupo_riesgo")) {

			grupo_riesgo = new Grupo_riesgo();

			grupo_riesgo.setTipo_diagnostico_id(Integer.parseInt(request.getParameter("tipo_diagnostico_id")));

			try {

				grupo_riesgoDao = new Grupo_riesgoDao();

				List<Grupo_riesgo> grupos = grupo_riesgoDao.Filtrar(grupo_riesgo);

				String json = new Gson().toJson(grupos);

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
		// TODO Auto-generated method stub
		doGet(request, response);
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

}
