package clasesBotones.accionUsuarios;

import clases.usuarios.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EditarUsuario extends JFrame {

    public EditarUsuario() {
        setTitle("Editar Usuario");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Cargar usuarios desde archivo
        LeerArchivoUsuario lector = new LeerArchivoUsuario();
        lector.leerArchivo("usuarios.txt");

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titulo = new JLabel("Editar usuario");
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titulo, BorderLayout.NORTH);

        JPanel centro = new JPanel(new GridLayout(4, 2, 10, 10));

        JLabel lblId = new JLabel("ID del usuario:");
        JTextField txtId = new JTextField();

        JLabel lblNombreActual = new JLabel("Nuevo nombre:");
        JTextField txtNuevoNombre = new JTextField();

        JButton btnBuscar = new JButton("Buscar");
        JButton btnGuardar = new JButton("Guardar cambios");

        centro.add(lblId); centro.add(txtId);
        centro.add(lblNombreActual); centro.add(txtNuevoNombre);
        centro.add(new JLabel()); centro.add(btnBuscar);
        centro.add(new JLabel()); centro.add(btnGuardar);

        panel.add(centro, BorderLayout.CENTER);
        add(panel);
        setVisible(true);

        // Buscar usuario por ID
        btnBuscar.addActionListener(e -> {
            String id = txtId.getText().trim();
            ArrayList<Usuario> lista = ManejoDeUsuarios.getListaUsuarios();
            boolean encontrado = false;

            for (Usuario u : lista) {
                if (u.getId().equals(id)) {
                    txtNuevoNombre.setText(u.getNombre());
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                JOptionPane.showMessageDialog(this, "❌ Usuario no encontrado.");
                txtNuevoNombre.setText("");
            }
        });

        // Guardar cambios
        btnGuardar.addActionListener(e -> {
            String id = txtId.getText().trim();
            String nuevoNombre = txtNuevoNombre.getText().trim();

            if (id.isEmpty() || nuevoNombre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Completá todos los campos.");
                return;
            }

            ArrayList<Usuario> lista = ManejoDeUsuarios.getListaUsuarios();
            boolean actualizado = false;

            for (Usuario u : lista) {
                if (u.getId().equals(id)) {
                    u.setNombre(nuevoNombre);
                    actualizado = true;
                    break;
                }
            }

            if (actualizado) {
                ManejoDeUsuarios.guardarCambios();
                JOptionPane.showMessageDialog(this, "✅ Usuario actualizado.");
                txtId.setText("");
                txtNuevoNombre.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "❌ No se pudo actualizar el usuario.");
            }
        });
    }
}
