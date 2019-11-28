package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Factura implements Serializable{

	private String codigo;
	private Cliente miCliente;
	private ArrayList<Queso> misQuesos;
	private static final long serialVersionUID = 1L;

	public Factura(String codigo, Cliente miCliente, ArrayList<Queso> misQuesos) {
		super();
		this.codigo = codigo;
		this.miCliente = miCliente;
//		misQuesos = new ArrayList<>();
		this.misQuesos = misQuesos;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Cliente getMiCliente() {
		return miCliente;
	}

	public void setMiCliente(Cliente miCliente) {
		this.miCliente = miCliente;
	}

	public ArrayList<Queso> getMisQuesos() {
		return misQuesos;
	}

	public void setMisQuesos(ArrayList<Queso> misQuesos) {
		this.misQuesos = misQuesos;
	}
	
	public boolean agregarQuesoFactura(Queso unQueso)
	{
		if(unQueso != null)
		{
			misQuesos.add(unQueso);
			unQueso.setEstadoDeVenta(false);
			return true;
		}
		return false;
	}
	
	public float valorTotal()
	{
		float total = 0;
		
		for(Queso queso : misQuesos)
		{
			total += queso.precioTotal();
		}
		
		return total;
	}
	
	public float precioQuesoEsfericoMayor()
	{
		float precioDelMayor = 0;
		float volumenDelMayor = 0;
		
		for(Queso queso : misQuesos)
		{
			if(queso instanceof Esfera)
			{
				if(queso.volumen() > volumenDelMayor)
				{
					volumenDelMayor = queso.volumen();
					precioDelMayor = queso.precioTotal();
				}
			}
		}
		
		return precioDelMayor;
	}
}
