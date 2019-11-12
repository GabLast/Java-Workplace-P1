package logico;

public class Articulo extends Publicacion {
	
	private String arbitro;
	private static final long serialVersionUID = 1L;

	public Articulo(String id, String titulo, String autor, int cant,
			boolean status, String materia, String arbitro) {
		super(id, titulo, autor, cant, status, materia);
	this.arbitro = arbitro;
	}

	public String getArbitro() {
		return arbitro;
	}

	public void setArbitro(String arbitro) {
		this.arbitro = arbitro;
	}

}
