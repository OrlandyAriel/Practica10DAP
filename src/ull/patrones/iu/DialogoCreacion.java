package ull.patrones.iu;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import ull.patrones.laberinto.Juego;
import ull.patrones.laberinto.JuegoDelLaberinto;
import ull.patrones.laberinto.JuegoDelLaberintoAnillo;
import ull.patrones.laberinto.JuegoDelLaberintoEncantado;

public class DialogoCreacion extends JDialog
{
	// ATRIBUTOS
		private JLabel mLabNumUsuarios;
		private JTextField mTxtNumUsuarios;
		private JButton mBtnEnviar;
		private Integer m_numUsuarios;
		
		private Juego m_juegoLaberinto;
		private JRadioButton m_radiolabNormal;
		private JRadioButton m_radiolabAnillo;
		private JRadioButton m_radiolabEncantado;
		private ButtonGroup m_groupRadio;
		private JPanel panelArriba;
		private JPanel panelCentro;//Radios

		// CONSTRUCTOR/ES
		public DialogoCreacion()
		{
			initPanelCentro();
			initPanelArriba();
			initComponent();
		}
		// MÉTODOS Y FUNCIONES
		private void initPanelCentro()
		{
			m_radiolabAnillo = new JRadioButton("Laberinto en Anillo");
			m_radiolabAnillo.setVisible(true);
			m_radiolabAnillo.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					m_juegoLaberinto = new JuegoDelLaberintoAnillo();
				}
			});
			
			m_radiolabEncantado = new JRadioButton("Laberinto Encantado");
			m_radiolabEncantado.setVisible(true);
			m_radiolabEncantado.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					m_juegoLaberinto = new JuegoDelLaberintoEncantado();
				}
			});
			
			m_radiolabNormal = new JRadioButton("Laberinto Normal");
			m_radiolabNormal.setVisible(true);
			m_radiolabNormal.setSelected(true);
			m_radiolabNormal.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					m_juegoLaberinto = new JuegoDelLaberinto();
				}
			});
			m_groupRadio = new ButtonGroup();
			m_groupRadio.add(m_radiolabAnillo);
			m_groupRadio.add(m_radiolabNormal);
			m_groupRadio.add(m_radiolabEncantado);
			
			panelCentro = new JPanel();
			panelCentro.setVisible(true);
			panelCentro.add(m_radiolabNormal);
			panelCentro.add(m_radiolabAnillo);
			panelCentro.add(m_radiolabEncantado);
		}

		private void initPanelArriba()
		{
			
			mLabNumUsuarios = new JLabel("Número de usuarios que deseas crear");
			mLabNumUsuarios.setVisible(true);

			mTxtNumUsuarios = new JTextField(10);
			mTxtNumUsuarios.setVisible(true);
			
			panelArriba = new JPanel();
			panelArriba.setVisible(true);
			panelArriba.add(mLabNumUsuarios);
			panelArriba.add(mTxtNumUsuarios);
		}
		
		private void initComponent()
		{
			
			mBtnEnviar = new JButton("Enviar");
			mBtnEnviar.setVisible(true);
			mBtnEnviar.addActionListener(
					new ActionListener()
					{
						@Override
						public void actionPerformed(ActionEvent e)
						{
							recogerDatosPerformed();
							dispose();
						}
					}
			);
			this.setLayout(new BorderLayout());
			this.setSize(500, 200);
			this.setTitle("Datos de creación");
			this.setVisible(true);
			this.setModal(true);
			this.setLocationRelativeTo(null);
			this.add(panelArriba, BorderLayout.NORTH);
			this.add(panelCentro,BorderLayout.CENTER);
			this.add(mBtnEnviar, BorderLayout.SOUTH);
		}
		private void recogerDatosPerformed()
		{
			m_numUsuarios = Integer.parseInt(mTxtNumUsuarios.getText());
			new VentanaInicial(m_juegoLaberinto, m_numUsuarios);
		}

}