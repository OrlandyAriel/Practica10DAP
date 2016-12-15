package ull.patrones.laberinto;

import ull.patrones.componentes.Habitacion;
import ull.patrones.componentes.Pared;
import ull.patrones.componentes.Puerta;
import ull.patrones.enumerador.Direccion;
import ull.patrones.enumerador.TipoHabitacion;

public class JuegoDelLaberinto implements Juego
{
	private Laberinto m_laberinto;

	public JuegoDelLaberinto()
	{
		m_laberinto = fabricarLaberinto();
	}

	public final Laberinto crearLaberinto()
	{
		m_laberinto = creacionLaberintoInterno();

		return m_laberinto;
	}

	public Laberinto creacionLaberintoInterno() // 3 x 3
	{
		Laberinto labNormal = fabricarLaberinto();
		Habitacion h1 = fabricarHabitacion(1);
		h1.setM_tipoHabitacion(TipoHabitacion.INICIO);
		Habitacion h2 = fabricarHabitacion(2);
		Habitacion h3 = fabricarHabitacion(3);
		Habitacion h4 = fabricarHabitacion(4);
		Habitacion h5 = fabricarHabitacion(5);
		Habitacion h6 = fabricarHabitacion(6);
		h6.setM_tipoHabitacion(TipoHabitacion.OBJETIVO);
		
		labNormal.anadirHabitacion(h1);
		labNormal.anadirHabitacion(h2);
		labNormal.anadirHabitacion(h3);
		labNormal.anadirHabitacion(h4);
		labNormal.anadirHabitacion(h5);
		labNormal.anadirHabitacion(h6);

		Puerta p1 = fabricarPuerta(h1, h2, false);
		Puerta p2 = fabricarPuerta(h1, h4, true);
		Puerta p3 = fabricarPuerta(h4, h5, true);
		Puerta p4 = fabricarPuerta(h2, h5, false);
		Puerta p5 = fabricarPuerta(h2, h3, true);
		Puerta p6 = fabricarPuerta(h6, h5, true);
		Puerta p7 = fabricarPuerta(h3, h6, true);

		h1.establecerLado(Direccion.NORTE, fabricarPared());
		h1.establecerLado(Direccion.ESTE, p1);
		h1.establecerLado(Direccion.SUR, p2);
		h1.establecerLado(Direccion.OESTE, fabricarPared());

		h2.establecerLado(Direccion.NORTE, fabricarPared());
		h2.establecerLado(Direccion.ESTE, p5);
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
		
		return labNormal;
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
		return new Puerta(h1, h2, abierta);
	}
}
