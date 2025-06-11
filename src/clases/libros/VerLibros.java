package clases.libros;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VerLibros extends JFrame {

    public VerLibros() {
        setTitle("Listado de Libros");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // leer libros
        LeerArchivo lector = new LeerArchivo();
        lector.leerArchivo("libros.txt");

        ArrayList<Libro> lista = ManejoDeLista.getLista();
        DefaultListModel<String> modelo = new DefaultListModel<>();

        for (Libro libro : lista) {
            modelo.addElement("• " + libro.toString());
        }

        JList<String> listaVisual = new JList<>(modelo);
        listaVisual.setFont(new Font("Arial", Font.PLAIN, 14));

        JScrollPane scroll = new JScrollPane(listaVisual);

        add(scroll, BorderLayout.CENTER);
        setVisible(true);
    }
}
