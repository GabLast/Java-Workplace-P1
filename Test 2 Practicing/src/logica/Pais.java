package logica;

public class Pais {

	private String nombre;
	private String entrenador;
	private int ranking;
	
	public Pais(String nombre, String entrenador, int ranking) {
		super();
		this.nombre = nombre;
		this.entrenador = entrenador;
		this.ranking = ranking;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEntrenador() {
		return entrenador;
	}
	public void setEntrenador(String entrenador) {
		this.entrenador = entrenador;
	}
	public int getRanking() {
		return ranking;
	}
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	
}
