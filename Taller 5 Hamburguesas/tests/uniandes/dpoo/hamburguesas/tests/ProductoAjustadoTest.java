package uniandes.dpoo.hamburguesas.tests;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.excepciones.IngredienteRepetidoException;
import uniandes.dpoo.hamburguesas.mundo.Ingrediente;
import uniandes.dpoo.hamburguesas.mundo.ProductoAjustado;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

public class ProductoAjustadoTest {

    private ProductoAjustado productoAjustado1;
    private ProductoMenu productoBase;

    @BeforeEach
    void setUp() throws Exception {
        productoBase = new ProductoMenu("corralita", 13000);
        productoAjustado1 = new ProductoAjustado(productoBase);
    }

    @AfterEach
    void tearDown() throws Exception {
        productoAjustado1 = null;
    }

    @Test
    void testGetNombre() {
        assertEquals("corralita", productoAjustado1.getNombre(), "El nombre del producto ajustado no es el esperado.");
    }

    @Test
    void testGetPrecio() {
        assertEquals(13000, productoAjustado1.getPrecio(), "El precio sin modificaciones no es el esperado.");
    }

    @Test
    void testAgregarIngrediente() {
        Ingrediente cebolla = new Ingrediente("cebolla", 1000);
        try {
			productoAjustado1.agregarIngrediente(cebolla);
		} catch (IngredienteRepetidoException e) {
			e.printStackTrace();
		}
        assertEquals(14000, productoAjustado1.getPrecio(), "El precio con un ingrediente agregado no es el esperado.");
    }

    @Test
    void testEliminarIngrediente() {
    	Ingrediente huevo = new Ingrediente("huevo", 2500);
    	try {
			productoAjustado1.agregarIngrediente(huevo);
		} catch (IngredienteRepetidoException e) {
			e.printStackTrace();
		}
        productoAjustado1.eliminarIngrediente(huevo);
        assertEquals(13000, productoAjustado1.getPrecio(), "El precio con un ingrediente quitado no es el esperado.");
    }
    
    
    @Test
    void testGenerarTextoFactura() {
        Ingrediente huevo = new Ingrediente("huevo", 2500);
        Ingrediente tomate = new Ingrediente("tomate", 1000);

        try {
            productoAjustado1.agregarIngrediente(huevo);
            productoAjustado1.agregarIngrediente(tomate);
        } catch (IngredienteRepetidoException e) {
            e.printStackTrace();
        }


        String resultado = productoAjustado1.generarTextoFactura();


        StringBuffer expected = new StringBuffer();
        expected.append(productoBase.getNombre());
        for (Ingrediente ing : productoAjustado1.getAgregados()) {
            expected.append("    +" + ing.getNombre());
            expected.append("                " + ing.getCostoAdicional());
        }
        
        for (Ingrediente ing : productoAjustado1.getEliminados()) {
            expected.append("    -" + ing.getNombre());
        }

        expected.append("            " + productoAjustado1.getPrecio() + "\n");

        //System.out.println(expected);
        //System.out.println(resultado);
        assertEquals(expected.toString(), resultado, "El texto de la factura no es el esperado.");
        
    }
}





