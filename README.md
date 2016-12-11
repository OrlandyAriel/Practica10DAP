# Diseño Arquitectónico y Patrones
##El patrón Factory Method: Un creador de laberintos
#Objetivo General
En esta práctica se pretende crear el “tablero” de un juego con determinadas características. Aunque el tablero se instanciara en la forma de un laberinto, el planteamiento utilizado puede ser aplicado a otros casos de uso.
##Introducción
En este caso que nos ocupa, se define el laberinto como un conjunto de habitaciones. Una habitación conoce sus lindes, que pueden ser otra habitación, una pared, o una puerta a otra habitación. Las clases Habitacion, Puerta y Pared definen los componentes del Laberinto. Cada habitación tiene cuatro lados. Se utilizará un tipo enumerado para especificar los lados Norte, Sur, Este y Oeste de una habitación:
```java
public enum Direccion {
 NORTE,
 SUR,
 ESTE,
 OESTE;
}
```
La clase LugarDelMapa es la clase abstracta común de todos los componentes de un laberinto. Se simplifica mediante la operación Entrar. El significado dependerá de dónde se esté entrando. Si se entra en una habitación, cambiará
la posición. Si tratamos de entrar en una puerta, pueden pasar dos cosas: si la puerta está abierta, se pasará a la siguiente habitación, si la puerta está cerrada, se tropieza de frente con la puerta.
```java
public interface LugarDelMapa {
 public void Entrar();
}
```
Entrar proporciona una base para operaciones más sofisticadas en el juego. Por ejemplo, si estamos en una habitación y decidimos ir hacia el Este, el juego puede determinar qué LugarDelMapa se Encuentra inmediatamente al Este,
para a continuación llamar a la operación Entrar. La operación Entrar, con cada subclase concreta determinará si cambia nuestra posición o si nos damos de frente. En un juego real, Entrar podría tomar como argumento el objeto jugador que se está moviendo. Habitación es la subclase concreta de LugarDelMapa que define las relaciones principales entre los componentes del laberinto. Mantiene referencias a otros objetos de LugarDelMapa y guarda su número de habitación. Este número identificará las habitaciones en el laberinto.
```java
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
	}

	public final void establecerLado(Direccion direccion, LugarDelMapa lugarDelMapa)
	{
	}

	@Override
	public void Entrar()
	{
	}}
```
	Las siguientes clases representan la pared o puerta que hay en cada lado de una estancia.
