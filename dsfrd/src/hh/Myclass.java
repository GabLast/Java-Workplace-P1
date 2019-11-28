package hh;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Myclass {

	public static void main(String[] args) throws IOException, ClassNotFoundException{
		
		
		 // Instancia un FileWriter que se encargara de escribir
		/*File archivo = new File ("F:/myFile.txt");
        FileWriter escritor;
	
			try {
			escritor = new FileWriter(archivo);
			String info = "Tengo que entender que las tareas se entregan en tiempo....no 15 horas despues.";
			// Escribe el archivo con la informacion
	        for (int i=0; i<info.length(); i++)
	            escritor.write(info.charAt(i));
	        escritor.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			    */
	        
	           
	        // Cierra el stream
	       

        // Construye una cadena de caracteres a ser guardada en el archivo     
       
        // Informa que el archivo ha sido escrito
     //   System.out.println("El archivo ha sido escrito...");
		
	/*	File archivo = new File ("F:/myFile.txt");
	      // Defino variables
        boolean eof = false;
        String lineaLeida = "";
        
		 // Construye un BufferedReader
        BufferedReader lectorMejorado;
		try {
			lectorMejorado = new BufferedReader(new FileReader(archivo));
			 while (!eof)
		        {
		            // Lee una linea entera
		            lineaLeida = lectorMejorado.readLine();
		           
		            // Imprime la linea en pantalla
		            if( lineaLeida != null )
		                System.out.println( lineaLeida );
		           
		            // Si llego al final del archivo, termina la ejecución
		            else
		                eof = true;
		        }

		        // Cierra el FileReader
		        lectorMejorado.close(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*
         
        // Lee el archivoEntrada de forma eficiente e imprime los datos en pantalla
       
		
		
		 // Instancia un objeto File de entrada y otro de salida*/
    /*    File archivoEntrada = new File("E:/Tulips.jpg");
        File archivoSalida = new File("F:/fotico.jpg");

        // Instancia un   FileInputStream  y un  FileOutputStream  que se encargaran de leer y escribir archivos respectivamente
       FileInputStream lector = new FileInputStream(archivoEntrada);
        FileOutputStream escritor = new FileOutputStream(archivoSalida);
       
        // Instancia una variable que contendrá el byte a leer
        int unByte;     
        // Informa que se está copiando el archivo
        System.out.println("\n\tEl archivo está siendo copiado....");
        // Lee el archivoEntrada y guarda la informacion en el archivoSalida
        try {
			while ((unByte = lector.read()) != -1)
			   escritor.write(unByte);
			
		    lector.close();
	        escritor.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
       
        // Informa que se ha copiado el archivo
       System.out.println("\tEl archivo ha sido copiado con éxito....\n");
	*/	
	//	FileOutputStream f = new FileOutputStream ("F:/MisStudents.dat");
				
  	FileInputStream f = new FileInputStream ("F:/MisStudents.dat");
	//   ObjectOutputStream oos 	= new ObjectOutputStream (f);

	ObjectInputStream oos = new ObjectInputStream(f);
		
    /*   ArrayList<Person> misPersons = new ArrayList<>();
        		for (int i = 0; i < 10 ; i++){
        			Student e = new Student("Pepe "+ i, i,("M-"+i));
        		  misPersons.add(e);
        		}
        		oos.writeInt(misPersons.size());
        		for (Person person : misPersons) {
					oos.writeObject(person);
				}
        oos.close();*/
         int size = oos.readInt();
        		for (int i = 0; i < size; i++){		
        			Person a = (Person)oos.readObject();
        		//	misPersons.add(a);
        		//	oos.writeObject(v[i]);
        			//System.out.println("Nombre: " + a.getName()+"- Edad: " + a.getAge()+"- Matri: "+a.getMatricula());
        			System.out.println("Nombre: " + a.getName()+"- Edad: " + a.getAge());
        		//	System.out.println(misPersons.size());
        		}
        		
        		f.close();
	}

}
