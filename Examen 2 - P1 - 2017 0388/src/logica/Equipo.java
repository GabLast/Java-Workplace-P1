package logica;

import java.util.ArrayList;

public class Equipo {

	private String nombre;
	private String entrenador;
	private int ranking;
	private ArrayList<Jugador> jugadores;
	
	public Equipo(String nombre, String entrenador, int ranking) {
		super();
		this.nombre = nombre;
		this.entrenador = entrenador;
		this.ranking = ranking;
		jugadores = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(String entrenador) {
		this.entrenador = entrenador;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	
	
	//3.a
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
	
	//3.b
	public ArrayList<Jugador> auxiliarEfectividadMayorQueX(float efectividadDada)
	{
		ArrayList<Jugador> jugadores = new ArrayList<>();
		
		for(Jugador aPlayer : jugadores)
		{
			if(aPlayer instanceof Auxiliar)
			{
				if(aPlayer.efectividad() > efectividadDada)
				{
					jugadores.add(aPlayer);
				}
			}
		}
		
		return jugadores;
	}

	
	//3.c
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
	
	//3.d
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
	
	//3.e
	public Opuesto jugadorOpuestoMayorEfectividad()
	{
		Opuesto jugador = null;
		Opuesto temporal = null;
		float mayor = jugador.efectividad();
		
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
	
	//3.f
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
	
	
	//3.g
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
