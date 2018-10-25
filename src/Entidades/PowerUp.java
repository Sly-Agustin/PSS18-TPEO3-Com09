package Entidades;

import javax.swing.Icon;

import Colisionador.Colisionador;

public abstract class PowerUp extends Entidad{

	protected int vida;
	
	protected PowerUp(Icon icon) {
		super(icon);	
	}
	
	public abstract void onRefresh();

	public abstract int getDano();
		
	public abstract void aceptar(Colisionador c);

	public abstract void colisionasteCon(Entidad another) ;

	public abstract void disparar();

}
