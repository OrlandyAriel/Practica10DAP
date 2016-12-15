package ull.patrones;

import java.util.ArrayList;

import ull.patrones.componentes.JugadorLaberinto;
import ull.patrones.enumerador.Direccion;
import ull.patrones.laberinto.JuegoDelLaberinto;
import ull.patrones.laberinto.JuegoDelLaberintoAnillo;
import ull.patrones.laberinto.Laberinto;

public class Principal
{
	public static ArrayList<Direccion> demoLaberintoAnillo()
	{
		ArrayList<Direccion> arrDir= new ArrayList<>();
		arrDir.add(Direccion.ESTE);
		arrDir.add(Direccion.ESTE);
		arrDir.add(Direccion.ESTE);
		arrDir.add(Direccion.ESTE);
		arrDir.add(Direccion.ESTE);
		arrDir.add(Direccion.OESTE);
		arrDir.add(Direccion.OESTE);
		arrDir.add(Direccion.OESTE);
		arrDir.add(Direccion.OESTE);
		arrDir.add(Direccion.SUR);
		arrDir.add(Direccion.SUR);
		arrDir.add(Direccion.ESTE);
		arrDir.add(Direccion.ESTE);
		arrDir.add(Direccion.ESTE);
		arrDir.add(Direccion.ESTE);
		arrDir.add(Direccion.ESTE);
		arrDir.add(Direccion.NORTE);
		return arrDir;
	}
	public static ArrayList<Direccion> demoLaberintoNormal()
	{
		ArrayList<Direccion> arrDir= new ArrayList<>();
		arrDir.add(Direccion.ESTE);
		arrDir.add(Direccion.SUR);
		arrDir.add(Direccion.ESTE);
		arrDir.add(Direccion.NORTE);
		arrDir.add(Direccion.ESTE);
		
		return arrDir;
	}
	public static void main(String[] args) throws InterruptedException
	{
		JuegoDelLaberinto jg = new JuegoDelLaberinto();
		Laberinto lab = jg.crearLaberinto();
		JugadorLaberinto player = new JugadorLaberinto(1, "Landy", lab);
		ArrayList<Direccion> arrDir = demoLaberintoNormal();
		for (int i = 0; i < arrDir.size(); i++)
		{
			player.mover(arrDir.get(i));
			player.dondeEstoy();
			Thread.sleep(200);
		}
		/*
		player.mover(Direccion.SUR);
		player.dondeEstoy();
		player.mover(Direccion.ESTE);
		player.dondeEstoy();
		player.mover(Direccion.ESTE);
		player.dondeEstoy();*/
	}
}
