package clasesBotones.accionUsuarios;

import javax.swing.*;
import java.awt.*;

public class AdministrarUsuarios extends JFrame {

    public AdministrarUsuarios() {
        setTitle("Administrar Usuarios");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JLabel titulo = new JLabel("Administración de Usuarios");
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titulo, BorderLayout.NORTH);

        JPanel botones = new JPanel(new GridLayout(3, 1, 15, 15));

        JButton btnAgregar = new JButton("➕ Agregar Usuario");
        JButton btnEditar = new JButton("✏️ Editar Usuario");
        JButton btnEliminar = new JButton("🗑️ Eliminar Usuario");

        btnAgregar.addActionListener(e -> new AgregarUsuario());
        btnEditar.addActionListener(e -> new EditarUsuario());
        btnEliminar.addActionListener(e -> new EliminarUsuario());

        botones.add(btnAgregar);
        botones.add(btnEditar);
        botones.add(btnEliminar);

        panel.add(botones, BorderLayout.CENTER);
        add(panel);
        setVisible(true);
    }
}
