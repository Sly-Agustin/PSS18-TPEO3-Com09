package Level;

import Datos.GameData;
import Entidades.Enemigo;
import Entidades.Obstaculo;
import Entrada.Discreta;
import TiposDeDatos.Coords;

public class CrearNivel1 extends AbsNivel {

	private int cantEnems;
	private int cantObs;

	public CrearNivel1(int cantidadDeEnemigos, int cantidadDeObs) {
		cantEnems = cantidadDeEnemigos;
		cantObs = cantidadDeObs;
	}

	public void crear() {
		int ancho = GameData.WindowSize.width;
		for(int i=1; i<=cantEnems ; i++) {
			Enemigo enem = new Enemigo(Enemigo.ic1);
			enemies.add(enem);
			Coords c = new Coords(ancho*i/(cantEnems+1),100);
			enem.getCuerpo().setPosicion(c);
		}
		for(int i=1; i<=cantObs; i++) {
			Obstaculo obs = new Obstaculo(Obstaculo.obs);
			obstacles.add(obs);
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
