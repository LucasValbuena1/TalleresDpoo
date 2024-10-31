package uniandes.dpoo.hamburguesas.mundo;

import java.util.ArrayList;

import uniandes.dpoo.hamburguesas.excepciones.IngredienteRepetidoException;

/**
 * Un producto ajustado es un producto para el cual el cliente solicitó alguna modificación.
 */
public class ProductoAjustado implements Producto
{
    /**
     * El producto base que el cliente sobre el cual el cliente quiere hacer ajustes
     */
    private ProductoMenu productoBase;

    /**
     * La lista de ingrediente que el usuario quiere agregar. El mismo ingrediente puede aparecer varias veces.
     */
    private ArrayList<Ingrediente> agregados;

    public ArrayList<Ingrediente> getEliminados() {
		return eliminados;
	}

	public void setEliminados(ArrayList<Ingrediente> eliminados) {
		this.eliminados = eliminados;
	}

	/**
     * La lista de ingrediente que el usuario quiere eliminar.
     */
    private ArrayList<Ingrediente> eliminados;

    /**
     * Construye un nuevo producto ajustado a partir del producto base y sin modificaciones
     * @param productoBase El producto base que se va a ajustar
     */
    public ProductoAjustado( ProductoMenu productoBase )
    {
        this.productoBase = productoBase;
        setAgregados(new ArrayList<Ingrediente>( ));
        eliminados = new ArrayList<Ingrediente>( );
    }

    @Override
    public String getNombre( )
    {
        return productoBase.getNombre( );
    }

    /**
     * Retorna el precio del producto ajustado, que debe ser igual al del producto base, sumándole el precio de los ingredientes adicionales.
     */
    @Override
    public int getPrecio( ) {
	    int precioTotal = productoBase.getPrecio();
	    for (Ingrediente ingrediente : getAgregados()) {
	        precioTotal += ingrediente.getCostoAdicional();
	    }
	    for (Ingrediente ingrediente : eliminados) {
	        precioTotal -= ingrediente.getCostoAdicional();
	    }
	    return precioTotal;
	}

    
    public void agregarIngrediente(Ingrediente ingrediente) throws IngredienteRepetidoException {
        if (getAgregados().contains(ingrediente)) {
            throw new IngredienteRepetidoException(ingrediente.getNombre());
        }
        getAgregados().add(ingrediente);
    }


    public void eliminarIngrediente(Ingrediente ingrediente) {
        eliminados.add(ingrediente);
    }
    

    /**
     * Genera el texto que debe aparecer en la factura.
     * 
     * El texto incluye el producto base, los ingredientes adicionales con su costo, los ingredientes eliminados, y el precio total
     */
    @Override
    public String generarTextoFactura( )
    {
        StringBuffer sb = new StringBuffer( );
        sb.append(productoBase.getNombre());
        for( Ingrediente ing : getAgregados() )
        {
            sb.append( "    +" + ing.getNombre( ) );
            sb.append( "                " + ing.getCostoAdicional( ) );
        }
        for( Ingrediente ing : eliminados )
        {
            sb.append( "    -" + ing.getNombre( ) );
        }

        sb.append( "            " + getPrecio( ) + "\n" );

        return sb.toString( );
    }

	public ArrayList<Ingrediente> getAgregados() {
		return agregados;
	}

	public void setAgregados(ArrayList<Ingrediente> agregados) {
		this.agregados = agregados;
	}

}
