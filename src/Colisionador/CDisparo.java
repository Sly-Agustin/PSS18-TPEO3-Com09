package Colisionador;

import Entidades.*;

public class CDisparo extends Colisionador {
//Visitor Concrete
	
	
	private float damage;
	
	public CDisparo(float damage) {
		this.damage = damage;
	}

	public void afectarJugador(Player p) {
		//el disparo no afecta al jugador
	}
	public void afectarEnemigo(Enemigo e) {
		e.setVida(e.getVida()-damage);
	}
	public void afectarEnemigoKami(EnemigoKami ek) {
		ek.setVida(ek.getVida()-damage);
	}
	public void afectarObstaculo(Obstaculo o) {
		o.setVida(o.getVida()-damage);
	}

}
