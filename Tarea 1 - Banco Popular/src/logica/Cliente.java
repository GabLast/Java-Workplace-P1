package logica;

public class Cliente {

	private String id;
	private String cedula;
	private String nombre;
	private String apellidos;
	private String telefono;
	private int puntos = 0;
	

	public Cliente(String id, String cedula, String nombre, String apellidos, String telefono, int puntos) {
		super();
		this.id = id;
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.puntos = puntos;
	}

	public String getId() {
		return id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(double puntos) {
		this.puntos = (int) puntos;
	}
		
}
