package Entidades;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Animation.Pictures;
import Colisionador.CJugador;
import Colisionador.Colisionador;
import Datos.IconsManager;
import Entrada.Discreta;
import IA.PseudoIA;
import Level.AbsNivel;
import Level.LevelDirector;
import TiposDeDatos.Coords;

public class Player extends Entidad {
	//Visitable


	private static Icon playerIcon = new ImageIcon(Pictures.player);
	private static Player inst;
	private int puntaje;

	public static Player getInstance(){
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
		vida = 100;
		col  = new CJugador();
	}

	public void disparar() {
		Balazo b = new BalazoPlayer(IconsManager.balazo);
		b.cuerpo.setPosicion(cuerpo.getPosicion().sumar(new Coords(playerIcon.getIconWidth()/2- b.getMostrable().getIcon().getIconWidth()/2,-40)));
		AbsNivel n = LevelDirector.instancia().currentLevel();
		n.addEntity(b);
		ElConocedor.instancia().add(b);
	}

	public void onRefresh() {
		cuerpo.mover(ia.ADondeVoy(this));
		this.getPuntaje();
	}

	public void sumarPuntaje(Entidad e) {
		puntaje+=e.getValor();
		System.out.println(puntaje);
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void aceptar(Colisionador c) {
		c.afectarJugador(this);
	}

	public void colisionasteCon(Entidad another) {
		another.aceptar(col);		
	}
	/*	
	public void manejarVida() {
		if(puntaje >83.4) 
			acomodar(IconsManager.v1);
		else 
			if(puntaje > 66.8)
				acomodar(IconsManager.v2);
			else 
				if(puntaje >50.2)
					acomodar(IconsManager.v3);
				else
					if(puntaje > 33.6)
						acomodar(IconsManager.v4);
					else
						if(puntaje > 17)
							acomodar(IconsManager.v5);
						else acomodar(IconsManager.v6);
	}

	private void acomodar(Icon icon) {
		Mostrador vida= new Mostrador(icon);
		vida.setBounds(700, 500, 100, 100);
		Pantalla.getInstance().addMostrable(vida);
		Pantalla.getInstance().refresh();
	}*/

}
