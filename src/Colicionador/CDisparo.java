package Colicionador;

import Entidades.*;

public class CDisparo extends Colicionador {

	//private Enemigo e;
	//private Obstaculo o;
	
	private Balazo b;
	
	
	public void afectarEnemigo(Enemigo e) {
		e.setVida(e.getVida()-b.getDano());
	}
	
	public void afectarObstaculo(Obstaculo o) {
		o.setVida(o.getVida()-b.getDano());
	}
	
}
