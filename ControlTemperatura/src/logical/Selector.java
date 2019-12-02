package logical;

public class Selector extends Thread {
	private static float seleccion;
	
	public Selector() {
		super();
		Selector.seleccion = 0;
	}

	public static float getSeleccion() {
		return seleccion;
	}

	public static void setSeleccion(float seleccion) {
		Selector.seleccion = seleccion;
	}

	
	@Override
	public void run() {
		esperarSeleccion();
	}
	
	private void esperarSeleccion () {
		while (seleccion == 0) {
			esperarSegundos(1);	// Esperar 1 segundo mientras le dan la seleccion
		}
	}
	
	private void esperarSegundos(int prod) {
		try {
			Thread.sleep(prod*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
