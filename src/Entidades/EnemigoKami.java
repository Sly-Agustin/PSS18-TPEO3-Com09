package Entidades;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Animation.Pictures;
import Colisionador.CEnemigoKami;
import Colisionador.Colisionador;
import IA.FollowIA;
import IA.KamiIA2;
import TiposDeDatos.Coords;

public class EnemigoKami extends Enemigo{
//Visitable
	
	public static Icon ic2 = new ImageIcon(Pictures.enemigo2);
	private float velocidad = 2f;
	private boolean cambieDeIA = false;
	protected int dano;
	int i = 0;
	
	public EnemigoKami(Icon icon) {
		super(icon);
		ia = new KamiIA2();
		valor=15;
		dano=50;
		vida = 200;
		col = new CEnemigoKami(dano);
	}

	public void onRefresh() {
		cuerpo.mover(ia.ADondeVoy(this).multK(velocidad));
		if(getVida()<=50 && !cambieDeIA) {
			cambieDeIA = true;
			ia = new FollowIA();
		}
	}
	
	public int getDano() {
		return dano;
	}
	
	public void aceptar(Colisionador c) {
		c.afectarEnemigoKami(this);
	}
}