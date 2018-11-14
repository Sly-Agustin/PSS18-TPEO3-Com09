package MenuPrincipal;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import InterfazGrafica.PantallaJuego;
import Level.LevelDirector;
import Login.ExceptionHandlerWindow;

public class MainMenuUser extends MainMenu{
	
	private JTextField textFieldComentarios;
	private JButton btnEnviarComentarios;
	private String user;
	
	public MainMenuUser(String usuario) {
		user = usuario;
		
		this.setSize(400, 400);
		getContentPane().setSize(400, 400);;
		getContentPane().setLayout(null);
		
		btnJugar = new JButton("Jugar");
		btnJugar.setBounds(10, 27, 89, 23);
		setActionListenerJugar();
		getContentPane().add(btnJugar);
		
		textFieldComentarios = new JTextField();
		textFieldComentarios.setBounds(10, 85, 218, 99);
		getContentPane().add(textFieldComentarios);
		textFieldComentarios.setColumns(10);
		
		btnEnviarComentarios = new JButton("Enviar comentarios");
		btnEnviarComentarios.setBounds(10, 207, 141, 23);
		setActionListenerEnviarComentarios();
		getContentPane().add(btnEnviarComentarios);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(10, 274, 89, 23);
		getContentPane().add(btnSalir);
	}
	
	/*private void setActionListenerJugar() {
		btnJugar.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				crearJuego();
				dispose();
			}
		});
	}*/
	
	private void setActionListenerEnviarComentarios() {
		btnJugar.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				String comentario = textFieldComentarios.getText();
			}
		});
	}
	
	/*private void setActionListenerSalir() {
		btnJugar.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}*/
	
	/*private void crearJuego() {
		PantallaJuego.getInstance();
		LevelDirector director = LevelDirector.instancia();
		director.inicializarNivel();
		(new Thread(director)).start();
	}*/
}
