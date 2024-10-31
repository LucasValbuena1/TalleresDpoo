package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;

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
        producto1 = new ProductoMenu("papas grandes", 6900);
        producto2 = new ProductoMenu("gaseosa", 5000);
        producto3 = new ProductoMenu("todoterreno", 25000);
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
	    assertTrue(pedido1.getProductos().contains(nuevoProducto), "El producto no fue agregado correctamente.");
	}
	
	@Test
	void testGetPrecioNetoPedido() {
	    int precioNeto = 36900;
	    assertEquals(precioNeto, pedido1.getPrecioTotalPedido() - (int) (precioNeto * IVA), "El precio neto del pedido no es el esperado.");
	}

	@Test
	void testGetPrecioTotalPedido() {
	    int precioNeto = 36900;
	    int precioConIVA = precioNeto + (int) (precioNeto * IVA);
	    assertEquals(precioConIVA, pedido1.getPrecioTotalPedido(), "El precio total del pedido no es el esperado.");
	}


	@Test
	void testGenerarTextoFactura() {
	    String resultado = pedido1.generarTextoFactura();

	    StringBuffer sb = new StringBuffer();
	    sb.append("Cliente: Lucas\n");
	    sb.append("Dirección: AC 53 #46-56\n");
	    sb.append("----------------\n");
	    sb.append(producto1.generarTextoFactura());
	    sb.append(producto2.generarTextoFactura());
	    sb.append(producto3.generarTextoFactura());
	    sb.append("----------------\n");
	    sb.append("Precio Neto:  ").append(36900).append("\n");
	    sb.append("IVA:          ").append((int) (36900 * IVA)).append("\n");
	    sb.append("Precio Total: ").append(pedido1.getPrecioTotalPedido()).append("\n");

	    assertEquals(sb.toString(), resultado, "El texto de la factura no es el mismo");
	}


    @Test
    void testGuardarFactura() {
        File archivo = new File("factura_test.txt");
        try {
            pedido1.guardarFactura(archivo);
            assertEquals(true, archivo.exists(), "El archivo de la factura no se generó correctamente.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            archivo.delete(); 
        }
    }
	


}
