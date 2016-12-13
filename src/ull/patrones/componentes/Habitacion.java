package ull.patrones.componentes;

import ull.patrones.enumerador.Direccion;

public class Habitacion implements LugarDelMapa
{
    public static final int NUMLADOS = 4;
    private int numeroHabitacion;
    private final LugarDelMapa lados[] = new LugarDelMapa[NUMLADOS];

    public Habitacion(int numHabitacion)
    {
    }

    public final LugarDelMapa obtenerLado(Direccion direccion)
    {
		return null;
    }

    public final void establecerLado(Direccion direccion, LugarDelMapa lugarDelMapa)
    {
    }

    @Override
    public void Entrar()
    {
    }
}
