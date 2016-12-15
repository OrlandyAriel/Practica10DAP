package ull.patrones;

import java.util.ArrayList;
import java.util.Scanner;

import ull.patrones.componentes.JugadorLaberinto;
import ull.patrones.enumerador.Direccion;
import ull.patrones.laberinto.Juego;
import ull.patrones.laberinto.JuegoDelLaberinto;
import ull.patrones.laberinto.JuegoDelLaberintoAnillo;
import ull.patrones.laberinto.JuegoDelLaberintoEncantado;
import ull.patrones.laberinto.Laberinto;

public class Practica10Consola
{
	private  ArrayList<JugadorLaberinto> arrayJugadores;
	private  Scanner sc;
	private  Laberinto laberinto;
	public static void main(String[] args)
	{
		new Practica10Consola();
	}
	public Practica10Consola()
	{
		arrayJugadores = new ArrayList<>();
		sc = new Scanner(System.in);
		char letra =inicio();
		laberinto = opcionesLaberintos(letra);
		crearJugadores();
		jugar();
	}
	private  void crearJugadores()
	{
		System.out.println("Introduce el número de jugadores que deseas:");
		int nunJugadores = sc.nextInt();
		
		for (int i = 0; i < nunJugadores; i++)
		{
			String nombre = "Jugador"+(i+1);
			System.out.println("Número de habitación de salida para "+nombre+":");
			int numHabSalida=sc.nextInt();
			arrayJugadores.add(new JugadorLaberinto(numHabSalida, nombre, laberinto));
		}
		System.out.println("###################################################");
		
	}
	private  Laberinto opcionesLaberintos(char letra)
	{
		Juego juegoLab = null;
		switch (letra)
		{
		case 'n' :
			juegoLab = new JuegoDelLaberinto();
			break;
		case 'a':
			juegoLab = new JuegoDelLaberintoAnillo();
			break;
		case 'e' :
			juegoLab = new JuegoDelLaberintoEncantado();
			break;
		default:
			juegoLab = new JuegoDelLaberinto();
			break;
		}
		return juegoLab.crearLaberinto();
	}
	private  void jugar()
	{
		while(true)
		{
			System.out.println("Introduce el jugador que deseas mover (sólo indicar el número):");
			int numJugador = sc.nextInt();
			instrucciones();
			int instruccion = sc.nextInt();
			if(numJugador >0 && numJugador<=arrayJugadores.size())
			{
				numJugador-=1;
				JugadorLaberinto tempJugador = arrayJugadores.get(numJugador);
				tempJugador.mover(convertirNumeroDireccion(instruccion));
				System.err.println(tempJugador.dondeEstoy());
				arrayJugadores.set(numJugador, tempJugador);
			}
			else
				System.err.println("introduce un número valido");
		}
	}
	private  Direccion convertirNumeroDireccion(int num)
	{
		Direccion d;
		switch (num)
		{
		case 0:
			d = Direccion.OESTE;
			break;
		case 1:
			d = Direccion.NORTE;
			break;
		case 2:
			d = Direccion.ESTE;
			break;
		case 3:
			d = Direccion.SUR;
			break;
		default:
			d = Direccion.OESTE;
			break;
		}
		return d;
	}
	public  char inicio()
	{
		System.out.println("Qué tipo de laberinto quieres? (pulsar letra marcada con [])");
		System.out.println("[N]ormal (laberinto de 6 habitaciones, conectadas normales");
		System.out.println("[A]nillo (laberinto de 12 habitaciones, conectadas en forma de anillo");
		System.out.println("[E]ncanta (Laberinto de 6 habitaciones, conectadas normales");
		String t_entrada =sc.next();
		t_entrada = t_entrada.toLowerCase();
		System.out.println(t_entrada);
		char letra = t_entrada.charAt(0);
		return letra;
	}
	public static void instrucciones()
	{
		System.out.println("Para moverte en el mapa selecciona selecciona una de las siguientes opciones:\n\tOeste = 0\n\tNorte = 1\n\tEste= 2\n\tSur= 3");
	}
}
