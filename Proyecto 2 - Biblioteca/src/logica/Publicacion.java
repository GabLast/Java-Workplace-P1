package logica;

public class Publicacion {
	
	protected String id;
	protected String titulo;
	protected int cantEjemplares;
	protected boolean estado;
	protected String materia;
	
	public Publicacion(String id, String titulo, int cantEjemplares, String materia) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.cantEjemplares = cantEjemplares;
		this.materia = materia;
		this.estado = true;
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

	public int getCantEjemplares() {
		return cantEjemplares;
	}

	public void setCantEjemplares(int cantEjemplares) {
		this.cantEjemplares = cantEjemplares;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public void actualizarEjemplares(boolean retirandoUnEjemplar) {
		
		if(retirandoUnEjemplar)
		{
			cantEjemplares--;
			if(cantEjemplares == 0)
			{
				estado = false;
			}
		}
		else
		{
			cantEjemplares++;
			
			if(cantEjemplares > 0)
			{
				estado = true;
			}
		}
		
	}
	

}
