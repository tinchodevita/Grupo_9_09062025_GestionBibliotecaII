package clases.libros;

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

    // getters necesarios
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

    // setter necesarios
    
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        String estado = disponible? "Disponible" : "Prestado";
        return nombre + "; " + autor + "; " + categoria + ";" + estado;
    }

}
