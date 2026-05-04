package Ejercicio2_7;
import javax.swing.*;

public class ejercicio2_7 extends JFrame {

    public ejercicio2_7() {
        setTitle("Ejercicios 2.7");
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

                if (num1 > num2 && num2 > num3) {
                    resultLabel.setText(num1 + ", " + num2 + ", " + num3);
                } else if (num1 > num3 && num3 > num2) {
                    resultLabel.setText(num1 + ", " + num3 + ", " + num2);
                } else if (num2 > num1 && num1 > num3) {
                    resultLabel.setText(num2 + ", " + num1 + ", " + num3);
                } else if (num2 > num3 && num3 > num1) {
                    resultLabel.setText(num2 + ", " + num3 + ", " + num1);
                } else if (num3 > num1 && num1 > num2) {
                    resultLabel.setText(num3 + ", " + num1 + ", " + num2);
                } else if (num3 > num2 && num2 > num1) {
                    resultLabel.setText(num3 + ", " + num2 + ", " + num1);
                } else {
                    resultLabel.setText("Entrada invalida. Introduce un numero");
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada invalida. Introduce un numero");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Escriba un Numero: "));
        panel.add(n1);
        panel.add(new JLabel("Escriba otro Numero: "));
        panel.add(n2);
        panel.add(new JLabel("Escriba otro Numero: "));
        panel.add(n3);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 150);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicio2_7 ejercicio = new ejercicio2_7();
            ejercicio.setVisible(true);
        });
    }
}
    


