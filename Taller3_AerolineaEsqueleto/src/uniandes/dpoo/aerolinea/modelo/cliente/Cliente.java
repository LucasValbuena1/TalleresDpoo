package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.ArrayList;
import java.util.List;

import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public abstract class Cliente {
	private List<Tiquete> tiquetesSinUsar;
    private List<Tiquete> tiquetesUsados;

    
	public Cliente() {
		this.tiquetesSinUsar = new ArrayList<>();
		this.tiquetesUsados = new ArrayList<>();
	}
	
	
	
	public abstract String getIdentificador();
	public abstract String getTipoCliente();
	
	public  void agregarTiquete(Tiquete tiquete) {
	}
	public  int calcularValorTotalTiquetes() {
		return 0;
	}
	public  void usarTiquetes(Vuelo vuelo) {
	}
	
	public List<Tiquete> getTiquetesSinUsar() {
		return tiquetesSinUsar;
	}
	public void setTiquetesSinUsar(List<Tiquete> tiquetesSinUsar) {
		this.tiquetesSinUsar = tiquetesSinUsar;
	}
	public List<Tiquete> getTiquetesUsados() {
		return tiquetesUsados;
	}
	public void setTiquetesUsados(List<Tiquete> tiquetesUsados) {
		this.tiquetesUsados = tiquetesUsados;
	}
}



