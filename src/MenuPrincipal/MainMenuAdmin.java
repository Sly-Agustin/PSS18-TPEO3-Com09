package MenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class MainMenuAdmin extends MainMenu{
	
	private String admin;
	private JButton btnMostrarComentarios;
	
	public MainMenuAdmin() {
		btnCerrarSesion.setBounds(10, 293, 147, 57);
		btnSalir.setBounds(10, 232, 147, 50);
		btnJugar.setBounds(10, 27, 147, 58);
		
		btnMostrarComentarios = new JButton("Mostrar comentarios");
		btnMostrarComentarios.setBounds(10, 145, 147, 50);
		btnMostrarComentarios.setIcon(new ImageIcon(MainMenu.class.getResource("/Fondos/button.png")));
		btnMostrarComentarios.setBorderPainted(false); 
		btnMostrarComentarios.setFocusPainted( false );
		btnMostrarComentarios.setOpaque(false);
		btnMostrarComentarios.setContentAreaFilled( false );
		btnMostrarComentarios.setHorizontalTextPosition(SwingConstants.CENTER);
		setActionListenerMostrarComentarios();
		getContentPane().add(btnMostrarComentarios);
		admin = "admin";
	}
	public MainMenuAdmin(String administrador) {
		admin = administrador;
	}
	
	private void setActionListenerMostrarComentarios() {
		btnMostrarComentarios.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				VentanaComentarios ventanaNueva = new VentanaComentarios();
				ventanaNueva.setVisible(true);
			}
		});
	}
}
