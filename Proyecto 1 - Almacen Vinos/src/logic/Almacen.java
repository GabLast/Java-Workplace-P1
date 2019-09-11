package logic;

public class Almacen {
	private Vino[] misVinos;
	private Suministrador[] misSumis;
	private static int cantVinos;
	private static int cantSumis;


	public Almacen() {
		super();

		cantSumis = 0;
		cantVinos = 0;
		misSumis = new Suministrador[50];
		misVinos = new Vino[50];
	}

	public Vino[] getMisVinos() {
		return misVinos;
	}

	public void setMisVinos(Vino[] misVinos) {
		this.misVinos = misVinos;
	}

	public Suministrador[] getMisSumis() {
		return misSumis;
	}

	public void setMisSumis(Suministrador[] misSumis) {
		this.misSumis = misSumis;
	}

	public static int getCantVinos() {
		return cantVinos;
	}

	public static void setCantVinos(int cantVinos) {
		Almacen.cantVinos = cantVinos;
	}

	public static int getCantSumis() {
		return cantSumis;
	}

	public static void setCantSumis(int cantSumis) {
		Almacen.cantSumis = cantSumis;
	}

	public void insertarSuministrador(Suministrador sumi)
	{
		misSumis[cantSumis] = sumi;
		cantSumis++;
	}

	public void insertarVino(Vino vino)
	{
		misVinos[cantVinos] = vino;
		cantVinos++;
	}

	public boolean hacerPedido(String idVino)
	{
		boolean hacer = false;
		Vino aux = buscarVino(idVino);

		if(aux != null)
		{
			if(aux.getMiSumi().getTiempoEntrega() < 30 && aux.getDisponibilidadReal() < aux.getDisponibilidadMin() && aux.promedioVentas())
			{
				hacer = true;
			}
		}

		return hacer;
	}

	private Vino buscarVino(String idVino) {

		Vino aux = null;
		boolean encontrado = false;
		int i = 0;

		while(!encontrado)
		{
			if(misVinos[i].getId().equalsIgnoreCase(idVino));
			{
				aux = misVinos[i];
				encontrado = true;
			}

			i++;
		}

		return aux;
	}

	private Suministrador buscarSuministrador(String idSumi) 
	{

		Suministrador aux = null;
		boolean encontrado = false;
		int i = 0;

		while(!encontrado)
		{
			if(misSumis[i].getId().equalsIgnoreCase(idSumi));
			{
				aux = misSumis[i];
				encontrado = true;
			}

			i++;
		}

		return aux;
	}

	public int cantidadTipoDeVino(String tipo) 
	{
		int i = 0;
		int cantidad = 0;

		for(i = 0; i < cantVinos; i++)
		{
			if(misVinos[i].getTipo().equals(tipo))
			{
				cantidad += misVinos[i].getDisponibilidadReal();
			}
		}

		return cantidad;

	}
	
	public String vinoMasRentable()
	{
		String nombre = misVinos[0].getNombre();
		float aux = misVinos[0].rentabilidad();
		
		for(int i = 1; i < cantVinos; i++)
		{
			if(aux < misVinos[i].rentabilidad())
			{
				aux = misVinos[i].rentabilidad();
				nombre = misVinos[i].getNombre();
			}
		}
		
		return nombre;
	}
}

