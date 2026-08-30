package IntegradorCAp_6;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MenuPrincipal frame = new MenuPrincipal();
            frame.setVisible(true);
        });
    }
}

