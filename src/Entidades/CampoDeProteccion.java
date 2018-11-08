package Entidades;

import javax.swing.Icon;
import Colisionador.*;
import IA.*;

import Colisionador.Colisionador;

public class CampoDeProteccion extends PowerUp{

	protected float velocidad= 1f;
	protected CCampoDeProteccion col;
	
	protected CampoDeProteccion(Icon icon) {
		super(icon);
		valor=-10;
		ia= new PowerUpIA();
		col= new CCampoDeProteccion();
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
