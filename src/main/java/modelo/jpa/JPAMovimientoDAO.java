package modelo.jpa;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import modelo.dao.MovimientoDAO;
import modelo.dto.CategoriaTotalDTO;
import modelo.dto.MovimientoDTO;
import modelo.entidades.Movimiento;

public class JPAMovimientoDAO extends JPAGenericDAO<Movimiento, Integer> implements MovimientoDAO {

	public JPAMovimientoDAO() {
		super(Movimiento.class);
	}

	@Override
	public List<CategoriaTotalDTO> getCategoriasConTotalByMesByPersona(int mes, int idPersona) {
		String sql = "Select c.id, nombre, tipo, propietario, sum(valor) as 'total' from movimiento m JOIN categoria c on m.categoria = c.id where month(fecha) = ? AND propietario = ? GROUP BY c.id, nombre, tipo;";
		Query query = em.createNativeQuery(sql);
		query.setParameter(1, mes);
		query.setParameter(2, idPersona);
		List<Object[]> resultados = query.getResultList();
		List<CategoriaTotalDTO> categoriasTotalDTO = new ArrayList<>();

		for (Object[] resultado : resultados) {
			CategoriaTotalDTO categoriaDTO = new CategoriaTotalDTO();
			categoriaDTO.setId((int) resultado[0]);
			categoriaDTO.setNombre((String) resultado[1]);
			categoriaDTO.setTipo((int) resultado[2]);
			categoriaDTO.setPropietario((int) resultado[3]);
			categoriaDTO.setTotal((double) resultado[4]);
			categoriasTotalDTO.add(categoriaDTO);
		}
		return categoriasTotalDTO;
	}
	
	@Override
	public List<MovimientoDTO> getAllByPesonaByMes(int idPersona, int mes) {
		String sql = "SELECT m.ID, m.concepto, m.valor, m.fecha, m.categoria, m.cuenta, m.relacion m FROM movimiento m join cuenta c on m.cuenta = c.ID join persona p on c.propietario = p.ID WHERE month(fecha) = ? and p.id= ?;";
		Query query = em.createNativeQuery(sql, Movimiento.class);
		query.setParameter(1, mes);
		query.setParameter(2, idPersona);
		
		List<MovimientoDTO> movimientosDTO = new ArrayList<MovimientoDTO>();
		for(Movimiento m: (List<Movimiento>) query.getResultList()) {
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		    String fechaFormateada = formato.format(m.getFecha());
			MovimientoDTO movimientoDTO = new MovimientoDTO(m.getId(), m.getConcepto(), m.getValor(), m.getFecha(), m.getCategoria(), m.getCuenta(), m.getRelacion(), fechaFormateada);
			movimientosDTO.add(movimientoDTO);
		}
		
		return movimientosDTO;
	}
	
	@Override
	public List<MovimientoDTO> getAllByPersona(int idPersona) {
		String sql = "SELECT m.ID, m.concepto, m.valor, m.fecha, m.categoria, m.cuenta, m.relacion m FROM movimiento m join cuenta c on m.cuenta = c.ID join persona p on c.propietario = p.ID WHERE p.id= ?;";
		Query query = em.createNativeQuery(sql, Movimiento.class);
		query.setParameter(1, idPersona);
		
		List<MovimientoDTO> movimientosDTO = new ArrayList<MovimientoDTO>();
		for(Movimiento m: (List<Movimiento>) query.getResultList()) {
			SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		    String fechaFormateada = formato.format(m.getFecha());
			MovimientoDTO movimientoDTO = new MovimientoDTO(m.getId(), m.getConcepto(), m.getValor(), m.getFecha(), m.getCategoria(), m.getCuenta(), m.getRelacion(), fechaFormateada);
			movimientosDTO.add(movimientoDTO);
		}
		
		return movimientosDTO;
	}

	@Override
	public List<Movimiento> getByPersona(int idPersona) {
		String sql = "SELECT m.ID, m.concepto, m.valor, m.fecha, m.categoria, m.cuenta, m.relacion m FROM movimiento m join cuenta c on m.cuenta = c.ID join persona p on c.propietario = p.ID WHERE p.id= ?;";
		Query query = em.createNativeQuery(sql, Movimiento.class);
		query.setParameter(1, idPersona);
		
		List<MovimientoDTO> movimientosDTO = new ArrayList<MovimientoDTO>();
		return (List<Movimiento>) query.getResultList();
	}

}
