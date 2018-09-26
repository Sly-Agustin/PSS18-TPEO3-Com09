package InterfazGrafica;

import java.awt.Container;
import Datos.*;
import Entrada.Teclado;

import javax.swing.*;
import javax.swing.JLabel;

public class Pantalla 
{
	private static Pantalla instancia;
	public static Pantalla getInstance() {
		instancia = instancia == null ? new Pantalla() : instancia;
		return instancia;
	}


	private JFrame frame;
	private Container container;

	private Pantalla() {	
		inicializar();
	}

	private void inicializar() {
		frame = new JFrame(GameData.NombreDelJuego);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(GameData.WindowSize);
		frame.setContentPane(new JLabel(IconsManager.fondo));
		container = frame.getContentPane();
		container.setLayout(null);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);		
	}

	public void addMostrable(Mostrador mostrable){
		container.add(mostrable);
	}
	
	public void removeMostrable(Mostrador mostrable) {
		container.remove(mostrable);
	}
	
	public void addTeclado(Teclado teclado) {
		frame.addKeyListener(teclado);

	}

	public void removeTeclado(Teclado teclado) {
		frame.removeKeyListener(teclado);		
	}




}
