package IA;

import Datos.GameData;
import Entidades.*;
import TiposDeDatos.Coords;

public class FollowIA implements IA{
	
	private Player p = Player.getInstance();
	
	public Coords ADondeVoy(Entidad e) {
		float enemyPosX = e.getCuerpo().getPosicion().getX();
		float enemyPosY = e.getCuerpo().getPosicion().getY();
		float playerPosX = p.getCuerpo().getPosicion().getX();
		
		if(enemyPosX < playerPosX) {
			return new Coords(1,1);
		}
		if(enemyPosX > playerPosX) {
			return new Coords(-1,1);
		}
		
		if(enemyPosY >= GameData.WindowSize.getHeight()-64){
			e.getCuerpo().setPosicion(new Coords(enemyPosX,0));;
		} 
		
		return Coords.abajo;
	}

}
