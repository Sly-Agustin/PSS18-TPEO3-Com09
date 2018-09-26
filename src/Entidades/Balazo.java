package Entidades;

import javax.swing.Icon;

public class Balazo extends Entidad{
	
	
	private float velocidad = 4f;
	
	protected Balazo(Icon icon) {
		super(icon);
		ia = new IABalaPlayer();
	}

	
	public void onRefresh() {
		cuerpo.mover(ia.ADondeVoy(this).multK(velocidad));
	}

}
