package ull.patrones.laberinto;

import java.util.ArrayList;

import ull.patrones.componentes.Habitacion;
/**
 *Clase que repesenta el laberinto en sí mismo.
 * @author Orlandy Ariel Sánchez A.
 *
 */
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
	/**
	 * Método que, partiendo de un número, busca la habitación a la que corresponde
	 * @param numero, número de habitación que se requiere
	 * @return, la habitación a la que corresponde dicho número, si no está se devuelve por defecto 0
	 */
	public final Habitacion numeroDeHabitacion(int numero)
	{
		Habitacion habiAux = new Habitacion(numero);
		int pos = arrayHabitaciones.indexOf(habiAux);
		if(pos == -1)
		{
			pos = 0;
			System.err.println("por defecto se devuelve la primera habiación");
		}
		return arrayHabitaciones.get(pos);
	}
}
