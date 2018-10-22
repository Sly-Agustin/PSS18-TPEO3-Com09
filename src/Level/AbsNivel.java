package Level;

import java.util.*;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Animation.Pictures;
import Colisionador.*;
import Datos.IconsManager;
import Entidades.*;
import Entrada.Discreta;
import InterfazGrafica.Mostrador;
import InterfazGrafica.Pantalla;

public abstract class AbsNivel {//implementar runnable
	
	protected Pantalla pantalla;
	
	protected Player player;
	protected Collection<Entidad> demasEntidades;
	
	private Queue<Entidad> toRemoveEnt;
	private Queue<Entidad> toAddEnt;
	
	private Discreta eliminaEnemigosConEnter;
	
	//--------------------------------------------------------- METODOS
	
	public abstract void crear();
	public abstract void iniciar();
	public abstract boolean gane();
	public abstract boolean limpiar();
	
	
	protected AbsNivel(){
		demasEntidades = new ArrayList<>();

		player = Player.getInstance();
		pantalla = Pantalla.getInstance();
		
		toRemoveEnt = new LinkedBlockingQueue<>();
		toAddEnt= new LinkedBlockingQueue<>();
		
		eliminaEnemigosConEnter = new Discreta(this::eliminaEnemies, Discreta.enter);	
	
	}
	
	private void eliminaEnemies(){
		toRemoveEnt.addAll(demasEntidades);
	}
	
	
	public void agregarTodo() {
		pantalla.addMostrable(player.getMostrable());
		Mostrador vida= new Mostrador(IconsManager.v1);
		vida.setBounds(700, 500, 100, 100);
		pantalla.addMostrable(vida);
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
		
		while(!toAddEnt.isEmpty()){
			Entidad e = toAddEnt.remove();
			demasEntidades.add(e);
		}	
	}	
	
		
	public final void addEntity(Entidad e) {
		toAddEnt.add(e);
		Pantalla.getInstance().addMostrable(e.getMostrable());
	}
	
	public final void removeEntity(Entidad e) {
		toRemoveEnt.remove(e);		
		Pantalla.getInstance().removeMostrable(e.getMostrable()); 
	}
	
	
}
