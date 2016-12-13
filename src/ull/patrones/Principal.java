package ull.patrones;

import ull.patrones.enumerador.Direccion;
import ull.patrones.laberinto.JuegoDelLaberinto;

public class Principal
{
	public static void main(String[] args) throws InterruptedException
	{
		JuegoDelLaberinto j = new JuegoDelLaberinto(1);
		//casilla inical
		j.mover(Direccion.NORTE);
		j.dondeEstoy();
		Thread.sleep(100);
		j.mover(Direccion.OESTE);
		j.dondeEstoy();
		Thread.sleep(100);
		j.mover(Direccion.ESTE);
		j.dondeEstoy();
		Thread.sleep(100);
		j.mover(Direccion.SUR);
		j.dondeEstoy();
		Thread.sleep(100);
		//en casilla 4
		j.mover(Direccion.SUR);
		j.dondeEstoy();
		Thread.sleep(100);
		j.dondeEstoy();
		j.mover(Direccion.OESTE);
		Thread.sleep(100);
		j.dondeEstoy();
		j.mover(Direccion.NORTE); //en la casilla 1
		Thread.sleep(100);
		j.dondeEstoy();
		j.mover(Direccion.SUR); //en la casilla4
		Thread.sleep(100);
		j.dondeEstoy();
		j.mover(Direccion.ESTE); //en la casilla 5
		Thread.sleep(100);
		j.dondeEstoy();
	}
}
