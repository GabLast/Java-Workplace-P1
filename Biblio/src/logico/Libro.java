package logico;

public class Libro extends Publicacion {
	
	private String editorial;
	private static final long serialVersionUID = 1L;	

	public Libro(String id, String titulo, String autor, int cant,
			boolean status, String materia, String editorial) {
		super(id, titulo, autor, cant, status, materia);
		this.editorial = editorial;
	}


	public String getEditorial() {
		return editorial;
	}


	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

}
