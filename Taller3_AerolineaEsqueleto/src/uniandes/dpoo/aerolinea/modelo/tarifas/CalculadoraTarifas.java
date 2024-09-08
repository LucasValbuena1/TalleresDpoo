package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public abstract class CalculadoraTarifas {
	public double IMPUESTO = 0.28;

	public CalculadoraTarifas(double iMPUESTO) {
		IMPUESTO = iMPUESTO;
	}

	public double getIMPUESTO() {
		return IMPUESTO;
	}

	public void setIMPUESTO(double iMPUESTO) {
		IMPUESTO = iMPUESTO;
	}
	
	 public int calcularTarifa(Vuelo vuelo, Cliente cliente) {
		 int costoBase = calcularCostoBase(vuelo, cliente);
	     double descuento = calcularPorcentajeDescuento(cliente);
	     double costoConDescuento = costoBase * (1 - descuento);
	     int impuestos = calcularValorImpuestos((int) costoConDescuento);
	     return (int) (costoConDescuento + impuestos);
	 
	 }
	
	 protected abstract int calcularCostoBase(Vuelo vuelo, Cliente cliente);
	 protected abstract double calcularPorcentajeDescuento(Cliente cliente);
	 protected int calcularDistanciaVuelo(Ruta ruta) {
		 Aeropuerto origen = ruta.getOrigen();
		 Aeropuerto destino = ruta.getDestino();
		 int distancia = Aeropuerto.calcularDistancia(origen, destino);
		return distancia;
	 
	 }
	 protected int calcularValorImpuestos(int costoBase) {
		return (int) (costoBase *IMPUESTO);
		 
	 }
}
