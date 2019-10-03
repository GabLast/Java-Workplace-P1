package logica;

import java.util.ArrayList;

public class Cliente {

	private String id;
	private String nombre;
	private String dirrecion;
	private ArrayList<Prestamo> misPrestamos;
	private int cantPrestamos;
	private double deuda;
	
	public Cliente(String id, String nombre, String dirrecion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.dirrecion = dirrecion;
		misPrestamos = new ArrayList<>();
		this.cantPrestamos = 0;
		this.setDeuda(0);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDirrecion() {
		return dirrecion;
	}

	public void setDirrecion(String dirrecion) {
		this.dirrecion = dirrecion;
	}

	public ArrayList<Prestamo> getMisPrestamos() {
		return misPrestamos;
	}

	public int getCantPrestamos() {
		return cantPrestamos;
	}

	public double getDeuda() {
		return deuda;
	}

	public void setDeuda(double deuda) {
		this.deuda = deuda;
	}

	public void actualizarPrestamos(Prestamo prestamo, boolean devolver) {
		
		if(devolver)
		{
			deuda += prestamo.getMultaPorRetraso();
			misPrestamos.remove(prestamo);
			cantPrestamos--;
		}
		else
		{
			misPrestamos.add(prestamo);
			cantPrestamos++;
		}
		
		
	}
	
	public ArrayList<int> numeroDocsPerType()
	{
		int i;
		int libros = articulos = revistas = 0;
		
		for(i = 0; i < misPrestamos.size(); i++)
		{
			if()
		}
	}
	
}
