package ull.patrones.componentes;

import ull.patrones.enumerador.Direccion;
/**
 * Clase que representa una habitación encantada.
 * @author Orlandy Ariel Sánchez A.
 *
 */
public class HabitacionEncantada extends Habitacion
{
	public HabitacionEncantada(int n)
	{
		super(n);
	}
	/**
     * método que, según la dirección, define su posición en el array
     * este, a diferencia de su clase padre Habitación, cambia en sentido contrario
     * a la pulsada
     * @param dir, dirección que se desea
     * @return, dirección que se desea
     */
	public int obtenerPos(Direccion dir)
	{
		int pos;
		switch (dir)
		{
		case OESTE:
			pos = 2;
			break;
		case NORTE:
			pos = 3;
			break;
		case ESTE:
			pos = 0;
			break;
		case SUR:
			pos = 1;
			break;
		default:
			pos = 0;
			break;
		}
		return pos;
	}
	public int establecePos(Direccion dir)
    {
    	return super.obtenerPos(dir);
    }
}
