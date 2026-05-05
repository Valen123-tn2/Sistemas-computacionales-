package Ejercicio2_9;
import javax.swing.*;

public class ejercicio2_9 extends JFrame {

    public ejercicio2_9() {
        setTitle("Ejercicios 2.9");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField n1 = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");


        submitButton.addActionListener(e -> {
            try {
                int num1 = Integer.parseInt(n1.getText());
                if (num1 < 10) {
                    resultLabel.setText("Tiene Una Cifra");
                } else  if (num1 < 100) {
                    resultLabel.setText("Tiene Dos Cifras");
                } else  if (num1 < 1000) {
                    resultLabel.setText("Tiene Tres Cifras");
                } else  if (num1 < 10000) {
                    resultLabel.setText("Tiene Cuatro Cifras");
                } else  if (num1 < 100000) {
                    resultLabel.setText("Tiene Cinco Cifras");
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada invalida. Introduce un numero");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Escriba un Numero: "));
        panel.add(n1);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 100);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicio2_9 ejercicio = new ejercicio2_9();
            ejercicio.setVisible(true);
        });
    }
}
    


