package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Complejo implements Serializable{

	private ArrayList<Queso> quesos;
	private ArrayList<Cliente> clientes;
	private ArrayList<Factura> facturas;
	private static int genCodeQueso;
	private static Complejo miFabrica = null;
	private static int contEsf;
	private static int contCil;
	private static int contHue;
	private static int genCodeFact;
	private static final long serialVersionUID = 1L;
	
	private Complejo()
	{
		super();
		quesos = new ArrayList<>();
		facturas = new ArrayList<>();
		clientes = new ArrayList<>();
		genCodeQueso = 0;
		contEsf = 0;
		contCil = 0;
		contHue = 0;
		genCodeFact = 0;
	}

	public static Complejo getInstance()
	{
		if(miFabrica == null)
		{
			miFabrica = new Complejo();
		}
		
		return miFabrica;
	}
	
	public static Complejo getMiFabrica() {
		return miFabrica;
	}

	public static void setMiFabrica(Complejo miFabrica) {
		Complejo.miFabrica = miFabrica;
	}
	
	public static int getContEsf() {
		return contEsf;
	}

	public static int getContCil() {
		return contCil;
	}

	public static int getContHue() {
		return contHue;
	}
	
	public static int getGenCodeFact() {
		return genCodeFact;
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
		genCodeFact++;
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
	
	public void reporteTipoQueso()
	{
		for(Queso unQueso: quesos)
		{
			if(unQueso.isEstadoDeVenta())
			{
				if(unQueso instanceof Esfera)
				{
					contEsf++;
				}
				else if(unQueso instanceof Cilindro && !(unQueso instanceof CHueco))
				{
					contCil++;
				}
				else if(unQueso instanceof CHueco)
				{
					contHue++;
				}
			}
		}
	}
	
	public void resetReporte()
	{
		contCil = 0;
		contEsf = 0;
		contHue = 0;
	}
	
	public ArrayList<Queso> obtenerQuesoByType(int tipo)
	{
		ArrayList<Queso> quesosADevolver = new ArrayList<>();
		
		switch (tipo)
		{
			//Todos
			case 0:
				for(Queso unQueso: quesos)
				{
					if(unQueso.isEstadoDeVenta())
					{
						quesosADevolver.add(unQueso);
					}
				}
				return quesosADevolver;
				
			//Esferico
			case 1:
				for(Queso unQueso: quesos)
				{
					if(unQueso instanceof Esfera && unQueso.isEstadoDeVenta())
					{
						quesosADevolver.add(unQueso);
					}
				}
				return quesosADevolver;
				
			//Cilindrico
			case 2:
				for(Queso unQueso: quesos)
				{
					if(unQueso instanceof Cilindro && unQueso.isEstadoDeVenta()  && !(unQueso instanceof CHueco))
					{
						quesosADevolver.add(unQueso);
					}
				}
				return quesosADevolver;
				
			//CilindroHueco
			case 3:
				for(Queso unQueso: quesos)
				{
					if(unQueso instanceof CHueco && unQueso.isEstadoDeVenta())
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
