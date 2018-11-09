package Entidades;

import javax.swing.Icon;

import Colisionador.CDetenerTiempo;
import Colisionador.*;
import IA.PowerUpIA;

public class BombaTemporal extends PowerUp{

	protected float velocidad= 1f;
	protected CBombaTemporal col;
	
	protected BombaTemporal(Icon icon) {
		super(icon);
		valor=-10;
		ia= new PowerUpIA();
		col= new CBombaTemporal();
	}

	@Override
	public void onRefresh() {cuerpo.mover(ia.ADondeVoy(this).multK(velocidad));
	}

	@Override
	public int getDano() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void aceptar(Colisionador c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void colisionasteCon(Entidad another) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disparar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void activar() {
		// TODO Auto-generated method stub
		
	}

}
