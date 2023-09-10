package controlador;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.entidades.Persona;
import modelo.dao.DAOFactory;
import modelo.dto.CategoriaTotalDTO;
import modelo.entidades.Cuenta;

@WebServlet("/DashboardController")
public class DashboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DashboardController() {
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
		HttpSession session = request.getSession();
		Persona persona = (Persona) session.getAttribute("personaAtenticada");
		
		if (persona == null) {
			response.sendRedirect("LoginController?ruta=iniciar");
			return;
		}
		
		String ruta = (request.getParameter("ruta") == null) ? "verDashboard" : request.getParameter("ruta");
		switch (ruta) {
		case "verDashboard":
			this.verDashboard(request, response);
			break;
		default:
			break;
		}
	}

	private void verDashboard(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Persona persona = (Persona) session.getAttribute("personaAtenticada");
		
		LocalDate fecha = LocalDate.now();
        int mesActual = fecha.getMonthValue();
        int mes = (request.getParameter("mes") == null) ? mesActual : Integer.parseInt(request.getParameter("mes"));
        
		List<CategoriaTotalDTO> categoriasConTotal = DAOFactory.getFactory().getMovimientoDAO().getCategoriasConTotalByMesByPersona(mes, persona.getId());
		List<Cuenta> cuentas = DAOFactory.getFactory().getCuentaDAO().getAllByPersona(persona.getId());
		
		request.setAttribute("categoriasConTotal", categoriasConTotal);
		request.setAttribute("cuentas", cuentas);
		request.getRequestDispatcher("jsp/dashboard/dashboard.jsp").forward(request, response);
	}

}
