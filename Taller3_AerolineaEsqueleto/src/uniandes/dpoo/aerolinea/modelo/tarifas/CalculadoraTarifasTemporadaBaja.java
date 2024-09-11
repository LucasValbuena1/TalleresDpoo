package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteNatural;

public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas {
	protected final int COSTO_POR_KM_NATURAL = 600; 
    protected final int COSTO_POR_KM_CORPORATIVO = 900; 
    protected final double DESCUENTO_GRANDES = 0.20;
    protected final double DESCUENTO_MEDIANAS = 0.10;
    protected final double DESCUENTO_PEQ = 0.02;
	
	
	public CalculadoraTarifasTemporadaBaja() {
		
	}

	@Override
	protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		int costoPorKm = 0;
		 if (cliente instanceof ClienteNatural) {
	            costoPorKm = COSTO_POR_KM_NATURAL;
	        } 
		 else if (cliente instanceof ClienteCorporativo) 
		 {
	            costoPorKm = COSTO_POR_KM_CORPORATIVO;}
		 
		Ruta ruta = vuelo.getRuta();
		int distancia = calcularDistanciaVuelo(ruta);
		return costoPorKm * distancia;
	}

	@Override
	protected double calcularPorcentajeDescuento(Cliente cliente) {
		double descuento = 0.0;
		
		if (cliente instanceof ClienteCorporativo) {
			ClienteCorporativo clienteCorporativo = (ClienteCorporativo) cliente;
			int tamanoEmpresa = clienteCorporativo.getTamanoEmpresa();
            if (tamanoEmpresa==ClienteCorporativo.GRANDE) {
            	descuento = DESCUENTO_GRANDES;
            }else if (tamanoEmpresa==ClienteCorporativo.MEDIANA) {
            	descuento = DESCUENTO_MEDIANAS;
            }else if(tamanoEmpresa==ClienteCorporativo.PEQUENA) {
            	descuento = DESCUENTO_PEQ;
            }
       
}
		return descuento;
	}}
