package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.dao.DAOFactory;
import modelo.entidades.Persona;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.ruteador(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.ruteador(request, response);
	}
	
	private void ruteador(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ruta = (request.getParameter("ruta") == null) ? "iniciar" : request.getParameter("ruta");
		switch (ruta) {
		case "iniciar":
			this.iniciar(request, response);
			break;
		case "ingresar":
			this.ingresar(request, response);
			break;
		case "salir":
			this.salir(request, response);
			break;
		default:
			break;
		}
	}
	
	private void iniciar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.- Obtener datos que me envían en la solicitud

		// 2.- Llamo al Modelo para obtener datos
		
		// 3.- Llamo a la vista
		request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
	}
	
	private void ingresar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("user");
		String clave = request.getParameter("password");

		Persona personaAtenticada = DAOFactory.getFactory().getPersonaDAO().autorizar(usuario, clave);

		if (personaAtenticada != null) {
			// Crear la sesion
			HttpSession session = request.getSession();
			session.setAttribute("personaAtenticada", personaAtenticada);
			response.sendRedirect("DashboardController?ruta=verDashboard");
		} else {
			String mensaje = "Ingresaste mal tu usuario y clave";
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher("jsp/dashboard/error.jsp").forward(request, response);
		}
	}
	
	private void salir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
	}
	
}
