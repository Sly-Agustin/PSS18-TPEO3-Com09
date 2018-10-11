package Entidades;


import javax.swing.Icon;

import Colisionador.*;
import IA.IABalaPlayer;
//import InterfazGrafica.Mostrador;
//import TiposDeDatos.Coords;
import TiposDeDatos.CuerpoRigido;

public class Balazo extends Entidad{
//Concrete Element

	private float velocidad = 4f;
	protected int dano; 
	protected CDisparo col;


	protected Balazo(Icon icon) {
		super(icon);
		ia = new IABalaPlayer();
		dano=30;
		vida = 200;
		col = new CDisparo(dano);
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

}
