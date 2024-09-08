package uniandes.dpoo.aerolinea.modelo;



public class Avion {
	private int nombre;
	private int capacidadAvion;
	
	
	//Constructor
	public Avion(int nombre, int capacidadAvion) {
		this.setNombre(nombre);
		this.setCapacidadAvion(capacidadAvion);
	}


	public int getNombre() {
		return nombre;
	}


	public void setNombre(int nombre) {
		this.nombre = nombre;
	}


	public int getCapacidadAvion() {
		return capacidadAvion;
	}


	public void setCapacidadAvion(int capacidadAvion) {
		this.capacidadAvion = capacidadAvion;
	}
}


