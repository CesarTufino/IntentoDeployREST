package controlador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.dao.DAOFactory;
import modelo.entidades.Categoria;
import modelo.entidades.Cuenta;
import modelo.entidades.Movimiento;
import modelo.entidades.Persona;

@WebServlet("/TransferenciaController")
public class TransferenciaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TransferenciaController() {
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

		String ruta = (request.getParameter("ruta") == null) ? "iniciarTransferencia" : request.getParameter("ruta");
		switch (ruta) {
		case "iniciarTransferencia":
			this.iniciarTransferencia(request, response);
			break;
		case "registrarTransferencia":
			this.registarTransferencia(request, response);
			break;
		default:
			break;
		}
	}

	private void iniciarTransferencia(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Persona persona = (Persona) session.getAttribute("personaAtenticada");
		
		List<Cuenta> cuentas = DAOFactory.getFactory().getCuentaDAO().getAllByPersona(persona.getId());
		List<Categoria> categoriasTransferencia = DAOFactory.getFactory().getCategoriaDAO().getAllTipoTransferenciaByPersona(persona.getId());

		request.setAttribute("cuentas", cuentas);
		request.setAttribute("categoriasTransferencia", categoriasTransferencia);
		request.getRequestDispatcher("jsp/dashboard/transferencia.jsp").forward(request, response);
	}

	private void registarTransferencia(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int idCuentaOrigen = Integer.parseInt(request.getParameter("cuenta_origen"));
		int idCuentaDestino = Integer.parseInt(request.getParameter("cuenta_destino"));

		int idCategoria = Integer.parseInt(request.getParameter("categoria"));

		String concepto = request.getParameter("concepto");
		String strFecha = request.getParameter("fecha");
		double valor = Double.parseDouble(request.getParameter("valor"));

		Cuenta cuentaOrigen = DAOFactory.getFactory().getCuentaDAO().getById(idCuentaOrigen);
		Cuenta cuentaDestino = DAOFactory.getFactory().getCuentaDAO().getById(idCuentaDestino);
		Categoria categoria = DAOFactory.getFactory().getCategoriaDAO().getById(idCategoria);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha = new Date();
		try {
			fecha = dateFormat.parse(strFecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if (valor > cuentaOrigen.getTotal()) {
			String mensaje = "El valor de transferencia es mayor a la cantidad existente en la cuenta de origen";
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher("jsp/dashboard/error.jsp").forward(request, response);
			return;
		}
		
		cuentaOrigen.setTotal(cuentaOrigen.getTotal() - valor);
		cuentaDestino.setTotal(cuentaDestino.getTotal() + valor);

		DAOFactory.getFactory().getCuentaDAO().update(cuentaOrigen);
		DAOFactory.getFactory().getCuentaDAO().update(cuentaDestino);

		Movimiento movimientoOrigen = new Movimiento(concepto, -valor, fecha, categoria, cuentaOrigen);
		Movimiento movimientoDestino = new Movimiento(concepto, valor, fecha, categoria, cuentaDestino, movimientoOrigen);
		
		DAOFactory.getFactory().getMovimientoDAO().create(movimientoOrigen);
		DAOFactory.getFactory().getMovimientoDAO().create(movimientoDestino);
		movimientoOrigen.setRelacion(movimientoDestino);
		DAOFactory.getFactory().getMovimientoDAO().update(movimientoOrigen);

		response.sendRedirect("TransferenciaController?ruta=iniciarTransferencia");
	}
	
}

