package Colisionador;

import Entidades.Balazo;
import Entidades.Enemigo;
import Entidades.EnemigoArmado;
import Entidades.EnemigoKami;
import Entidades.Obstaculo;
import Entidades.Player;

public class CEnemigoArmado extends Colisionador{

	private float damage;

	public CEnemigoArmado(float damage) {
		this.damage = damage;
	}

	public void afectarJugador(Player p) {
		p.setVida(p.getVida()-damage);
		/**
		 * Al colisionar al jugador se le descuenta de la vida que tenga la vida del enemigo
		 * dividido por el puntaje que tenga al morir.
		 */
	}
	public void afectarEnemigo(Enemigo e) {}
	public void afectarObstaculo(Obstaculo o) {}
	public void afectarEnemigoKami(EnemigoKami ek) {}
	public void afectarEnemigoArmado(EnemigoArmado ea) {}
	public void afectarDisparo(Balazo balazo) {
		balazo.setVida(-2);
	}
}
