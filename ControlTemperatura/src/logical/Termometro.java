package logical;

public class Termometro extends Thread {
	private float actual;
	private boolean temp;
	private boolean is_aire;

	public Termometro(float actual) {
		super();
		this.actual = actual;
		this.temp = false;
		this.is_aire = false;
	}

	public float getActual() {
		return actual;
	}

	public void setActual(float actual) {
		this.actual = actual;
	}
	
	public boolean isTemp() {
		return temp;
	}

	public void setTemp(boolean temp) {
		this.temp = temp;
	}
	

	public float medir_temperatura(boolean enfriar) {
		if (enfriar)
			actual -= 0.5f;
		else if (!enfriar && actual < 32)
			actual += 0.5f;
		return actual;
	}
	/*
	private void esperarSegundos(int prod) {
		try {
			Thread.sleep(prod*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/
}
