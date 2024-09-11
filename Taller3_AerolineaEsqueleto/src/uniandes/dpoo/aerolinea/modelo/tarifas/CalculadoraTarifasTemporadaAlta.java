package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class CalculadoraTarifasTemporadaAlta extends CalculadoraTarifas{
	
	
	protected final int COSTO_POR_KM = 1000;
	
	public CalculadoraTarifasTemporadaAlta() {
		
	}
	
	
	
	@Override
	protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		Vuelo miVuelo = vuelo;
		Ruta ruta = miVuelo.getRuta();
		Aeropuerto aeropuertoOrigen = ruta.getOrigen();
	    Aeropuerto aeropuertoDestino = ruta.getDestino();
		int distancia = Aeropuerto.calcularDistancia(aeropuertoOrigen, aeropuertoDestino);
		return distancia * COSTO_POR_KM;
	}
	@Override
	protected double calcularPorcentajeDescuento(Cliente cliente) {
		
		return 0;
	}

	
}
