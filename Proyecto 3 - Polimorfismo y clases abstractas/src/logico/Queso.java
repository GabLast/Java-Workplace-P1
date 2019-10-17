package logico;
import java.lang.Math; 

public abstract class Queso {

	protected float precioBase;
	protected float precioUnitario;
	
	
	public Queso(float precioBase, float precioUnitario) {
		super();
		this.precioBase = precioBase;
		this.precioUnitario = precioUnitario;
		
	}

	public float getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(float precioBase) {
		this.precioBase = precioBase;
	}

	public float getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	
	public abstract float volumen();
	
	public float precioTotal()
	{
		return precioBase + precioUnitario*volumen();
	}
	
}
