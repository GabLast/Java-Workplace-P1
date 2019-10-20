package logico;

public class Publicacion {
	
	protected String id;
	protected String titulo;
	protected String autor;
	protected int cant;
	protected boolean status;
	protected String materia;
	
	public Publicacion(String id, String titulo, String autor, int cant,
			boolean status, String materia) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.cant = cant;
		this.status = status;
		this.materia = materia;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		if(cant == 0){
			status = false;
			this.cant = 0;
		}else{
		this.cant = cant;
		}
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}
	
	

}
