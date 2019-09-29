package logico;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		Almacen alma = new Almacen();
		Suministrador S1 = new Suministrador("s-1", "Juan", "Chile", 20);
		Vino v1 = new Vino("v-1", "Carlos Rosi", "Tinto",240,318, 2015, 10, 20, 9, S1);
		Vino v2 = new Vino("v-2", "La fuerza", "Tinto",50,125, 2019, 10, 20, 10, S1);
		int[] ventas = new int[10];
		for (int i = 0; i < 10; i++) {
			ventas[i] = (i+1)*10;
		}
		v1.setVentas(ventas);
		v2.setVentas(ventas);
		alma.insertarSuministrador(S1);
		
		alma.insertarVino(v1);
		alma.insertarVino(v2);
		System.out.println(alma.cantByTipo("Tinto"));
		

	}

}
