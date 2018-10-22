package Level;

import Datos.GameData;
import Entidades.Enemigo;
import Entidades.EnemigoArmado;
import Entidades.EnemigoKami;
import Entidades.Obstaculo;
import Entrada.Discreta;
import TiposDeDatos.Coords;

public class CrearNivel1 extends AbsNivel {

	private int cantEnems;
	private int cantEnemsK;
	private int cantObs;
	private int cantEnemsA;

	public CrearNivel1(int cantidadDeEnemigos, int cantidadDeEnemigosArmados, int cantidadDeObs, int cantidadDeEnemigosK) {
		cantEnems = cantidadDeEnemigos;
		cantEnemsK=cantidadDeEnemigos;
		cantObs = cantidadDeObs;
		cantEnemsA=cantidadDeEnemigosArmados;
	}

	public void crear() {
		int ancho = GameData.WindowSize.width;
		//ENEMIGOS 1
		for(int i=1; i<=cantEnems ; i++) {
			Enemigo enem = new Enemigo(Enemigo.ic1);
			demasEntidades.add(enem);
			Coords c = new Coords(ancho*i/(cantEnems+1),100);
			enem.getCuerpo().setPosicion(c);
		}
		//ENEMIGOS KAMI
		for(int i=1; i<=cantEnemsK;i++) {
			EnemigoKami enemK = new EnemigoKami(EnemigoKami.ic2);
			demasEntidades.add(enemK);
			Coords c = new Coords(ancho*i/(cantEnemsK+1),350);
			enemK.getCuerpo().setPosicion(c);
		}
		//ENEMIGOS ARMADOS
		for(int i=1; i<cantEnemsA; i++) {
			EnemigoArmado enemA= new EnemigoArmado(EnemigoArmado.armadoIcon);
			demasEntidades.add(enemA);
			Coords c= new Coords(ancho*i/(cantEnems+1),50);
			enemA.getCuerpo().setPosicion(c);
		}
		//OBSTACULOS
		for(int i=1; i<=cantObs; i++) {
			Obstaculo obs = new Obstaculo(Obstaculo.obs);
			demasEntidades.add(obs);
			Coords c = new Coords(ancho*i/(cantObs+1),200);
			obs.getCuerpo().setPosicion(c);
		}
		
		player.getCuerpo().setPosicion(new Coords(400,500));		
	}

	
	public void iniciar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean gane() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean limpiar() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void refrescarTodo() {
		super.refrescarTodo();
	}

}
