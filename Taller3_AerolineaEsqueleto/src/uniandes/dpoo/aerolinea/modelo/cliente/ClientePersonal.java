package uniandes.dpoo.aerolinea.modelo.cliente;

public class ClientePersonal extends Cliente {
	 public static final String PERSONAL = "Cliente Personal";
	  private String nombre;
	  
	  public ClientePersonal(String nombre) {
	        this.nombre = nombre;
	    }
	  
	  @Override
	    public String getIdentificador() {
	        return this.nombre; 
	    }
	  
	  @Override
	    public String getTipoCliente() {
	        return PERSONAL; 
	    }
	}

