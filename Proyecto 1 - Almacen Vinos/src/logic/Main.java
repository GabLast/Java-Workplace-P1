package logic;

public class Main {

	public static void main(String[] args) {
		
		Almacen alma = new Almacen();
		
		Suministrador S1 = new Suministrador("s-1", "Jose", "USA", 95);
		
		Vino V1 = new Vino("v-1", "Carlos", "Tinto", 2015, 10, 20, 15, S1, 240, 340);
		Vino V2 = new Vino("v-2", "Pedro", "Blanco", 2013, 9, 19, 10, S1, 140, 350);
		
		int ventas[] = new int[10];
		
		for(int i = 0; i < 10; i++)
		{
			ventas[i] = (i+1)*10;
		}
		
		V1.setVentas(ventas);
		V2.setVentas(ventas);
		
		alma.insertarSuministrador(S1);
		
		alma.insertarVino(V1);
		alma.insertarVino(V2);
	
		System.out.println(alma.cantidadTipoDeVino("Tinto"));
		System.out.println(alma.vinoMasRentable());
	}

}

