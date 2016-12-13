package ull.patrones.laberinto;

import ull.patrones.componentes.Habitacion;
import ull.patrones.componentes.Puerta;

public class JuegoDelLaberintoEncantado extends JuegoDelLaberinto
{
	public JuegoDelLaberintoEncantado()
	{
		super(1);
	}

	public Habitacion fabricarHabitacion(int n)
	{
		return new HabitacionEncantada(n, Hechizar());
	}

	public Puerta fabricarPuerta(Habitacion h1, Habitacion h2)
	{
		return new PuertaQueNecesitaHechizo(h1, h2);
	}

	protected final Hechizo Hechizar()
	{
		return null;
	}
}
