package clases.libros;

public class Libro {
    String nombre;
    String autor;
    String categoria;
    boolean disponible;
    String idUsuario;

    public Libro(String nombre, String autor, String categoria) {
        this.nombre = nombre;
        this.autor = autor;
        this.categoria = categoria;
        this.disponible = true;
        this.idUsuario = null;
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

    public String getIdUsuario() {
        return idUsuario;
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

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        String estado = disponible? "Disponible" : "Prestado";
        String infoUsario = (!disponible && idUsuario != null && !idUsuario.isEmpty()) ? "(ID usario: " + idUsuario + ")" : "";
        return nombre + "; " + autor + "; " + categoria + " - " + estado + infoUsario;
    }

}
