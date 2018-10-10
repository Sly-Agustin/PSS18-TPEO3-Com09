package Entidades;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Animation.Pictures;
import Colisionador.Colisionador;
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

	
	
	public void serChocado(Entidad e) {
		
	}

	@Override
	public void chocar(Entidad e) {
		// TODO Auto-generated method stub
		
	}

	public void aceptar(Colisionador c) {
		c.afectarObstaculo(this);
	}
	
}
