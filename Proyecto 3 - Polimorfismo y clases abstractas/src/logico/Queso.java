package logico;
import java.lang.Math; 

public abstract class Queso {

	protected String id;
	protected float precioBase;
	protected float precioUnitario;
	protected boolean estadoDeVenta;
	
	public Queso(String id, float precioBase, float precioUnitario, boolean estadoDeVenta) {
		super();
		this.id = id;
		this.precioBase = precioBase;
		this.precioUnitario = precioUnitario;
		this.estadoDeVenta = estadoDeVenta;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	
	public boolean isEstadoDeVenta() {
		return estadoDeVenta;
	}

	public void setEstadoDeVenta(boolean estadoDeVenta) {
		this.estadoDeVenta = estadoDeVenta;
	}

	public abstract float volumen();
	
	public float precioTotal()
	{
		return precioBase + precioUnitario*volumen();
	}
	
}
