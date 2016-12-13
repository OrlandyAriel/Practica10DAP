package ull.patrones.componentes;

import ull.patrones.enumerador.Direccion;

public class Habitacion implements LugarDelMapa
{
    public static final int NUMLADOS = 4;
    private int numeroHabitacion;
    private final LugarDelMapa lados[] = new LugarDelMapa[NUMLADOS];
    
    public Habitacion(int numHabitacion)
    {
    	this.numeroHabitacion = numHabitacion;
    }
    public int getNumeroHabitacion()
	{
		return numeroHabitacion;
	}

	public LugarDelMapa[] getLados()
	{
		return lados;
	}

    public final LugarDelMapa obtenerLado(Direccion direccion)
    {
		return lados[obtenerPos(direccion)];
    }
    private int obtenerPos(Direccion dir)
    {
    	int pos;
		switch (dir)
		{
		case OESTE:
			pos =0;
			break;
		case NORTE:
			pos = 1;
			break;
		case ESTE:
			pos= 2;
			break;
		case SUR:
			pos = 3;
			break;
		default:
			pos = 0;
			break;
		}
		return pos;
    }
    
    public final void establecerLado(Direccion direccion, LugarDelMapa lugarDelMapa)
    {
    	int pos = obtenerPos(direccion);
    	lados[pos] = lugarDelMapa;
    }
    @Override
    public boolean equals(Object obj)
    {
    	Habitacion habitacion = (Habitacion) obj;
    	if(habitacion.numeroHabitacion == numeroHabitacion)
    		return true;
    	else
    		return false;
    }
    @Override
    public String toString()
    {
    	return "soy la habicación num:"+numeroHabitacion;
    }
    public void Entrar(Direccion dir)
    {
    	int pos = obtenerPos(dir);
    	LugarDelMapa puede = lados[pos];
    	puede.Entrar();
    }
	@Override
	public void Entrar()
	{
		// TODO Auto-generated method stub
		
	}
}
