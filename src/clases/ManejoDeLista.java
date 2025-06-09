package clases;

import java.util.ArrayList;

public class ManejoDeLista {

    private static ArrayList<String> lista = new ArrayList<>();

    public void crearLista(String item){
        lista.add(item);
    }

    public static ArrayList<String> getLista() {
        return lista;
    }

}
