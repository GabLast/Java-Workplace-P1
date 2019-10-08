package logica;

public class Almacen {

	private String codigo;
	private String ciudad;
	private String municipio;
	private double capacidadAlma;
	private double superficie;
	private Producto[] productos;
	private static int cantProductos;
	
	public Almacen(String codigo, String ciudad, String municipio, double capacidadAlma, double superficie) {
		super();
		this.codigo = codigo;
		this.ciudad = ciudad;
		this.municipio = municipio;
		this.capacidadAlma = capacidadAlma;
		this.superficie = superficie;
		productos = new Producto[10];
		cantProductos = 0;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public double getCapacidadAlma() {
		return capacidadAlma;
	}

	public void setCapacidadAlma(double capacidadAlma) {
		this.capacidadAlma = capacidadAlma;
	}

	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}

	public Producto[] getProductos() {
		return productos;
	}

	public void setProductos(Producto[] productos) {
		this.productos = productos;
	}

	public static int getCantProductos() {
		return cantProductos;
	}

	public static void setCantProductos(int cantProductos) {
		Almacen.cantProductos = cantProductos;
	}
	
	public void insertarProducto(Producto producto)
	{
		productos[cantProductos] = producto;
		cantProductos++;
	}
	
	public float estimarGanancias()
	{
		int i = 0;
		int estimado = 0;
		
		for(i = 0; i < cantProductos; i++)
		{
			estimado += productos[i].calcularGanancia();
		}
		
		return estimado;
	}
	
	public float estimarPerdidas()
	{
		int i = 0;
		int estimado = 0;
		
		for(i = 0; i < cantProductos; i++)
		{
			estimado += productos[i].calcularPerdidaPorVencimiento();
		}
		
		return estimado;
	}
	
	public int cantidadProductoPorTipo(String tipo)
	{
		int cantidad = 0;
		int i;
		
		for(i = 0; i < cantProductos; i++)
		{
			cantidad += productos[i].stockDelProducto(tipo);
		}
		
		return cantidad;
	}

	public String despacharProducto(String codigoProducto) {
		
		String code = null;
		int i;	
		
		for(i = 0; i < cantProductos; i++)
		{
			if(productos[i].despacho(codigoProducto))
			{
				code = codigo;
			}
		}
		
		return code;
	}
}
