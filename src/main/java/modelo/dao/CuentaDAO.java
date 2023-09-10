package modelo.dao;

import java.util.List;

import modelo.entidades.Cuenta;

public interface CuentaDAO extends GenericDAO<Cuenta, Integer>{
	public List<Cuenta> getAllByPersona(int idPersona);
	
}
