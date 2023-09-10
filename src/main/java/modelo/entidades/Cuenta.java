package modelo.entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cuenta")
public class Cuenta implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "nombre")
	private String nombre;
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "propietario")
	private Persona propietario;
	@Column(name = "total")
	private double total;

	public Cuenta() {

	}

	public Cuenta(String nombre, Persona propietario, double total) {
		this.nombre = nombre;
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

	public Persona getPropietario() {
		return propietario;
	}

	public void setPropietario(Persona propietario) {
		this.propietario = propietario;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
}
