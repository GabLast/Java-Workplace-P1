package logico;

import java.io.Serializable;

public class Cliente implements Serializable{

	private String nombre;
	private String cedula;
	private String direccion;
	private String telefono;
	private static final long serialVersionUID = 1L;
	
	public Cliente(String nombre, String cedula, String direccion, String telefono) {
		super();
		this.nombre = nombre;
		this.cedula = cedula;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
