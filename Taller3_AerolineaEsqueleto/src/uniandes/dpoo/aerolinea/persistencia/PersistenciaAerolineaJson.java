package uniandes.dpoo.aerolinea.persistencia;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

import org.json.JSONObject;

import uniandes.dpoo.aerolinea.exceptions.InformacionInconsistenteException;
import uniandes.dpoo.aerolinea.modelo.Aerolinea;

public class PersistenciaAerolineaJson implements IPersistenciaAerolinea {

	@Override
	public void cargarAerolinea(String archivo, Aerolinea aerolinea) throws IOException, InformacionInconsistenteException {
	    try {
	        String jsonCompleto = new String(Files.readAllBytes(new File(archivo).toPath()));
	        JSONObject raiz = new JSONObject(jsonCompleto);


	    } catch (IOException e) {
	        throw new IOException("No se puede leer el archivo");
	    } catch (Exception e) {
	        throw new InformacionInconsistenteException("Información inconsistente en el archivo");
	    }
	}

	@Override
	public void salvarAerolinea(String archivo, Aerolinea aerolinea) throws IOException  {
		
		try (PrintWriter writer = new PrintWriter(new FileWriter(archivo))) {
	        JSONObject raiz = new JSONObject();
	        } catch (IOException e) {
	            throw new IOException("No se puede escribir el archivo");
	        }
	    }
}
