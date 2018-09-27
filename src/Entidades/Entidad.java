package Entidades;

import TiposDeDatos.*;
import javax.swing.*;

import InterfazGrafica.Mostrador;
public abstract class Entidad {

	protected CuerpoRigido cuerpo;
	protected Mostrador mostrador;
	protected IA ia;
	protected int valor;
	
	protected Entidad(Icon icon) {
		cuerpo = new CuerpoRigido();
		mostrador = new Mostrador(icon);
		
	}
	
	public abstract void onRefresh();

	public Mostrador getMostrable() {
		return mostrador;
	}
	
	public CuerpoRigido getCuerpo()
	{
		return cuerpo;
	}
	
	public void refresh() {
		int w,h,x,y;
		w = mostrador.getWidth();
		h = mostrador.getHeight();
		x = (int)cuerpo.getPosicion().getX();
		y = (int)cuerpo.getPosicion().getY();
		mostrador.setBounds(x,y,w,h);
		onRefresh();
	}

	public int getValor() {
		return valor;
	}
	
}
