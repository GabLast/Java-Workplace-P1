package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Departamento implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombreDelDepart;
	private int cantTrabaj;
	private ArrayList<Trabajadores> misTrabajadores;
	
	public Departamento(String nombreDelDepart) {
		super();
		this.nombreDelDepart = nombreDelDepart;
		this.misTrabajadores = new ArrayList<>();
	}

	public int getCantTrabaj() {
		return cantTrabaj;
	}

	public void setCantTrabaj(int cantTrabaj) {
		this.cantTrabaj = cantTrabaj;
	}

	public String getNombreDelDepart() {
		return nombreDelDepart;
	}

	public ArrayList<Trabajadores> getMisTrabajadores() {
		return misTrabajadores;
	}
	
	
}
