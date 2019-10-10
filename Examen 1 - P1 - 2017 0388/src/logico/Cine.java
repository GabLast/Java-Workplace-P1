package logico;

public class Cine {

	private String codigo;
	private String nombre;
	private int cantSalas;
	private String provincia;
	private float[] recaudacionMes;
	private Boleta[] boletas;
	private static int cantBoletas;
	//debi poner que el cine conoce las peliculas OJO
	
	public Cine(String codigo, String nombre, int cantSalas, String provincia) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.cantSalas = cantSalas;
		this.provincia = provincia;
		recaudacionMes = new float[30];
		boletas = new Boleta[10];
		cantBoletas = 0;
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

	public int getCantSalas() {
		return cantSalas;
	}

	public void setCantSalas(int cantSalas) {
		this.cantSalas = cantSalas;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public float[] getRecaudacionDiaria() {
		return recaudacionMes;
	}

	public void setRecaudacionDiaria(float[] recaudacionDiaria) {
		this.recaudacionMes = recaudacionDiaria;
	}
	
	
	public int compararRecaudacion() {
	
		int i;
		int mayor = -1;
		
		for(i = 0; i < 30; i++)
		{
			if(recaudacionMes[i] > mayor)
			{
				mayor = i;
			}
		}
		
		
		return mayor;
	}

	public float calcularVentas() {
		
		float ventas = 0;
		int i;
		
		for(i = 0; i < 30; i++)
		{
			ventas += recaudacionMes[i];
		}
		
		return ventas;
	}

	public String compararPeliculasPorGenero() {
		
		int i;
		String genero = null;
		int accion = 0;
		int comedia = 0;
		int terror = 0;
		
		for(i = 0; i < cantBoletas; i++)
		{
			if(boletas[i].getPeliculaProyectada().getGenero().equalsIgnoreCase("Acción"))
			{
				accion++;
			}
			else if(boletas[i].getPeliculaProyectada().getGenero().equalsIgnoreCase("Comedia"))
			{
				comedia++;
			}
			else if(boletas[i].getPeliculaProyectada().getGenero().equalsIgnoreCase("Terror"))
			{
				terror++;
			}
		}
		
		if(accion > comedia && accion > terror)
		{
			genero = "Acción";
		}
		else if(comedia > accion && comedia > terror)
		{
			genero = "Comedia";
		}else if(terror > accion && terror > comedia)
		{
			genero = "Terror";
		}
	
		return genero;
	}

	public int cantidadProyecciones(String nombrePeli) {
		
		int cantidad = 0;
		int i;
		
		for(i = 0; i < cantBoletas; i++)
		{
			if(boletas[i].getPeliculaProyectada().getNombre().equalsIgnoreCase(nombrePeli))
			{
				cantidad++;
			}
		}
		
		return cantidad;
	}
	
	
}
