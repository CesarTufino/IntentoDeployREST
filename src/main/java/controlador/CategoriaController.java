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
import modelo.entidades.Categoria;
import modelo.entidades.Persona;
import modelo.entidades.Tipo;

@WebServlet("/CategoriaController")
public class CategoriaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CategoriaController() {
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
		
		String ruta = (request.getParameter("ruta") == null) ? "inicio" : request.getParameter("ruta");
		switch (ruta) {
		case "verCategorias":
			this.verCategorias(request, response);
			break;
		case "registrarCategoria":
			this.registrarCategoria(request, response);
			break;
		default:
			break;
		}
	}

	private void verCategorias(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Persona persona = (Persona) session.getAttribute("personaAtenticada");
		
		List<Tipo> tipos = Tipo.getAll();
		request.setAttribute("tipos", tipos);
		
		List<Categoria> categorias = DAOFactory.getFactory().getCategoriaDAO().getAllByPersona(persona.getId());

		request.setAttribute("categorias", categorias);

		request.getRequestDispatcher("jsp/dashboard/categoria.jsp").forward(request, response);
	}

	private void registrarCategoria(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Persona persona = (Persona) session.getAttribute("personaAtenticada");

		String nombre = request.getParameter("nombreCategoria");

		int idTipo = Integer.parseInt(request.getParameter("tipoCategoria"));

		Tipo tipo = Tipo.getById(idTipo);

		Categoria categoria = new Categoria(nombre, tipo, persona);

		DAOFactory.getFactory().getCategoriaDAO().create(categoria);

		response.sendRedirect("CategoriaController?ruta=verCategorias");
	}

}
