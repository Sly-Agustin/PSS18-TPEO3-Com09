package IA;

import java.util.Random;

import Datos.GameData;
import Entidades.Entidad;
import TiposDeDatos.Coords;

public class ObsIA implements IA {

	private static int modu = 40;
	private int i=1;
	private int k=1;

	public Coords ADondeVoy(Entidad e) {
		int x = (int) e.getCuerpo().getPosicion().getX();
		if(x >= GameData.WindowSize.getWidth()-90){
			return Coords.izquierda;
		}
		if(x <= 0){
			return Coords.derecha;
		}
		if(i >= modu || new Random().nextInt(modu*2) <3){
			k *= -1;	
			i=0;
		}
		i++;

		return Coords.derecha.multK(k*e.getCuerpo().getVelocidadMaxima()/2);
	}
}
