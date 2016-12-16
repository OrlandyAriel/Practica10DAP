package ull.patrones.componentes;

import ull.patrones.enumerador.Direccion;
import ull.patrones.laberinto.Laberinto;

public class JugadorLaberinto
{ // ATRIBUTOS
	private int m_habitacionInicial;
	private String m_nombreJugador;
	private Habitacion m_habitacion;

	// CONSTRUCTOR
	public JugadorLaberinto(int numHabitaconInicial, String nombreJugador, Laberinto laberinto)
	{
		m_habitacionInicial = numHabitaconInicial;
		m_nombreJugador = nombreJugador;
		m_habitacion = laberinto.numeroDeHabitacion(m_habitacionInicial);
	}
	/**
	 * M�todo para mover al jugador dentro del laberinto donde se encuentra.
	 * @param direccionMovimiento
	 */
	public void mover(Direccion direccionMovimiento)
	{
		if (m_habitacion.obtenerLado(direccionMovimiento) != null)
		{
			if (m_habitacion.obtenerLado(direccionMovimiento).getClass() == Puerta.class)
			{
				Puerta tPuerta = (Puerta) m_habitacion.obtenerLado(direccionMovimiento);
				tPuerta.Entrar();
				if (tPuerta.obtenerEstadoPuerta())
				{
					m_habitacion = (Habitacion) tPuerta.otroLadoDe(m_habitacion);
				}
			} else if (m_habitacion.obtenerLado(direccionMovimiento).getClass() == Pared.class)
			{
				Pared pared = (Pared) m_habitacion.obtenerLado(direccionMovimiento);
				pared.Entrar();
			}
		}
		m_habitacion.Entrar();
	}
	public String getNombre()
	{
		return m_nombreJugador;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (m_nombreJugador.equals((String) obj))
			return true;
		else
			return false;
	}
	/**
	 * M�todo para saber en que habitaci�n est� el jugador
	 * @return
	 */
	public String dondeEstoy()
	{
		return m_nombreJugador + ", est� en la habitaci�n n�mero:" + m_habitacion.getNumeroHabitacion();
	}
}
