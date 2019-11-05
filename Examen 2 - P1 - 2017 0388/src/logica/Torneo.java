package logica;

import java.util.ArrayList;

public class Torneo {

	private static Torneo miTorneo = null;
	private ArrayList<String> paises;
	private ArrayList<Equipo> equipos;

	private Torneo() {
		super();

		paises = new ArrayList<>();
		equipos = new ArrayList<>();
	}
	
	//2
	public static Torneo getInstance()
	{
		if(miTorneo == null)
			miTorneo = new Torneo();

		return miTorneo;
	}
	
	public ArrayList<String> getPaises() {
		return paises;
	}

	public void setPaises(ArrayList<String> paises) {
		this.paises = paises;
	}

	public ArrayList<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(ArrayList<Equipo> equipos) {
		this.equipos = equipos;
	}
	
	
	//3.a
	public Jugador masValiosoTorneo()
	{
		Jugador jugador = null;
		
		for(Equipo aTeam : equipos)
		{
			if(aTeam.jugadorMasValioso().efectividad() > jugador.efectividad())
			{
				jugador = aTeam.jugadorMasValioso();
			}
		}
		
		return jugador;
	}
	
	
	//3.b
	public ArrayList<Jugador> jugAuxiliarEfectividadMayorQueX(float efectividadDada)
	{		
		ArrayList<Jugador> jugadores = new ArrayList<>();
		
		for(Equipo aTeam : equipos)
		{
			//se van agregando la listas de jugadores de cada equipo
			//que cumplen con la condicion
			jugadores.addAll(aTeam.auxiliarEfectividadMayorQueX(efectividadDada));
		}
		
		return jugadores;
		
	}
	
	
	//3.c
	public int cantLiberosMasErroresQueRecibosTorneo()
	{
		int cantidad = 0;
		
		for(Equipo aTeam : equipos)
		{
			cantidad += aTeam.cantLiberosMasErroresQueRecibos();
		}
		
		return cantidad;
	}
	
	
	//3.d
	public Pasador pasadorMasFintasTorneo()
	{
		Pasador pasador = null;
		Pasador pasMayor = null;
		int mayor = pasador.getFintasEfectivas();
		
		for(Equipo aTeam : equipos)
		{
			pasador = aTeam.pasadorMasFintas();
			
			if(pasador.getFintasEfectivas() > mayor)
			{
				mayor = pasador.getFintasEfectivas();
				pasMayor = pasador;
			}
		}
		
		return pasMayor;
	}
	
	//3.e
	public Opuesto opuestoMayorEfectividad()
	{
		Opuesto temporal = null;
		Opuesto opMayor = null;
		
		float mayor = opMayor.efectividad();
		
		for(Equipo aTeam : equipos)
		{
			temporal = aTeam.jugadorOpuestoMayorEfectividad();
			
			if(temporal.efectividad() > mayor)
			{
				mayor = temporal.efectividad();
				opMayor = temporal;
			}
		}
		
		return opMayor;
	}
	
	
	//3.f
	public int bloqueosEfectivosOpuestoByName(String nombre)
	{
		Atacante opuesto = null;
		
		for(Equipo aTeam : equipos)
		{
			if(opuesto == null)
			{
				opuesto = aTeam.buscarOpuesto(nombre);
			}
		}
		
		return opuesto.getBloqueosEfectivos();
	}
	
	
	//3.g
	public ArrayList<Jugador> jugadoresSinErroresTorneo()
	{
		ArrayList<Jugador> jugadores = new ArrayList<>();
		
		for(Equipo aTeam : equipos)
		{
			jugadores.addAll(aTeam.jugadoresSinErrores());
		}
		
		return jugadores;
	}
}
