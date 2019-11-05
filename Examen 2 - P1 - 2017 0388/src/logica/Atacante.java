package logica;

public abstract class Atacante extends Jugador {
	
	protected int ataquesEfectivos;
	protected int bloqueosEfectivos;
	protected int bloqueosFallidos;
	
	public Atacante(String nombre, int errores, int aces, int serviciosTotales,
			int ataquesEfectivos, int bloqueosEfectivos, int bloqueosFallidos) {
		super(nombre, errores, aces, serviciosTotales);
		
		this.ataquesEfectivos = ataquesEfectivos;
		this.bloqueosEfectivos = bloqueosEfectivos;
		this.bloqueosFallidos = bloqueosFallidos;
	}
	
	public int getAtaquesEfectivos() {
		return ataquesEfectivos;
	}

	public void setAtaquesEfectivos(int ataquesEfectivos) {
		this.ataquesEfectivos = ataquesEfectivos;
	}

	public int getBloqueosEfectivos() {
		return bloqueosEfectivos;
	}

	public void setBloqueosEfectivos(int bloqueosEfectivos) {
		this.bloqueosEfectivos = bloqueosEfectivos;
	}

	public int getBloqueosFallidos() {
		return bloqueosFallidos;
	}

	public void setBloqueosFallidos(int bloqueosFallidos) {
		this.bloqueosFallidos = bloqueosFallidos;
	}

	@Override
	public float efectividad() {
		
		float efectividad;
		
		efectividad = ((ataquesEfectivos + bloqueosEfectivos - bloqueosFallidos - errores) * 100 / (ataquesEfectivos + 
				bloqueosEfectivos + bloqueosFallidos + errores) + (aces * 100 / serviciosTotales));
		
		return efectividad;
	}

}
