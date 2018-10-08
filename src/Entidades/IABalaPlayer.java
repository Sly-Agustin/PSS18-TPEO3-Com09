package Entidades;

import IA.IA;
import TiposDeDatos.Coords;

public class IABalaPlayer implements IA{

	public Coords ADondeVoy(Entidad e) 
	{
		return new Coords(0,-1);		
	}

}
