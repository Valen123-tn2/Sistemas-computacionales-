package Ejercicio4_1;
import javax.swing.*;

public class ejercicio4_1 extends JFrame {

    public ejercicio4_1() {
        setTitle("Ejercicio 4.1");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField inputField = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");

        submitButton.addActionListener(e -> {
            try {
                int n = Integer.parseInt(inputField.getText());
                eco(n, resultLabel);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Introduce un número");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Escriba el número: "));
        panel.add(inputField);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 100);
        setLocationRelativeTo(null);
    }

    public static void eco(int a, JLabel label) {
        String texto = "";
        for (int i = 0; i < a; i++) {
            texto += "Eco... ";
        }
        label.setText(texto);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicio4_1 ejercicio = new ejercicio4_1();
            ejercicio.setVisible(true);
        });
    }
}