package ull.patrones.laberinto;

import ull.patrones.componentes.Habitacion;
import ull.patrones.componentes.Pared;
import ull.patrones.componentes.Puerta;
import ull.patrones.enumerador.Direccion;

public class JuegoDelLaberinto
{
	private int m_NumeroHabitacionJugador;
	private Habitacion m_habitacionActual;
	private Laberinto m_laberinto;

	public JuegoDelLaberinto(int m_NumeroHabitacionJugador)
	{
		this.m_NumeroHabitacionJugador = 1;
		m_laberinto = crearLaberinto();
		m_habitacionActual = m_laberinto.numeroDeHabitacion(m_NumeroHabitacionJugador);
		
	}
	public void mover(Direccion dir)
	{
		if(m_habitacionActual.obtenerLado(dir) != null)
		{
			if(m_habitacionActual.obtenerLado(dir).getClass() == Puerta.class)
			{
				Puerta tPuerta = (Puerta) m_habitacionActual.obtenerLado(dir);
				tPuerta.Entrar();
				if(tPuerta.obtenerEstadoPuerta())
				{
					m_habitacionActual = (Habitacion) tPuerta.otroLadoDe(m_habitacionActual);
				}
			}
			else if(m_habitacionActual.obtenerLado(dir).getClass() == Pared.class)
			{
				Pared pared = (Pared)m_habitacionActual.obtenerLado(dir);
				pared.Entrar();
			}
		}
	}
	public final Laberinto crearLaberinto()
	{
		m_laberinto = new Laberinto();
		Habitacion h1 = new Habitacion(m_NumeroHabitacionJugador);
		Habitacion h2 = new Habitacion(2);
		Habitacion h3 = new Habitacion(3);
		Habitacion h4 = new Habitacion(4);
		Habitacion h5 = new Habitacion(5);
		Habitacion h6 = new Habitacion(6);

		m_laberinto.anadirHabitacion(h1);
		m_laberinto.anadirHabitacion(h2);
		m_laberinto.anadirHabitacion(h3);
		m_laberinto.anadirHabitacion(h4);
		m_laberinto.anadirHabitacion(h5);
		m_laberinto.anadirHabitacion(h6);

		Puerta p1 = fabricarPuerta(h1,h2,false);
		Puerta p2 = fabricarPuerta(h1,h4,true);
		Puerta p3 = fabricarPuerta(h4,h5, true);
		Puerta p4 = fabricarPuerta(h2,h5,false);
		Puerta p5 = fabricarPuerta(h2,h3,true);
		Puerta p6 = fabricarPuerta(h3,h5,true);
		Puerta p7 = fabricarPuerta(h5,h6,true);

		h1.establecerLado(Direccion.NORTE, fabricarPared());
		h1.establecerLado(Direccion.ESTE, p1);
		h1.establecerLado(Direccion.SUR, p2);
		h1.establecerLado(Direccion.OESTE, fabricarPared());
		
		h2.establecerLado(Direccion.NORTE, fabricarPared());
		h2.establecerLado(Direccion.ESTE, p1);
		h2.establecerLado(Direccion.SUR, p2);
		h2.establecerLado(Direccion.OESTE, p1);
		
		h3.establecerLado(Direccion.NORTE, fabricarPared());
		h3.establecerLado(Direccion.ESTE, fabricarPared());
		h3.establecerLado(Direccion.SUR, p7);
		h3.establecerLado(Direccion.OESTE, p5);
		
		h4.establecerLado(Direccion.NORTE, p2);
		h4.establecerLado(Direccion.ESTE, p3);
		h4.establecerLado(Direccion.SUR, fabricarPared());
		h4.establecerLado(Direccion.OESTE, fabricarPared());
		
		h5.establecerLado(Direccion.NORTE, p4);
		h5.establecerLado(Direccion.ESTE, p6);
		h5.establecerLado(Direccion.SUR, fabricarPared());
		h5.establecerLado(Direccion.OESTE, p3);
		
		h6.establecerLado(Direccion.NORTE, p7);
		h6.establecerLado(Direccion.ESTE, fabricarPared());
		h6.establecerLado(Direccion.SUR, fabricarPared());
		h6.establecerLado(Direccion.OESTE, p6);
		return m_laberinto;
	}
	// Métodos de fabricación
	public Laberinto fabricarLaberinto()
	{
		return new Laberinto();
	}

	public Habitacion fabricarHabitacion(int n)
	{
		return new Habitacion(n);
	}

	public Pared fabricarPared()
	{
		return new Pared();
	}

	public Puerta fabricarPuerta(Habitacion h1, Habitacion h2, boolean abierta)
	{
		return new Puerta(h1, h2,abierta);
	}
	public void dondeEstoy()
	{
		System.out.println("estoy en la habitación: "+m_habitacionActual.getNumeroHabitacion());
	}
}
