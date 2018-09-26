package Entidades;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Animation.Pictures;

public class Obstaculo extends Entidad {

	
	public static Icon obs = new ImageIcon(Pictures.obstaculos);
	
	public Obstaculo(Icon icon) {
		super(icon);
	}

	public void onRefresh() {
		cuerpo.mover(ia.ADondeVoy(this));
	}
	
}
