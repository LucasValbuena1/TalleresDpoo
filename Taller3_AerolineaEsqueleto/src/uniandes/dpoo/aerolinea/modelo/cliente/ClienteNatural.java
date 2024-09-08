package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.List;

import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public class ClienteNatural extends Cliente {
	public static final String NATURAL = "Natural";
	private String nombre;
	
	

	public ClienteNatural(List<Tiquete> tiquetesSinUsar, List<Tiquete> tiquetesUsados, String nombre) {
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
		return null;
	}

	@Override
	public String getTipoCliente() {
		return NATURAL;
	}

		
	}



