package clases.usuarios;

import java.io.*;

public class LeerArchivoUsuario {

    public void leerArchivo(String nombreArchivo) {
        ManejoDeUsuarios.getListaUsuarios().clear();

        ManejoDeUsuarios manejador = new ManejoDeUsuarios();

        try (BufferedReader leer = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = leer.readLine()) != null) {
                manejador.crearLista(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer archivo de usuarios: " + e.getMessage());
        }
    }
}
