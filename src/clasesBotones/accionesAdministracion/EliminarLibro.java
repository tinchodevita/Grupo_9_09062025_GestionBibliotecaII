package clasesBotones.accionesAdministracion;

import javax.swing.*;

import clases.libros.LeerArchivo;
import clases.libros.Libro;
import clases.libros.ManejoDeLista;

import java.awt.*;
import java.util.ArrayList;

public class EliminarLibro extends JFrame {

    public EliminarLibro() {
        // caracteristicas generales
        setTitle("Eliminar Libro");
        setSize(450, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // leer archivo
        LeerArchivo lector = new LeerArchivo();
        lector.leerArchivo("libros.txt");

        // panel principal
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titulo = new JLabel("Eliminar libro del sistema");
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titulo, BorderLayout.NORTH);

        JPanel centro = new JPanel(new GridLayout(2, 1, 10, 10));

        JTextField txtNombre = new JTextField();
        txtNombre.setFont(new Font("Arial", Font.PLAIN, 16));
        centro.add(txtNombre);

        // boton
        JButton btnEliminar = new JButton("Eliminar Libro");
        btnEliminar.setFont(new Font("Arial", Font.BOLD, 16));

        btnEliminar.addActionListener(e -> {
            String texto = txtNombre.getText().trim().toLowerCase();
            ArrayList<Libro> lista = ManejoDeLista.getLista();
            System.out.println("Tamaño de la lista: " + lista.size());

            boolean eliminado = false;

            for (int i = 0; i < lista.size(); i++) {
                Libro libro = lista.get(i);
                System.out.println("Buscando: " + texto);
                System.out.println("Comparando con: " + libro.getNombre().trim().toLowerCase());
                if (libro.getNombre().trim().toLowerCase().equals(texto)) {

                    int confirmacion = JOptionPane.showConfirmDialog(this,
                        "¿Estás seguro que querés eliminar el libro \"" + libro.getNombre() + "\"?",
                        "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

                    if (confirmacion == JOptionPane.YES_OPTION) {
                        lista.remove(i);
                        ManejoDeLista.guardarCambios();
                        JOptionPane.showMessageDialog(this, "🗑️ Libro eliminado correctamente.");
                        eliminado = true;
                    }
                    break;
                }
            }

            if (!eliminado) {
                JOptionPane.showMessageDialog(this, "❌ Libro no encontrado o no eliminado.");
            }
        });

        centro.add(btnEliminar);
        panel.add(centro, BorderLayout.CENTER);
        add(panel);
        setVisible(true);
    }
}
