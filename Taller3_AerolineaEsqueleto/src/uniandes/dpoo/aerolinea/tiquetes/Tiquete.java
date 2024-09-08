package uniandes.dpoo.aerolinea.tiquetes;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class Tiquete {
	private String codigo;
	private int tarifa;
	private boolean usado;
	private Vuelo vuelo;
    private Cliente clienteComprador;


	public Tiquete(String codigo,Vuelo vuelo,Cliente clienteComprador, int tarifa  ) {

		this.codigo = codigo;
		this.tarifa = tarifa;
		this.vuelo = vuelo;
		this.clienteComprador = clienteComprador;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getTarifa() {
		return tarifa;
	}

	public void setTarifa(int tarifa) {
		this.tarifa = tarifa;
	}
	
	
	
	

	 
    public void marcarComoUsado() {
        this.usado = true; 
    }

    
    public boolean esUsado() {
        return usado; 
    }

    
    public void setUsado(boolean usado) {
        this.usado = usado;
    }

	
	

	public Cliente getCliente() {
		return clienteComprador;
	}

	public void setCliente(Cliente clienteComprador) {
		this.clienteComprador = clienteComprador;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}


	
	



	
}
