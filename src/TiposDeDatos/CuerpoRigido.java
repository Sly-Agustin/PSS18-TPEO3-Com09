package TiposDeDatos;

import java.awt.Rectangle;

public class CuerpoRigido extends Rectangle {
	
	private Coords posicion;
	private float velocidadMaxima;
	private float aceleracion;
	
	public CuerpoRigido(){
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

	
	
	// ESTE METODO NO LO REDEFINO PORQUE CUERPO RIGIDO EXTIENDE A RECTANGLE
//	public boolean intersects(CuerpoRigido cr) {
//		boolean bool = false;
//		int ancho = cr.width;
//		int alto = cr.height;
//		
//		if(this.getPosicion().equals(cr.getPosicion())){
//			bool=true;
//		}
//		return bool;
//	}
	
}
