package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public abstract class CalculadoraTarifas {
	public double IMPUESTO = 0.28;

	public CalculadoraTarifas(double iMPUESTO) {
		super();
		IMPUESTO = iMPUESTO;
	}

	public double getIMPUESTO() {
		return IMPUESTO;
	}

	public void setIMPUESTO(double iMPUESTO) {
		IMPUESTO = iMPUESTO;
	}
	
	 public int calcularTarifa(Vuelo vuelo, Cliente cliente) {
		return 0;
	 
	 }
	
	 public abstract int calcularCostoBase(Vuelo vuelo, Cliente cliente);
	 public abstract double calcularPorcentajeDescuento(Cliente cliente);
	 public int calcularDistanciaVuelo(Ruta ruta) {
		return 0;
	 
	 }
	 public int calcularValorImpuestos(int costoBase) {
		return costoBase;
		 
	 }
}
