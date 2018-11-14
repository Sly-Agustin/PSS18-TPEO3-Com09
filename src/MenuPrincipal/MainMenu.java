package MenuPrincipal;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

public class MainMenu extends JFrame{
	
	private JButton btnJugar;
	private JTextField textField;
	private JButton btnSalir;
	
	public MainMenu() {
		getContentPane().setLayout(null);
		
		btnJugar = new JButton("Jugar");
		btnJugar.setBounds(10, 27, 89, 23);
		getContentPane().add(btnJugar);
		
		textField = new JTextField();
		textField.setBounds(10, 85, 218, 99);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnEnviarComentarios = new JButton("Enviar comentarios");
		btnEnviarComentarios.setBounds(10, 207, 141, 23);
		getContentPane().add(btnEnviarComentarios);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(10, 274, 89, 23);
		getContentPane().add(btnSalir);
	}
}
