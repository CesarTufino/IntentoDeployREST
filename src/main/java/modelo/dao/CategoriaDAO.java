package modelo.dao;

import java.util.List;

import modelo.entidades.Categoria;

public interface CategoriaDAO extends GenericDAO<Categoria, Integer>{
	
	public List<Categoria> getAllTipoIngresoByPersona(int idPersona);
	public List<Categoria> getAllTipoEgresoByPersona(int idPersona);
	public List<Categoria> getAllTipoTransferenciaByPersona(int idPersona);
	public List<Categoria> getAllByPersona(int idPersona);

}
