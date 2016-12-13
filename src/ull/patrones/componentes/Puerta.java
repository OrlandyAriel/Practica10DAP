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
		if(habitacion.equals(habitacion1))
			return habitacion2;
		else if(habitacion.equals(habitacion2))
			return habitacion1;
		return null;
	}

	@Override
	public void Entrar()
	{
		if(estaAbierta)
			System.out.println("Cambio de habitacion");
		else
			System.err.println("No puedes pasar, puerta cerrada");
	}
}
