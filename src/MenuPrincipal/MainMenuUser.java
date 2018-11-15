package MenuPrincipal;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

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
		
		/*btnJugar = new JButton("Jugar");
		btnJugar.setBounds(10, 27, 89, 23);
		getContentPane().add(btnJugar);*/
		
		textFieldComentarios = new JTextField();
		textFieldComentarios.setBounds(10, 85, 218, 99);
		getContentPane().add(textFieldComentarios);
		textFieldComentarios.setColumns(10);
		
		btnEnviarComentarios = new JButton("Enviar comentarios");
		btnEnviarComentarios.setBounds(0, 209, 172, 23);
		btnEnviarComentarios.setIcon(new ImageIcon(MainMenu.class.getResource("/Fondos/button.png")));
		btnEnviarComentarios.setBorderPainted(false); 
		btnEnviarComentarios.setFocusPainted( false );
		btnEnviarComentarios.setOpaque(false);
		btnEnviarComentarios.setContentAreaFilled( false );
		btnEnviarComentarios.setHorizontalTextPosition(SwingConstants.CENTER);
		setActionListenerEnviarComentarios();
		getContentPane().add(btnEnviarComentarios);
		
		/*btnSalir = new JButton("Salir");
		btnSalir.setBounds(10, 274, 89, 23);
		getContentPane().add(btnSalir);*/
	}
	
	private void setActionListenerEnviarComentarios() {
		btnEnviarComentarios.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				String comentario = textFieldComentarios.getText();
				EscrituraDeComentarios.escribirEnArchivo(comentario, user);
			}
		});
	}
}
