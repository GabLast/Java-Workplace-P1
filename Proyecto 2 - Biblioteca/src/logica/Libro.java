package logica;

public class Libro extends Publicacion {
	
	private String editorial;
	private String autor;
	
	public Libro(String id, String titulo, int cantEjemplares, String materia, 
			String editorial, String autor) {
		super(id, titulo, cantEjemplares, materia);
		
		this.editorial = editorial;
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
}
