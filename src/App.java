import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class App extends JFrame{

    public App() {
        setTitle("Biblioteria On-Line");
        setSize(600, 400);
        setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 1 , 20, 20));

    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
