package logica;

public class Libero extends Jugador {

	private int recibosEfectivos;

	public Libero(String nombre, int errores, int aces, int serviciosTotales, int recibosEfectivos) {
		super(nombre, errores, aces, serviciosTotales);
		
		this.recibosEfectivos = recibosEfectivos;
	}

	public int getRecibosEfectivos() {
		return recibosEfectivos;
	}

	public void setRecibosEfectivos(int recibosEfectivos) {
		this.recibosEfectivos = recibosEfectivos;
	}
	
	@Override
	public int efectividad() {
		
		return 0;
	}

}
