package clasesBotones.accionesConLibros;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import clases.libros.LeerArchivo;
import clases.libros.Libro;
import clases.libros.ManejoDeLista;

public class BuscarLibro extends JFrame {

    public BuscarLibro() {
        setTitle("Buscador de Libros");
        setSize(500, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Cargar libros
        LeerArchivo lector = new LeerArchivo();
        lector.leerArchivo("libros.txt");

        // Panel principal
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // padding

        // Título
        JLabel titulo = new JLabel("Buscar un Libro");
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titulo, BorderLayout.NORTH);

        // Panel central (input + botón)
        JPanel centro = new JPanel(new GridLayout(2, 1, 10, 10));

        JTextField txtNombreLibro = new JTextField();
        txtNombreLibro.setFont(new Font("Arial", Font.PLAIN, 16));
        centro.add(txtNombreLibro);

        JButton btnBuscar = new JButton("Buscar Libro");
        btnBuscar.setFont(new Font("Arial", Font.BOLD, 16));

        btnBuscar.addActionListener(e -> {
            String txtBusqueda = txtNombreLibro.getText().trim();

            if (txtBusqueda.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar el nombre de un libro.");
            } else {
                
                ArrayList<Libro> listaLibros = ManejoDeLista.getLista();
                ArrayList<Libro> resultados = new ArrayList<>();

                for (Libro libro : listaLibros) {
                    // System.out.println("Buscando: " + txtBusqueda);
                    // System.out.println("→ Nombre: " + libro.getNombre().toLowerCase());
                    // System.out.println("→ Autor: " + libro.getAutor().toLowerCase());
                    // System.out.println("→ Categoría: " + libro.getCategoria().toLowerCase());

                    // System.out.println("¿Coincide?: " + (
                    //     libro.getNombre().toLowerCase().contains(txtBusqueda.toLowerCase()) ||
                    //     libro.getAutor().toLowerCase().contains(txtBusqueda.toLowerCase()) ||
                    //     libro.getCategoria().toLowerCase().contains(txtBusqueda.toLowerCase())
                    // ));

                    if (
                        libro.getNombre().toLowerCase().contains(txtBusqueda.toLowerCase()) ||
                        libro.getAutor().toLowerCase().contains(txtBusqueda.toLowerCase()) ||
                        libro.getCategoria().toLowerCase().contains(txtBusqueda.toLowerCase())
                    ) {
                        resultados.add(libro);
                    }
                }

                if (resultados.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "❌ No se encontraron resultados.");
                } else {
                    StringBuilder mensaje = new StringBuilder("📚 Resultados encontrados:\n\n");
                    for (Libro l : resultados) {
                        mensaje.append("Titulo: ").append(l.getNombre()).append("\n");
                        mensaje.append("Autor: ").append(l.getAutor()).append("\n");
                        mensaje.append("Categoría: ").append(l.getCategoria()).append("\n");
                        mensaje.append("-------------------------\n");
                    }
                    JOptionPane.showMessageDialog(this, mensaje.toString());
                }
            }
        });

        centro.add(btnBuscar);

        panel.add(centro, BorderLayout.CENTER);

        add(panel);
        setVisible(true);
    }
}
