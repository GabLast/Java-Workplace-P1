package logico;

import java.io.Serializable;

public class Trabajadores implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cedula;
	private String nombre;
	private float salario;
	
	public Trabajadores(String cedula, String nombre, float salario) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.salario = salario;
	}

	public String getCedula() {
		return cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public float getSalario() {
		return salario;
	}
	
	
}
