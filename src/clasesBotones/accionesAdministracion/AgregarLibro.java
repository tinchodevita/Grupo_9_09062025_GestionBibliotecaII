package clasesBotones.accionesAdministracion;

import javax.swing.*;

import clases.libros.LeerArchivo;
import clases.libros.Libro;
import clases.libros.ManejoDeLista;

import java.awt.*;

public class AgregarLibro extends JFrame {

    public AgregarLibro() {
        setTitle("Agregar Libro");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // lectura de archivo
        LeerArchivo lector = new LeerArchivo();
        lector.leerArchivo("libros.txt");


        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titulo = new JLabel("Agregar nuevo libro");
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titulo, BorderLayout.NORTH);

        JPanel centro = new JPanel(new GridLayout(4, 2, 10, 10));

        JLabel lblNombre = new JLabel("Nombre:");
        JTextField txtNombre = new JTextField();

        JLabel lblAutor = new JLabel("Autor:");
        JTextField txtAutor = new JTextField();

        JLabel lblCategoria = new JLabel("Categoría:");
        JTextField txtCategoria = new JTextField();

        JButton btnAgregar = new JButton("Agregar Libro");

        btnAgregar.addActionListener(e -> {
            String nombre = txtNombre.getText().trim();
            String autor = txtAutor.getText().trim();
            String categoria = txtCategoria.getText().trim();

            if (nombre.isEmpty() || autor.isEmpty() || categoria.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
            } else {
                Libro nuevoLibro = new Libro(nombre, autor, categoria);
                ManejoDeLista.getLista().add(nuevoLibro);
                ManejoDeLista.guardarCambios();
                JOptionPane.showMessageDialog(this, "📘 Libro agregado correctamente.");
                txtNombre.setText("");
                txtAutor.setText("");
                txtCategoria.setText("");
            }
        });

        centro.add(lblNombre); centro.add(txtNombre);
        centro.add(lblAutor); centro.add(txtAutor);
        centro.add(lblCategoria); centro.add(txtCategoria);
        centro.add(new JLabel()); centro.add(btnAgregar);

        panel.add(centro, BorderLayout.CENTER);
        add(panel);
        setVisible(true);
    }
}
