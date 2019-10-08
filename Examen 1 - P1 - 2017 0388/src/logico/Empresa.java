package logico;

public class Empresa {

	private Cine[] misCines;
	private Pelicula[] misPeliculas;
	private static int cantCines;
	private static int cantPeliculas;
	
	public Empresa() {
		super();
		
		misCines = new Cine[10];
		misPeliculas = new Pelicula[10];
		cantCines = 1;
		cantPeliculas = 1;
	}

	public Cine[] getMisCines() {
		return misCines;
	}

	public void setMisCines(Cine[] misCines) {
		this.misCines = misCines;
	}

	public Pelicula[] getMisPeliculas() {
		return misPeliculas;
	}

	public void setMisPeliculas(Pelicula[] misPeliculas) {
		this.misPeliculas = misPeliculas;
	}
	
	private int buscarIndiceCine(String codigoCine) {

		boolean encontrado = false;
		int aBuscar = -1;
		int i = 0;
		
		while(!encontrado && i < cantCines) {
			if(misCines[i].getCodigo().equalsIgnoreCase(codigoCine))
			{
				encontrado = true;
				aBuscar = i;
			}
			i++;
		}
		
		return aBuscar;
	}
	
	public int diaMesMayorRecaudacion(String codigoCine)
	{
		int dia = -1;
		int i;
		
		for(i = 0; i < cantCines; i++)
		{
			if(misCines[i].getCodigo().equalsIgnoreCase(codigoCine))
			{
				dia = misCines[i].compararRecaudacion();
			}
			
		}
		if(dia == -1)
			return dia;
		else
			return dia+1;
	}
	
	public float estimarVentasDelMes()
	{
		float ventas = 0;
		int i;
		
		for(i = 0; i < cantCines; i++)
		{
			ventas += misCines[i].calcularVentas();
		}
		
		
		return ventas;
	}
	
	public String generoMasPopular(String codigoCine)
	{
		String genero = null;
		int i = buscarIndiceCine(codigoCine);
		
		if(i > -1)
		{
			genero = misCines[i].compararPeliculasPorGenero();
		}
	
		return genero;
	}

	public String cineMayorProyecciones(String nombrePeli)
	{
		String nombreCine = null;
		int i;
		int mayor = misCines[0].cantidadProyecciones(nombrePeli);
		nombreCine = misCines[0].getNombre();
		
		for(i = 0; i < cantCines; i++)
		{
			if(misCines[i].cantidadProyecciones(nombrePeli) > mayor)
			{
				mayor = misCines[i].cantidadProyecciones(nombrePeli);
				nombreCine = misCines[i].getNombre();
			}
			
		}
		
		return nombreCine;
	}
	
}
