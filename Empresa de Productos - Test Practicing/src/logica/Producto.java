package logica;

public class Producto {

	private String codigo;
	private String nombre;
	private String tipo; //electronico,comestible,atuendo
	private double precioCompra;
	private double precioVenta;
	private int diasParaVencer;
	private int stockReal;
	private int stockInicial;
	
	public Producto(String codigo, String nombre, String tipo, double precioCompra, double precioVenta,
			int diasParaVencer, int stockReal, int stockInicial) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.tipo = tipo;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
		this.diasParaVencer = diasParaVencer;
		this.stockReal = stockReal;
		this.stockInicial = stockInicial;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	public double getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public int getDiasParaVencer() {
		return diasParaVencer;
	}

	public void setDiasParaVencer(int diasParaVencer) {
		this.diasParaVencer = diasParaVencer;
	}

	public int getStockReal() {
		return stockReal;
	}

	public void setStockReal(int stockReal) {
		this.stockReal = stockReal;
	}

	public int getStockInicial() {
		return stockInicial;
	}

	public void setStockInicial(int stockInicial) {
		this.stockInicial = stockInicial;
	}
	
	public float calcularGanancia()
	{
		float ganancia = 0;
		
		ganancia = (float) (stockReal * (precioVenta - precioCompra));
		
		return ganancia;
	}
	
	public float calcularPerdidaPorVencimiento()
	{
		float perdida = 0;
		
		if(tipo.equalsIgnoreCase("Comestible") && diasParaVencer < 60)
		{
			perdida = (float) (precioVenta - (float) (precioVenta * 0.50));
		}
		else if(tipo.equalsIgnoreCase("Atuendo") && diasParaVencer < 75)
		{
			perdida = (float) (precioVenta - (float) (precioVenta * 0.35));
		}
		else if(tipo.equalsIgnoreCase("Electrónico") && diasParaVencer < 90)
		{
			perdida = (float) (precioVenta - (float) (precioVenta * 0.20));
		}
		
		return perdida;
	}

	public int stockDelProducto(String tipo2) {
		
		int stock = 0;
		
		if(tipo2.equalsIgnoreCase(tipo))
		{
			stock = stockReal;
		}
		
		return stock;
	}

	public boolean despacho(String codigoProducto) {
		
		boolean despacho = false;
		
		if(codigo.equalsIgnoreCase(codigoProducto))
		{
			if(stockReal >= (stockInicial * 0.10))
			{
				despacho = true;
			}
		}
		
		
		return despacho;
	}
}
