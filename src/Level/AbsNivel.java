package Level;

import java.util.*;
import java.util.Collection;
import java.util.concurrent.LinkedBlockingQueue;

import Colisionador.*;
import Entidades.*;
import Entrada.Discreta;
import InterfazGrafica.Pantalla;

public abstract class AbsNivel {//implementar runnable
	
	protected Pantalla pantalla;
	
	protected Player player;
	protected Collection<Entidad> demasEntidades;
	
	private Queue<Entidad> toRemoveEnt;
	
	private Discreta eliminaEnemigosConEnter;
	
	//--------------------------------------------------------- METODOS
	
	public abstract void crear();
	public abstract void iniciar();
	public abstract boolean gane();
	public abstract boolean limpiar();
	
	
	protected AbsNivel(){
		demasEntidades = new LinkedList<>();

		player = Player.getInstance();
		pantalla = Pantalla.getInstance();
		
		toRemoveEnt = new LinkedBlockingQueue<>();
		
		eliminaEnemigosConEnter = new Discreta(this::eliminaEnemies, Discreta.enter);	
	}
	
	private void eliminaEnemies(){
		toRemoveEnt.addAll(demasEntidades);
	}
	
	
	public void agregarTodo() {
		pantalla.addMostrable(player.getMostrable());
		//enemies.forEach(e -> pantalla.addMostrable(e.getMostrable()));
		//enemiesK.forEach(e->pantalla.addMostrable(e.getMostrable()));
		//obstacles.forEach(e -> pantalla.addMostrable(e.getMostrable()));
		demasEntidades.forEach(e -> pantalla.addMostrable(e.getMostrable()));		
		demasEntidades.forEach(ElConocedor.instancia()::add);
		ElConocedor.instancia().add(player);		
		
		refrescarTodo();
	}

	public void refrescarTodo() {
		player.refresh();
		demasEntidades.forEach(e->e.refresh());	
		ElConocedor.instancia().refresh();
		
		while(!toRemoveEnt.isEmpty()){
			Entidad e = toRemoveEnt.remove();
			player.sumarPuntaje(e);
			demasEntidades.remove(e);
			Pantalla.getInstance().removeMostrable(e.getMostrable());
		}
	}	
	
	
	
	public final void addEntity(Entidad e) {
		demasEntidades.add(e);
		Pantalla.getInstance().addMostrable(e.getMostrable());
	}
	
	public final void removeEntity(Entidad e) {
		demasEntidades.remove(e);		
		Pantalla.getInstance().removeMostrable(e.getMostrable()); 
	}
	
	
}
