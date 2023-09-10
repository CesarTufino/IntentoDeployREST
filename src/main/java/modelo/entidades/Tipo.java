package modelo.entidades;

import java.util.Arrays;
import java.util.List;

public enum Tipo {
	INGRESO(0,"Ingreso"),
	EGRESO(1,"Egreso"),
	TRANSFERENCIA(2,"Transferencia");
	
	private int id;
	private String descripcion;
	
	private Tipo(int id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public static Tipo getById(int id) {
		for (Tipo tipo : values()) {
			if (tipo.getId() == id)
				return tipo;
		}
		return null;
	}
	
	public static List<Tipo> getAll() {
		List<Tipo> tipos = Arrays.asList(values());
		return tipos;
	}
	
	

}
