package logica;

public class Revista extends Publicacion {

	private int anio;
	private String numero;
	
	public Revista(String id, String titulo, int cantEjemplares, String materia, int anio, String numero) {
		super(id, titulo, cantEjemplares, materia);
		this.anio = anio;
		this.numero = numero;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
}
