package logical;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Aire aire = new Aire(); 
		Selector selec = new Selector();
		String ans = "";
		Scanner lector = new Scanner(System.in);
		
		System.out.println("Control de temperatura.");
		System.out.println("Su temperatura actual es de :" + aire.getTemp().getActual() + "C.");
		
		while (!ans.equalsIgnoreCase("y")) {
			System.out.print("\n¿Desea activar el climatizador? [y/n]: ");
			ans = lector.nextLine();
		}
		
		selec.start();
		float seleccion = 0;
		while (seleccion <= 0 || seleccion >= 40) {
			System.out.print("\nIngrese temperatura: ");
			seleccion = lector.nextFloat();
		}
		
		selec.setSeleccion(seleccion);
		aire.start();
	}

}
