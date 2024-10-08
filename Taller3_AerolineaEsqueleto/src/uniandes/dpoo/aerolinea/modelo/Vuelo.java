package uniandes.dpoo.aerolinea.modelo;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import uniandes.dpoo.aerolinea.exceptions.VueloSobrevendidoException;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public class Vuelo {
	private String fecha;
	private Ruta ruta;
	private Avion avion;
	private Map<String, Tiquete> tiquetes = new HashMap<>();

	

	public Vuelo(String fecha, Ruta ruta, Avion avion, Map<String, Tiquete> tiquetes) {
		this.fecha = fecha;
		this.ruta = ruta;
		this.avion = avion;
		this.tiquetes = tiquetes;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Ruta getRuta() {
		return ruta;
	}

	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public Collection<Tiquete> getTiquetes() {
		return tiquetes.values();
	}

	public void setTiquetes(Map<String, Tiquete> tiquetes) {
		this.tiquetes = tiquetes;
	}
	
	public int venderTiquetes(Cliente cliente, CalculadoraTarifas calculadora, int cantidad) throws VueloSobrevendidoException {
		 if (tiquetes.size() + cantidad > avion.getCapacidadAvion()) {
	            throw new VueloSobrevendidoException(this);
	        }else {
	        	
	        	int tarifa = calculadora.calcularTarifa(this, cliente) * cantidad;
	        	for (int i = 0; i < cantidad; i++) {
	                Tiquete tiquete = new Tiquete(null, this, cliente, tarifa / cantidad);  
	                String codigoTiquete = tiquete.getCodigo();  
	                tiquetes.put(codigoTiquete, tiquete);
	            }
	            return tarifa;
	        }
	
	
}}

