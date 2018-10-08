package Entidades;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Animation.Pictures;
import IA.ObsIA;

public class Obstaculo extends Entidad {

	
	public static Icon obs = new ImageIcon(Pictures.obstaculos);
	
	public Obstaculo(Icon icon) {
		super(icon);
		ia = new ObsIA();
	}

	public void onRefresh() {
		cuerpo.mover(ia.ADondeVoy(this));
	}

	@Override
	public Entidad serChocado(Entidad e) {
		return e;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chocar(Entidad e) {
		// TODO Auto-generated method stub
		
	}
	
}
