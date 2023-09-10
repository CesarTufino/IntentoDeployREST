package modelo.jpa;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.dao.PersonaDAO;
import modelo.entidades.Persona;

public class JPAPersonaDAO extends JPAGenericDAO<Persona, Integer> implements PersonaDAO{

	public JPAPersonaDAO() {
		super(Persona.class);
	}

	@Override
	public Persona autorizar(String usuario, String clave) {
		Persona usuarioAutorizado = null;
		String sentecia = "SELECT p FROM Persona p WHERE p.usuario= :usuario AND p.clave= :clave";
		Query query = em.createQuery(sentecia);
		query.setParameter("usuario", usuario);
		query.setParameter("clave", clave);

		try {
			usuarioAutorizado = (Persona) query.getSingleResult();
		} catch (NoResultException e) {
			usuarioAutorizado = null;
		}
		return usuarioAutorizado;
	}

	
}
