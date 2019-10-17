package logico;

import java.util.ArrayList;

public class Complejo {

	private ArrayList<Queso> quesos;
	private ArrayList<Cliente> clientes;
	private ArrayList<Factura> facturas;
	
	public Complejo() {
		super();
		quesos = new ArrayList<>();
		facturas = new ArrayList<>();
		clientes = new ArrayList<>();
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

	private Factura buscarFacturaByCode(String code) {
		
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

}
