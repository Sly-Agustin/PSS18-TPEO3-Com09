package Login;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import InterfazGrafica.JPanelFondo;
import InterfazGrafica.PantallaJuego;
import Level.LevelDirector;
import MenuPrincipal.MainMenu;
import MenuPrincipal.MainMenuAdmin;
import MenuPrincipal.MainMenuUser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;

public class loginPrincipal extends JFrame{
	private JLabel lblUsuario;
	private JTextField textFieldUsuario;
	private JLabel lblContrasenia;
	private JButton btnIniciarSesion;
	private VerificadorUsuario verificadorUsuario;
	private JPasswordField passwordField;
	private JPanelFondo panel;
	
	public loginPrincipal() {
		this.setSize(400, 400);
		panel = new JPanelFondo();
		panel.setOpaque(false);
		panel.setIcon(new ImageIcon(loginPrincipal.class.getResource("/Fondos/galaxian.jpg")));
		panel.setBounds(50, 50, 600, 600);
		panel.setLayout(null);
		setContentPane(panel);
		getContentPane().setLayout(null);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setBounds(24, 12, 65, 14);
		getContentPane().add(lblUsuario);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(24, 37, 86, 20);
		getContentPane().add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		lblContrasenia = new JLabel("Contrase\u00F1a");
		lblContrasenia.setForeground(Color.WHITE);
		lblContrasenia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContrasenia.setBounds(24, 85, 86, 14);
		getContentPane().add(lblContrasenia);
		
		btnIniciarSesion = new JButton("Iniciar sesion");
		btnIniciarSesion.setBounds(108, 255, 143, 47);
		btnIniciarSesion.setIcon(new ImageIcon(MainMenu.class.getResource("/Fondos/button.png")));
		btnIniciarSesion.setBorderPainted(false); 
		btnIniciarSesion.setFocusPainted( false );
		btnIniciarSesion.setOpaque(false);
		btnIniciarSesion.setContentAreaFilled( false );
		btnIniciarSesion.setHorizontalTextPosition(SwingConstants.CENTER);
		getContentPane().add(btnIniciarSesion);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(24, 110, 86, 20);
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
						abrirMenuPrincipal(usuario);
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
	private void abrirMenuPrincipal(String usuario) {
		if (usuario.equals("admin")) {
			MainMenuAdmin menu = new MainMenuAdmin();
			menu.setVisible(true);
		}
		else {
			MainMenuUser menu = new MainMenuUser(usuario);
			menu.setVisible(true);
		}
	}
}
