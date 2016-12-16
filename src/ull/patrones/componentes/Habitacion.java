package ull.patrones.componentes;

import ull.patrones.enumerador.Direccion;
import ull.patrones.enumerador.TipoHabitacion;
/**
 * Clase que representa una habitación.
 * @author Orlandy Ariel Sánchez A.
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
     * @param numHabitacion, número para identificar la habitación.
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
	 * Método que, partiendo de una dirección, devuelve lo que se encuentra en esa dirección.
	 * @param direccion
	 * @return
	 */
    public final LugarDelMapa obtenerLado(Direccion direccion)
    {
		return lados[obtenerPos(direccion)];
    }
    /**
     * método que, según la dirección, define su posición en el array
     * @param dir, dirección que se desea
     * @return, dirección que se desea
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
     * Método que, según la dirección, obtiene su posición para establecer en el array
     * (este método llama a obtenerPos, se hace de esa manera para, en caso de herencia, el programador
     * pueda elegir como se comporta a la hora de establecer un lugar en la habitación.
     * @param dir, dirección que se desea
     * @return, dirección que se desea
     */
    public int establecePos(Direccion dir)
    {
    	return obtenerPos(dir);
    }
    /**
     * Método para establecer a quíen tendrá en los lados esta habitación.
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
    	return "Soy la habicación num:"+numeroHabitacion;
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
