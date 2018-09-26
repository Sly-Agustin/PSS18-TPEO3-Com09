package Entidades;

import javax.swing.Icon;

public class Balazo extends Entidad{
	
	
	protected Balazo(Icon icon) {
		super(icon);
		ia = new IABalaPlayer();
	}

	
	public void onRefresh() {
		cuerpo.mover(ia.ADondeVoy(this));
	}

}
