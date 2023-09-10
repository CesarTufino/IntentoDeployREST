package modelo.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "movimiento")
public class Movimiento implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "concepto")
	private String concepto;
	@Column(name = "valor")
	private double valor;
	@Column(name = "fecha")
	@Temporal(TemporalType.DATE)
	private Date fecha;
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "categoria")
	private Categoria categoria;
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "cuenta")
	private Cuenta cuenta;
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "relacion")
	private Movimiento relacion;


	public Movimiento() {

	}
	
	public Movimiento(String concepto, double valor, Date fecha, Categoria categoria,
			Cuenta cuenta) {
		this.concepto = concepto;
		this.valor = valor;
		this.fecha = fecha;
		this.categoria = categoria;
		this.cuenta = cuenta;
	}

	public Movimiento(String concepto, double valor, Date fecha, Categoria categoria, Cuenta cuenta,
			Movimiento relacion) {
		this.concepto = concepto;
		this.valor = valor;
		this.fecha = fecha;
		this.categoria = categoria;
		this.cuenta = cuenta;
		this.relacion = relacion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public Movimiento getRelacion() {
		return relacion;
	}

	public void setRelacion(Movimiento relacion) {
		this.relacion = relacion;
	}
	
	
	
}
