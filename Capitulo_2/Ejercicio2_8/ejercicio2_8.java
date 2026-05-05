package Ejercicio2_8;
import javax.swing.*;

public class ejercicio2_8 extends JFrame {

    public ejercicio2_8() {
        setTitle("Ejercicios 2.8");
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
                double t = (num2 * num2 - 4 * num1 * num3);
                if (num1 == 0) {
                    resultLabel.setText("No es una Ecuacion de Segundo Grado");
                } else if (t<0) {
                    resultLabel.setText("No Existen Soluciones Reales");
                } else {
                    double x1 = (-num2 + Math.sqrt(t)) / (2 * num1);
                    double x2 = (-num2 - Math.sqrt(t)) / (2 * num1);
                    resultLabel.setText("Solucion 1: " + x1 + " Solucion 2: " + x2);
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
            ejercicio2_8 ejercicio = new ejercicio2_8();
            ejercicio.setVisible(true);
        });
    }
}
    


