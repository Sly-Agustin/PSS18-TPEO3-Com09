package Colicionador;

import Entidades.*;

public class CDisparo extends Colicionador {

	//private Enemigo e;
	private Balazo b;
	
	
	
	public void afectarEnemigo(Enemigo e) {
		e.setVida(e.getVida()-b.getDano());
	}
	
}
