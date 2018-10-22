package Colisionador;

import Entidades.Enemigo;
import Entidades.EnemigoKami;
import Entidades.Obstaculo;
import Entidades.Player;

public class CDisparoEnemigo extends Colisionador{

	private float damage;
	
	public CDisparoEnemigo(float damage) {
		this.damage = damage;
	}

	public void afectarJugador(Player p) {
		p.setVida(p.getVida()-5);
		p.manejarVida();
		System.out.println("Vida: "+p.getVida());
	}
	public void afectarEnemigo(Enemigo e) {
	
	}
	public void afectarEnemigoKami(EnemigoKami ek) {
		
	}
	public void afectarObstaculo(Obstaculo o) {
		
	}

	
}
