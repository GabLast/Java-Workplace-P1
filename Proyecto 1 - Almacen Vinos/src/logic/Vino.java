package logic;

public class Vino {
	private String id;
	private String nombre;
	private String tipo;
	private int cosechaAnio;
	private int disponibilidadMin;
	private int disponibilidadMax;
	private int disponibilidadReal;
	private int[] ventas;
	private Suministrador miSumi;
	private float precioCompra;
	private float precioVenta;
	
	
	public Vino(String id, String nombre, String tipo, int cosechaAnio, int disponibilidadMin, int disponibilidadMax,
			int disponibilidadReal, Suministrador miSumi, float precioCompra, float precioVenta) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.cosechaAnio = cosechaAnio;
		this.disponibilidadMin = disponibilidadMin;
		this.disponibilidadMax = disponibilidadMax;
		this.disponibilidadReal = disponibilidadReal;
		this.miSumi = miSumi; //no es necesario un new porque es conocer. Si fuera una composiicon, si fuera new.
		this.ventas = new int[10];
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public int getCosechaAnio() {
		return cosechaAnio;
	}


	public void setCosechaAnio(int cosechaAnio) {
		this.cosechaAnio = cosechaAnio;
	}


	public int getDisponibilidadMin() {
		return disponibilidadMin;
	}


	public void setDisponibilidadMin(int disponibilidadMin) {
		this.disponibilidadMin = disponibilidadMin;
	}


	public int getDisponibilidadMax() {
		return disponibilidadMax;
	}


	public void setDisponibilidadMax(int disponibilidadMax) {
		this.disponibilidadMax = disponibilidadMax;
	}


	public int getDisponibilidadReal() {
		return disponibilidadReal;
	}


	public void setDisponibilidadReal(int disponibilidadReal) {
		this.disponibilidadReal = disponibilidadReal;
	}


	public int[] getVentas() {
		return ventas;
	}


	public void setVentas(int[] ventas) {
		this.ventas = ventas;
	}


	public Suministrador getMiSumi() {
		return miSumi;
	}


	public void setMiSumi(Suministrador miSumi) {
		this.miSumi = miSumi;
	}
	
	public float getPrecioCompra() {
		return precioCompra;
	}


	public void setPrecioCompra(float precioCompra) {
		this.precioCompra = precioCompra;
	}


	public float getPrecioVenta() {
		return precioVenta;
	}


	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}

	public boolean promedioVentas() {
		
		boolean promedio = false;
		int suma = 0;
		for(int i = 6; i <= 8; i++)
		{
			suma += ventas[i];
		}
		
		if(ventas[9] > suma/3)
		{
			promedio = true;
		}
		
		return promedio;
	}

	public float rentabilidad()
	{
		float suma=0;
		for(int i = 0; i < ventas.length; i++)
		{
			suma += (ventas[i] * precioCompra - ventas[i] * precioVenta);
			
		}
		
		return suma;
	}	
}
