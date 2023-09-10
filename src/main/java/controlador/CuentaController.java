package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.entidades.Persona;
import modelo.dao.DAOFactory;
import modelo.entidades.Cuenta;

@WebServlet("/CuentaController")
public class CuentaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CuentaController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.ruteador(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.ruteador(request, response);
	}
	
	private void ruteador(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Persona persona = (Persona) session.getAttribute("personaAtenticada");

		if (persona == null) {
			response.sendRedirect("LoginController?ruta=iniciar");
			return;
		}
		
		String ruta = (request.getParameter("ruta") == null) ? "verCuentas" : request.getParameter("ruta");
		switch (ruta) {
		case "verCuentas":
			this.verCuentas(request, response);
			break;
		case "registrarCuenta":
			this.registrarCuenta(request, response);
			break;
		default:
			break;
		}
	}
	
	private void verCuentas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Persona persona = (Persona) session.getAttribute("personaAtenticada");
		
		List<Cuenta> cuentas = DAOFactory.getFactory().getCuentaDAO().getAllByPersona(persona.getId());
		
		request.setAttribute("cuentas", cuentas);

		request.getRequestDispatcher("jsp/dashboard/cuenta.jsp").forward(request, response);
	}
	
	private void registrarCuenta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Persona persona = (Persona) session.getAttribute("personaAtenticada");
		
		String nombre = request.getParameter("nombreCuenta");
		
		double valor = Double.parseDouble(request.getParameter("valorInicial"));

		Cuenta cuenta = new Cuenta(nombre,persona, valor);

		DAOFactory.getFactory().getCuentaDAO().create(cuenta);

		response.sendRedirect("CuentaController?ruta=verCuentas");
	}

}
