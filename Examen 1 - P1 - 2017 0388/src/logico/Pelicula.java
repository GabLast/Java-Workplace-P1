package logico;

public class Pelicula {

	private String nombre;
	private String genero;
	private int duracion;
	
	public Pelicula(String nombre, String genero, int duracion) {
		super();
		this.nombre = nombre;
		this.genero = genero;
		this.duracion = duracion;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
}
