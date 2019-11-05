package logica;

public class Pasador extends Jugador {

	private int pases;
	private int fintasEfectivas;
	
	public Pasador(String nombre, int errores, int aces, int serviciosTotales, int pases, int fintasEfectivas) {
		super(nombre, errores, aces, serviciosTotales);
		
		this.pases = pases;
		this.fintasEfectivas = fintasEfectivas;
	}
	
	public int getPases() {
		return pases;
	}

	public void setPases(int pases) {
		this.pases = pases;
	}

	public int getFintasEfectivas() {
		return fintasEfectivas;
	}

	public void setFintasEfectivas(int fintasEfectivas) {
		this.fintasEfectivas = fintasEfectivas;
	}

	@Override
	public int efectividad() {
		
		return 0;
	}



}
