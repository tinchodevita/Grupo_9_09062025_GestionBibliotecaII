import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import clasesBotones.accionUsuarios.AdministrarUsuarios;
import clasesBotones.accionesConLibros.AdministrarLibro;
import clasesBotones.accionesConLibros.BuscarLibro;
import clasesBotones.accionesConLibros.DevolverLibro;
import clasesBotones.accionesConLibros.PrestarLibro;
import clasesBotones.accionUsuarios.AdministrarUsuarios;

public class App extends JFrame{

    public App() {
        // configuraciones generales
        setTitle("Biblioteria On-Line");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        Font font = new Font("Arial", Font.BOLD, 16);
        Color fondoPanel = new Color(240, 248, 255); // azul muy claro

        // contenedor
        JPanel panel = new JPanel(new GridLayout(3, 2, 20, 20));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panel.setBackground(fondoPanel);

        // botones
        JButton btnBuscarLibro = new JButton("Buscar Libro");
        btnBuscarLibro.addActionListener(e -> new BuscarLibro().setVisible(true));  

        JButton btnPrestarLibro = new JButton("Prestar Libro");
        btnPrestarLibro.addActionListener(e -> new PrestarLibro().setVisible(true));

        JButton btnDevolverLibro = new JButton("Devolver Libro");
        btnDevolverLibro.addActionListener(e -> new DevolverLibro().setVisible(true));

        JButton btnAdministracionLibro = new JButton("Administrar Libros");
        btnAdministracionLibro.addActionListener(e -> new AdministrarLibro().setVisible(true));

        JButton btnAdministrarUsuarios = new JButton("Administrar Usuarios");
        btnAdministrarUsuarios.addActionListener(e -> new AdministrarUsuarios().setVisible(true));

        btnBuscarLibro.setFont(font);
        btnPrestarLibro.setFont(font);
        btnDevolverLibro.setFont(font);
        btnAdministracionLibro.setFont(font);
        btnAdministrarUsuarios.setFont(font);

        // agregar botones al panel
        panel.add(btnBuscarLibro);
        panel.add(btnPrestarLibro);
        panel.add(btnDevolverLibro);
        panel.add(btnAdministracionLibro);
        panel.add(btnAdministrarUsuarios);

        add(panel);
    }

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(() -> new App().setVisible(true));
    }
}