package logico;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Enumeration;

public class Stream extends Thread {

	private Socket socket;
	private DataInputStream StreamLectura;
	private DataOutputStream StreamEscritura;

	public Stream (Socket socketIn)
	{
		socket = socketIn;
		try
		{
			StreamLectura = new DataInputStream(new BufferedInputStream(socketIn.getInputStream()));
			StreamEscritura = new DataOutputStream(new BufferedOutputStream(socketIn.getOutputStream()));
		}
		catch(IOException ioe)
		{
			System.out.println("IOException(Stream): " + ioe);
		}
	}

	public void run()
	{
		broadcast(socket.getInetAddress()+"> se ha conectado");
		Server.usuarios.add ((Object) this);
		
		while(true)
		{
			try
			{
				String linea = StreamLectura.readUTF();
				if (!linea.equals(""))
				{
					linea = socket.getInetAddress() +"> "+ linea;
					broadcast(linea);
				}
			}
			catch(IOException ioe)
			{
				Server.usuarios.removeElement(this);
				broadcast(socket.getInetAddress()+"> se ha desconectado.");
				break;
			}
		}
	}
	
	public void broadcast(String mensaje)
	{
		synchronized (Server.usuarios)
		{
			Enumeration e = Server.usuarios.elements();
			while (e.hasMoreElements())
			{
				Stream f = (Stream) e.nextElement();
				try
				{
					synchronized(f.StreamEscritura)
					{
						f.StreamEscritura.writeUTF(mensaje);
						f.StreamEscritura.flush();
					}
				}
				catch(IOException ioe)
				{
					System.out.println("Error: "+ioe);
				}
			}
		}
	}
}
