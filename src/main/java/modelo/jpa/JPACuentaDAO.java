package modelo.jpa;

import java.util.List;

import javax.persistence.Query;

import modelo.dao.CuentaDAO;
import modelo.entidades.Cuenta;

public class JPACuentaDAO extends JPAGenericDAO<Cuenta, Integer> implements CuentaDAO{

	public JPACuentaDAO() {
		super(Cuenta.class);
	}

	@Override
	public List<Cuenta> getAllByPersona(int idPersona) {
		String sql = "SELECT * FROM cuenta WHERE propietario = ?;";
		Query query = em.createNativeQuery(sql, Cuenta.class);
		query.setParameter(1, idPersona);
		
		return (List<Cuenta>) query.getResultList();
	}

}
