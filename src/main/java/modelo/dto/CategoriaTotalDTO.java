package modelo.dto;
import java.io.Serializable;

public class CategoriaTotalDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private int tipo;
	private int propietario;
	private double total;

	public CategoriaTotalDTO() {
	}

	public CategoriaTotalDTO(int id, String nombre, int tipo, int propietario, double total) {
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.propietario = propietario;
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getPropietario() {
		return propietario;
	}

	public void setPropietario(int propietario) {
		this.propietario = propietario;
	}
	
}