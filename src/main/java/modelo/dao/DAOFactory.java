package modelo.dao;

import modelo.jpa.JPADAOFactory;

public abstract class DAOFactory {
	protected static DAOFactory factory = new JPADAOFactory();
	
	public static DAOFactory getFactory() {
		return factory;
	}
	
	public abstract PersonaDAO getPersonaDAO();
	
	public abstract CuentaDAO getCuentaDAO();
	
	public abstract MovimientoDAO getMovimientoDAO();
	
	public abstract CategoriaDAO getCategoriaDAO();

}
