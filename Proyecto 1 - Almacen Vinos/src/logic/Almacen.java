package logic;

public class Almacen {
	private Vino[] misVinos;
	private Suministrador[] misSumis;
	private static int cantVinos;
	private static int cantSumis;
	private static int generadorCodigoVino = 1;
	private static int generadorCodigoSupli = 1;


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
		generadorCodigoSupli++;
	}

	public void insertarVino(Vino vino)
	{
		misVinos[cantVinos] = vino;
		cantVinos++;
		generadorCodigoVino++;
	}

	public boolean hacerPedido(String idVino)
	{
		boolean hacer = false;
		Vino aux = buscarVino(idVino);

		if(aux != null)
		{
			if(aux.getMiSumi().getTiempoEntrega() < 30 && aux.getDisponibilidadReal() > aux.getDisponibilidadMin() && aux.getDisponibilidadReal() < aux.getDisponibilidadMax() && aux.promedioVentas())
			{//aux.getDisponibilidadReal() < aux.getDisponibilidadMin() antes
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
		float masRentable = misVinos[0].rentabilidad();
		
		for(int i = 1; i < cantVinos; i++)
		{
			if(masRentable < misVinos[i].rentabilidad())
			{
				masRentable = misVinos[i].rentabilidad();
				nombre = misVinos[i].getNombre();
			}
		}
		
		return nombre;
	}

	public static int getGeneradorCodigoVino() {
		return generadorCodigoVino;
	}

	public static int getGeneradorCodigoSupli() {
		return generadorCodigoSupli;
	}
	
	public int obtenerIndiceSumi(String codigo) {
		boolean aEncontrar = false;
		int i = 0;
		int index = -1;
		
		while(!aEncontrar && i < cantSumis)
		{
			if(codigo.equalsIgnoreCase(misSumis[i].getId()))
			{
				aEncontrar = true;
				index = i;
			}
			i++;
		}
		return index;		
	}
	
	public void eliminarSuplidor(String suministradorEliminar) {
		int indice = -1;
		int i = 0;
		
		if(obtenerIndiceSumi(suministradorEliminar) >= -1)
		{
			index = obtenerIndiceSumi(suministradorEliminar);
			i = index;
			
			while(i < cantSumis-1)
			{
				misSumis[i] = misSumis[i+1];
				i++;
			}
			cantSumis--;
		}
	}
}

