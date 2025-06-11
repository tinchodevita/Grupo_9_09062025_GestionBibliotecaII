package clases.libros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeerArchivo {

    public void leerArchivo(String nombreArchivo) {

        ManejoDeLista lista = new ManejoDeLista();
        
        try (BufferedReader leer = new BufferedReader(new FileReader(nombreArchivo))) {
            String lectura; 
            ManejoDeLista.getLista().clear(); // limpia la lista antes de recargar

            while ((lectura = leer.readLine()) != null) {

                lista.crearLista(lectura);                
            }
    
        } catch (IOException e) {
            System.out.println("Error al encontrar el archivo: "+e.getMessage());
        }
    }

}
