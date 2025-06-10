package clasesBotones.accionUsuarios;

import clases.usuarios.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AgregarUsuario extends JFrame {

    public AgregarUsuario() {
        setTitle("Agregar Usuario");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Cargar archivo (por si no se cargó antes)
        LeerArchivoUsuario lector = new LeerArchivoUsuario();
        lector.leerArchivo("usuarios.txt");

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titulo = new JLabel("Agregar nuevo usuario");
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titulo, BorderLayout.NORTH);

        JPanel centro = new JPanel(new GridLayout(3, 2, 10, 10));

        JLabel lblNombre = new JLabel("Nombre:");
        JTextField txtNombre = new JTextField();

        JLabel lblDni = new JLabel("DNI:");
        JTextField txtDni = new JTextField();

        JButton btnAgregar = new JButton("Agregar Usuario");

        btnAgregar.addActionListener(e -> {
            String nombre = txtNombre.getText().trim();
            String dni = txtDni.getText().trim();

            if (nombre.isEmpty() || dni.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, completá todos los campos.");
                return;
            }

            Usuario nuevoUsuario = new Usuario(nombre, dni);
            ArrayList<Usuario> lista = ManejoDeUsuarios.getListaUsuarios();
            lista.add(nuevoUsuario);
            ManejoDeUsuarios.guardarCambios();

            JOptionPane.showMessageDialog(this, "✅ Usuario agregado correctamente.");
            txtNombre.setText("");
            txtDni.setText("");
        });

        centro.add(lblNombre); centro.add(txtNombre);
        centro.add(lblDni); centro.add(txtDni);
        centro.add(new JLabel()); centro.add(btnAgregar);

        panel.add(centro, BorderLayout.CENTER);
        add(panel);
        setVisible(true);
    }
}
