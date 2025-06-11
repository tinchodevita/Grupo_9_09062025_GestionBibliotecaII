package clases.usuarios;

import java.io.*;
import java.util.ArrayList;

public class ManejoDeUsuarios {

    private static ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    public void crearLista(String linea) {
        String[] partes = linea.split(";");
        if (partes.length == 2) {
            String nombre = partes[0].trim();
            String id = partes[1].trim();
            Usuario usuario = new Usuario(nombre, id);
            listaUsuarios.add(usuario);
        }
    }

    public static ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public static void guardarCambios() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("usuarios.txt"))) {
            for (Usuario u : listaUsuarios) {
                writer.write(u.getNombre() + ";" + u.getId());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar usuarios: " + e.getMessage());
        }
    }
}
