package Colisionador;

import Entidades.Enemigo;
import Entidades.EnemigoKami;
import Entidades.Obstaculo;
import Entidades.Player;

public class CEnemigo extends Colisionador{
	
	private Enemigo e;
	
	public void afectarJugador(Player p) {
		p.setVida(p.getVida()-(e.getVida()/e.getValor()));
		/**
		 * Al colisionar al jugador se le descuenta de la vida que tenga la vida del enemigo
		 * dividido por el puntaje que tenga al morir.
		 */
	}
	public void afectarEnemigo(Enemigo e) {}
	public void afectarObstaculo(Obstaculo o) {}
	public void afectarEnemigoKami(EnemigoKami ek) {}
	
}
