package Entidades;

import javax.swing.Icon;

import Colisionador.*;
import IA.*;

public class SuperMisil extends PowerUp{

	protected float velocidad = 1f;
	protected CBombaTemporal col;
	
	protected SuperMisil(Icon icon) {
		super(icon);
		valor=-20;
		ia= new PowerUpIA();
		col= new CBombaTemporal(15);
	}

	@Override
	public void onRefresh() {
		cuerpo.mover(ia.ADondeVoy(this).multK(velocidad));
		vida--;
	}

	@Override
	public int getDano() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void aceptar(Colisionador c) {
		c.afectarSacaVida(this);
	}

	@Override
	public void colisionasteCon(Entidad another) {
		another.aceptar(col);
	}

	@Override
	public void disparar() {
		// TODO Auto-generated method stub
		
	}

}
