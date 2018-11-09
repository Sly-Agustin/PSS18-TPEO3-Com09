package Colisionador;

import Entidades.Enemigo;
import Entidades.EnemigoArmado;
import Entidades.EnemigoKami;
import Entidades.Obstaculo;
import Entidades.Player;

public class CSuperMisil extends Colisionador{

	public CSuperMisil() {
	
	}
	
	public void afectarJugador(Player p) {
		p.setSuperMisil();
	}
	
	public void afectarEnemigoArmado(EnemigoArmado ea) {
		ea.setSuperMisil();
	}
	
}