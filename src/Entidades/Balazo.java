package Entidades;


import javax.swing.Icon;

import Colisionador.*;
import IA.IABalaPlayer;
//import InterfazGrafica.Mostrador;
//import TiposDeDatos.Coords;
import TiposDeDatos.CuerpoRigido;

public class Balazo extends Entidad{


	private float velocidad = 4f;
	protected int dano; 
	protected CDisparo col;


	protected Balazo(Icon icon) {
		super(icon);
		ia = new IABalaPlayer();
		dano=10;
		col = new CDisparo();
	}


	public void onRefresh() {
		cuerpo.mover(ia.ADondeVoy(this).multK(velocidad));
	}


	public int getDano() {
		return dano;
	}
	
	
	public void aceptar(Colisionador c) {
		
	}
	
	public void serChocado(Entidad e) {
		
	}
	
	public void chocar(Entidad e) {
//		Coords posEntidad =  e.getCuerpo().getPosicion();
//		Coords posThis = this.getCuerpo().getPosicion();
//		if(posEntidad.getX() == posThis.getX() && posEntidad.getY() == posThis.getY()) {
//			col.afectarEnemigo((Enemigo) e);
//			System.out.println("Disparo choco con enemigo");
//		}
		
//		Mostrador rEntidad = e.getMostrable();
//		Mostrador rThis = this.getMostrable();
//		
//		if(rEntidad == rThis) {
//			col.afectarEnemigo((Enemigo) e);
//			System.out.println("Disparo choco con enemigo");
//		}
		
		CuerpoRigido crThis = this.getCuerpo();
		CuerpoRigido crEntidad = e.getCuerpo();
		if(crThis.intersects(crEntidad)) {
			System.out.println("Disparo colisiono");
			col.afectarEnemigo((Enemigo) e);
			System.out.println("Disparo afecto");
		}
	}

}
