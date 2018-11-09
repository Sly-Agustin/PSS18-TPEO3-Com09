package Colisionador;

import Entidades.Balazo;
import Entidades.Enemigo;
import Entidades.EnemigoKami;
import Entidades.Obstaculo;
import Entidades.Player;

public class CEnemigo extends Colisionador{
	
	private Enemigo e;
	
	public void afectarJugador(Player p) {
		p.setVida(p.getVida()-(e.getVida()/e.getValor()));
		System.out.println("Enemigo choco con Jugador");
		/**
		 * Al colisionar al jugador se le descuenta de la vida que tenga la vida del enemigo
		 * dividido por el puntaje que tenga al morir.
		 */
	}
	public void afectarEnemigo(Enemigo e) {}
	public void afectarObstaculo(Obstaculo o) {}
	public void afectarEnemigoKami(EnemigoKami ek) {}
	@Override
	public void afectarDisparo(Balazo balazo) {
		balazo.setVida(-2);
	}
}
