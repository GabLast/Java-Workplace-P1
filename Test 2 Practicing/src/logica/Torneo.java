package logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Torneo {
	
	private static Torneo miTorneo = null;
	private ArrayList<Pais> paises;
	private ArrayList<Equipo> equipos;
	
	private Torneo() {
		super();
		
		paises = new ArrayList<>();
		equipos = new ArrayList<>();
	}
	
	public static Torneo getInstance()
	{
		if(miTorneo == null)
			miTorneo = new Torneo();
		
		return miTorneo;
	}
	
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
	
	public ArrayList<Jugador> jugAuxiliarEfectividadMayorQueX(int efectividadDada)
	{
//		ArrayList<Jugador> jugadores;
//		List<Jugador> listaJugadores = new ArrayList<>();
//	      
//		
//		for(Equipo aTeam : equipos)
//		{
//			jugadores = aTeam.auxiliarEfectividadMayorQueX(efectividadDada);
//			Collections.addAll(listaJugadores, jugadores);
//		}
//		
//		return listaJugadores;
		
		ArrayList<Jugador> jugadores = new ArrayList<>();
		
		for(Equipo aTeam : equipos)
		{
			jugadores.addAll(aTeam.auxiliarEfectividadMayorQueX(efectividadDada));
		}
		
		return jugadores;
		
	}
	
	public int cantLiberosMasErroresQueRecibosTorneo()
	{
		int cantidad = 0;
		
		for(Equipo aTeam : equipos)
		{
			cantidad += aTeam.cantLiberosMasErroresQueRecibos();
		}
		
		return cantidad;
	}
	
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
	
	
	public Opuesto opuestoMayorEfectividad()
	{
		Opuesto temporal = null;
		Opuesto opMayor = null;
		
		int mayor = opMayor.efectividad();
		
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
	
	public int bloqueosEfectivosOpuestoByName(String nombre)
	{
		Atacante opuesto = null;
		
		for(Equipo aTeam : equipos)
		{
			opuesto = aTeam.buscarOpuesto(nombre);
		}
		
		return opuesto.getBloqueosEfectivos();
	}
	
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
