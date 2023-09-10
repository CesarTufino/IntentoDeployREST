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

@WebServlet("/EgresoController")
public class EgresoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EgresoController() {
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

		String ruta = (request.getParameter("ruta") == null) ? "iniciarEgreso" : request.getParameter("ruta");
		switch (ruta) {
		case "iniciarEgreso":
			this.iniciarEgreso(request, response);
			break;
		case "registrarEgreso":
			this.registrarEgreso(request, response);
			break;
		default:
			break;
		}
	}

	private void iniciarEgreso(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Persona persona = (Persona) session.getAttribute("personaAtenticada");

		List<Cuenta> cuentas = DAOFactory.getFactory().getCuentaDAO().getAllByPersona(persona.getId());

		List<Categoria> categoriasEgreso = DAOFactory.getFactory().getCategoriaDAO()
				.getAllTipoEgresoByPersona(persona.getId());

		request.setAttribute("cuentas", cuentas);
		request.setAttribute("categoriasEgreso", categoriasEgreso);

		request.getRequestDispatcher("jsp/dashboard/egreso.jsp").forward(request, response);
	}

	private void registrarEgreso(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int idCuenta = Integer.parseInt(request.getParameter("cuenta"));
		int idCategoria = Integer.parseInt(request.getParameter("categoria"));
		String concepto = request.getParameter("concepto");
		String strFecha = request.getParameter("fecha");
		double valor = Double.parseDouble(request.getParameter("valor"));

		Cuenta cuenta = DAOFactory.getFactory().getCuentaDAO().getById(idCuenta);
		Categoria categoria = DAOFactory.getFactory().getCategoriaDAO().getById(idCategoria);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha = new Date();
		try {
			fecha = dateFormat.parse(strFecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (valor > cuenta.getTotal()) {
			String mensaje = "El valor del egreso es mayor a la cantidad existente en la cuenta seleccionada";
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher("jsp/dashboard/error.jsp").forward(request, response);
			return;
		}
		
		cuenta.setTotal(cuenta.getTotal() - valor);
		
		DAOFactory.getFactory().getCuentaDAO().update(cuenta);
		
		Movimiento movimiento = new Movimiento(concepto, -valor, fecha, categoria, cuenta);
		DAOFactory.getFactory().getMovimientoDAO().create(movimiento);
		
		response.sendRedirect("EgresoController?ruta=iniciarEgreso");
	}

}
