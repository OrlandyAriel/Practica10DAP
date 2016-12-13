package ull.patrones.componentes;

public class Puerta implements LugarDelMapa
{
	private Habitacion habitacion1;
	private Habitacion habitacion2;
	private boolean estaAbierta;

	public Puerta(Habitacion habitacion1, Habitacion habitacion2)
	{
	}

	public final Habitacion otroLadoDe(Habitacion habitacion)
	{
		return habitacion;
	}

	@Override
	public void Entrar()
	{
	}

}
