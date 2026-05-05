package Ejercicio1_5;
import javax.swing.*;

public class ejercicio1_5 extends JFrame {

    public ejercicio1_5() {
        setTitle("Ejercicios 1.5");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField n1 = new JTextField(10);
        JTextField n2 = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");

        submitButton.addActionListener(e -> {
            try {
                int num1 = Integer.parseInt(n1.getText());
                int num2 = Integer.parseInt(n2.getText());
                double media = (num1 + num2)/ 2.0;
                resultLabel.setText("La Media es: " + media);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Introduce un número");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Escriba La Nota 1: "));
        panel.add(n1);
        panel.add(new JLabel("Escriba La Nota 2: "));
        panel.add(n2);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 100);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicio1_5 ejercicio = new ejercicio1_5();
            ejercicio.setVisible(true);
        });
    }
}
