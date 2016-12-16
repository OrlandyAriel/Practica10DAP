package ull.patrones.componentes;
/**
 * Clase que representa una pared, por tanto no se puede entrar.
 * @author Orlandy Ariel Sánchez A.
 *
 */
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
