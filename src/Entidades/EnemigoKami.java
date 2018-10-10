package Entidades;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Animation.Pictures;
import IA.KamiIA1;
import IA.KamiIA2;

public class EnemigoKami extends Enemigo{

	private float velocidad = 2f;

	public static Icon ic2 = new ImageIcon(Pictures.enemigo2);
	
	public EnemigoKami(Icon icon) {
		super(icon);
		ia = new KamiIA2();
		valor=15;
	}

	
	public void onRefresh() {
		cuerpo.mover(ia.ADondeVoy(this).multK(velocidad)); //Se  mueve como un disparo
	}

}
