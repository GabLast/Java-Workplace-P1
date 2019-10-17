package logico;

public class Esfera extends Queso {

	private float radio;
	
	public Esfera(float precioBase, float precioUnitario, float radio) {
		super(precioBase, precioUnitario);
		
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
