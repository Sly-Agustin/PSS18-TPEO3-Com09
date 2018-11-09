package Entidades;

import javax.swing.Icon;

import Colisionador.CCampoDeProteccion;
import Colisionador.Colisionador;
import IA.PowerUpIA;
import Colisionador.*;

public class DetenerTiempo extends PowerUp{

	protected float velocidad= 1f;
	protected CDetenerTiempo col;
	
	protected DetenerTiempo(Icon icon) {
		super(icon);
		valor=-10;
		ia= new PowerUpIA();
		col= new CDetenerTiempo();
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

