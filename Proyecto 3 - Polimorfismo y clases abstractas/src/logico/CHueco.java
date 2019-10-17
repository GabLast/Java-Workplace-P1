package logico;

public class CHueco extends Cilindro {

	private float radioInterior;
	
	public CHueco(float precioBase, float precioUnitario, float radioExterior, float longitud, float radioInterior) {
		super(precioBase, precioUnitario, radioExterior, longitud);
		
		this.radioInterior = radioInterior;
	}

	public float areaBase()
	{
		float area = (float) (Math.PI * Math.pow(radioExterior, 2) - (float) (Math.PI * Math.pow(radioInterior, 2)));
		return area;
	}
}
