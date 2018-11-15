package InterfazGrafica;

import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import Datos.*;
import Entidades.ElConocedor;
import Entrada.*;
import Level.LevelDirector;
import MenuPrincipal.MainMenu;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaJuego extends Pantalla{
	
	private static PantallaJuego instancia;
	public static PantallaJuego getInstance() {
		instancia = instancia == null ? new PantallaJuego() : instancia;
		return instancia;
	}


	private JFrame frame;
	private Container container;
	private JPanel panelEscape;
	private JButton btnReiniciarJuego;
	private JButton btnSalir;
	private JButton btnX;

	private PantallaJuego() {	
		run();
	}

	protected void inicializar() {
		frame = new JFrame(GameData.NombreDelJuego);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(GameData.WindowSize);
		frame.setContentPane(new JLabel(IconsManager.fondo));
		container = frame.getContentPane();
		container.setLayout(null);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);		
		
		panelEscape = new JPanel();
		panelEscape.setSize(200, 200);
		panelEscape.setBounds(300, 200, 200, 200);
		panelEscape.setVisible(false);
		panelEscape.setLayout(null);
		panelEscape.setOpaque(false);
		container.add(panelEscape);
		
		btnReiniciarJuego = new JButton("Reiniciar juego");
		btnReiniciarJuego.setVisible(false);
		btnReiniciarJuego.setBounds(24, 34, 138, 48);
		btnReiniciarJuego.setIcon(new ImageIcon(MainMenu.class.getResource("/Fondos/button.png")));
		btnReiniciarJuego.setBorderPainted(false); 
		btnReiniciarJuego.setFocusPainted( false );
		btnReiniciarJuego.setOpaque(false);
		btnReiniciarJuego.setContentAreaFilled( false );
		btnReiniciarJuego.setHorizontalTextPosition(SwingConstants.CENTER);
		btnReiniciarJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				esconderMenuEscape();
				LevelDirector.instancia().reiniciar();
			}
		});
		panelEscape.add(btnReiniciarJuego);
		
		btnSalir = new JButton("Salir");
		btnSalir.setVisible(false);
		btnSalir.setIcon(new ImageIcon(MainMenu.class.getResource("/Fondos/button.png")));
		btnSalir.setBorderPainted(false); 
		btnSalir.setFocusPainted( false );
		btnSalir.setOpaque(false);
		btnSalir.setContentAreaFilled( false );
		btnSalir.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(24, 110, 138, 58);
		panelEscape.add(btnSalir);
		
		btnX = new JButton("X");
		btnX.setBounds(147, 0, 53, 23);
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				esconderMenuEscape();
			}
		});
		panelEscape.add(btnX);
		
	}

	public void addMostrable(Mostrador mostrable){
		container.add(mostrable);
	}
	
	public void removeMostrable(Mostrador mostrable) {
		container.remove(mostrable);
	}
	
	public void addTeclado(KeyListener kl) {
		frame.addKeyListener(kl);
	}

	public void refresh() {
		frame.repaint();	
	}

	public void run() {
		inicializar();
	}
	
	public void mostrarMenuEscape() {
		panelEscape.setVisible(true);
		btnSalir.setVisible(true);
		btnReiniciarJuego.setVisible(true);
	}
	
	public void esconderMenuEscape() {
		panelEscape.setVisible(false);
		btnSalir.setVisible(false);
		btnReiniciarJuego.setVisible(false);
	}
}
