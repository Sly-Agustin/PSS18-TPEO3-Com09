package Entidades;

import javax.swing.Icon;

import Colisionador.*;
import IA.*;

public class TiroTriple extends PowerUp{


	protected float velocidad = 1f;
	protected CSumaVida col;

	
	protected TiroTriple(Icon icon) {
		super(icon);
		valor=20;
		ia= new PowerUpIA();
		col= new CSumaVida(15);
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
		c.afectarSumaVida(this);
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
