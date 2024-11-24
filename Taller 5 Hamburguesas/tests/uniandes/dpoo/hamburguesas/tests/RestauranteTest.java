package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.excepciones.HamburguesaException;
import uniandes.dpoo.hamburguesas.excepciones.NoHayPedidoEnCursoException;
import uniandes.dpoo.hamburguesas.excepciones.YaHayUnPedidoEnCursoException;
import uniandes.dpoo.hamburguesas.mundo.Combo;
import uniandes.dpoo.hamburguesas.mundo.Ingrediente;
import uniandes.dpoo.hamburguesas.mundo.Pedido;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;
import uniandes.dpoo.hamburguesas.mundo.Restaurante;

public class RestauranteTest {

    private Restaurante restaurante;

    @BeforeEach
    void setUp() {
        restaurante = new Restaurante();
    }

    @AfterEach
    void tearDown() {
      
        restaurante = null;
    }

    @Test
    void testIniciarPedido() throws YaHayUnPedidoEnCursoException {

        restaurante.iniciarPedido("Ivan Salazar", "Carrera 2 calle 19");
        Pedido pedidoEnCurso = restaurante.getPedidoEnCurso();
        assertEquals("Ivan Salazar", pedidoEnCurso.getNombreCliente());

        assertAll("Verificación de pedido en curso",
                () -> assertEquals("Ivan Salazar", pedidoEnCurso.getNombreCliente(), "El nombre del cliente no es el esperado"),
                () -> assertNotEquals(null, pedidoEnCurso, "El pedido en curso aparece inexistente")
            );
    }

    @Test
    void testCerrarYGuardarPedido()throws YaHayUnPedidoEnCursoException {

    	 assertEquals(null, restaurante.getPedidoEnCurso(), "El pedido en curso debería ser null después de cerrar");
    }

    @Test
    void testGetPedidoEnCurso() throws YaHayUnPedidoEnCursoException {
     
    	assertEquals(null, restaurante.getPedidoEnCurso(), "Inicialmente no debería haber pedido en curso");
    	 restaurante.iniciarPedido("Ivan Salazar", "Carrera 2 calle 19");
         Pedido pedidoEnCurso = restaurante.getPedidoEnCurso();

         assertTrue(pedidoEnCurso != null, "Existe un pedido en curso");

    }

    @Test
    void testGetPedidos() throws YaHayUnPedidoEnCursoException, IOException, NoHayPedidoEnCursoException {
    	restaurante.iniciarPedido("Ivan Salazar", "Carrera 2 calle 19");
        
        List<Pedido> pedidosEsperados = new ArrayList<>();
        pedidosEsperados.add(new Pedido("Ivan Salazar", "Carrera 2 calle 19"));
        
        assertEquals(pedidosEsperados, restaurante.getPedidos(), "La lista de pedidos no coincide");
    }

    @Test
    void testGetMenuBase() {
        assertTrue(restaurante.getMenuBase().isEmpty(), "La lista debería estar inicialmente vacía.");    
        ProductoMenu nuevoProducto = new ProductoMenu("corral queso", 16000);
        restaurante.getMenuBase().add(nuevoProducto);

 
        assertTrue(restaurante.getMenuBase().contains(nuevoProducto), "El menú base debería contener una corral de queso");
    }
    
    
    @Test
    void testGetMenuCombos() {
        assertTrue(restaurante.getMenuCombos().isEmpty(), "El menú de combos debería estar inicialmente vacío.");
        
        ArrayList<ProductoMenu> items = new ArrayList<>();
        ProductoMenu item1 = new ProductoMenu("papas grandes", 6900);
        ProductoMenu item2 = new ProductoMenu("gaseosa", 5000);
        ProductoMenu item3 = new ProductoMenu("todoterreno", 25000);
        items.add(item1);
        items.add(item2);
        items.add(item3);
        
        Combo combo1 = new Combo("combo todoterreno", 0.7, items);
        restaurante.getMenuCombos().add(combo1);
        
        assertTrue(restaurante.getMenuCombos().contains(combo1), "El menú de combos debería contener el combo agregado.");
    }


    @Test
    void testGetIngredientes() {
        assertTrue(restaurante.getIngredientes().isEmpty(), "La lista debería estar inicialmente vacía.");
        Ingrediente nuevoIngrediente = new Ingrediente("lechuga", 1000);
        restaurante.getIngredientes().add(nuevoIngrediente);
        assertTrue(restaurante.getIngredientes().contains(nuevoIngrediente), "La lista de ingredientes debería contener lechuga");
    }

    @Test
    void testCargarInformacionRestaurante() throws IOException, NumberFormatException, HamburguesaException {
        
    	File archivoIngredientes = new File("data/ingredientes.txt");
        File archivoMenu = new File("data/menu.txt");
        File archivoCombos = new File("data/combos.txt");

        restaurante.cargarInformacionRestaurante(archivoIngredientes, archivoMenu, archivoCombos);
        
        
        assertTrue(restaurante.getIngredientes().size() != 0);
        assertTrue(restaurante.getMenuBase().size() != 0);
        assertTrue(restaurante.getMenuCombos().size() != 0);
    }
}

