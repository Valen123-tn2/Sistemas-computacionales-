package ejercicio1_1swing;
import javax.swing.*;

public class Ejercicio1_1swing extends JFrame {

    public Ejercicio1_1swing() {
        setTitle("Ejercicio 1.1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField inputField = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("Tu Edad en un Año Sera: ");

        submitButton.addActionListener(e -> {
            try {
                int num = Integer.parseInt(inputField.getText());
                resultLabel.setText("Tu Edad en un Año Sera: " + (num + 1));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada invalida. Introduce un numero");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Escriba su Edad: "));
        panel.add(inputField);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 100);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Ejercicio1_1swing ejercicio = new Ejercicio1_1swing();
            ejercicio.setVisible(true);
        });
    }
}
    

