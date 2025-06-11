package clasesBotones.accionesConLibros;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import clases.libros.LeerArchivo;
import clases.libros.Libro;
import clases.libros.ManejoDeLista;

public class PrestarLibro extends JFrame{

    public PrestarLibro() {
        // configuracion generales
        setTitle("Prestar Libro");
        setSize(500, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // cargar libros
        LeerArchivo lector = new LeerArchivo();
        lector.leerArchivo("libros.txt");

        // panel
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // titulo
        JLabel titulo = new JLabel("Prestar un libro");
        titulo.setFont(new Font("Arias", Font.BOLD, 22));
        panel.add(titulo, BorderLayout.NORTH);

        // panel con boton e input
        JPanel centro = new JPanel(new GridLayout(4, 2, 10, 10));
        
        JTextField txtNombre = new JTextField();
        txtNombre.setFont(new Font("Arial", Font.PLAIN, 16));

        JTextField txtIDUsuario = new JTextField();
        txtIDUsuario.setFont(new Font("Arial", Font.PLAIN, 16));
        
        JButton btnPrestar = new JButton("Prestar Libro");
        btnPrestar.setFont(new Font("Arial", Font.BOLD, 16));
        
        JButton btnVerDisponibles = new JButton("Ver Libros Disponibles");
        btnVerDisponibles.setFont(new Font("Arial", Font.PLAIN, 14));
        
        // accion boton prestar
        btnPrestar.addActionListener(e -> {
            String texto = txtNombre.getText().trim();
            String idUsuario = txtIDUsuario.getText().trim();
            
            if (texto.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar el titulo del libro.");
            } else {
                ArrayList<Libro> lista = ManejoDeLista.getLista();
                boolean encontrado = false;
                
                for (Libro libro : lista) {
                    if (libro.getNombre().equalsIgnoreCase(texto)) {
                        encontrado = true;
                        if (libro.getDisponible()) {
                            libro.setDisponible(false);
                            JOptionPane.showMessageDialog(this, "✅ El libro \"" + libro.getNombre() + "\" fue prestado al usuario ID: " + idUsuario + ".");
                        } else {
                            JOptionPane.showMessageDialog(this, "❌ El libro ya está prestado.");
                        }
                        
                        break;
                    }
                }
                if (!encontrado) {
                    JOptionPane.showMessageDialog(this, "📕 Libro no encontrado.");
                }
            }
        });
        
        // accion boton ver disponibles
        btnVerDisponibles.addActionListener(e -> {
            ArrayList<Libro> lista = ManejoDeLista.getLista();
            StringBuilder disponibles = new StringBuilder("📚 Libros disponibles:\n\n");
            
            for (Libro libro : lista) {
                if (libro.getDisponible()) {
                    disponibles
                    .append("• ").append(libro.getNombre())
                    .append(" (").append(libro.getAutor())
                    .append(" - ").append(libro.getCategoria()).append(")\n");
                }
            }
            
            if (disponibles.toString().equals("📚 Libros disponibles:\n\n")) {
                disponibles.append("No hay libros disponibles en este momento.");
            }
            
            JOptionPane.showMessageDialog(this, disponibles.toString());
        });
        
        centro.add(new JLabel("Titulo del Libro:"));
        centro.add(txtNombre);
        centro.add(new JLabel("ID de Usuario:"));
        centro.add(txtIDUsuario);
        centro.add(btnPrestar);
        centro.add(btnVerDisponibles);
        panel.add(centro, BorderLayout.CENTER);
        add(panel);
        setVisible(true);
    }
}
