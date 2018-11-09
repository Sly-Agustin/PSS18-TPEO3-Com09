package Entidades;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Animation.Pictures;
import Colisionador.CEnemigoArmado;
import Colisionador.CEnemigoKami;
import Colisionador.Colisionador;
import Datos.GameData;
import Datos.IconsManager;
import Entrada.Discreta;
import IA.ArmadoIA;
import IA.DummyIA;
import IA.FollowIA;
import IA.KamiIA2;
import Level.AbsNivel;
import Level.LevelDirector;
import TiposDeDatos.Coords;


public class EnemigoArmado extends Enemigo{
//Visitable

public static Icon armadoIcon = new ImageIcon(Pictures.naveArmada);
	
	private float velocidad = 2f;
	private boolean cambieDeIA = false;
	protected int dano;
	protected CEnemigoArmado col;

	
	public EnemigoArmado(Icon icon) {
		super(icon);
		ia= new ArmadoIA();
		valor=15;
		dano=1000;
		vida = 200;
		col = new CEnemigoArmado(dano);
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
		c.afectarEnemigoArmado(this);
	}

	public void disparar() {
		Balazo b = new BalazoEnemigo(IconsManager.balazoEnemigo);
		b.cuerpo.setPosicion(cuerpo.getPosicion().sumar(new Coords(armadoIcon.getIconWidth()/2- b.getMostrable().getIcon().getIconWidth()/2,40)));
		AbsNivel n = LevelDirector.instancia().currentLevel();
		n.addEntity(b);
		ElConocedor.instancia().add(b);
	}
	
	
	public void colisionasteCon(Entidad another) {
		another.aceptar(col);	
	}
	
	public void setVida(int v) {
		vida=v;
	}

}

	

