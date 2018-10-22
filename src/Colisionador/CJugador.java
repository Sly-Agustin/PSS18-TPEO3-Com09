package Colisionador;

import Entidades.*;

public class CJugador extends Colisionador
{
	public void afectarDisparo(Balazo balazo) {
		balazo.setVida(-2);
	}
/*	public void afectarEnemigoKami(EnemigoKami ek) {
		ek.setVida(0);
	}*/

}
