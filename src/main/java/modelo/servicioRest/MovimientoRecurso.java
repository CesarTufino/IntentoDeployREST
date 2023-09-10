package modelo.servicioRest;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import modelo.dao.DAOFactory;
import modelo.entidades.Categoria;
import modelo.entidades.Cuenta;
import modelo.entidades.Movimiento;

@Path("/movimientos")
public class MovimientoRecurso {

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Movimiento> getMovimientoById(@PathParam("id") int id) {
		return DAOFactory.getFactory().getMovimientoDAO().getAll();
	}

	@POST
	@Path("/registrarIngreso")
	@Consumes(MediaType.APPLICATION_JSON)
	public void registrarIngreso(Movimiento m) {
		Cuenta cuenta = DAOFactory.getFactory().getCuentaDAO().getById(m.getCuenta().getId());
		Categoria categoria = DAOFactory.getFactory().getCategoriaDAO().getById(m.getCategoria().getId());
		cuenta.setTotal(cuenta.getTotal() + m.getValor());
		DAOFactory.getFactory().getCuentaDAO().update(cuenta);

		DAOFactory.getFactory().getMovimientoDAO().create(m);
	}

	@POST
	@Path("/registrarEgreso")
	@Consumes(MediaType.APPLICATION_JSON)
	public void registrarEgreso(Movimiento m) {
		Cuenta cuenta = DAOFactory.getFactory().getCuentaDAO().getById(m.getCuenta().getId());
		Categoria categoria = DAOFactory.getFactory().getCategoriaDAO().getById(m.getCategoria().getId());

		if (m.getValor() < cuenta.getTotal()) {
			cuenta.setTotal(cuenta.getTotal() + m.getValor());
			DAOFactory.getFactory().getCuentaDAO().update(cuenta);
			DAOFactory.getFactory().getMovimientoDAO().create(m);
		}
	}
}