```java
	public class Pared implements LugarDelMapa
	{
		public Pared()
		{
		}

		@Override
		public void Entrar()
		{
		}
	}

public class Puerta implements LugarDelMapa {
	private Habitacion habitacion1;
	private Habitacion habitacion2;
 	private boolean estaAbierta;
 	public Puerta(Habitacion habitacion1, Habitacion habitacion2) {}
 	public final Habitacion otroLadoDe(Habitacion habitacion){ }

	 @Override
	 public void Entrar() {}
	}
```
Se definirá también una clase Laberinto que representa a una serie de habitaciones. Laberinto también puede encontrar una determinada habitación usando su operación NumeroDeHabitación.
```java
public class Laberinto {
 // ....
 public final void anadirHabitacion(Habitacion habitacion) {}
 public final Habitacion numeroDeHabitacion(int numero) {}
}
```
Por último se define la clase JuegoDelLaberinto, que es la que crea el laberinto.
```java
public class JuegoDelLaberinto {
	public final Laberinto crearLaberinto() {
	//...
	}
}
```
Una forma sencilla de crear el laberinto es con una serie de operaciones que añadan componentes a un laberinto y los conecten entre sí. Por ejemplo, las siguientes llamadas a funciones miembro crearían un laberinto con una puerta entre ambas:
```java
public final Laberinto crearLaberinto() {
     Laberinto unLaberinto = new Laberinto();
     Habitacion h1 = new Habitacion(1);
     Habitacion h2 = new Habitacion(2);
     unLaberinto.añadirHabitacion(h1);
     unLaberinto.añadirHabitacion(h2);
     Puerta laPuerta = new Puerta(h1, h2);
     h1.establecerLado(Direccion.NORTE, new Pared());
     h1.establecerLado(Direccion.ESTE, laPuerta);
     h1.establecerLado(Direccion.SUR, new Pared());
     h1.establecerLado(Direccion.OESTE, new Pared());
     h2.establecerLado(Direccion.NORTE, new Pared());
     h2.establecerLado(Direccion.ESTE, new Pared());
     h2.establecerLado(Direccion.SUR, new Pared());
     h2.establecerLado(Direccion.OESTE, laPuerta);
     return unLaberinto;
 }
```
Esta función resulta un tanto inflexible puesto que la distribución del laberinto está fijada al código, de modo que para cambiar la distribución del laberinto es necesario cambiar esta función. Lo deseable es disponer de métodos de fabricación en el JuegoDelLaberinto para crear los objetos Laberinto, Habitacion, Pared y Puerta:
```java
// Métodos de fabricación
 public Laberinto fabricarLaberinto() {
 	return new Laberinto();
 }
 public Habitacion fabricarHabitacion(int n) {
 	return new Habitacion(n);
 }
 public Pared fabricarPared() {
 	return new Pared();
 }
 public Puerta fabricarPuerta(Habitacion h1, Habitacion h2) {
 	return new Puerta(h1, h2);
 }
```
Cada método de fabricación devuelve un componente del laberinto de un tipo dado. JuegoDelLaberinto proporciona implementaciones predeterminadas que devuelven los tipos más simples de laberintos, habitaciones, paredes y puertas.
Ahora se redefiniría CrearLaberinto para que use los métodos de fabricación:
```java
 public final Laberinto crearLaberinto() {
     Laberinto unLaberinto = new Laberinto();
     Habitacion h1 = new Habitacion(1);
     Habitacion h2 = new Habitacion(2);
     unLaberinto.añadirHabitacion(h1);
     unLaberinto.añadirHabitacion(h2);
     Puerta laPuerta = fabricarPuerta(h1, h2);
     h1.establecerLado(Direccion.NORTE, fabricarPared());
     h1.establecerLado(Direccion.ESTE, laPuerta);
     h1.establecerLado(Direccion.SUR, fabricarPared());
     h1.establecerLado(Direccion.OESTE, fabricarPared());
     h2.establecerLado(Direccion.NORTE, fabricarPared());
     h2.establecerLado(Direccion.ESTE, fabricarPared());
     h2.establecerLado(Direccion.SUR, fabricarPared());
     h2.establecerLado(Direccion.OESTE, laPuerta);
     return unLaberinto;
 }
```
De este modo, juegos diferentes pueden heredar del JuegoDelLaberinto para especializar partes del laberinto. Las subclases del JuegoDelLaberinto pueden redefinir algunos de los métodos de fabricación o todos para especificar variantes de los productos. Por ejemplo, un JuegoDelLaberintoEncantado podría definirse como sigue:
```java
public class JuegoDelLaberintoEncantado extends JuegoDelLaberinto {
 	public JuegoDelLaberintoEncantado () {
 	}
     public Habitacion fabricarHabitacion(int n) {
    	 return new HabitacionEncantada(n, Hechizar());
     }
     public Puerta fabricarPuerta(Habitacion h1, Habitacion h2) {
     	return new PuertaQueNecesitaHechizo(h1, h2);
     }
     protected final Hechizo Hechizar() {
     }
}
```
## Objetivos Específicos
Diseña, e implementa cada uno de los siguientes apartados:
1. Siguiendo las indicaciones anteriores diseña tableros de juegos para los personajes que has creado en la práctica Deberás diseñar, al menos dos tableros distintos.
2. Posiciona personajes de tus juegos en distintas posiciones de los tableros y generando movimientos de cada uno de ellos. Recuerda que los personajes pueden cambiar su personalidad.
3. Opcional: Desarrolla una versión gráfica de tus juegos.