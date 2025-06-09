package clasesBotones;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import clases.LeerArchivo;
import clases.ManejoDeLista;

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
            String nombre = txtNombreLibro.getText().trim();

            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar el nombre de un libro.");
            } else {
                
                ArrayList<String> listaLibros = ManejoDeLista.getLista();
                boolean encontrado = false;

                for (String libro : listaLibros) {
                    if (libro.equalsIgnoreCase(nombre)) {
                        JOptionPane.showMessageDialog(this, "📚 El libro \"" + libro + "\" está disponible.");
                        encontrado = true;
                        break;
                    }
                }

                if (!encontrado) {
                    JOptionPane.showMessageDialog(this, "❌ El libro no fue encontrado.");
                }
            }
        });

        centro.add(btnBuscar);

        panel.add(centro, BorderLayout.CENTER);

        add(panel);
        setVisible(true);
    }
}
