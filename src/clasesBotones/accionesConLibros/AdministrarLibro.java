package clasesBotones.accionesConLibros;

import javax.swing.*;

import clasesBotones.accionesAdministracion.*;

import java.awt.*;

public class AdministrarLibro extends JFrame {

    public AdministrarLibro() {
        setTitle("Administrar Libros");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JLabel titulo = new JLabel("Administración de Libros");
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titulo, BorderLayout.NORTH);

        JPanel botones = new JPanel(new GridLayout(3, 1, 15, 15));

        JButton btnAgregar = new JButton("➕ Agregar Libro");
        JButton btnEditar = new JButton("✏️ Editar Libro");
        JButton btnEliminar = new JButton("🗑️ Eliminar Libro");

        btnAgregar.addActionListener(e -> new AgregarLibro());
        btnEditar.addActionListener(e -> new EditarLibro());
        btnEliminar.addActionListener(e -> new EliminarLibro());

        botones.add(btnAgregar);
        botones.add(btnEditar);
        botones.add(btnEliminar);

        panel.add(botones, BorderLayout.CENTER);
        add(panel);
        setVisible(true);
    }
}
