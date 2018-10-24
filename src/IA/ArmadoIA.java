package IA;

import java.util.Random;

import Datos.GameData;
import Entidades.Entidad;
import TiposDeDatos.Coords;

public class ArmadoIA implements IA{
	
	private static int modu = 60;
	private int i=1;
	private int k =1;

	public Coords ADondeVoy(Entidad e) {

		int x = (int) e.getCuerpo().getPosicion().getX();
		if(x >= GameData.WindowSize.getWidth()-40){
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
		
		int numeroAleatorio= (int) (Math.random()*50+1);
		if(numeroAleatorio==5)
			e.disparar();
		return Coords.izquierda.multK(k*e.getCuerpo().getVelocidadMaxima());
	}
	


}
