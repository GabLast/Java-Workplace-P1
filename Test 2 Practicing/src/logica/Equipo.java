package logica;

import java.util.ArrayList;

public class Equipo {

	private String nombre;
	private ArrayList<Jugador> jugadores;
	
	public Equipo(String nombre) {
		super();
		this.nombre = nombre;
		jugadores = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	
	public Jugador jugadorMasValioso()
	{
		Jugador valioso = null;
		
		for(Jugador aPlayer : jugadores)
		{
			if(aPlayer.efectividad() > valioso.efectividad())
			{
				valioso = aPlayer;
			}
		}
		
		return valioso;
	}
	
	public ArrayList<Jugador> auxiliarEfectividadMayorQueX(int efectividadDada)
	{
		ArrayList<Jugador> jugadores = new ArrayList<>();
		
		for(Jugador aPlayer : jugadores)
		{
			if(aPlayer.efectividad() > efectividadDada)
			{
				jugadores.add(aPlayer);
			}
		}
		
		return jugadores;
	}

	public int cantLiberosMasErroresQueRecibos() {
		
		int cantidad = 0;
		
		for(Jugador aPlayer : jugadores)
		{
			if(aPlayer instanceof Libero)
			{
				if(aPlayer.getErrores() > ((Libero) aPlayer).getRecibosEfectivos())
				{
					cantidad++;
				}
			}
		}
		
		return cantidad;
	} 
	
	public Pasador pasadorMasFintas()
	{
		Pasador pasador = null;
		Pasador temp = null;
		int mayor = temp.getFintasEfectivas();
		
		for(Jugador aPlayer : jugadores)
		{
			if(aPlayer instanceof Pasador)
			{
				temp = (Pasador) aPlayer;
				
				if(temp.getFintasEfectivas() > mayor)
				{
					pasador = temp;
					mayor = temp.getFintasEfectivas();
				}
			}
		}
		
		return pasador;
	}
	
	public Opuesto jugadorOpuestoMayorEfectividad()
	{
		Opuesto jugador = null;
		Opuesto temporal = null;
		int mayor = jugador.efectividad();
		
		for(Jugador aPlayer : jugadores)
		{
			if(aPlayer instanceof Opuesto)
			{
				temporal = (Opuesto) aPlayer;
				
				if(temporal.efectividad() > mayor)
				{
					mayor = temporal.efectividad();
					jugador = temporal;
				}
			}
		}
		
		return jugador;
	}
	
	public Opuesto buscarOpuesto(String nombre)
	{
		Opuesto aBuscar = null;
		
		for(Jugador aPlayer : jugadores)
		{
			if(aPlayer instanceof Opuesto)
			{
				if(aPlayer.getNombre().equalsIgnoreCase(nombre))
				{
					aBuscar = (Opuesto) aPlayer;
					return aBuscar;
				}
			}
		}
		
		return aBuscar;
	}
	
	public ArrayList<Jugador> jugadoresSinErrores()
	{
		ArrayList<Jugador> jugadoresNoErrors = new ArrayList<>();
		
		for(Jugador aPlayer : jugadores)
		{
			if(aPlayer.getErrores() == 0)
			{
				jugadoresNoErrors.add(aPlayer);
			}
		}
		
		return jugadoresNoErrors;
	}
}
