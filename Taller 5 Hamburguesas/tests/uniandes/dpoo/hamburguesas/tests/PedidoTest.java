package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.Pedido;
import uniandes.dpoo.hamburguesas.mundo.Producto;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

public class PedidoTest {

	
	private static final double IVA = 0.19;
	private Pedido pedido1;
	private Producto producto1;
    private Producto producto2;
    private Producto producto3;
	
	@BeforeEach
    void setUp() throws Exception {
	 pedido1 = new Pedido("Lucas", "AC 53 #46-56");
	 ProductoMenu producto1 = new ProductoMenu("papas grandes", 6900);
	 ProductoMenu producto2 = new ProductoMenu("gaseosa", 5000);
	 ProductoMenu producto3 = new ProductoMenu("todoterreno", 25000);
	 pedido1.agregarProducto(producto1);
	 pedido1.agregarProducto(producto2);
	 pedido1.agregarProducto(producto3);
	
	 
		}
	
	@AfterEach
    void tearDown( ) throws Exception
    {
    }
	
	@Test
    void testGetNombreCliente() {
        assertEquals("Lucas", pedido1.getNombreCliente(), "El nombre del cliente no es el esperado.");
    }
			
	@Test
	void testGetIdPedido() {
	    int respuesta = pedido1.getIdPedido(); 
	    assertEquals(respuesta, pedido1.getIdPedido(), "El id del pedido no coincide.");
	}
	
	@Test
	void testAgregarProducto() {
	    ProductoMenu nuevoProducto = new ProductoMenu("corral queso", 16000);
	    pedido1.agregarProducto(nuevoProducto);
	    assertEquals(nuevoProducto, pedido1.getProductos(), "El producto no fue agregado correctamente.");
	}


	


}
