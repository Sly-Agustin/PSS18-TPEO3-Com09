package Entidades;

import javax.swing.Icon;

import Colisionador.*;
import IA.IABalaPlayer;

public class Balazo extends Entidad{


	private float velocidad = 4f;
	protected int dano; 
	protected CDisparo col;


	protected Balazo(Icon icon) {
		super(icon);
		ia = new IABalaPlayer();
	}


	public void onRefresh() {
		cuerpo.mover(ia.ADondeVoy(this).multK(velocidad));
	}


	public int getDano() {
		return dano;
	}
	
	
	public Entidad serChocado(Entidad e) {
		return this;
	}
	
	public void chocar(Entidad e) {
		float posXentidad =  e.getCuerpo().getPosicion().getX();
		float posXthis = this.getCuerpo().getPosicion().getX();

		if(posXentidad == posXthis) {
			col.afectarEnemigo((Enemigo) e);
		}

	}


}
