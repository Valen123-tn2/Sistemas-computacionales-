package Ejercicio1_7;
import javax.swing.*;

public class ejercicio1_7 extends JFrame {

    public ejercicio1_7() {
        setTitle("Ejercicio 1.7");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField inputField = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("Redondeado es: ");


        submitButton.addActionListener(e -> {
            try {
                double n = Double.parseDouble(inputField.getText());
                int redondeo = (int) (n + 0.5);
                resultLabel.setText( n + " Redondeado es: " + redondeo);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada invalida. Introduce un numero");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Escriba el numero decimal: "));
        panel.add(inputField);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 100);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicio1_7 ejercicio = new ejercicio1_7();
            ejercicio.setVisible(true);
        });
    }
}
    