package clases;

import java.util.ArrayList;

public class ManejoDeLista {

    private static ArrayList<Libro> lista = new ArrayList<>();

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

    public static ArrayList<Libro> getLista() {
        return lista;
    }

}
