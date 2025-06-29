package clases.libros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeerArchivo {

    public void leerArchivo(String nombreArchivo) {

        ManejoDeLista.getLista().clear();
        
        try (BufferedReader leer = new BufferedReader(new FileReader(nombreArchivo))) {
            
            String lectura; 

            while ((lectura = leer.readLine()) != null) {

                new ManejoDeLista().crearLista(lectura);
            }
    
        } catch (IOException e) {
            System.out.println("Error al encontrar el archivo: "+e.getMessage());
        }
    }

}
