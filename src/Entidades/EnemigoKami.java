package Entidades;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Animation.Pictures;
import Colisionador.CEnemigoKami;
import Colisionador.Colisionador;
import IA.KamiIA2;

public class EnemigoKami extends Enemigo{
//Visitable
	
	public static Icon ic2 = new ImageIcon(Pictures.enemigo2);
	
	private float velocidad = 2f;
	protected int dano;
	protected CEnemigoKami col;
	
	public EnemigoKami(Icon icon) {
		super(icon);
		ia = new KamiIA2();
		valor=15;
		dano=1000;
		vida = 200;
		col = new CEnemigoKami(dano);
	}

	
	public void onRefresh() {
		cuerpo.mover(ia.ADondeVoy(this).multK(velocidad)); //Se  mueve como un disparo
	}
	
	public int getDano() {
		return dano;
	}
	
	public void aceptar(Colisionador c) {
		c.afectarEnemigoKami(this);
	}

	@Override
	public void colisionasteCon(Entidad another) {
		another.aceptar(col);	
	}


}
