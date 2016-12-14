package ull.patrones.componentes;

import ull.patrones.enumerador.Direccion;
import ull.patrones.laberinto.Laberinto;

public class JugadorLaberinto
{ //ATRIBUTOS
	private int m_habitacionInicial;
	private String m_nombreJugador;
	private Laberinto m_laberinto;
	private Habitacion m_habitacion;
	//CONSTRUCTOR
	public JugadorLaberinto(int numHabitaconInicial, String nombreJugador, Laberinto laberinto)
	{
		m_habitacionInicial = numHabitaconInicial;
		m_nombreJugador = nombreJugador;
		m_laberinto = laberinto;
	}
	public void mover(Direccion direccionMovimiento)
	{
		
	}
}
