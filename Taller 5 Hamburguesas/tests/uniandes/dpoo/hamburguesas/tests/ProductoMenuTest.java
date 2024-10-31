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

}
