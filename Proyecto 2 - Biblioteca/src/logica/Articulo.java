package logica;

public class Articulo extends Publicacion {
	
	private String autor;
	private String arbitro;
	
	public Articulo(String id, String titulo, int cantEjemplares, String materia, String autor, String arbitro) {
		super(id, titulo, cantEjemplares, materia);
		this.autor = autor;
		this.arbitro = arbitro;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getArbitro() {
		return arbitro;
	}

	public void setArbitro(String arbitro) {
		this.arbitro = arbitro;
	}
	
	
}
