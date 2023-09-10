package modelo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.dao.GenericDAO;

public class JPAGenericDAO<T, ID> implements GenericDAO<T, ID>{
	
	private Class<T> persistentClass;
	protected EntityManager em;

	public JPAGenericDAO(Class <T> clasePersistente) {
		this.persistentClass = clasePersistente;
		this.em = Persistence.createEntityManagerFactory("constgr9bd").createEntityManager();
	}
	
	@Override
	public T getById(ID id) {
		return em.find(persistentClass, id);
	}

	@Override
	public List<T> getAll() {
		String sentenciaJPQL = "Select t From " + persistentClass.getSimpleName() + " t";
		Query query1 = em.createQuery(sentenciaJPQL);
		return query1.getResultList();
	}

	@Override
	public void create(T entity) {
		em.getTransaction().begin();
		try {
			em.persist(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error de inserci�n");
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
	}

	@Override
	public void update(T entity) {
		em.getTransaction().begin();
		try {
			em.merge(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error actualizaci�n");
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
	}
	
	@Override
	public void delete(T entity) {
		em.getTransaction().begin();
		try {
			em.remove(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error eliminaci�n");
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
	}

	@Override
	public void deleteById(ID id) {
		T entity = this.getById(id);
		if (entity!=null) {
			this.delete(entity);
		}
	}

}
