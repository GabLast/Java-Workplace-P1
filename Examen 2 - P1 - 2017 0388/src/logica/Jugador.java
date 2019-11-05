package logica;

public abstract class Jugador {

	protected String nombre;
	protected int errores;
	protected int aces;
	protected int serviciosTotales;
	
	public Jugador(String nombre, int errores, int aces, int serviciosTotales) {
		super();
		this.nombre = nombre;
		this.errores = errores;
		this.aces = aces;
		this.serviciosTotales = serviciosTotales;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getErrores() {
		return errores;
	}
	public void setErrores(int errores) {
		this.errores = errores;
	}
	public int getAces() {
		return aces;
	}
	public void setAces(int aces) {
		this.aces = aces;
	}
	public int getServiciosTotales() {
		return serviciosTotales;
	}
	public void setServiciosTotales(int serviciosTotales) {
		this.serviciosTotales = serviciosTotales;
	}
	
	public abstract float efectividad();
}
