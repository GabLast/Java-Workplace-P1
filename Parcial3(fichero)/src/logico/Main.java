package logico;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		//Escribir Personas.dat
		/*FileOutputStream file = new FileOutputStream ("Personas.dat");
		ObjectOutputStream oos 	= new ObjectOutputStream (file);
		Departamento depart1 = new Departamento("Administrativo");
		ArrayList<Trabajadores> trab = new ArrayList<>();
		
		for (int i = 0; i < 12; i++) {
			Trabajadores nuevo = new Trabajadores("C-" + i, "Pepe" + i, 1000);
			depart1.getMisTrabajadores().add(nuevo);
		}
		
		oos.writeUTF(depart1.getNombreDelDepart());
		oos.writeInt(depart1.getMisTrabajadores().size());
		
		for (Trabajadores trabajadores : depart1.getMisTrabajadores()) {
			oos.writeObject(trabajadores);
		}
		
		System.out.println("Fichero dat escrito correctamente");*/
		
		//Leer Personas.dat
		FileInputStream file = new FileInputStream ("Personas.dat");
		ObjectInputStream oos = new ObjectInputStream(file);
		ArrayList<Trabajadores> misTra = new ArrayList<>();
		
		String nombreDepart = oos.readUTF();
		int size = oos.readInt();
		
		System.out.println("Departamento: " + nombreDepart);
		System.out.println("Cantidad de trabajadores: " + size);
		
		for (int i = 0; i < size; i++){		
			Trabajadores a = (Trabajadores)oos.readObject();
			misTra.add(a);
			System.out.println("Cédula: " + a.getCedula()+" -- : " + a.getNombre()+" -- Salario: "+a.getSalario());
		}
		
		//file.close();
		
		//Escribir Salary.txt
		
		File archivo = new File ("Salary.txt");
		FileWriter escritor;
		
		escritor = new FileWriter(archivo);
		
		escritor.write("Departamento: ");
		for (int i=0; i<nombreDepart.length(); i++)
            escritor.write(nombreDepart.charAt(i));
		
		escritor.write('\n');
		
		escritor.write("Cantidad de Trabajadores: " + size);
		
		for (int i = 0; i < size; i++){		
			Trabajadores a = misTra.get(i);
			escritor.write("Cédula: " + a.getCedula()+" -- : " + a.getNombre()+" -- Salario: "+a.getSalario());
			escritor.write('\n');
		}
		
		escritor.close();
		file.close();
		System.out.println("El archivo Salary.txt ha sido escrito correctamente");
	}

}
