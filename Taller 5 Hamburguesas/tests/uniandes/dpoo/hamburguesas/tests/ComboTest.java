package uniandes.dpoo.hamburguesas.tests;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.Combo;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class ComboTest {

	
	private Combo combo1;
	private ArrayList<ProductoMenu> items;
	
	 @BeforeEach
	    void setUp( ) throws Exception
	    {
		 	items = new ArrayList<>();
		 	ProductoMenu item1 = new ProductoMenu("papas grandes", 6900);
		 	ProductoMenu item2 = new ProductoMenu("gaseosa", 5000);
		 	ProductoMenu item3 = new ProductoMenu("todoterreno", 25000);
	        items.add(item1);
	        items.add(item2);
	        items.add(item3);
	        combo1 = new Combo("combo todoterreno", 0.7, items);
	    }

	    @AfterEach
	    void tearDown( ) throws Exception
	    {
	    }
	    
	    @Test
	    void testGetNombre() {
	    	assertEquals("combo todoterreno", combo1.getNombre(), "El nombre del combo debería ser 'combo todoterreno'");
	    }

	    @Test
	    void testGetPrecio() {
	    	 int precioEsperado = (int) ((6900 + 5000+25000) * 0.7);
	         assertEquals(precioEsperado, combo1.getPrecio(), "El precio del combo es incorrecto");
	     }
	    
	    @Test
	    void testGenerarTextoFactura() {
	        String resultado = combo1.generarTextoFactura();

	        StringBuffer sb = new StringBuffer();
	        sb.append("Combo " + combo1.getNombre() + "\n");
	        sb.append(" Descuento: " + 0.7 + "\n");
	        sb.append("            " + combo1.getPrecio() + "\n");

	        assertEquals(sb.toString(), resultado, "El texto de la factura del combo no es el mismo");
	    }

	    
	    
	    
	    
}
