package logico;

import java.util.ArrayList;
import java.util.Date;

public class Biblioteca {
  private ArrayList<Cliente> misClientes;
  private ArrayList<Publicacion> misPublicaciones;
  private ArrayList<Prestamo> misPrestamos;
  private static Biblioteca biblio = null;
  
  private Biblioteca() {
	super();
	misClientes = new ArrayList<>();
	misPrestamos = new ArrayList<>();
	misPublicaciones = new ArrayList<>();
}
  
 public static Biblioteca getInstance(){
	 if(biblio == null){
		 biblio = new Biblioteca();
	 }
	 
	 return biblio;
 } 

public ArrayList<Cliente> getMisClientes() {
	return misClientes;
}

public void setMisClientes(ArrayList<Cliente> misClientes) {
	this.misClientes = misClientes;
}

public ArrayList<Publicacion> getMisPublicaciones() {
	return misPublicaciones;
}

public void setMisPublicaciones(ArrayList<Publicacion> misPublicaciones) {
	this.misPublicaciones = misPublicaciones;
}

public ArrayList<Prestamo> getMisPrestamos() {
	return misPrestamos;
}

public void setMisPrestamos(ArrayList<Prestamo> misPrestamos) {
	this.misPrestamos = misPrestamos;
}

//inciso a
public void insertLibro(Libro aux){
	misPublicaciones.add(aux);
}

//registro general
public void insertPublicacion(Publicacion aux){
	misPublicaciones.add(aux);
}

//inciso b
public String getPublicacionById(String code){
	String titulo="";
	boolean find = false;
	int i=0;
	while (i<misPublicaciones.size()&&!find) {
		if(misPublicaciones.get(i).getId().equalsIgnoreCase(code)){
			titulo = misPublicaciones.get(i).getTitulo();
			find = true;
		}
		i++;
	}
	return titulo;
}
  
//inciso c
public int cantByMateria(String materia){
	int cant = 0;
	for (Publicacion aux : misPublicaciones) {
		if(aux.getMateria().equalsIgnoreCase(materia))
			cant++;
	}
	return cant;
}

//inciso d
public boolean doPrestamo(String id, String cedula,Date retorno){
	boolean doPrestamo = false;
	Cliente client = findClienteByCedula(cedula);
	Publicacion publi = findPublicacionById(id);
	if(client.getMisPrestamos().size()<5 && publi.isStatus()){
		Prestamo nuevoPrestamo = new Prestamo(new Date(), retorno, publi, client.getCedula());
		misPrestamos.add(nuevoPrestamo);
		client.getMisPrestamos().add(nuevoPrestamo);
		doPrestamo = true;
		publi.setCant(publi.getCant()-1);
	}
	
	return doPrestamo;
}

private Publicacion findPublicacionById(String id) {
	Publicacion publicacion=null;
	boolean find = false;
	int i=0;
	while (i<misPublicaciones.size()&&!find) {
		if(misPublicaciones.get(i).getId().equalsIgnoreCase(id)){
			publicacion = misPublicaciones.get(i);
			find = true;
		}
		i++;
	}
	return publicacion;
}

private Cliente findClienteByCedula(String cedula) {
	Cliente client=null;
	boolean find = false;
	int i=0;
	while (i<misClientes.size()&&!find) {
		if(misClientes.get(i).getCedula().equalsIgnoreCase(cedula)){
			client = misClientes.get(i);
			find = true;
		}
		i++;
	}
	return client;
}

public int[] prestamosByType(String cedula){
	int[] cant = new int[3];
	for (int i = 0; i < cant.length; i++) {
		cant[i]=0;
	}
	
	for (Prestamo aux : misPrestamos) {
	   if(aux.getCedula().equalsIgnoreCase(cedula)){
		   if(aux.getPrestamo() instanceof Libro){
			   cant[0]++;
		   }
		   if(aux.getPrestamo() instanceof Revista){
			   cant[1]++;
		   }
		   if(aux.getPrestamo() instanceof Articulo){
			   cant[2]++;
		   }
	   }
	}
	return cant;
	
}

 public Cliente findClient(String cedula){
	 Cliente aux = null;
	 boolean find = false;
	 int i = 0;
	 while( i < misClientes.size() && !find){
		 if(misClientes.get(i).getCedula().equalsIgnoreCase(cedula))
		 {
			 find = true;
			 aux = misClientes.get(i);
		  }
		 i++;
		 }
	 return aux;
 }
 
 public boolean removeClient(String cedula){
	 boolean iCanRemove = false;
	 if(findClient(cedula)!=null){
		 if(findClient(cedula).getMisPrestamos().size()==0){
		 misClientes.remove(findClient(cedula));
		 iCanRemove = true;
		 }
	 }	 
	 return iCanRemove;
 }
 
}
