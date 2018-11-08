package Colisionador;

import Entidades.Enemigo;
import Entidades.EnemigoArmado;
import Entidades.EnemigoKami;
import Entidades.Player;

public class CSumaVida extends Colisionador{

	private float damage;

	public CSumaVida(float damage) {
		this.damage = damage;
	}

	public void afectarJugador(Player p) {
		System.out.println("Aumento vida del jugador");
		p.setVida(p.getVida()+damage);
	}
	
	public void afectarEnemigo(Enemigo e) {
		e.setVida(e.getVida()+damage);			
	}
	
	public void afectarEnemigoKami(EnemigoKami ek) {
		ek.setVida(ek.getVida()+damage);
	}
	
	public void afectarEnemigoArmado(EnemigoArmado ea) {
		ea.setVida(ea.getVida()+damage);
	}
}
