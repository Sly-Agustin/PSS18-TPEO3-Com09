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
			enemies.add(enem);
			Coords c = new Coords(ancho*i/(cantEnems+1),100);
			enem.getCuerpo().setPosicion(c);
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
