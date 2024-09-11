package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.List;

import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public class ClienteNatural extends Cliente {
	public static final String NATURAL = "Natural";
	private String nombre;
	private List<Tiquete>aux;
	
	

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

    public void auxiliar(Tiquete tiquete) {
    	this.aux.add(tiquete);
    }
    
    @Override
	public String getIdentificador() {
		return aux.get(aux.size()-1).getCodigo();
	}

	@Override
	public String getTipoCliente() {
		return NATURAL;
	}

		
	}



