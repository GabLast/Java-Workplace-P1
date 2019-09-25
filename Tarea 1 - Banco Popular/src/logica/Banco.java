package logica;

public class Banco {

	private Cliente[] clientes;
	private Cuenta[] cuentas;
	private static int cantClientes;
	private static int cantCuentas;
	private static int codigoCuenta = 0;
	private static int codigoCliente = 0;

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

	public static int getCodigoCuenta() {
		return codigoCuenta;
	}

	
	public static int getCodigoCliente() {
		return codigoCliente;
	}

	public void insertarCliente(Cliente cliente) {
		clientes[cantClientes] = cliente;
		cantClientes++;
		codigoCliente++;
	}

	public void insertarCuenta(Cuenta cuenta) {
		cuentas[cantCuentas] = cuenta;
		cantCuentas++;
		codigoCuenta++;
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

	public Cliente buscarCliente(String idCliente) {

		boolean encontrado = false;
		Cliente aBuscar = null;
		int i = 0;

		while(!encontrado && i < cantClientes) {
			if(clientes[i].getId().equalsIgnoreCase(idCliente))
			{
				encontrado = true;
				aBuscar = clientes[i];
			}
			i++;
		}

		return aBuscar;
	}
	
	public int buscarIndiceCuenta(String codigoCuenta) {

//		boolean encontrado = false;
//		int aBuscar = -1;
//		int i = 0;
//		
//		while(!encontrado && i < cantCuentas) {
//			if(cuentas[i].getCodigo().equalsIgnoreCase(codigoCuenta))
//			{
//				encontrado = true;
//				aBuscar = i;
//			}
//			i++;
//		}
//		
//		return aBuscar;
		int indice = 0;
		for (Cuenta cuenta : cuentas) {
			if(cuenta != null)
			{
				if(cuenta.getCodigo().equalsIgnoreCase(codigoCuenta)) {
					return indice;
				}
				indice++;
			}
		}
		return -1;
	}
	
	public int buscarIndiceCliente(String idCliente) {

//		boolean encontrado = false;
//		int aBuscar = -1;
//		int i = 0;

//		while(!encontrado && i < cantClientes) {
//			if(clientes[i].getId().equalsIgnoreCase(idCliente))
//			{
//				aBuscar = i;
//				encontrado = true;
//				
//			}
//			i++;
//		}
//		return aBuscar;
		
		int indice = 0;
		for (Cliente cliente : clientes) 
		{
			if(cliente != null)
			{
				if(cliente.getId().equalsIgnoreCase(idCliente)) 
				{
					return indice;
				}
				indice++;
			}
			
		}
		return -1;
	}
	public void eliminarCliente(String idCliente) {

		int i = 0;

		if(buscarIndiceCliente(idCliente) > -1)
		{
			i = buscarIndiceCliente(idCliente);

			while(i < cantClientes-1)
			{
				clientes[i] = clientes[i+1];
				i++;
			}
			cantClientes--;
		}
	}
	
	public void eliminarCuenta(String idCuenta) {

		int i = 0;

		if(buscarIndiceCuenta(idCuenta) > -1)
		{
			i = buscarIndiceCuenta(idCuenta);
			
			while(i < cantClientes-1)
			{
				cuentas[i] = cuentas[i+1];
				i++;
			}
			cantCuentas--;
		}
	}
	
	public boolean verificarTipoCuentaUnico(String idCliente, String tipo)
	{
		for(Cuenta cuenta : cuentas) 
		{
			if(cuenta != null)
			{
				if(cuenta.getPropietario().getId().equalsIgnoreCase(idCliente)) 
				{

					if(cuenta.getTipoDeCuenta().equalsIgnoreCase(tipo)) 
					{
						return true;
					}

				}
			}
		}
		return false;
	}

	public double ingresarDinero(String codigoCuenta, double dineroIngresar) {

		int indiceCuenta = buscarIndiceCuenta(codigoCuenta);
		
		
		if(cuentas[indiceCuenta] != null && indiceCuenta > -1 
				&& cuentas[indiceCuenta].getEstado().equalsIgnoreCase("Habilitada")) 
		{
			cuentas[indiceCuenta].setDineroActual(cuentas[indiceCuenta].getDineroActual() + dineroIngresar);
			cuentas[indiceCuenta].setPuntos(dineroIngresar/6 + cuentas[indiceCuenta].getPuntos());
			cuentas[indiceCuenta].getPropietario().setPuntos(dineroIngresar/6 + cuentas[indiceCuenta].getPropietario().getPuntos());
			return dineroIngresar;
		}
		
		return 0;
	}
	
	public boolean retirarDinero(String codigoCuenta, double dineroRetirar) {

		int indiceCuenta = buscarIndiceCuenta(codigoCuenta);
		
		if(cuentas[indiceCuenta] != null && indiceCuenta > -1 
				&& cuentas[indiceCuenta].getEstado().equalsIgnoreCase("Habilitada"))
		{
			if(cuentas[indiceCuenta].getTipoDeCuenta().equalsIgnoreCase("Corriente")
					&& dineroRetirar < cuentas[indiceCuenta].getDineroActual())
			{
				cuentas[indiceCuenta].setDineroActual(cuentas[indiceCuenta].getDineroActual() - dineroRetirar);
				return true;
			}
			
			else if(cuentas[indiceCuenta].getTipoDeCuenta().equalsIgnoreCase("Vivienda"))
			{
				return false;
			}
			
			else if(cuentas[indiceCuenta].getTipoDeCuenta().equalsIgnoreCase("Fondo de inversión"))
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
	
	public double revisionMensual(String idCliente)
	{
		double saldoTotal = 0;
		
		for(Cuenta cuenta : cuentas)
		{

			if(cuenta != null)
			{

				if(cuenta.getPropietario().getId().equalsIgnoreCase(idCliente))
				{
					if(cuenta.getTipoDeCuenta().equalsIgnoreCase("Corriente"))
					{
						saldoTotal += cuenta.getDineroActual() * 1.1 - 0.6;
					}
					else if(cuenta.getTipoDeCuenta().equalsIgnoreCase("Vivienda"))
					{
						saldoTotal += cuenta.getDineroActual() * 1.2 - 0.6;
					}
					else if(cuenta.getTipoDeCuenta().equalsIgnoreCase("Fondo de inversión"))
					{
						saldoTotal += cuenta.getDineroActual() * 1.34 - 0.6;
					}
				}
			}
		}
		
		return saldoTotal;
	}
}
