package Entidades;

import javax.swing.Icon;

import Colisionador.*;
import IA.*;

public class SuperMisil extends PowerUp{

	protected float velocidad = 1f;
	protected CSuperMisil col;
	
	protected SuperMisil(Icon icon) {
		super(icon);
		valor=-20;
		ia= new PowerUpIA();
		col= new CSuperMisil();
	}

	@Override
	public void onRefresh() {
		cuerpo.mover(ia.ADondeVoy(this).multK(velocidad));
	}

	@Override
	public int getDano() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void aceptar(Colisionador c) {
		c.afectarSuperMisil(this);
	}

	@Override
	public void colisionasteCon(Entidad another) {
		another.aceptar(col);
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
