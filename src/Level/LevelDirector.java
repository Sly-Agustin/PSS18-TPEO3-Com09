package Level;

import InterfazGrafica.Pantalla;

public class LevelDirector implements Runnable{
	
	protected AbsNivel nivel;
	
	private static LevelDirector instan;
	public static LevelDirector instancia(){
		if(instan==null){
			instan = new LevelDirector();
		}
		return instan;
	}
	
	public AbsNivel currentLevel(){
		return nivel;
	}
	
	private LevelDirector() {
		nivel = new CrearNivel1(5,5,5,3); //enemigos, obstaculos, enemigos kamikaze			
	}
	
	public void inicializarNivel(){
		nivel.crear();
		nivel.iniciar();
		nivel.agregarTodo();
	}

//	public void iniciarMotor() {
//		
//		long time = System.nanoTime();
//		long time2 = System.nanoTime();
//		long tiempoDeFrame = 1_000_000_000L/60;
//		while(true){
//			time = System.nanoTime(); 
//			nivel.refrescarTodo();
//			time2 = System.nanoTime();
//			esperar(tiempoDeFrame-(time2-time));
//			Pantalla.getInstance().refresh();
//		}
//		
//	}

	private void esperar(long l) {
		try{
			if(l>0)
			Thread.sleep(l/1000000);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en el sleep");
		}
		
	}

	
	public void run() {
		long time = System.nanoTime();
		long time2 = System.nanoTime();
		long tiempoDeFrame = 1_000_000_000L/60;
		while(true){
			time = System.nanoTime(); 
			nivel.refrescarTodo();
			time2 = System.nanoTime();
			esperar(tiempoDeFrame-(time2-time));
			Pantalla.getInstance().refresh();
		}
		
	}


}
