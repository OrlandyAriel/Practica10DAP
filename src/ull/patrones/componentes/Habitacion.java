package ull.patrones.componentes;

import ull.patrones.enumerador.Direccion;
import ull.patrones.enumerador.TipoHabitacion;
/**
 * Clase que representa una habitaci�n.
 * @author Orlandy Ariel S�nchez A.
 *
 */
public class Habitacion implements LugarDelMapa
{
    public static final int NUMLADOS = 4;
    private int numeroHabitacion;
    private final LugarDelMapa lados[] = new LugarDelMapa[NUMLADOS];
    private TipoHabitacion m_tipoHabitacion;
    /**
     * Construcotr.
     * @param numHabitacion, n�mero para identificar la habitaci�n.
     */
    public Habitacion(int numHabitacion)
    {
    	setM_tipoHabitacion(TipoHabitacion.NORMAL);
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
	/**
	 * M�todo que, partiendo de una direcci�n, devuelve lo que se encuentra en esa direcci�n.
	 * @param direccion
	 * @return
	 */
    public final LugarDelMapa obtenerLado(Direccion direccion)
    {
		return lados[obtenerPos(direccion)];
    }
    /**
     * m�todo que, seg�n la direcci�n, define su posici�n en el array
     * @param dir, direcci�n que se desea
     * @return, direcci�n que se desea
     */
    public int obtenerPos(Direccion dir)
    {
    	int pos;
		switch (dir)
		{
		case OESTE:
			pos = 0;
			break;
		case NORTE:
			pos = 1;
			break;
		case ESTE:
			pos = 2;
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
    /**
     * M�todo que, seg�n la direcci�n, obtiene su posici�n para establecer en el array
     * (este m�todo llama a obtenerPos, se hace de esa manera para, en caso de herencia, el programador
     * pueda elegir como se comporta a la hora de establecer un lugar en la habitaci�n.
     * @param dir, direcci�n que se desea
     * @return, direcci�n que se desea
     */
    public int establecePos(Direccion dir)
    {
    	return obtenerPos(dir);
    }
    /**
     * M�todo para establecer a qu�en tendr� en los lados esta habitaci�n.
     * @param direccion
     * @param lugarDelMapa
     */
    public final void establecerLado(Direccion direccion, LugarDelMapa lugarDelMapa)
    {
    	int pos = establecePos(direccion);
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
    	return "Soy la habicaci�n num:"+numeroHabitacion;
    }
   
	@Override
	public void Entrar()
	{
		if(m_tipoHabitacion == TipoHabitacion.OBJETIVO)
		{
			System.out.println("LLEGO AL OBJETIVO");
		}
	}
	public TipoHabitacion getM_tipoHabitacion()
	{
		return m_tipoHabitacion;
	}
	public void setM_tipoHabitacion(TipoHabitacion m_tipoHabitacion)
	{
		this.m_tipoHabitacion = m_tipoHabitacion;
	}
}
