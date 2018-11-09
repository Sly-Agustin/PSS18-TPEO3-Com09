package Colisionador;

import Entidades.Enemigo;
import Entidades.EnemigoKami;
import Entidades.Obstaculo;
import Entidades.Player;
import Entidades.CampoDeProteccion;
import Entidades.SuperMisil;
import Entidades.SumaVida;
import Entidades.TiroTriple;

public class CDisparoEnemigo extends Colisionador{

	private float damage;
	
	public CDisparoEnemigo(float damage) {
		this.damage = damage;
	}

	public void afectarJugador(Player p) {
		p.setVida(p.getVida()-damage);
		//System.out.println("Vida: "+p.getVida());
	}
	public void afectarEnemigo(Enemigo e) {}
	public void afectarEnemigoKami(EnemigoKami ek) {}
	public void afectarObstaculo(Obstaculo o) {}
	public void afectarSacaDano(CampoDeProteccion p) {}
	public void afectarSumaDano(SumaVida p) {}
	public void afectarSumaVida(TiroTriple p) {}	
	public void afectarSacaVida(SuperMisil p) {}
	
}
