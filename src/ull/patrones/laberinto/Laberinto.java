package ull.patrones.laberinto;

import java.util.ArrayList;

import ull.patrones.componentes.Habitacion;
/**
 *Clase que repesenta el laberinto en s� mismo.
 * @author Orlandy Ariel S�nchez A.
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
	 * M�todo que, partiendo de un n�mero, busca la habitaci�n a la que corresponde
	 * @param numero, n�mero de habitaci�n que se requiere
	 * @return, la habitaci�n a la que corresponde dicho n�mero, si no est� se devuelve por defecto 0
	 */
	public final Habitacion numeroDeHabitacion(int numero)
	{
		Habitacion habiAux = new Habitacion(numero);
		int pos = arrayHabitaciones.indexOf(habiAux);
		if(pos == -1)
		{
			pos = 0;
			System.err.println("por defecto se devuelve la primera habiaci�n");
		}
		return arrayHabitaciones.get(pos);
	}
}
