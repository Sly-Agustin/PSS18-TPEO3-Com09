package MenuPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import InterfazGrafica.PantallaJuego;
import Level.LevelDirector;
import Login.loginPrincipal;

public class MainMenu extends JFrame{
	protected JButton btnJugar;
	protected JButton btnSalir;
	protected JButton btnCerrarSesion;
	
	public MainMenu() {
		this.setSize(400, 400);
		getContentPane().setSize(400, 400);;
		getContentPane().setLayout(null);
		
		btnJugar = new JButton("Jugar");
		btnJugar.setBounds(10, 27, 89, 23);
		setActionListenerJugar();
		getContentPane().add(btnJugar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(10, 274, 116, 23);
		setActionListenerSalir();
		getContentPane().add(btnSalir);
		
		btnCerrarSesion = new JButton("Cerrar sesion");
		btnCerrarSesion.setBounds(10, 308, 116, 23);
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
