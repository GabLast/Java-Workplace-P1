package logica;

import java.util.ArrayList;
import java.util.Date;

public class Biblioteca {

	private ArrayList<Publicacion> misPublic;
	private ArrayList<Cliente> misClientes;
	private ArrayList<Prestamo> misPrestamos;
	private int generadorIdPrestamos;
	
	public Biblioteca() {
		super();
		this.misPublic = new ArrayList<>();
		this.misClientes = new ArrayList<>();
		this.misPrestamos = new ArrayList<>();
		this.generadorIdPrestamos = 1;
	}

	public ArrayList<Publicacion> getMisPublic() {
		return misPublic;
	}

	public void setMisPublic(ArrayList<Publicacion> misPublic) {
		this.misPublic = misPublic;
	}

	public ArrayList<Cliente> getMisClientes() {
		return misClientes;
	}

	public void setMisClientes(ArrayList<Cliente> misClientes) {
		this.misClientes = misClientes;
	}

	public ArrayList<Prestamo> getMisPrestamos() {
		return misPrestamos;
	}

	public void setMisPrestamos(ArrayList<Prestamo> misPrestamos) {
		this.misPrestamos = misPrestamos;
	}
	
	public void insertarPublicacion(Publicacion aInsertar)
	{
		misPublic.add(aInsertar);
	}
	
	public String findTituloById(String idPublicacion)
	{
		String titulo = null;
		
		boolean encontrado = false;
		int i = 0;
		
		while(!encontrado && i < misPublic.size())
		{
			if(misPublic.get(i).getId().equalsIgnoreCase(idPublicacion))
			{
				titulo = misPublic.get(i).getTitulo();
				encontrado = true;
			}
			i++;
		}
		
		return titulo;
	}
	
	public int cantDocumentoByMateria(String materia)
	{
		int cant = 0;
		
		for(Publicacion publis : misPublic)
		{
			if(publis.getMateria().equalsIgnoreCase(materia))
			{
				cant+=publis.getCantEjemplares();
			}
		}
		
		return cant;
	}
	
	public Publicacion buscarPublicacion(String idPublicacion)
	{
		Publicacion publi = null;
		int i = 0;
		boolean encontrado = false;
		
		while(!encontrado && i < misPublic.size())
		{
			if(misPublic.get(i).getId().equalsIgnoreCase(idPublicacion))
			{
				encontrado = true;
				publi = misPublic.get(i);
			}
			i++;
		}
			
		return publi;
	}
	
	public Cliente buscarCliente(String idCliente)
	{
		Cliente cliente = null;
		int i = 0;
		boolean encontrado = false;
		
		while(!encontrado && i < misClientes.size())
		{
			if(misClientes.get(i).getId().equalsIgnoreCase(idCliente))
			{
				encontrado = true;
				cliente = misClientes.get(i);
			}
			i++;
		}
			
		return cliente;
	}
	
	private Prestamo buscarPrestamo(String idPrestamo) {

		Prestamo prestamo = null;
		int i = 0;
		boolean encontrado = false;

		while(!encontrado && i < misPrestamos.size())
		{
			if(misPrestamos.get(i).getId().equalsIgnoreCase(idPrestamo))
			{
				encontrado = true;
				prestamo = misPrestamos.get(i);
			}
			i++;
		}

		return prestamo;
	}
	
	public boolean realizarPrestamo(String idCliente, String idPublicacion, Date fechaEntrego)
	{
		boolean realizado = false;
		
		Cliente cliente = buscarCliente(idCliente);
		Publicacion publicacion = buscarPublicacion(idPublicacion);
		
		if(cliente != null && publicacion != null)
		{
			if(publicacion.isEstado() && cliente.getCantPrestamos() < 5)
			{
				Prestamo prestamo = new Prestamo("P-"+generadorIdPrestamos, fechaEntrego, idCliente, publicacion);
				misPrestamos.add(prestamo);
				cliente.actualizarPrestamos(prestamo, false);
				publicacion.actualizarEjemplares(true);
				generadorIdPrestamos++;
				realizado = true;
				
			}
		}
		
		return realizado;
	}
	
	public boolean devolverPrestamo(String idCliente, String idPrestamo, Date fechaEntrego)
	{
		boolean realizado = false;
		
		Cliente cliente = buscarCliente(idCliente);
		Prestamo prestamo = buscarPrestamo(idPrestamo);
		
		if(cliente != null && prestamo != null)
		{
			Publicacion publicacion = prestamo.getPublicacion();
			cliente.actualizarPrestamos(prestamo, true);
			publicacion.actualizarEjemplares(false);
			realizado = true;
			
			prestamo.verificarRetraso();
		}
		
		return realizado;
	}

	public ArrayList cantidadDocumentosPorTipo(String idCliente)
	{
	
		Cliente cliente = buscarCliente(idCliente);
		ArrayList<Integer> arreglo = new ArrayList<>();
		
		if(cliente != null)
		{
			
		}
		
		return arreglo;
	}
}
