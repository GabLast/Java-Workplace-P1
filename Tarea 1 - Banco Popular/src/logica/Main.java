package logica;
//key, maps?
public class Main {

	public static void main(String[] args) {

		Banco popularBanco = new Banco();
		
		Cuenta c1 = new Cuenta("123", "3/3/2019", "1/1/2020", "Habilitada", "Cuenta_Corriente", 0);
		Cuenta c2 = new Cuenta("456", "3/3/2019", "1/1/2020", "Habilitada", "Cuenta_Vivienda", 0);
		Cuenta c3 = new Cuenta("789", "3/3/2019", "1/1/2020", "Habilitada", "Fondo_Inversion", 0);
		
		Cliente p1 = new Cliente("112233", "Gabriel", "Marte Lantigua", "8095021552", true, true, true, c1, c2, c3);
		
		popularBanco.insertarCliente(p1);
		popularBanco.insertarCuenta(c1);
		popularBanco.insertarCuenta(c2);
		popularBanco.insertarCuenta(c3);
		
		System.out.println(popularBanco.getCantClientes());
		System.out.println(Banco.getCantCuentas());
		System.out.println("");
		
		System.out.println("Cuenta Corriente");
		System.out.println(popularBanco.mostrarSaldoActual("123"));
		popularBanco.ingresarDinero("123", 549.99);
		System.out.println(popularBanco.mostrarSaldoActual("123"));
		popularBanco.retirarDinero("123", 501);
		System.out.println(popularBanco.mostrarSaldoActual("123"));
		System.out.println("");
		
		System.out.println("Cuenta vivienda");
		System.out.println(popularBanco.mostrarSaldoActual("456"));
		popularBanco.ingresarDinero("456", 100.99);
		System.out.println(popularBanco.mostrarSaldoActual("456"));
		popularBanco.retirarDinero("456", 55);
		System.out.println(popularBanco.mostrarSaldoActual("456"));
		System.out.println("");
		
		System.out.println("Fondo Inversion");
		System.out.println(popularBanco.mostrarSaldoActual("789"));
		popularBanco.ingresarDinero("789", 5000);
		System.out.println(popularBanco.mostrarSaldoActual("789"));
		popularBanco.retirarDinero("789", 500);
		System.out.println(popularBanco.mostrarSaldoActual("789"));
		popularBanco.retirarDinero("789", 501);
		System.out.println(popularBanco.mostrarSaldoActual("789"));
		popularBanco.retirarDinero("789", 100);
		System.out.println(popularBanco.mostrarSaldoActual("789"));
		System.out.println(c3.getEstado());
	}

}
