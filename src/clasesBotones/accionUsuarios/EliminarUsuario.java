package clasesBotones.accionUsuarios;

import clases.usuarios.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EliminarUsuario extends JFrame {

    public EliminarUsuario() {
        setTitle("Eliminar Usuario");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Cargar archivo de usuarios
        LeerArchivoUsuario lector = new LeerArchivoUsuario();
        lector.leerArchivo("usuarios.txt");

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titulo = new JLabel("Eliminar usuario");
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titulo, BorderLayout.NORTH);

        JPanel centro = new JPanel(new GridLayout(2, 1, 10, 10));

        JTextField txtDni = new JTextField();
        txtDni.setFont(new Font("Arial", Font.PLAIN, 16));
        centro.add(txtDni);

        JButton btnEliminar = new JButton("Eliminar Usuario");
        btnEliminar.setFont(new Font("Arial", Font.BOLD, 16));

        btnEliminar.addActionListener(e -> {
            String dni = txtDni.getText().trim();
            ArrayList<Usuario> lista = ManejoDeUsuarios.getListaUsuarios();

            boolean eliminado = false;

            for (int i = 0; i < lista.size(); i++) {
                Usuario u = lista.get(i);
                if (u.getDni().equals(dni)) {
                    int confirmacion = JOptionPane.showConfirmDialog(this,
                        "¿Estás seguro que querés eliminar al usuario \"" + u.getNombre() + "\"?",
                        "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

                    if (confirmacion == JOptionPane.YES_OPTION) {
                        lista.remove(i);
                        ManejoDeUsuarios.guardarCambios();
                        JOptionPane.showMessageDialog(this, "🗑️ Usuario eliminado correctamente.");
                        eliminado = true;
                    }
                    break;
                }
            }

            if (!eliminado) {
                JOptionPane.showMessageDialog(this, "❌ Usuario no encontrado o no eliminado.");
            }
        });

        centro.add(btnEliminar);
        panel.add(centro, BorderLayout.CENTER);
        add(panel);
        setVisible(true);
    }
}
