package IA;

import java.util.Random;

import Datos.GameData;
import Entidades.Entidad;
import TiposDeDatos.Coords;

public class KamiIA1 implements IA {

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
		
		if(e.getCuerpo().getPosicion().getY()<0) {
			e.getCuerpo().setPosicion(new Coords(e.getCuerpo().getPosicion().getX(),0));
		}
		
		if(e.getCuerpo().getPosicion().getY()>600)
			e.getCuerpo().setPosicion(new Coords(e.getCuerpo().getPosicion().getX(),0));
		
		int numeroAleatorio= (int) (Math.random()*10+1);
		if(numeroAleatorio==5)
			caer(e);
		
		return Coords.arriba.multK(k*e.getCuerpo().getVelocidadMaxima());
	}	
	
	private void caer(Entidad e) {
		e.getCuerpo().setPosicion(e.getCuerpo().getPosicion().aumentarY(10));
	}
	

}

