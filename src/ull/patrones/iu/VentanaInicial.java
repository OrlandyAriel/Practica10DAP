package ull.patrones.iu;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import ull.patrones.componentes.JugadorLaberinto;
import ull.patrones.enumerador.Direccion;
import ull.patrones.laberinto.Juego;
import ull.patrones.laberinto.Laberinto;
/**
 * Clase que representa la ventana.
 * @author Orlandy Ariel Sánchez A.
 *
 */
public class VentanaInicial extends JFrame implements KeyListener
{
	private JTextArea m_jtxtPantalla;
	private JPanel panelRadios;
	private Laberinto m_Laberinto;
	private JugadorLaberinto m_jugadorSeleccionado;
	private Juego m_juegoLaberinto;
	private Integer m_numUsuarios;
	private ArrayList<JRadioButton> m_arrayJugadoresRadio;
	private ArrayList<JugadorLaberinto> m_arrayJugadoresLaberinto;
	private ButtonGroup m_groupButton;
	/**
	 * constructor que recibe el juego y el número de usuarios.
	 * @param juegolaberinto
	 * @param numUsuarios
	 */
	public VentanaInicial(Juego juegolaberinto, Integer numUsuarios)
	{
		m_arrayJugadoresRadio = new ArrayList<>();
		m_arrayJugadoresLaberinto = new ArrayList<>();
		m_juegoLaberinto = juegolaberinto;
		m_numUsuarios = numUsuarios;
		initPatallaConifg();
		crearJugadores();
		initComponent();
	}

	/**
	 *  Método sobre escrito que se acciona cuando se pulsa una tecla,
	 *  Las teclas que comprueba son las flechas, (izquierda, arriba,abajo,derecha)
	 * @param e, evento del teclado
	 */
	@Override
	public void keyPressed(KeyEvent e)
	{
		Direccion dir;
		switch (e.getKeyCode())
		{
		case 37:// izquierda
			dir= Direccion.OESTE;
			break;
		case 38:// arriba
			dir= Direccion.NORTE;
			break;
		case 39:// derecha
			dir= Direccion.ESTE;
			break;
		case 40:// abajo
			dir= Direccion.SUR;
			break;
		default:
			dir = Direccion.ESTE;
			break;
		}
		mueveJugador(dir);
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		//No es necesario añadir código
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		//No es necesario añadir código
	}
	/**
	 * Método para crear los jugadores, así tambien como su representación en la pantalla
	 * meediante JRadioButtons
	 */
	private void crearJugadores()
	{
		m_Laberinto = m_juegoLaberinto.crearLaberinto();
		m_jugadorSeleccionado =new JugadorLaberinto(1, "jugador" + 1, m_Laberinto);//Por defecto los coloco en la posicion 1
		for (int i = 0; i < m_numUsuarios; i++)
		{
			int aux = i + 1;
			JugadorLaberinto jugadorTemp = new JugadorLaberinto(1, "jugador" + aux, m_Laberinto);
			m_arrayJugadoresLaberinto.add(jugadorTemp);
			JRadioButton radioAux = new JRadioButton("jugador" + aux);
			radioAux.setVisible(true);
			radioAux.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					jugarPerformed(aux-1);
				}
			});
			m_arrayJugadoresRadio.add(radioAux);
		}
		m_arrayJugadoresRadio.get(0).setSelected(true);
		
		groupRadiosPanel();
	}
	private void jugarPerformed(int i)
	{
		m_jugadorSeleccionado = m_arrayJugadoresLaberinto.get(i);
	}
	private void mueveJugador(Direccion dir)
	{
		System.out.println(m_jugadorSeleccionado.getNombre());
		m_jugadorSeleccionado.mover(dir);
		actualizarTexto();
	}
	private void groupRadiosPanel()
	{
		m_groupButton = new ButtonGroup();
		panelRadios = new JPanel();
		panelRadios.setVisible(true);
		for (int i = 0; i < m_arrayJugadoresRadio.size(); i++)
		{
			m_groupButton.add(m_arrayJugadoresRadio.get(i));
			panelRadios.add(m_arrayJugadoresRadio.get(i));
		}
	}
	/**
	 * Configuración inicial del textarea
	 */
	private void initPatallaConifg()
	{
		m_jtxtPantalla = new JTextArea();
		m_jtxtPantalla.setVisible(true);
		m_jtxtPantalla.setEditable(false);
		m_jtxtPantalla.addKeyListener(this);
	}
	/**
	 * Método para actualizar el texto;
	 */
	private void actualizarTexto()
	{
		String temp = m_jtxtPantalla.getText()+"\n"+m_jugadorSeleccionado.dondeEstoy();
		m_jtxtPantalla.setText(temp);
	}
	/**
	 * Método que inicializa los componentes de la ventana inicial
	 */
	private void initComponent()
	{
		this.addKeyListener(this);
		this.setTitle("Practica 10");
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setSize(600, 300);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.add(panelRadios, BorderLayout.NORTH);
		this.add(m_jtxtPantalla, BorderLayout.CENTER);
	}

}
