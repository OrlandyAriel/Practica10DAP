package ull.patrones.componentes;

public class Puerta implements LugarDelMapa
{
	private Habitacion habitacion1;
	private Habitacion habitacion2;
	private boolean estaAbierta;
	
	public Puerta(Habitacion habitacion1, Habitacion habitacion2, boolean abierta)
	{
		//habitación que comparten la pared
		this.habitacion1 = habitacion1;
		this.habitacion2 = habitacion2;
		estaAbierta = abierta;
	}
	public boolean obtenerEstadoPuerta()
	{
		return estaAbierta;
	}
	public final Habitacion otroLadoDe(Habitacion habitacion)
	{
		return habitacion2;
	}

	@Override
	public void Entrar()
	{
	}
}
