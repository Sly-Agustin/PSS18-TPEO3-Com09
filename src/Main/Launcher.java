package Main;

import InterfazGrafica.PantallaJuego;
import Level.LevelDirector;

public class Launcher {

	public static void main(String[] x) {
		PantallaJuego.getInstance();
		LevelDirector director = LevelDirector.instancia();
		director.inicializarNivel();
//		if(director.currentLevel().getEntidades().isEmpty())
//			director.cambiarNivel();
		(new Thread(director)).start();
	}
}
