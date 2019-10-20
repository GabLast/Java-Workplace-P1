package logico;

public class Cilindro extends Queso {

	protected float radioExterior;
	protected float longitud;

	public Cilindro(String id, float precioBase, float precioUnitario, boolean estadoDeVenta, float radioExterior, float longitud) {
		super(id, precioBase, precioUnitario, estadoDeVenta);
	
		this.radioExterior = radioExterior;
		this.longitud = longitud;
	}
	
	public float getRadioExterior() {
		return radioExterior;
	}

	public void setRadioExterior(float radioExterior) {
		this.radioExterior = radioExterior;
	}

	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

	@Override
	public float volumen()
	{
		float volumen = areaBase() * longitud;
		return volumen;
	}
	
	public float areaBase()
	{
		float area = (float) (Math.PI * Math.pow(radioExterior, 2));
		return area;
	}

	

	
}
