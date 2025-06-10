package clasesBotones.accionesConLibros;

import javax.swing.*;

import clases.libros.LeerArchivo;
import clases.libros.Libro;
import clases.libros.ManejoDeLista;

import java.awt.*;
import java.util.ArrayList;
import java.util.function.LongBinaryOperator;

public class DevolverLibro extends JFrame {

    public DevolverLibro() {
        setTitle("Devolver Libro");
        setSize(500, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Cargar libros
        LeerArchivo lector = new LeerArchivo();
        lector.leerArchivo("libros.txt");

        // Panel principal
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Título
        JLabel titulo = new JLabel("Devolver un Libro");
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titulo, BorderLayout.NORTH);

        // Panel central
        JPanel centro = new JPanel(new GridLayout(2, 1, 10, 10));

        JTextField txtNombre = new JTextField();
        txtNombre.setFont(new Font("Arial", Font.PLAIN, 16));
        centro.add(txtNombre);

        // botones

        JButton btnDevolver = new JButton("Devolver Libro");
        btnDevolver.setFont(new Font("Arial", Font.BOLD, 16));

        JButton btnVerPrestados = new JButton("Ver Libros Prestados.");
        btnVerPrestados.setFont(new Font("Arial", Font.PLAIN, 14));

        btnDevolver.addActionListener(e -> {
            String texto = txtNombre.getText().trim();
            if (texto.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar el nombre del libro.");
            } else {
                ArrayList<Libro> lista = ManejoDeLista.getLista();
                boolean encontrado = false;

                for (Libro libro : lista) {
                    if (libro.getNombre().equalsIgnoreCase(texto)) {
                        encontrado = true;
                        if (!libro.getDisponible()) {
                            libro.setDisponible(true);
                            JOptionPane.showMessageDialog(this, "✅ El libro \"" + libro.getNombre() + "\" fue devuelto.");
                        } else {
                            JOptionPane.showMessageDialog(this, "❌ El libro ya está disponible.");
                        }
                        break;
                    }
                }

                if (!encontrado) {
                    JOptionPane.showMessageDialog(this, "📕 Libro no encontrado.");
                }
            }
        });

        btnVerPrestados.addActionListener(e -> {
            ArrayList<Libro> lista = ManejoDeLista.getLista();
            StringBuilder prestados = new StringBuilder("📕 Libros prestados:\n\n");

            for (Libro libro : lista) {
                if (!libro.getDisponible()) {
                    prestados
                        .append("• ").append(libro.getNombre())
                        .append(" (").append(libro.getAutor())
                        .append(" - ").append(libro.getCategoria()).append(")\n");
                }
            }

            if (prestados.toString().equals("📕 Libros prestados:\n\n")) {
                prestados.append("No hay libros prestados en este momento.");
            }

            JOptionPane.showMessageDialog(this, prestados.toString());
        });

        centro.add(btnDevolver);
        centro.add(btnVerPrestados);
        panel.add(centro, BorderLayout.CENTER);
        add(panel);
        setVisible(true);
    }
}
