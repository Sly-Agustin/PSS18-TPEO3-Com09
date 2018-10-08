package IA;

import Datos.GameData;
import Entidades.Entidad;
import Entrada.Teclado;
import TiposDeDatos.Coords;

public class PseudoIA  implements IA{

	private Teclado teclado = new Teclado();


	public Coords ADondeVoy(Entidad e) {

		int x = (int) e.getCuerpo().getPosicion().getX();
		if(x >= GameData.WindowSize.getWidth()-e.getMostrable().getIcon().getIconWidth()*2){
			return Coords.izquierda;
		}
		if(x <= e.getMostrable().getIcon().getIconWidth()*2){
			return Coords.derecha;
		}
		if(teclado.left()){
			return Coords.izquierda.multK(1f*e.getCuerpo().getVelocidadMaxima());
		}
		if(teclado.right()){
			return Coords.derecha.multK(1f*e.getCuerpo().getVelocidadMaxima());
		}

		return Coords.ORIGEN;
	}


}
