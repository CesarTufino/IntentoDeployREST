package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.DAOFactory;
import modelo.entidades.Persona;

@WebServlet("/RegistroController")
public class RegistroController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistroController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.ruteador(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.ruteador(request, response);
	}

	private void ruteador(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ruta = (request.getParameter("ruta") == null) ? "iniciarRegistro" : request.getParameter("ruta");
		switch (ruta) {
		case "iniciarRegistro":
			this.iniciarRegistro(request, response);
			break;
		case "registrar":
			this.registrar(request, response);
			break;
		default:
			break;
		}
	}
	
	private void iniciarRegistro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("jsp/registro.jsp").forward(request, response);
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String usuario = request.getParameter("username");
		String nombre = request.getParameter("firstName");
		String apellido = request.getParameter("lastName");
		String clave = request.getParameter("password");
		
		Persona persona = new Persona(usuario, nombre, apellido, clave);
		
		DAOFactory.getFactory().getPersonaDAO().create(persona);
		
		response.sendRedirect("LoginController?ruta=iniciar");
	}


}
