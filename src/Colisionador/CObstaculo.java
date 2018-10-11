package Colisionador;

import Entidades.Balazo;

public class CObstaculo extends Colisionador{

	@Override
	public void afectarDisparo(Balazo balazo) {
		balazo.setVida(-2);
	}
	
}
