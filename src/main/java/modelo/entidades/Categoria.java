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
@Table(name = "categoria")
public class Categoria implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "tipo")
	private Tipo tipo;
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "propietario")
	private Persona propietario;
	
	public Categoria() {

	}

	public Categoria(String nombre, Tipo tipo, Persona propietario) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.propietario = propietario;
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
	

	public Tipo getTipoMovimiento() {
		return tipo;
	}

	public void setTipoMovimiento(Tipo tipoMovimiento) {
		this.tipo = tipoMovimiento;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Persona getPropietario() {
		return propietario;
	}

	public void setPropietario(Persona propietario) {
		this.propietario = propietario;
	}
	

}
