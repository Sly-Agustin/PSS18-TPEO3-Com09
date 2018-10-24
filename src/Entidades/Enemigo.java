package Entidades;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import Animation.Pictures;
import Colisionador.CEnemigo;
import Colisionador.CEnemigoArmado;
import Colisionador.Colisionador;
import IA.ArmadoIA;
import IA.DummyIA;
import IA.PseudoIA;

public class Enemigo extends Entidad {
//Concrete Element

	
	public static Icon ic1 = new ImageIcon(Pictures.enemigo1);

	
	public Enemigo(Icon icon) {
		super(icon);
		ia = new DummyIA();
		valor = 10;
		vida = 100;
		col = new CEnemigo();
	}

	
	public void onRefresh() {
		cuerpo.mover(ia.ADondeVoy(this));
	}
	
	public void setVida(int v) {
		vida=v;
	}

	public void aceptar(Colisionador c) {
		c.afectarEnemigo(this);
	}

	@Override
	public void colisionasteCon(Entidad another) {
		another.aceptar(col);	
	}


	@Override
	public void disparar() {
		
	}
	
}
