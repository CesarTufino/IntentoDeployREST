package modelo.jpa;

import java.util.List;

import javax.persistence.Query;

import modelo.dao.CategoriaDAO;
import modelo.entidades.Categoria;

public class JPACategoriaDAO extends JPAGenericDAO<Categoria, Integer> implements CategoriaDAO{

	public JPACategoriaDAO() {
		super(Categoria.class);
	}

	@Override
	public List<Categoria> getAllTipoIngresoByPersona(int idPersona) {
		String sql = "SELECT * FROM categoria WHERE tipo = 0 AND propietario = ?;";
		Query query = em.createNativeQuery(sql, Categoria.class);
		query.setParameter(1, idPersona);
		return (List<Categoria>) query.getResultList();
	}

	@Override
	public List<Categoria> getAllTipoEgresoByPersona(int idPersona) {
		String sql = "SELECT * FROM categoria WHERE tipo = 1 AND propietario = ?;";
		Query query = em.createNativeQuery(sql, Categoria.class);
		query.setParameter(1, idPersona);
		return (List<Categoria>) query.getResultList();
	}

	@Override
	public List<Categoria> getAllTipoTransferenciaByPersona(int idPersona) {
		String sql = "SELECT * FROM categoria WHERE tipo = 2 AND propietario = ?;";
		Query query = em.createNativeQuery(sql, Categoria.class);
		query.setParameter(1, idPersona);
		return (List<Categoria>) query.getResultList();
	}

	@Override
	public List<Categoria> getAllByPersona(int idPersona) {
		String sql = "SELECT * FROM categoria WHERE propietario = ?;";
		Query query = em.createNativeQuery(sql, Categoria.class);
		query.setParameter(1, idPersona);
		return (List<Categoria>) query.getResultList();
	}

}
