package logico;

public class Esfera extends Queso {

	private float radio;
	
	
	
	public Esfera(String id, float precioBase, float precioUnitario, boolean estadoDeVenta, float radio) {
		super(id, precioBase, precioUnitario, estadoDeVenta);
		
		this.radio = radio;
	}

	public float getRadio() {
		return radio;
	}

	public void setRadio(float radio) {
		this.radio = radio;
	}

	@Override
	public float volumen()
	{
		float volumen = (float) ((4/3) * Math.PI * (float) Math.pow(radio, 3));
		return volumen;
	}

	
}
