package logica;

public class Banco {

	private Cliente[] clientes;
	private Cuenta[] cuentas;
	private static int cantClientes;
	private static int cantCuentas;

	public Banco() {
		super();

		cantClientes = 0;
		cantCuentas = 0;
		clientes = new Cliente[50];
		cuentas = new Cuenta[50];
	}

	public Cliente[] getClientes() {
		return clientes;
	}

	public void setClientes(Cliente[] clientes) {
		this.clientes = clientes;
	}

	public Cuenta[] getCuentas() {
		return cuentas;
	}

	public void setCuentas(Cuenta[] cuentas) {
		this.cuentas = cuentas;
	}

	public static int getCantClientes() {
		return cantClientes;
	}

	public static void setCantClientes(int cantClientes) {
		Banco.cantClientes = cantClientes;
	}

	public static int getCantCuentas() {
		return cantCuentas;
	}

	public static void setCantCuentas(int cantCuentas) {
		Banco.cantCuentas = cantCuentas;
	}

	public void insertarCliente(Cliente cliente) {
		clientes[cantClientes] = cliente;
		cantClientes++;
	}

	public void insertarCuenta(Cuenta cuenta) {
		cuentas[cantCuentas] = cuenta;
		cantCuentas++;
	}

	public Cuenta buscarCuenta(String codigoCuenta) {

		boolean encontrado = false;
		Cuenta aBuscar = null;
		int i = 0;

		while(!encontrado && i < cantCuentas) {
			if(cuentas[i].getCodigo().equalsIgnoreCase(codigoCuenta))
			{
				encontrado = true;
				aBuscar = cuentas[i];
			}
			i++;
		}

		return aBuscar;
	}

	public Cliente buscarCliente(String cedulaCliente) {

		boolean encontrado = false;
		Cliente aBuscar = null;
		int i = 0;

		while(!encontrado && i < cantClientes) {
			if(clientes[i].getCedula().equalsIgnoreCase(cedulaCliente))
			{
				encontrado = true;
				aBuscar = clientes[i];
			}
			i++;
		}

		return aBuscar;
	}

	public int buscarIndiceCuenta(String codigoCuenta) {

		boolean encontrado = false;
		int aBuscar = -1;
		int i = 0;
		
		while(!encontrado && i < cantCuentas) {
			if(cuentas[i].getCodigo().equalsIgnoreCase(codigoCuenta))
			{
				encontrado = true;
				aBuscar = i;
			}
			i++;
		}
		return aBuscar;
	}

	public double ingresarDinero(String codigoCuenta, double dineroIngresar) {

		int indiceCuenta = buscarIndiceCuenta(codigoCuenta);
		//Cuenta cuenta = buscarCuenta(codigoCuenta);
		
		if(/*cuenta != null*/cuentas[indiceCuenta] != null && indiceCuenta > -1 
				&& cuentas[indiceCuenta].getEstado().equalsIgnoreCase("Habilitada")) 
		{
			//cuenta.setDineroActual(cuenta.getDineroActual()+dineroIngresar);
			//cuentas[indiceCuenta] = cuenta;
			cuentas[indiceCuenta].setDineroActual(cuentas[indiceCuenta].getDineroActual() + dineroIngresar);
			return dineroIngresar;
		}
		
		return 0;
	}
	
	public boolean retirarDinero(String codigoCuenta, double dineroRetirar) {

		int indiceCuenta = buscarIndiceCuenta(codigoCuenta);
		
		if(cuentas[indiceCuenta] != null && indiceCuenta > -1 
				&& cuentas[indiceCuenta].getEstado().equalsIgnoreCase("Habilitada"))
		{
			if(cuentas[indiceCuenta].getTipoDeCuenta().equalsIgnoreCase("Cuenta_Corriente")
					&& dineroRetirar < cuentas[indiceCuenta].getDineroActual())
			{
				cuentas[indiceCuenta].setDineroActual(cuentas[indiceCuenta].getDineroActual() - dineroRetirar);
				return true;
			}
			
			else if(cuentas[indiceCuenta].getTipoDeCuenta().equalsIgnoreCase("Cuenta_Vivienda"))
			{
				return false;
			}
			
			else if(cuentas[indiceCuenta].getTipoDeCuenta().equalsIgnoreCase("Fondo_Inversion"))
			{
				if(dineroRetirar > 500)
				{
					cuentas[indiceCuenta].setEstado("Bloqueada");;
					return false;
				}
				
				cuentas[indiceCuenta].setDineroActual(cuentas[indiceCuenta].getDineroActual() - dineroRetirar);
				return true;
			}
			
		}
		
		return false;
	}

	public double mostrarSaldoActual(String codigoCuenta) {
		
		int indiceCuenta = buscarIndiceCuenta(codigoCuenta);
		
		if(indiceCuenta > -1) 
		{
			return cuentas[indiceCuenta].getDineroActual();
		}
		
		return -1;
	}
}
