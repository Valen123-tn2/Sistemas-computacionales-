package Ejercicio1_6;
import javax.swing.*;

public class ejercicio1_6 extends JFrame {

    public ejercicio1_6() {
        setTitle("Ejercicios 1.6");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField n1 = new JTextField(10);
        JTextField n2 = new JTextField(10);
        JTextField n3 = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");

        submitButton.addActionListener(e -> {
            try {
                int num1 = Integer.parseInt(n1.getText());
                int num2 = Integer.parseInt(n2.getText());
                int num3 = Integer.parseInt(n3.getText());
                double media = (int) ((num1 + num2 + num3)/ 3.0);
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
        panel.add(new JLabel("Escriba La Nota 3: "));
        panel.add(n3);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 100);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicio1_6 ejercicio = new ejercicio1_6();
            ejercicio.setVisible(true);
        });
    }
}
