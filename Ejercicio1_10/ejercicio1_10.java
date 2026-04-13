package Ejercicio1_10;
import javax.swing.*;

public class ejercicio1_10 extends JFrame {

    public ejercicio1_10() {
        setTitle("Ejercicio 1.10");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField inputField = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabelL = new JLabel("La longitud del Circulo es: ");
        JLabel resultLabelA = new JLabel("El Area de la Circunferencia es: ");


        submitButton.addActionListener(e -> {
            try {
                final double PI = 3.14;
                double radio = Double.parseDouble(inputField.getText());
                double longitud = 2 * PI * radio;
                double area = PI * radio * radio;
                resultLabelL.setText( "La longitud del Circulo es: " + longitud);
                resultLabelA.setText( "El Area de la Circunferencia es: " + area);
            } catch (NumberFormatException ex) {
                resultLabelL.setText("Entrada invalida. Introduce un numero");
                resultLabelA.setText("Entrada invalida. Introduce un numero");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Escriba el Radio: "));
        panel.add(inputField);
        panel.add(submitButton);
        panel.add(resultLabelL);
        panel.add(resultLabelA);

        add(panel);
        setSize(600, 100);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicio1_10 ejercicio = new ejercicio1_10();
            ejercicio.setVisible(true);
        });
    }
}
    