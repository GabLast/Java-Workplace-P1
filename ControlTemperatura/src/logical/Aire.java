package logical;

public class Aire extends Thread {
	private float rangoU;
	private int razon;
	private boolean encendido;
	private Termometro temp;

	
	public Aire() {
		super();
		this.rangoU = 2;
		this.temp = new Termometro((float)(Math.random() * 40 + 1));
		this.razon = 1;
		this.encendido = false;
	}


	public float getRangoU() {
		return rangoU;
	}


	public int getRazon() {
		return razon;
	}


	public void setRangoU(float rangoU) {
		this.rangoU = rangoU;
	}


	public void setRazon(int razon) {
		this.razon = razon;
	}
	
	public boolean isEncendido() {
		return encendido;
	}


	public void setEncendido(boolean encendido) {
		this.encendido = encendido;
	}


	public Termometro getTemp() {
		return temp;
	}


	public void Activar_Calor() {
		razon = 2;
	}
	
	public void Parar() {
		razon = 1;
	}
	
	public void Activar_Frio() {
		razon = 0;
	}
	
	@Override
	public void run() {
		encendido = true;
		while (encendido) {
			
			if (Selector.getSeleccion() + rangoU < temp.getActual()) {
				Activar_Frio();
			} else if (Selector.getSeleccion() - rangoU > temp.getActual()) {
				Parar();
			}
			esperarSegundos(1);
			temp.medir_temperatura(razon == 1 ? false : true);
			System.out.print("\nTemperatura actual: " + temp.getActual() + "C. ");
			System.out.print(razon == 1 ? "Calentando" : "Enfriando");
		}
	}
	
	private void esperarSegundos(Integer prod) {
		try {
			Thread.sleep(prod*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
