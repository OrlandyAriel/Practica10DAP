package ull.patrones.laberinto;

import ull.patrones.componentes.Habitacion;
import ull.patrones.componentes.Puerta;
import ull.patrones.enumerador.Direccion;
import ull.patrones.enumerador.TipoHabitacion;

public class JuegoDelLaberintoAnillo extends JuegoDelLaberinto
{
	public JuegoDelLaberintoAnillo()
	{
		super();
	}

	@Override
	public Laberinto creacionLaberintoInterno()
	{

		Laberinto labAnillo = fabricarLaberinto();

		Habitacion h1 = fabricarHabitacion(1);
		h1.setM_tipoHabitacion(TipoHabitacion.INICIO);
		Habitacion h2 = fabricarHabitacion(2);
		Habitacion h3 = fabricarHabitacion(3);
		Habitacion h4 = fabricarHabitacion(4);
		Habitacion h5 = fabricarHabitacion(5);
		Habitacion h6 = fabricarHabitacion(6);
		Habitacion h7 = fabricarHabitacion(7);
		h7.setM_tipoHabitacion(TipoHabitacion.OBJETIVO);
		Habitacion h8 = fabricarHabitacion(8);
		Habitacion h9 = fabricarHabitacion(9);
		Habitacion h10 = fabricarHabitacion(10);
		Habitacion h11 = fabricarHabitacion(11);
		Habitacion h12 = fabricarHabitacion(12);

		labAnillo.anadirHabitacion(h1);
		labAnillo.anadirHabitacion(h2);
		labAnillo.anadirHabitacion(h3);
		labAnillo.anadirHabitacion(h4);
		labAnillo.anadirHabitacion(h5);
		labAnillo.anadirHabitacion(h6);
		labAnillo.anadirHabitacion(h7);
		labAnillo.anadirHabitacion(h8);
		labAnillo.anadirHabitacion(h9);
		labAnillo.anadirHabitacion(h10);
		labAnillo.anadirHabitacion(h11);
		labAnillo.anadirHabitacion(h12);

		Puerta p1 = fabricarPuerta(h1, h2, true);
		Puerta p2 = fabricarPuerta(h2, h3, true);
		Puerta p3 = fabricarPuerta(h3, h4, true);
		Puerta p4 = fabricarPuerta(h4, h5, true);
		Puerta p5 = fabricarPuerta(h5, h7, false);
		Puerta p6 = fabricarPuerta(h1, h6, true);
		Puerta p7 = fabricarPuerta(h6, h8, true);
		Puerta p8 = fabricarPuerta(h8, h9, true);
		Puerta p9 = fabricarPuerta(h9, h10, true);
		Puerta p10 = fabricarPuerta(h10, h11, true);
		Puerta p11 = fabricarPuerta(h11, h12, true);
		Puerta p12 = fabricarPuerta(h12, h7, true);

		h1.establecerLado(Direccion.NORTE, fabricarPared());
		h1.establecerLado(Direccion.ESTE, p1);
		h1.establecerLado(Direccion.SUR, p6);
		h1.establecerLado(Direccion.OESTE, fabricarPared());

		h2.establecerLado(Direccion.NORTE, fabricarPared());
		h2.establecerLado(Direccion.ESTE, p2);
		h2.establecerLado(Direccion.SUR, fabricarPared());
		h2.establecerLado(Direccion.OESTE, p1);

		h3.establecerLado(Direccion.NORTE, fabricarPared());
		h3.establecerLado(Direccion.ESTE, p3);
		h3.establecerLado(Direccion.SUR, fabricarPared());
		h3.establecerLado(Direccion.OESTE, p2);

		h4.establecerLado(Direccion.NORTE, fabricarPared());
		h4.establecerLado(Direccion.ESTE, p4);
		h4.establecerLado(Direccion.SUR, fabricarPared());
		h4.establecerLado(Direccion.OESTE, p3);

		h5.establecerLado(Direccion.NORTE, fabricarPared());
		h5.establecerLado(Direccion.ESTE, fabricarPared());
		h5.establecerLado(Direccion.SUR, p5);
		h5.establecerLado(Direccion.OESTE, p4);

		h6.establecerLado(Direccion.NORTE, p6);
		h6.establecerLado(Direccion.ESTE, fabricarPared());
		h6.establecerLado(Direccion.SUR, p7);
		h6.establecerLado(Direccion.OESTE, fabricarPared());

		h7.establecerLado(Direccion.NORTE, p5);
		h7.establecerLado(Direccion.ESTE, fabricarPared());
		h7.establecerLado(Direccion.SUR, p12);
		h7.establecerLado(Direccion.OESTE, fabricarPared());

		h8.establecerLado(Direccion.NORTE, p7);
		h8.establecerLado(Direccion.ESTE, p8);
		h8.establecerLado(Direccion.SUR, fabricarPared());
		h8.establecerLado(Direccion.OESTE, fabricarPared());

		h9.establecerLado(Direccion.NORTE, fabricarPared());
		h9.establecerLado(Direccion.ESTE, p9);
		h9.establecerLado(Direccion.SUR, fabricarPared());
		h9.establecerLado(Direccion.OESTE, p8);

		h10.establecerLado(Direccion.NORTE, fabricarPared());
		h10.establecerLado(Direccion.ESTE, p10);
		h10.establecerLado(Direccion.SUR, fabricarPared());
		h10.establecerLado(Direccion.OESTE, p9);

		h11.establecerLado(Direccion.NORTE, fabricarPared());
		h11.establecerLado(Direccion.ESTE, p11);
		h11.establecerLado(Direccion.SUR, fabricarPared());
		h11.establecerLado(Direccion.OESTE, p10);

		h12.establecerLado(Direccion.NORTE, p12);
		h12.establecerLado(Direccion.ESTE, fabricarPared());
		h12.establecerLado(Direccion.SUR, fabricarPared());
		h12.establecerLado(Direccion.OESTE, p11);
		return labAnillo;
	}
}
