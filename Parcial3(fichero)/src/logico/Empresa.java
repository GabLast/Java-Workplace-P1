package logico;

import java.util.ArrayList;

public class Empresa {
	
	private ArrayList<Departamento> misDepartamentos;

	public Empresa() {
		super();
		this.misDepartamentos = new ArrayList<>();
	}

	public ArrayList<Departamento> getMisDepartamentos() {
		return misDepartamentos;
	}
	
	
}
