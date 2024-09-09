package uniandes.dpoo.aerolinea.persistencia;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import uniandes.dpoo.aerolinea.exceptions.InformacionInconsistenteException;
import uniandes.dpoo.aerolinea.modelo.Aerolinea;

public class PersistenciaAerolineaJson implements IPersistenciaAerolinea {

	@Override
	public void cargarAerolinea(String archivo, Aerolinea aerolinea) throws IOException,InformacionInconsistenteException {
		// ASUMIENDO QUE ES SERIALIZABLE
		try (ObjectOutputStream contenido = new ObjectOutputStream(new FileOutputStream(archivo))) {
        } catch (IOException e) {
            throw new IOException("no se puede leer el archivo");
        } catch (Exception e) {
            throw new InformacionInconsistenteException("informacion inconsistente");}
        }

	@Override
	public void salvarAerolinea(String archivo, Aerolinea aerolinea) throws IOException  {
		
		 try (ObjectOutputStream contenido = new ObjectOutputStream(new FileOutputStream(archivo))) {
	            contenido.writeObject(aerolinea);
	        } catch (IOException e) {
	            throw new IOException("No se puede escribir el archivo");
	        }
	    }
}
