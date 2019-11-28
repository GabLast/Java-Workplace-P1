package logico;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JOptionPane;

public class Server extends Thread {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null;
		Socket socket = null;
		InputStream in = null;
		OutputStream out = null;
		String fecha = null;
		byte[] bytes = new byte[1024];

		try {
			serverSocket = new ServerSocket(8000);
		} catch (IOException ioe) {
			System.out.println("Comunicación rechazada."+ioe);
			System.exit(1);
		}



		while (true) {
			try {
				socket = serverSocket.accept();

				fecha = new SimpleDateFormat("yyMMddHHmmss").format(new Date());
				System.out.println("Conexion aceptada de: "+ socket.getInetAddress());

			} catch (IOException ex) {
				System.out.println("El cliente no pudo conectarse.");
			}

			try {
				in = socket.getInputStream();
			} catch (IOException ex) {
				System.out.println("No se pudo recibir la informacion del cliente.");
			}

			try {
				out = new FileOutputStream("facturaRecibida-"+fecha+".txt");
			} catch (FileNotFoundException ex) {
				System.out.println("Archivo no encontrado.");
			}


			int count;
			while ((count = in.read(bytes)) > 0) {
				out.write(bytes, 0, count);
				System.out.println(count);
			}
			out.close();
			in.close();

		}

	}
}
/*public class Server extends Thread
{
	public static Vector usuarios = new Vector();

	public static void main (String args[])
	{
		ServerSocket socketServer = null;
		try
		{
			socketServer = new ServerSocket(8000);
		}
		catch (IOException ioe)
		{
			System.out.println("Comunicación rechazada."+ioe);
			System.exit(1);
		}

		while (true)
		{
			try
			{
				Socket socketRecibido = socketServer.accept();
				System.out.println("Conexion aceptada de: "+ socketRecibido.getInetAddress());


				socketRecibido.getInputStream()
			}
			catch(IOException ioe)
			{
				System.out.println("Error: "+ioe);
			}
		}
	}

}*/