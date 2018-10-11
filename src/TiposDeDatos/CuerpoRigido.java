package TiposDeDatos;


public class CuerpoRigido{
	
	private Coords posicion;
	private float velocidadMaxima;
	private float aceleracion;
	private CajaDeColisiones hitbox;
	
	public CuerpoRigido(float w, float h){
		
		setVelocidadMaxima(1);
		setAceleracion(1);
		hitbox = new CajaDeColisiones(new Coords(w,h));
		setPosicion(Coords.ORIGEN);
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
		hitbox.setSupIzq(posicion);
	}
	
	public void mover(Coords direccion){
		setPosicion(posicion.sumar(direccion));
	}

	public boolean CollidesWith(CuerpoRigido otro) {
		return hitbox.Solapa(otro.hitbox);
	}
	
	
	
	
}
