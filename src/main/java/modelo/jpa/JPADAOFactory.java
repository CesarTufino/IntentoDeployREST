package modelo.jpa;

import modelo.dao.CategoriaDAO;
import modelo.dao.CuentaDAO;
import modelo.dao.DAOFactory;
import modelo.dao.MovimientoDAO;
import modelo.dao.PersonaDAO;

public class JPADAOFactory extends DAOFactory{

	@Override
	public PersonaDAO getPersonaDAO() {
		return new JPAPersonaDAO();
	}

	@Override
	public CuentaDAO getCuentaDAO() {
		return new JPACuentaDAO();
	}

	@Override
	public MovimientoDAO getMovimientoDAO() {
		return new JPAMovimientoDAO();
	}

	@Override
	public CategoriaDAO getCategoriaDAO() {
		return new JPACategoriaDAO();
	}

}
