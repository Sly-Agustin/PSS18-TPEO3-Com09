package Level;

import java.util.*;
import java.util.Collection;
import java.util.concurrent.LinkedBlockingQueue;

import Entidades.*;
import InterfazGrafica.Pantalla;

public abstract class AbsNivel {
	
	protected Pantalla pantalla;
	protected Player player;
	protected Collection<Enemigo> enemies;
	protected Collection<Entidad> elresto;
	private Queue<Enemigo> toRemoveEnem;
	private Queue<Entidad> toRemoveEnt;
	
	
	public abstract void crear();
	public abstract void iniciar();
	public abstract boolean gane();
	public abstract boolean limpiar();
	
	
	protected AbsNivel()
	{
		enemies = new ArrayList<>();
		elresto = new LinkedList<>();

		player = Player.getInstance();
		pantalla = Pantalla.getInstance();
		
		toRemoveEnem = new LinkedBlockingQueue<>();
		toRemoveEnt = new LinkedBlockingQueue<>();
		
	}
	
	
	
	public void agregarTodo() {
		pantalla.addMostrable(player.getMostrable());
		enemies.forEach(e -> pantalla.addMostrable(e.getMostrable()));
		refrescarTodo();
	}

	public void refrescarTodo() {
		player.refresh();
		enemies.forEach(e->e.refresh());	
		elresto.forEach(e->e.refresh());	
		
		while(!toRemoveEnem.isEmpty()){
			
			
			//desencolar y quitar de enemigo
			//hacer lo mismo con entidad
		}
		
	}	
	
	public void addEntity(Entidad e) {
		elresto.add(e);
	}
	
	public void removeEntity(Entidad e) {
		elresto.remove(e);
	}
	
	
}
