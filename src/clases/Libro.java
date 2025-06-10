package clases;

public class Libro {
    String nombre;
    String autor;
    String categoria;
    boolean disponible;

    public Libro(String nombre, String autor, String categoria) {
        this.nombre = nombre;
        this.autor = autor;
        this.categoria = categoria;
        this.disponible = true;
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

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        String estado = disponible? "Disponible" : "Prestado";
        return nombre + "; " + autor + "; " + categoria + ";" + estado;
    }

}
