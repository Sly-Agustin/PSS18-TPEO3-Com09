package Entidades;

import javax.swing.Icon;

import Colisionador.Colisionador;

public class SumaVidaPU extends PowerUp{

	protected SumaVidaPU(Icon icon) {
		super(icon);
		valor=20;
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
