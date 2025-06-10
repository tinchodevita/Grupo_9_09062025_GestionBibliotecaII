package clasesBotones.accionesAdministracion;

import javax.swing.*;

import clases.libros.LeerArchivo;
import clases.libros.Libro;
import clases.libros.ManejoDeLista;

import java.awt.*;
import java.util.ArrayList;

public class EditarLibro extends JFrame {

    public EditarLibro() {
        // caracteristicas principales
        setTitle("Editar Libro");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // leer archivo
        LeerArchivo lector = new LeerArchivo();
        lector.leerArchivo("libros.txt");

        // panel
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titulo = new JLabel("Editar libro existente");
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titulo, BorderLayout.NORTH);

        JPanel centro = new JPanel(new GridLayout(5, 2, 10, 10));

        // Campo para buscar libro
        JLabel lblBuscar = new JLabel("Nombre del libro:");
        JTextField txtBuscar = new JTextField();

        // Campos editables
        JLabel lblNuevoNombre = new JLabel("Nuevo nombre:");
        JTextField txtNuevoNombre = new JTextField();

        JLabel lblNuevoAutor = new JLabel("Nuevo autor:");
        JTextField txtNuevoAutor = new JTextField();

        JLabel lblNuevaCategoria = new JLabel("Nueva categoría:");
        JTextField txtNuevaCategoria = new JTextField();

        JButton btnBuscar = new JButton("Buscar libro");
        JButton btnGuardar = new JButton("Guardar cambios");

        // Buscar libro por nombre
        btnBuscar.addActionListener(e -> {
            String nombreBuscado = txtBuscar.getText().trim();
            ArrayList<Libro> lista = ManejoDeLista.getLista();

            boolean encontrado = false;
            for (Libro libro : lista) {
                if (libro.getNombre().trim().toLowerCase().equals(nombreBuscado.trim().toLowerCase())){
                    txtNuevoNombre.setText(libro.getNombre());
                    txtNuevoAutor.setText(libro.getAutor());
                    txtNuevaCategoria.setText(libro.getCategoria());
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                JOptionPane.showMessageDialog(this, "📕 Libro no encontrado.");
                txtNuevoNombre.setText("");
                txtNuevoAutor.setText("");
                txtNuevaCategoria.setText("");
            }
        });

        // Guardar cambios
        btnGuardar.addActionListener(e -> {
            String nombreOriginal = txtBuscar.getText().trim();
            ArrayList<Libro> lista = ManejoDeLista.getLista();

            for (Libro libro : lista) {
                if (libro.getNombre().equalsIgnoreCase(nombreOriginal)) {
                    libro.setNombre(txtNuevoNombre.getText().trim());
                    libro.setAutor(txtNuevoAutor.getText().trim());
                    libro.setCategoria(txtNuevaCategoria.getText().trim());
                    ManejoDeLista.guardarCambios();

                    JOptionPane.showMessageDialog(this, "✅ Libro editado correctamente.");
                    return;
                }
            }

            JOptionPane.showMessageDialog(this, "❌ No se pudo editar el libro.");
        });

        centro.add(lblBuscar); centro.add(txtBuscar);
        centro.add(new JLabel()); centro.add(btnBuscar);
        centro.add(lblNuevoNombre); centro.add(txtNuevoNombre);
        centro.add(lblNuevoAutor); centro.add(txtNuevoAutor);
        centro.add(lblNuevaCategoria); centro.add(txtNuevaCategoria);
        centro.add(new JLabel()); centro.add(btnGuardar);

        panel.add(centro, BorderLayout.CENTER);
        add(panel);
        setVisible(true);
    }
}
