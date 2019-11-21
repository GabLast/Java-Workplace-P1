package logico;

public class CHueco extends Cilindro {

	private float radioInterior;
	
	public CHueco(String id, float precioBase, float precioUnitario, boolean estadoDeVenta, 
			float radioExterior, float radioInterior, float longitud) {
		super(id, precioBase, precioUnitario, estadoDeVenta, radioExterior, longitud);
		
		this.radioInterior = radioInterior;
	}

	public float getRadioInterior() {
		return radioInterior;
	}

	public void setRadioInterior(float radioInterior) {
		this.radioInterior = radioInterior;
	}

	@Override
	public float volumen()
	{
		float volumen = -1;
		if(radioExterior > radioInterior)
			volumen = areaBase() * longitud;
		
		return volumen;
	}
	
	@Override
	public float areaBase()
	{
		float area = (float)(Math.PI * Math.pow(radioExterior, 2) - (float) (Math.PI * Math.pow(radioInterior, 2)));
		return area;
	}
	
}
