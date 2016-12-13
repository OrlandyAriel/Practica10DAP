package ull.patrones;

import ull.patrones.enumerador.Direccion;
import ull.patrones.laberinto.JuegoDelLaberinto;
import ull.patrones.laberinto.Laberinto;

public class Principal
{
	public static void main(String[] args)
	{
		JuegoDelLaberinto j = new JuegoDelLaberinto(1);
		Laberinto lab = j.crearLaberinto();
		j.mover(Direccion.ESTE);
		j.dondeEstoy();
	}
}
