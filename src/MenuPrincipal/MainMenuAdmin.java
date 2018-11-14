package MenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MainMenuAdmin extends MainMenu{
	
	private String admin;
	private JButton btnMostrarComentarios;
	
	public MainMenuAdmin() {
		
		btnMostrarComentarios = new JButton("Mostrar comentarios");
		btnMostrarComentarios.setBounds(10, 145, 157, 23);
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
