package Entidades;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

import Level.LevelDirector;
public class ElConocedor implements Refrescable
{
	
	private static ElConocedor instance;
	public static ElConocedor instancia() {
		if(instance==null) {
			instance = new ElConocedor();
		}
		return instance;
	}
	
	
	private Collection<Entidad> entidades;
	private Queue<Entidad> removeQueue; //TODO HACEOTRO PARA ADD
	
	
	private ElConocedor() {
		entidades = new HashSet<>();
		removeQueue = new LinkedBlockingDeque<>();
	}	
	
	public void add(Entidad entidad) {
		entidades.add(entidad);
	}
	
	public void refresh()
	{		
		
		for(Entidad e : entidades) {
			
			if(e.getVida()<=0) {
				removeQueue.add(e);
				LevelDirector.instancia().currentLevel().removeEntity(e);
			}
			
			
			for(Entidad e1:entidades) {
				if(e!=e1 && e.getCuerpo().CollidesWith(e1.getCuerpo())) {
					e.colisionasteCon(e1);
				}
			}
		}
		while(!removeQueue.isEmpty()) {
			entidades.remove(removeQueue.remove());
		}
	}
	
	
	
}
