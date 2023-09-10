package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.dao.DAOFactory;
import modelo.dto.MovimientoDTO;
import modelo.entidades.Cuenta;
import modelo.entidades.Movimiento;
import modelo.entidades.Persona;

@WebServlet("/MovimientoController")
public class MovimientoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MovimientoController() {
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

		String ruta = (request.getParameter("ruta") == null) ? "vizualizarTodo" : request.getParameter("ruta");
		switch (ruta) {
		case "vizualizarTodo":
			this.vizualizarTodo(request, response);
			break;
		case "vizualizarPorMes":
			this.vizualizarPorMes(request, response);
			break;
		case "eliminarMovimiento":
			this.eliminarMovimiento(request, response);
			break;
		default:
			break;
		}
	}

	private void vizualizarTodo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Persona persona = (Persona) session.getAttribute("personaAtenticada");

		List<MovimientoDTO> movimientos = DAOFactory.getFactory().getMovimientoDAO().getAllByPersona(persona.getId());

		request.setAttribute("movimientos", movimientos);

		request.getRequestDispatcher("jsp/dashboard/movimientos.jsp").forward(request, response);
	}

	private void vizualizarPorMes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Persona persona = (Persona) session.getAttribute("personaAtenticada");

		int mes = Integer.parseInt(request.getParameter("mes"));

		List<MovimientoDTO> movimientos = DAOFactory.getFactory().getMovimientoDAO()
				.getAllByPesonaByMes(persona.getId(), mes);
		request.setAttribute("movimientos", movimientos);

		request.getRequestDispatcher("jsp/dashboard/movimientos.jsp").forward(request, response);
	}

	private void eliminarMovimiento(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int idMovimiento = Integer.parseInt(request.getParameter("idMovimiento"));
		
		Movimiento movimiento = DAOFactory.getFactory().getMovimientoDAO().getById(idMovimiento);
		
		Cuenta cuentaOrigen = movimiento.getCuenta();
		cuentaOrigen.setTotal(cuentaOrigen.getTotal() - movimiento.getValor());
		DAOFactory.getFactory().getCuentaDAO().update(cuentaOrigen);
		
		Movimiento movimientoRelacionado = movimiento.getRelacion();

		if (movimientoRelacionado != null) {
			Cuenta cuentaDestino = movimientoRelacionado.getCuenta();
			cuentaDestino.setTotal(cuentaDestino.getTotal() - movimientoRelacionado.getValor());
			DAOFactory.getFactory().getCuentaDAO().update(cuentaDestino);
		}
		
		
		DAOFactory.getFactory().getMovimientoDAO().deleteById(idMovimiento);
		
		response.sendRedirect("MovimientoController?ruta=vizualizarTodo");
	}

}
