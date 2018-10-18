package Entidades;


import javax.swing.Icon;

import Colisionador.*;
import IA.IA;
import IA.IABalaEnemigo;
import IA.IABalaPlayer;
//import InterfazGrafica.Mostrador;
//import TiposDeDatos.Coords;
import TiposDeDatos.CuerpoRigido;

public abstract class Balazo extends Entidad{


	protected float velocidad;
	protected int dano;
	protected IA ia;
	
	
	public Balazo(Icon icon) {
		super(icon);
	}

	public abstract void onRefresh();

	public abstract int getDano();
		
	public abstract void aceptar(Colisionador c);

	@Override
	public abstract void colisionasteCon(Entidad another) ;

	@Override
	public abstract void disparar();

}
