package logico;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server extends Thread
{
	public static Vector usuarios = new Vector();
	public static void main (String args[])
	{
		ServerSocket socketServer = null;
		try
		{
			socketServer = new ServerSocket(7000);
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
				
				//Flujo flujo = new Flujo(nsocket);
				//Thread t = new Thread(flujo);
				//t.start();
			}
			catch(IOException ioe)
			{
				System.out.println("Error: "+ioe);
			}
		}
	}
}