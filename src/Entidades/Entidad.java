package Entidades;

import TiposDeDatos.*;
import javax.swing.*;

import Colisionador.Colisionador;

import IA.IA;
import InterfazGrafica.Mostrador;

public abstract class Entidad {

	/*
	 * Hacer el patron State en eneitdad para generalizar la IA
	 * meter el onRefresh en entidad
	 * generalizar mas todo
	 * los puntajes y demas cosas buscar de meterlas en entidad
	 * que cada entidad cambie de IA sin que nadie se entere, solo ellos.
	 */
	
	protected CuerpoRigido cuerpo;
	protected Mostrador mostrador;
	protected IA ia;
	protected int valor;
	protected int vida;
	protected Colisionador col;
	
	protected Entidad(Icon icon) {
		cuerpo = new CuerpoRigido();
		mostrador = new Mostrador(icon);
		
	}
	
	public abstract void onRefresh();

	public Mostrador getMostrable() {
		return mostrador;
	}
	public CuerpoRigido getCuerpo(){
		return cuerpo;
	}
	public int getValor() {
		return valor;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int v) {
		vida=v;
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


	
	
	
	public abstract void serChocado(Entidad e);
	
	public abstract void chocar(Entidad e);
	
	public abstract void aceptar(Colisionador c);
}
