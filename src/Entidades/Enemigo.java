package Entidades;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Animation.Pictures;

public class Enemigo extends Entidad {

	
	public static Icon ic1 = new ImageIcon(Pictures.enemigo1);
	public static Icon ic2 = new ImageIcon(Pictures.enemigo2);
	
	
	public Enemigo(Icon icon) {
		super(icon);
		ia = new DummyIA();
	}


	public void onRefresh() {
		cuerpo.mover(ia.ADondeVoy(this));		
	}

}
