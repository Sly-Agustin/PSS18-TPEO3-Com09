package Login;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import InterfazGrafica.PantallaJuego;
import Level.LevelDirector;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPasswordField;

public class loginPrincipal extends JFrame{
	private JLabel lblUsuario;
	private JTextField textFieldUsuario;
	private JLabel lblContrasenia;
	private JButton btnIniciarSesion;
	private VerificadorUsuario verificadorUsuario;
	private JPasswordField passwordField;
	
	public loginPrincipal() {
		this.setSize(400, 400);
		getContentPane().setLayout(null);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(50, 11, 46, 14);
		getContentPane().add(lblUsuario);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(50, 36, 86, 20);
		getContentPane().add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		lblContrasenia = new JLabel("Contrase\u00F1a");
		lblContrasenia.setBounds(50, 80, 86, 14);
		getContentPane().add(lblContrasenia);
		
		btnIniciarSesion = new JButton("Iniciar sesion");
		btnIniciarSesion.setBounds(34, 161, 121, 23);
		getContentPane().add(btnIniciarSesion);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(50, 105, 86, 20);
		getContentPane().add(passwordField);
		
		setActionListenerbtnIniciarSesion();
		
		verificadorUsuario = new VerificadorUsuario();
		
	}
	
	private void setActionListenerbtnIniciarSesion() {
		btnIniciarSesion.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				if(textFieldUsuario.getText().length() == 0 ||  passwordField.getText().length() == 0) {
					ExceptionHandlerWindow.showExceptionMessage("Usuario o contraseña vacia");
				}
				else {
					String usuario = textFieldUsuario.getText();
					String contrasenia = new String(passwordField.getPassword());
					boolean loguear = verificadorUsuario.login(usuario, contrasenia);
					if (loguear) {
						crearJuego();
						dispose();
					}
					else {
						ExceptionHandlerWindow.showExceptionMessage("Usuario y/o contraseña incorrecto/s");
					}
				}
			}
		});
	}
	
	public void crearJuego() {
		PantallaJuego.getInstance();
		LevelDirector director = LevelDirector.instancia();
		director.inicializarNivel();
		(new Thread(director)).start();
	}
}
