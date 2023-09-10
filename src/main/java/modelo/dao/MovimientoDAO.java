package modelo.dao;

import java.util.List;

import modelo.dto.CategoriaTotalDTO;
import modelo.dto.MovimientoDTO;
import modelo.entidades.Movimiento;

public interface MovimientoDAO extends GenericDAO<Movimiento, Integer>{
	
	public List<CategoriaTotalDTO> getCategoriasConTotalByMesByPersona(int mes, int idPropietario);
	public List<MovimientoDTO> getAllByPesonaByMes(int idPersona, int mes);
	public List<MovimientoDTO> getAllByPersona(int idPersona);
	public List<Movimiento> getByPersona(int idPersona);
}
