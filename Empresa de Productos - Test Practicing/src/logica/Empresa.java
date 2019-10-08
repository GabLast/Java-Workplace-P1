package logica;

public class Empresa {

	private Almacen[] almacenes;
	private static int cantAlmacenes;
	
	public Empresa() {
		super();
		cantAlmacenes = 0;
		almacenes = new Almacen[10];
	}

	public Almacen[] getAlmacenes() {
		return almacenes;
	}

	public void setAlmacenes(Almacen[] almacenes) {
		this.almacenes = almacenes;
	}

	public static int getCantAlmacenes() {
		return cantAlmacenes;
	}

	public static void setCantAlmacenes(int cantAlmacenes) {
		Empresa.cantAlmacenes = cantAlmacenes;
	}
	
	public void insertarAlmacen(Almacen unAlma)
	{
		almacenes[cantAlmacenes] = unAlma;
		cantAlmacenes++;
	}
	
	public float estimadoGanancias(Almacen miAlmacen)
	{
		float estimado = 0;
		
		estimado = miAlmacen.estimarGanancias();
		
		return estimado;
	}
	
	public float estimarPerdidasTotal()
	{
		float perdidas = 0;
		int i;
		
		for(i = 0; i < cantAlmacenes; i++)
		{
			perdidas += almacenes[i].estimarPerdidas();
		}
		
		return perdidas;
	}
	
	public int stockProductosPorTipo(String tipo)
	{
		int stock = 0;
		int i;
		
		for(i = 0; i < cantAlmacenes; i++)
		{
			stock += almacenes[i].cantidadProductoPorTipo(tipo);
		}
		
		return stock;
	}
	
	public String almacenQueDespacha(String codigoProducto)
	{
		String codeAlma = null;
		int i;
		
		for(i = 0; i < cantAlmacenes; i++)
		{
			codeAlma = almacenes[i].despacharProducto(codigoProducto);
		}
		
		return codeAlma;
	}
}
