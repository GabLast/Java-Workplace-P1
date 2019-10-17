package logico;

import java.util.ArrayList;

public class Factura {

	private String codigo;
	private Cliente miCliente;
	private ArrayList<Queso> misQuesos;

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

	
	
	public float valorTotal()
	{
		float total = 0;
		
		for(Queso queso : misQuesos)
		{
			total += queso.precioTotal();
		}
		
		return total;
	}
}
