package MenuPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import InterfazGrafica.JPanelFondo;
import InterfazGrafica.PantallaJuego;
import Level.LevelDirector;
import Login.loginPrincipal;

public class MainMenu extends JFrame{
	protected JButton btnJugar;
	protected JButton btnSalir;
	protected JButton btnCerrarSesion;
	protected JPanelFondo panel;
	
	public MainMenu() {
		this.setSize(400, 400);
		
		panel = new JPanelFondo();
		panel.setOpaque(false);
		panel.setIcon(new ImageIcon(loginPrincipal.class.getResource("/Fondos/galaxian.jpg")));
		panel.setBounds(50, 50, 600, 600);
		panel.setLayout(null);
		setContentPane(panel);
		getContentPane().setSize(400, 400);;
		getContentPane().setLayout(null);
		
		btnJugar = new JButton("Jugar");
		btnJugar.setBounds(10, 27, 89, 23);
		btnJugar.setIcon(new ImageIcon(MainMenu.class.getResource("/Fondos/button.png")));
		btnJugar.setBorderPainted(false); 
		btnJugar.setFocusPainted( false );
		btnJugar.setOpaque(false);
		btnJugar.setContentAreaFilled( false );
		btnJugar.setHorizontalTextPosition(SwingConstants.CENTER);
		setActionListenerJugar();
		getContentPane().add(btnJugar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(10, 274, 116, 23);
		btnSalir.setIcon(new ImageIcon(MainMenu.class.getResource("/Fondos/button.png")));
		btnSalir.setBorderPainted(false); 
		btnSalir.setFocusPainted( false );
		btnSalir.setOpaque(false);
		btnSalir.setContentAreaFilled( false );
		btnSalir.setHorizontalTextPosition(SwingConstants.CENTER);
		setActionListenerSalir();
		getContentPane().add(btnSalir);
		
		btnCerrarSesion = new JButton("Cerrar sesion");
		btnCerrarSesion.setBounds(10, 308, 116, 23);
		btnCerrarSesion.setIcon(new ImageIcon(MainMenu.class.getResource("/Fondos/button.png")));
		btnCerrarSesion.setBorderPainted(false); 
		btnCerrarSesion.setFocusPainted( false );
		btnCerrarSesion.setOpaque(false);
		btnCerrarSesion.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCerrarSesion.setContentAreaFilled( false );
		setActionListenerCerrarSesion();
		getContentPane().add(btnCerrarSesion);
	}
	
	protected void setActionListenerJugar() {
		btnJugar.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				crearJuego();
				dispose();
			}
		});
	}
	
	protected void setActionListenerSalir() {
		btnSalir.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	protected void crearJuego() {
		PantallaJuego.getInstance();
		LevelDirector director = LevelDirector.instancia();
		director.inicializarNivel();
		(new Thread(director)).start();
	}
	
	protected void setActionListenerCerrarSesion() {
		btnCerrarSesion.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				loginPrincipal login = new loginPrincipal();
				login.setVisible(true);
				dispose();
			}
		});
	}
}
