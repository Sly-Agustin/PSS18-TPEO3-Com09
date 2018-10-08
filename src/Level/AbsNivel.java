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
	protected Collection<EnemigoKami> enemiesK;
	protected Collection<Obstaculo> obstacles;
	protected Collection<Entidad> demasEntidades;
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
		enemiesK = new ArrayList<>();
		obstacles = new ArrayList<>();
		demasEntidades = new LinkedList<>();

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
		enemiesK.forEach(e->pantalla.addMostrable(e.getMostrable()));
		obstacles.forEach(e -> pantalla.addMostrable(e.getMostrable()));
		refrescarTodo();
	}

	public void refrescarTodo() {
		player.refresh();
		enemies.forEach(e->e.refresh());
		enemiesK.forEach(e->e.refresh());
		obstacles.forEach(e->e.refresh());
		demasEntidades.forEach(e->e.refresh());	
		
		while(!toRemoveEnem.isEmpty()){
			Enemigo e = toRemoveEnem.remove();
			player.sumarPuntaje(e);
			enemies.remove(e);
			Pantalla.getInstance().removeMostrable(e.getMostrable());
		}
		
	}	
	
	public void addEntity(Entidad e) {
		demasEntidades.add(e);
		Pantalla.getInstance().addMostrable(e.getMostrable());
	}
	
	public void removeEntity(Entidad e) {
		demasEntidades.remove(e);		
		Pantalla.getInstance().removeMostrable(e.getMostrable()); 
	}
	
	
}
