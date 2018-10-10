package Entidades;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import Animation.Pictures;
import Colisionador.Colisionador;
import IA.DummyIA;

public class Enemigo extends Entidad {

	
	public static Icon ic1 = new ImageIcon(Pictures.enemigo1);
	
	private int vida;
	
	
	public Enemigo(Icon icon) {
		super(icon);
		ia = new DummyIA();
		valor = 10;
		vida = 100;
	}

	
	public void onRefresh() {
		cuerpo.mover(ia.ADondeVoy(this));		
	}
	
	public int getVida() {
		return vida;
	}
	public void setVida(int v) {
		vida=v;
	}
	
	
	public void serChocado(Entidad e) {
		
	}

	public void chocar(Entidad e) {
		
	}

	public void aceptar(Colisionador c) {
		c.afectarEnemigo(this);
	}


	
}
