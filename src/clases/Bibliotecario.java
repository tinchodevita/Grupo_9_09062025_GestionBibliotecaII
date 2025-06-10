package clases;

import java.util.ArrayList;

import clases.libros.Libro;

public class Bibliotecario {

    ArrayList<Libro> listaLibros;
    boolean eliminado = false;

    public Bibliotecario(ArrayList<Libro> listaLibros) {
    // Si te pasan una lista usala sino crea una lista vacia
        if (listaLibros != null) {
            this.listaLibros = listaLibros;
        } else {
            this.listaLibros = new ArrayList<>();
        }
    }

}   
