package logico;

import java.io.*;
import java.net.*;
import java.util.*;

public class Servidor extends Thread
{
  public static Vector usuarios = new Vector();
  public static void main (String args[])
  {
    ServerSocket sfd = null;
    try
    {
      sfd = new ServerSocket(7000);
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
        Socket nsfd = sfd.accept();
        System.out.println("Conexion aceptada de: "+nsfd.getInetAddress());
	Flujo flujo = new Flujo(nsfd);
	Thread t = new Thread(flujo);
        t.start();
      }
      catch(IOException ioe)
      {
        System.out.println("Error: "+ioe);
      }
    }
  }
}

