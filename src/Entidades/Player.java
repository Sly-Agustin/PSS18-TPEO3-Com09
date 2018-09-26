package Entidades;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Animation.Pictures;

public class Player extends Entidad {
	
	private static Icon playerIcon = new ImageIcon(Pictures.player);
	private static Player inst;
	public static Player getInstance()
	{
		inst = inst != null? inst : new Player(playerIcon);
		return inst;
	}
	
	
	protected Player(Icon icon) {
		super(icon);
		ia = new PseudoIA();
		cuerpo.setVelocidadMaxima(3);
	}
	
	public void onRefresh() {
		cuerpo.mover(ia.ADondeVoy(this));		
	}


}
