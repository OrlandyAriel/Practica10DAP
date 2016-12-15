package ull.patrones.componentes;

import ull.patrones.enumerador.Direccion;

public class HabitacionEncantada extends Habitacion
{
	public HabitacionEncantada(int n)
	{
		super(n);
	}
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
			pos = 3;
			break;
		}
		return pos;
	}
	public int establecePos(Direccion dir)
    {
    	return super.obtenerPos(dir);
    }
}
