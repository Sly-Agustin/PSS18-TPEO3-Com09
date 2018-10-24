package Entidades;


import javax.swing.Icon;

import Colisionador.*;
import IA.IABalaEnemigo;
import IA.IABalaPlayer;
//import InterfazGrafica.Mostrador;
//import TiposDeDatos.Coords;
import TiposDeDatos.CuerpoRigido;

public class BalazoPlayer extends Balazo{
//Concrete Element - Visitable


	protected float velocidad = 5f;
	protected int dano; 
	protected CDisparoPlayer col;

	
	public BalazoPlayer(Icon icon) {
		super(icon);
		ia = new IABalaPlayer();
		dano=30;
		vida = 200;
		col = new CDisparoPlayer(dano);
	}

	public void onRefresh() {
		cuerpo.mover(ia.ADondeVoy(this).multK(velocidad));
		vida--;
	}

	public int getDano() {
		return dano;
	}
		
	public void aceptar(Colisionador c) {
		c.afectarDisparo(this);
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
