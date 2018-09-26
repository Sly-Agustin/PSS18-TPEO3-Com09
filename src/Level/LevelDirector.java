package Level;

public class LevelDirector
{
	protected AbsNivel nivel;
	
	private static LevelDirector instan;
	public static LevelDirector instancia()
	{
		instan = instan == null ?  new LevelDirector() : instan;
		return instan;
	}
	
	public AbsNivel currentLevel()
	{
		return nivel;
	}
	
	private LevelDirector() {
		nivel = new CrearNivel1(5);
		inicializarNivel();
		iniciarMotor();
	}
	
	private void inicializarNivel()
	{
		nivel.crear();
		nivel.iniciar();
		nivel.agregarTodo();
	}

	private void iniciarMotor() {
		
		long time = System.nanoTime();
		long time2 = System.nanoTime();
		long tiempoDeFrame = 1_000_000_000L/60;
		while(true)
		{
			time = System.nanoTime(); 
			nivel.refrescarTodo();
			time2 = System.nanoTime();
			esperar(tiempoDeFrame-(time2-time));			
		}
		
	}

	private void esperar(long l) {
		try
		{
			if(l>0)
			Thread.sleep(l/1000000);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
	}


}
