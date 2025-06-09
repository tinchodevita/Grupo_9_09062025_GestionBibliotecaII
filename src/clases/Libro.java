package clases;

public class Libro {
    String nombre;
    String autor;
    String categoria;

    public Libro(String nombre, String autor, String categoria) {
        this.nombre = nombre;
        this.autor = autor;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAutor() {
        return autor;
    }

    public String getCategoria() {
        return categoria;
    }

}
