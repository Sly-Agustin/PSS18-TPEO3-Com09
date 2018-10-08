package Entrada;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import InterfazGrafica.Pantalla;

public class Discreta implements KeyListener {
	
	public static int espacio = KeyEvent.VK_SPACE;
	public static int enter = KeyEvent.VK_ENTER;

	private boolean lastRead = false;
	private Runnable mifuncion;
	private int keycode;

	public Discreta(Runnable funcion, int keycode) {
		this.mifuncion = funcion;
		this.keycode = keycode;
		Pantalla.getInstance().addTeclado(this);
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == keycode) {
			if(!lastRead){
				mifuncion.run();
			}
			lastRead = true;
		}
	}


	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == keycode) {
			lastRead = false;
		}
	}	
	
	public void keyTyped(KeyEvent e) {}

}
