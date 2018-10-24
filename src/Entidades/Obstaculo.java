package Entidades;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Animation.Pictures;
import Colisionador.CObstaculo;
import Colisionador.Colisionador;
import IA.ObsIA;

public class Obstaculo extends Entidad {

	
	public static Icon obs = new ImageIcon(Pictures.obstaculos);
	
	public Obstaculo(Icon icon) {
		super(icon);
		ia = new ObsIA();
		vida = 50;
		col = new CObstaculo(); 
	}

	public void onRefresh() {
		cuerpo.mover(ia.ADondeVoy(this));
	}

	


	public void aceptar(Colisionador c) {
		c.afectarObstaculo(this);
	}

	@Override
	public void colisionasteCon(Entidad another) {
		another.aceptar(col);		
	}

	@Override
	public void disparar() {
		// TODO Auto-generated method stub
		
	}
	
}
