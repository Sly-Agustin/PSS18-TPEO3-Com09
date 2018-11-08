package Entidades;

import javax.swing.Icon;

import Colisionador.*;
import IA.*;

public class SumaVida extends PowerUp{


	protected float velocidad = 1f;
	protected CTiroTriple col;

	
	protected SumaVida(Icon icon) {
		super(icon);
		valor=10;
		ia= new PowerUpIA();
		col= new CSumaVida();
	}

	@Override
	public void onRefresh() {
		// TODO Auto-generated method stub
		
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
}
