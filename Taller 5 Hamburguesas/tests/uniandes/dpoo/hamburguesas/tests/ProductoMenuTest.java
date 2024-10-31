package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

public class ProductoMenuTest {

		private ProductoMenu Menu1;
		
		
		
		@BeforeEach
	    void setUp( ) throws Exception
	    {
	        Menu1 = new ProductoMenu( "corralita", 13000 );
	    }

	    @AfterEach
	    void tearDown( ) throws Exception
	    {
	    }
	    
	    @Test
	    void testGetNombre( )
	    {
	        assertEquals( "corralita", Menu1.getNombre( ), "El nombre del menu no es el esperado." );
	    }
	    
	    @Test
	    void testGetprecio( )
	    {
	        assertEquals( 13000, Menu1.getPrecio( ), "El precio del menu no es el esperado." );
	    }
	    
	    @Test
	    void testGenerarTextoFactura() {
	        String resultado = Menu1.generarTextoFactura();

	        StringBuffer sb = new StringBuffer();
	        sb.append(Menu1.getNombre()).append("\n");
	        sb.append("            ").append(Menu1.getPrecio()).append("\n");

	        assertEquals(sb.toString(), resultado, "El texto de la factura del producto no es el esperado.");
	    }

}
