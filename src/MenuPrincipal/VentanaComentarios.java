package MenuPrincipal;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import Login.ExceptionHandlerWindow;

public class VentanaComentarios extends JFrame{
	
	private JLabel lblComentarios;
	private JTextPane textPane;
	private JScrollPane scrollPaneComentarios;
	
	public VentanaComentarios() {
		this.setSize(450, 400);
		getContentPane().setLayout(null);
		
		lblComentarios = new JLabel("Comentarios");
		lblComentarios.setBounds(10, 11, 88, 14);
		getContentPane().add(lblComentarios);
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(10, 36, 414, 289);
		getContentPane().add(textPane);
		
		scrollPaneComentarios = new JScrollPane(textPane);
		scrollPaneComentarios.setPreferredSize(new Dimension(450, 400));
		scrollPaneComentarios.setVisible(true);
		scrollPaneComentarios.setBounds(10, 36, 414, 289);
		getContentPane().add(scrollPaneComentarios);
		
		obtenerComentarios();
	}
	
	private void obtenerComentarios() {
		BufferedReader lectorArchivo = null;
		try {
			lectorArchivo = new BufferedReader(new FileReader("src/Cuentas/comentarios"));
			String comentarios = "";
			String linea;
			while ((linea=lectorArchivo.readLine()) != null) {
				System.out.println("Comentario: "+linea);
				comentarios = comentarios+linea+"\n";
			}
			System.out.println("Comentarios: "+comentarios);
			textPane.setText(comentarios);
		}
		catch(IOException e) {
			ExceptionHandlerWindow.showExceptionMessage("Error en la lectura de archivo de comentarios");
		}
	}
}
