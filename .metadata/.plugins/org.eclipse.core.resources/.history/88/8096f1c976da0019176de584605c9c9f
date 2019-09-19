package logico;

public class Almacen {

	private Vino[] misVinos;
	private Suministrador[] misSumis;
	private static int cantVinos;
	private static int cantSumi;
	private static int generadorCodigoVino=1;
	private static int generadorCodigoSupli=1;

	public Almacen() {
		super();
		cantSumi = 0;
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

	public static int getCantSumi() {
		return cantSumi;
	}

	public static void setCantSumi(int cantSumi) {
		Almacen.cantSumi = cantSumi;
	}
	
	public void insertarSuministrador(Suministrador sumi){
		misSumis[cantSumi] = sumi;
		cantSumi++;
		generadorCodigoSupli++;
	}
	
	public void insertarVino(Vino vino){
		misVinos[cantVinos] = vino;
		cantVinos++;
		generadorCodigoVino++;
	}
	
	public boolean hacerPedido(String idVino){
		boolean hacer = false;
		Vino aux = buscarVino(idVino);
		if(aux!=null){
			if(aux.getMiSumi().getTiempoEntrega()<30 && aux.getDispReal()<aux.getDispMin() && aux.promedioVentas()){
				hacer = true;
			}
		}
		return hacer;
	}

	public Vino buscarVino(String idVino) {
		Vino aux = null;
		boolean encontrado = false;
		int i = 0;
		while(! encontrado && i< cantVinos){
			if(misVinos[i].getId().equalsIgnoreCase(idVino)){
				aux = misVinos[i];
				encontrado = true;
			}
			i++;
		}
		return aux;
	}
	
	public Suministrador buscarSuministrador(String idSumi) {
		Suministrador aux = null;
		boolean encontrado = false;
		int i = 0;
		while(! encontrado && i< cantSumi){
			if(misSumis[i].getId().equalsIgnoreCase(idSumi)){
				aux = misSumis[i];
				encontrado = true;
			}
			i++;
		}
		return aux;
	}
	
	public int cantByTipo(String tipo){
		int suma = 0;
		for (int i = 0; i < cantVinos; i++) {
			if(misVinos[i].getTipo().equalsIgnoreCase(tipo)){
				suma+=misVinos[i].getDispReal();
			}
		}
	    return suma;			
	}
	
	public String vinoMasRentable(){
		String nombre = misVinos[0].getNombre();
		float aux = misVinos[0].gananciaTotal();
		for (int i = 1; i < cantVinos; i++) {
			if(aux<misVinos[i].gananciaTotal()){
				aux = misVinos[i].gananciaTotal();
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
	
	private int indexBycodigo(String codigo) {
		boolean encontrado = false;
		int i = 0;
		int index = -1;
		while (!encontrado && i< cantSumi) {
			if(misSumis[i].getId().equalsIgnoreCase(codigo)){
				encontrado = true;
				index = i;
				
			}
			i++;
		}
		return index;
	}

	public void eliminarSuministrador(String identificador) {
		int index = -1;
		int i= 0;
		if(indexBycodigo(identificador)>-1){
			index = indexBycodigo(identificador);
			i = index;
				while(i<cantSumi-1){
				  misSumis[i]=misSumis[i+1];
				  i++;
				}
			cantSumi--;	
		}

	}

}
