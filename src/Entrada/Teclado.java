package Entrada;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import InterfazGrafica.PantallaJuego;
import Level.LevelDirector;

public class Teclado implements KeyListener{
	
	private boolean left;
	private boolean right;
	
	
	public Teclado() {
		left = false;
		right=false;
		PantallaJuego.getInstance().addTeclado(this);
	}

	
	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar() == 'a' || e.getKeyChar() == 'A' ) {
			left = true;
		}
		if(e.getKeyChar() == 'D' || e.getKeyChar() == 'd' ) {
			right = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.out.println("aprete escape");
			PantallaJuego.getInstance().mostrarMenuEscape();
		}
		
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyChar() == 'a' || e.getKeyChar() == 'A' ) {
			left = false;
		}
		if(e.getKeyChar() == 'D' || e.getKeyChar() == 'd' ) {
			right = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.out.println("deje de apretar escape");
		}
	}
	
	public boolean left() {
		return left;
	}

	
	public boolean right() {
		return right;
	}

}
