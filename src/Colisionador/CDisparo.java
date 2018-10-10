package Colisionador;

import Entidades.*;

public class CDisparo extends Colisionador {

	//private Enemigo e;
	//private Obstaculo o;

	private Balazo b;

	public void afectarJugador(Player p) {
		//el disparo no afecta al jugador
	}
	public void afectarEnemigo(Enemigo e) {
		e.setVida(e.getVida()-b.getDano());
	}
	public void afectarEnemigoKami(EnemigoKami ek) {
		ek.setVida(ek.getVida()-b.getDano());
	}
	public void afectarObstaculo(Obstaculo o) {
		o.setVida(o.getVida()-b.getDano());
	}


}
