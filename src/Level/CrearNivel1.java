package Level;

import Datos.GameData;
import Entidades.Enemigo;
import Entrada.Discreta;
import TiposDeDatos.Coords;

public class CrearNivel1 extends AbsNivel {

	
	
	private int cantEnems;

	public CrearNivel1(int cantidadDeEnemigos) {
		cantEnems = cantidadDeEnemigos;
		
	}


	
	
	public void crear() {
		int ancho = GameData.WindowSize.width;
		for(int i=1; i<=cantEnems ; i++) {
			Enemigo enem = new Enemigo(Enemigo.ic1);
			Enemigo enem1 = new Enemigo(Enemigo.ic2);
			enemies.add(enem);
			enemies.add(enem1);
			Coords c = new Coords(ancho*i/(cantEnems+1),100);
			Coords c1 = new Coords(ancho*i/(cantEnems+1),200);
			enem.getCuerpo().setPosicion(c);
			enem1.getCuerpo().setPosicion(c1);
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
