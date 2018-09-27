package Entidades;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Animation.Pictures;
import Datos.IconsManager;
import Entrada.Discreta;
import Level.AbsNivel;
import Level.LevelDirector;
import TiposDeDatos.Coords;

public class Player extends Entidad {
	
	private static Icon playerIcon = new ImageIcon(Pictures.player);
	private static Player inst;
	private int puntaje;
	
	public static Player getInstance()
	{
		inst = inst != null? inst : new Player(playerIcon);
		return inst;
	}
	private Discreta disparoControl;
	
	protected Player(Icon icon) {
		super(icon);
		puntaje = 0;
		ia = new PseudoIA();
		cuerpo.setVelocidadMaxima(3);
		disparoControl = new Discreta(this::disparar, Discreta.espacio);
	}
	
	private void disparar() {
		
		Balazo b = new Balazo(IconsManager.balazo);
		b.cuerpo.setPosicion(cuerpo.getPosicion().sumar(new Coords(playerIcon.getIconWidth()/2- b.getMostrable().getIcon().getIconWidth()/2,-40)));
		AbsNivel n = LevelDirector.instancia().currentLevel();
		n.addEntity(b);
	}
	
	public void onRefresh() {
		cuerpo.mover(ia.ADondeVoy(this));		
	}
	
	public void sumarPuntaje(Entidad e) {
		puntaje+=e.getValor();
		System.out.println(puntaje);
	}
	
	public int getPuntaje() {
		return puntaje;
	}


}
