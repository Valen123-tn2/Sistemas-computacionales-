//Introducir por teclado dos palabras e indicar cuál de ellas es la más corta, 
//es decir, la que contiene menos caracteres.

package Ejercicio6_1;
import javax.swing.*;

public class ejercicio6_1 extends JFrame {

    public ejercicio6_1() {

        setTitle("Ejercicio 6.1");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField inputField1 = new JTextField(10);
        JTextField inputField2 = new JTextField(10);
        JButton submitButton = new JButton("Comparar");
        JLabel resultLabel = new JLabel("");

        submitButton.addActionListener(e -> {
            String palabra1 = inputField1.getText().trim();
            String palabra2 = inputField2.getText().trim();
            if (palabra1.isEmpty() || palabra2.isEmpty()) {
                resultLabel.setText("Debe ingresar ambas palabras.");
                return;
            }
            int longPal1 = palabra1.length();
            int longPal2 = palabra2.length();

            if (longPal1 == longPal2) {
                resultLabel.setText("Las dos palabras tienen la misma longitud.");
            } else if (longPal1 < longPal2) {
                resultLabel.setText("\"" + palabra1 + "\" es más corta que \"" + palabra2 + "\".");
            } else {
                resultLabel.setText("\"" + palabra2 + "\" es más corta que \"" + palabra1 + "\".");
            }

        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Primera palabra: "));
        panel.add(inputField1);
        panel.add(new JLabel("Segunda palabra: "));
        panel.add(inputField2);
        panel.add(submitButton);
        panel.add(resultLabel);
        add(panel);

        setSize(650, 120);
        setLocationRelativeTo(null);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicio6_1 ejercicio = new ejercicio6_1();
            ejercicio.setVisible(true);
        });
    }
}