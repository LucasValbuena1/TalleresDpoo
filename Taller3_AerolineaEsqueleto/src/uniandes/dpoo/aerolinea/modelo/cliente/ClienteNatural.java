package uniandes.dpoo.aerolinea.modelo.cliente;

import uniandes.dpoo.aerolinea.modelo.Aerolinea;

public class ClienteNatural extends Cliente {
	public static final String NATURAL = "Natural";
	private String nombre;
	
	

	public ClienteNatural(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String getIdentificador() {
		Cliente cliente = Aerolinea.getCliente();
		return cliente;
	}

	@Override
	public String getTipoCliente() {
		return NATURAL;
	}

		
	}



