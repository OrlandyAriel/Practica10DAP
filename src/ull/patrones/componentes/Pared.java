package ull.patrones.componentes;

public class Pared implements LugarDelMapa
{
	public Pared()
	{
	}
	@Override
	public void Entrar()
	{
		System.err.println("No puedes pasar, hay una pared");
	}

}
