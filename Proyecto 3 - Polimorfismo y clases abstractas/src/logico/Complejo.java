package logico;

import java.util.ArrayList;

public class Complejo {

	private ArrayList<Queso> quesos;
	private ArrayList<Cliente> clientes;
	private ArrayList<Factura> facturas;
	private static int genCodeQueso;
	private static Complejo miFabrica = null;
	
	private Complejo()
	{
		super();
		quesos = new ArrayList<>();
		facturas = new ArrayList<>();
		clientes = new ArrayList<>();
		genCodeQueso = 0;
	}
	
	public static Complejo getInstance()
	{
		if(miFabrica == null)
		{
			miFabrica = new Complejo();
		}
		
		return miFabrica;
	}
	
	public ArrayList<Queso> getQuesos() {
		return quesos;
	}

	public void setQuesos(ArrayList<Queso> quesos) {
		this.quesos = quesos;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ArrayList<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(ArrayList<Factura> facturas) {
		this.facturas = facturas;
	}
	
	public static int getGenCodeQueso() {
		return genCodeQueso;
	}

	public void agregarQueso(Queso queso)
	{
		quesos.add(queso);
		genCodeQueso++;
	}
	
	public void agregarFactura(Factura fact)
	{
		facturas.add(fact);
	}

	public void agregarCliente(Cliente cliente)
	{
		clientes.add(cliente);
	}
	
	public float precioByFactura(String code)
	{
		float fact = 0;
		
		Factura unaFact = buscarFacturaByCode(code);
		
		if(unaFact != null)
		{
			fact = unaFact.valorTotal();
		}
		
		return fact;
	}

	public Factura buscarFacturaByCode(String code) {
		
		Factura factura = null;
		boolean encontrado = false;
		int i = 0;
		
		while(i < facturas.size() && !encontrado)
		{
			if(facturas.get(i).getCodigo().equalsIgnoreCase(code))
			{
				encontrado = true;
				factura = facturas.get(i);				
			}
			i++;
		}
		
		return factura;
	}
	
	public Queso buscarQuesoByID(String code) {

		Queso miQueso = null;
		boolean encontrado = false;
		int i = 0;

		while(i < quesos.size() && !encontrado)
		{
			if(quesos.get(i).getId().equalsIgnoreCase(code))
			{
				encontrado = true;
				miQueso = quesos.get(i);				
			}
			i++;
		}

		return miQueso;
	}
	
	public Cliente buscarClienteByCedula(String code) {

		Cliente miCliente = null;
		boolean encontrado = false;
		int i = 0;

		while(i < clientes.size() && !encontrado)
		{
			if(clientes.get(i).getCedula().equalsIgnoreCase(code))
			{
				encontrado = true;
				miCliente = clientes.get(i);				
			}
			i++;
		}
		
		return miCliente;
	}
	
	public float valorQuesoEsfericoMayor(Factura miFactura)
	{
		float precio = -1;
		
		precio = miFactura.precioQuesoEsfericoMayor();
		
		return precio;
	}
	
	public ArrayList<Queso> obtenerQuesoByType(int tipo)
	{
		ArrayList<Queso> quesosADevolver = new ArrayList<>();
		
		switch (tipo)
		{
			//Todos
			case 0:
				
				return quesos;
				
			//Esferico
			case 1:
				for(Queso unQueso: quesos)
				{
					if(unQueso instanceof Esfera)
					{
						quesosADevolver.add(unQueso);
					}
				}
				return quesosADevolver;
				
			//Cilindrico
			case 2:
				for(Queso unQueso: quesos)
				{
					if(unQueso instanceof Cilindro)
					{
						quesosADevolver.add(unQueso);
					}
				}
				return quesosADevolver;
				
			//CilindroHueco
			case 3:
				for(Queso unQueso: quesos)
				{
					if(unQueso instanceof CHueco)
					{
						quesosADevolver.add(unQueso);
					}
				}
				return quesosADevolver;
				
			default:
				break;
		}
		
		return null;
	}
}
