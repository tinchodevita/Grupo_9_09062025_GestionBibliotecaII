package clases.libros;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ManejoDeLista {

    private static ArrayList<Libro> lista = new ArrayList<>();

    // crea lista
    public void crearLista(String item){
        String[] parte = item.split(";");

        if (parte.length == 3) {
            String nombre = parte[0].trim();
            String autor = parte[1].trim();
            String categoria = parte[2].trim();

            Libro libro = new Libro(nombre, autor, categoria);
            lista.add(libro);
        }
    }

    // actualiza estado de la lista
    public static void guardarCambios() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("libros.txt"))) {
            for (Libro libro : lista) {
                writer.write(libro.getNombre() + ";" + libro.getAutor() + ";" + libro.getCategoria());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    // retorna lista
    public static ArrayList<Libro> getLista() {
        return lista;
    }

}
