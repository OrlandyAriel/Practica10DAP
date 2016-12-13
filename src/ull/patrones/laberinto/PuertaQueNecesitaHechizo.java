package ull.patrones.laberinto;

import ull.patrones.componentes.Habitacion;
import ull.patrones.componentes.Puerta;

public class PuertaQueNecesitaHechizo extends Puerta
{

	public PuertaQueNecesitaHechizo(Habitacion habitacion1, Habitacion habitacion2)
	{
		super(habitacion1, habitacion2,true);
	}

}
