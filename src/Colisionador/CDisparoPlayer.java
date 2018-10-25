package Colisionador;

import Entidades.*;/*
import Level.AbsNivel;
import Level.LevelDirector;
import TiposDeDatos.Coords;*/

public class CDisparoPlayer extends Colisionador {
//Visitor Concrete
	
	
	private float damage;
	//private PowerUp powerUp;
	
	public CDisparoPlayer(float damage) {
		this.damage = damage;
	}

	public void afectarJugador(Player p) {
		//El disparo player no afecta al jugador
	}
	public void afectarEnemigo(Enemigo e) {
		e.setVida(e.getVida()-damage);	
		if ( e.getVida() <= 0) {
			e.dropearPW();
		}
		/*
		powerUp.cuerpo.setPosicion(cuerpo.getPosicion().sumar(new Coords(playerIcon.getIconWidth()/2- b.getMostrable().getIcon().getIconWidth()/2,-40)));
		AbsNivel n = LevelDirector.instancia().currentLevel();
		n.addEntity(b);
		ElConocedor.instancia().add(b);
		*/
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
