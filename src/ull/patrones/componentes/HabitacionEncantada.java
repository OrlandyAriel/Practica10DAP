package ull.patrones.componentes;

import ull.patrones.enumerador.Direccion;
/**
 * Clase que representa una habitaci�n encantada.
 * @author Orlandy Ariel S�nchez A.
 *
 */
public class HabitacionEncantada extends Habitacion
{
	public HabitacionEncantada(int n)
	{
		super(n);
	}
	/**
     * m�todo que, seg�n la direcci�n, define su posici�n en el array
     * este, a diferencia de su clase padre Habitaci�n, cambia en sentido contrario
     * a la pulsada
     * @param dir, direcci�n que se desea
     * @return, direcci�n que se desea
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
