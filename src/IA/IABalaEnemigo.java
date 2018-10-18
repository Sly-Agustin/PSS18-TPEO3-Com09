package IA;

import Entidades.Entidad;
import TiposDeDatos.Coords;

public class IABalaEnemigo implements IA{

	public Coords ADondeVoy(Entidad e) 
	{
		return new Coords(0,1);		
	}

	
}
