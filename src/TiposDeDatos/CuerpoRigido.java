package TiposDeDatos;

public class CuerpoRigido 
{
	
	private Coords posicion;
	private float velocidadMaxima;
	private float aceleracion;
	
	public CuerpoRigido()
	{
		setPosicion(Coords.ORIGEN);
		setVelocidadMaxima(1);
		setAceleracion(1);
	}

	public float getAceleracion() {
		return aceleracion;
	}

	public void setAceleracion(float aceleracion) {
		this.aceleracion = aceleracion;
	}

	public float getVelocidadMaxima() {
		return velocidadMaxima;
	}

	public void setVelocidadMaxima(float velocidadMaxima) {
		this.velocidadMaxima = velocidadMaxima;
	}

	public Coords getPosicion() {
		return posicion;
	}

	
	public void setPosicion(Coords posicion) {
		this.posicion = posicion;
	}
	
	public void mover(Coords direccion){
		posicion = posicion.sumar(direccion);
	}

}
