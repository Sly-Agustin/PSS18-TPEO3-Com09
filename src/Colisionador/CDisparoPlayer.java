package Colisionador;

import Entidades.*;

public class CDisparoPlayer extends Colisionador {
//Visitor Concrete
	
	
	private float damage;
	
	
	public CDisparoPlayer(float damage) {
		this.damage = damage;
	}

	public void afectarJugador(Player p) {
		//El disparo player no afecta al jugador
	}
	public void afectarEnemigo(Enemigo e) {
		e.setVida(e.getVida()-damage);
	}
	public void afectarEnemigoKami(EnemigoKami ek) {
		ek.setVida(ek.getVida()-damage);
	}
	public void afectarEnemigoArmado(EnemigoArmado ea) {
		ea.setVida(ea.getVida()-damage);
	}
	public void afectarObstaculo(Obstaculo o) {
		o.setVida(o.getVida()-damage);
	}

}
