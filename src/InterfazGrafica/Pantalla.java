package InterfazGrafica;

import java.awt.event.KeyListener;

public abstract class Pantalla {

	protected abstract void inicializar();

	public  abstract void addMostrable(Mostrador mostrable);
	
	public abstract void removeMostrable(Mostrador mostrable) ;
	
	public abstract void addTeclado(KeyListener kl);

	public abstract void refresh();
	
}
