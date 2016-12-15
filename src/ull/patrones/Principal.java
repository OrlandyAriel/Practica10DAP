package ull.patrones;

import ull.patrones.componentes.JugadorLaberinto;
import ull.patrones.enumerador.Direccion;
import ull.patrones.laberinto.JuegoDelLaberinto;
import ull.patrones.laberinto.Laberinto;

public class Principal
{
	public static void main(String[] args) throws InterruptedException
	{
		JuegoDelLaberinto jg = new JuegoDelLaberinto();
		Laberinto lab = jg.crearLaberinto();
		JugadorLaberinto player = new JugadorLaberinto(1, "landy", lab);
		
		player.mover(Direccion.SUR);
		player.dondeEstoy();
		player.mover(Direccion.ESTE);
		player.dondeEstoy();
		player.mover(Direccion.ESTE);
		player.dondeEstoy();
	}
}
