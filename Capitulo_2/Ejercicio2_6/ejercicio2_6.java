package Ejercicio2_6;
import javax.swing.*;

public class ejercicio2_6 extends JFrame {

    public ejercicio2_6() {
        setTitle("Ejercicios 2.6");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField n1 = new JTextField(10);
        JTextField n2 = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");


        submitButton.addActionListener(e -> {
            try {
                double num1 = Double.parseDouble(n1.getText());
                double num2 = Double.parseDouble(n2.getText());
                double mayor = num1 > num2 ? num1 : num2;
                double menor = num1 < num2 ? num1 : num2;
                resultLabel.setText(mayor + ", " + menor);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada invalida. Introduce un numero");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Escriba un Numero: "));
        panel.add(n1);
        panel.add(new JLabel("Escriba otro Numero: "));
        panel.add(n2);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 100);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicio2_6 ejercicio = new ejercicio2_6();
            ejercicio.setVisible(true);
        });
    }
}
    

