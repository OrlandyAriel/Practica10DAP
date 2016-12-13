package ull.patrones.laberinto;

import ull.patrones.componentes.Habitacion;
import ull.patrones.componentes.Pared;
import ull.patrones.componentes.Puerta;
import ull.patrones.enumerador.Direccion;

public class JuegoDelLaberinto
{
	private int posHabitacion;
	private Habitacion habitacionActual;
	private Laberinto lab;

	public JuegoDelLaberinto(int posHabitacion)
	{
		this.posHabitacion = 1;
		lab = crearLaberinto();
		habitacionActual = lab.numeroDeHabitacion(posHabitacion);
		
	}
	public void mover(Direccion dir)
	{
		if(habitacionActual.obtenerLado(dir) != null)
		{
			if(habitacionActual.obtenerLado(dir).getClass() == Puerta.class)
			{
				Puerta tPuerta = (Puerta) habitacionActual.obtenerLado(dir);
				if(tPuerta.obtenerEstadoPuerta())
				{
					habitacionActual = (Habitacion) tPuerta.otroLadoDe(habitacionActual);
				}
			}
		}
			
	}
	public final Laberinto crearLaberinto()
	{
		lab = new Laberinto();
		Habitacion h1 = new Habitacion(posHabitacion);
		Habitacion h2 = new Habitacion(2);
		lab.anadirHabitacion(h1);
		lab.anadirHabitacion(h2);
		Puerta laPuerta = fabricarPuerta(h1, h2);
		h1.establecerLado(Direccion.NORTE, fabricarPared());
		h1.establecerLado(Direccion.ESTE, laPuerta);
		h1.establecerLado(Direccion.SUR, fabricarPared());
		h1.establecerLado(Direccion.OESTE, fabricarPared());
		h2.establecerLado(Direccion.NORTE, fabricarPared());
		h2.establecerLado(Direccion.ESTE, fabricarPared());
		h2.establecerLado(Direccion.SUR, fabricarPared());
		h2.establecerLado(Direccion.OESTE, laPuerta);
		return lab;
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

	public Puerta fabricarPuerta(Habitacion h1, Habitacion h2)
	{
		return new Puerta(h1, h2,true);
	}
	public void dondeEstoy()
	{
		System.out.println("estoy en la habitación: "+habitacionActual.getNumeroHabitacion());
	}
}
