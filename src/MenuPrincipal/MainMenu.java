package MenuPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import InterfazGrafica.PantallaJuego;
import Level.LevelDirector;

public class MainMenu extends JFrame{
	protected JButton btnJugar;
	protected JButton btnSalir;
	
	public MainMenu() {
		this.setSize(400, 400);
		getContentPane().setSize(400, 400);;
		getContentPane().setLayout(null);
		
		btnJugar = new JButton("Jugar");
		btnJugar.setBounds(10, 27, 89, 23);
		setActionListenerJugar();
		getContentPane().add(btnJugar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(10, 274, 89, 23);
		setActionListenerSalir();
		getContentPane().add(btnSalir);
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
}
