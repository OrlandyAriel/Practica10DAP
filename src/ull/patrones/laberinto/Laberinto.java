package ull.patrones.laberinto;

import java.util.ArrayList;

import ull.patrones.componentes.Habitacion;

public class Laberinto
{
	private ArrayList<Habitacion> arrayHabitaciones ;
	public Laberinto()
	{
		arrayHabitaciones = new ArrayList<>();
	}
	public final void anadirHabitacion(Habitacion habitacion)
	{
		arrayHabitaciones.add(habitacion);
	}

	public final Habitacion numeroDeHabitacion(int numero)
	{
		Habitacion habiAux = new Habitacion(numero);
		int pos = arrayHabitaciones.indexOf(habiAux);
		if(pos == -1)
		{
			pos =0;
			System.err.println("por defecto se devuelve la primera habiación");
		}
		return arrayHabitaciones.get(pos);
	}
}
