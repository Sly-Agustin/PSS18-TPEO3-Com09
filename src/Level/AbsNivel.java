package Level;

import java.util.*;
import java.util.Collection;
import java.util.concurrent.LinkedBlockingQueue;

import Entidades.*;
import Entrada.Discreta;
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
	
	private Discreta eliminaEnemigosConEnter;
	
	
	
	protected AbsNivel()
	{
		enemies = new ArrayList<>();
		elresto = new LinkedList<>();

		player = Player.getInstance();
		pantalla = Pantalla.getInstance();
		
		toRemoveEnem = new LinkedBlockingQueue<>();
		toRemoveEnt = new LinkedBlockingQueue<>();
		
		eliminaEnemigosConEnter = new Discreta(this::eliminaEnemies, Discreta.enter);
	}
	
	private void eliminaEnemies()
	{
		toRemoveEnem.addAll(enemies);
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
			Enemigo e = toRemoveEnem.remove();
			enemies.remove(e);
			Pantalla.getInstance().removeMostrable(e.getMostrable());
		}
		
	}	
	
	public void addEntity(Entidad e) {
		elresto.add(e);
		Pantalla.getInstance().addMostrable(e.getMostrable());
	}
	
	public void removeEntity(Entidad e) {
		elresto.remove(e);		
		Pantalla.getInstance().removeMostrable(e.getMostrable()); 
	}
	
	
}
