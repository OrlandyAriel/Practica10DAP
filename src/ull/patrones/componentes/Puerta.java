package ull.patrones.componentes;
/**
 * Clase que represnta una puerta que conecta 2 habitaciones
 * @author Orlandy Ariel Sánchez A.
 *
 */
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
	/**
	 * Método para saber si la puerta está cerrada o no.
	 * @return
	 */
	public boolean obtenerEstadoPuerta()
	{
		return estaAbierta;
	}
	/**
	 * Método para, dependiendo del lado en que se encuentre, obtener la otra habitación.
	 * @param habitacion, habitación desde donde se llama a la puerta.
	 * @return, devuelve la otra habitación con la que está conectada.
	 */
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
