//Un anagrama es un palabra, o frase, que resulta de la transposición de otra 
//palabra o frase. Ejemplos de anagramas para la palabra roma son: amor, ramo o mora.
//Construir un programa que solicite al usuario dos palabras e indique si son 
//anagramas una de otra.

package Ejercicio6_12;
import javax.swing.*;

public class ejercicio6_12 extends JFrame {

    public ejercicio6_12() {

        setTitle("Ejercicio 6.12");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField inputField = new JTextField(30);
        JTextField inputField2 = new JTextField(30);
        JButton submitButton = new JButton("Comprobar");
        JLabel resultLabel = new JLabel("");

        submitButton.addActionListener(e -> {
            String palabra1 = inputField.getText().trim().toLowerCase();
            String palabra2 = inputField2.getText().trim().toLowerCase();
            if (palabra1.isEmpty() || palabra2.isEmpty()) {
                resultLabel.setText("Debe ingresar dos palabras.");
                return;
            }
            char[] letras1 = palabra1.toCharArray();
            char[] letras2 = palabra2.toCharArray();
            java.util.Arrays.sort(letras1);
            java.util.Arrays.sort(letras2);

            if (java.util.Arrays.equals(letras1, letras2)) {
                resultLabel.setText("Las palabras son anagramas.");
            } else {
                resultLabel.setText("Las palabras no son anagramas.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Primera palabra: "));
        panel.add(inputField);
        panel.add(new JLabel("Segunda palabra: "));
        panel.add(inputField2);
        panel.add(submitButton);
        panel.add(resultLabel);
        add(panel);

        setSize(850, 150);
        setLocationRelativeTo(null);

    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicio6_12 ejercicio = new ejercicio6_12();
            ejercicio.setVisible(true);
        });
    }
}