package Colisionador;

import Entidades.Enemigo;
import Entidades.EnemigoArmado;
import Entidades.EnemigoKami;
import Entidades.Obstaculo;
import Entidades.Player;

public class CTiroTriple extends Colisionador{

	public CTiroTriple() {
	
	}
	
	public void afectarJugador(Player p) {
		p.setTiroTriple();
	}
	
	public void afectarEnemigoArmado(EnemigoArmado ea) {
		ea.setTiroTriple();
	}
	
}
