//Diseñar un programa que solicite al usuario una frase y una palabra.
//A continuación buscará cuántas veces aparece la palabra en la frase.

package Ejercicio6_7;
import javax.swing.*;

public class ejercicio6_7 extends JFrame {

    public ejercicio6_7() {

        setTitle("Ejercicio 6.7");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField inputField1 = new JTextField(20);
        JTextField inputField2 = new JTextField(10);
        JButton submitButton = new JButton("Buscar");
        JLabel resultLabel = new JLabel("");

        submitButton.addActionListener(e -> {
            String frase = inputField1.getText().trim();
            String palabra = inputField2.getText().trim();
            if (frase.isEmpty() || palabra.isEmpty()) {
                resultLabel.setText("Debe ingresar la frase y la palabra.");
                return;
            }
            int contador = 0;
            String[] palabras = frase.split(" ");

            for (int i = 0; i < palabras.length; i++) {
                if (palabras[i].equalsIgnoreCase(palabra)) {
                    contador++;
                }
            }
            resultLabel.setText("La palabra aparece " + contador + " veces.");
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Frase: "));
        panel.add(inputField1);
        panel.add(new JLabel("Palabra: "));
        panel.add(inputField2);
        panel.add(submitButton);
        panel.add(resultLabel);
        add(panel);

        setSize(750, 120);
        setLocationRelativeTo(null);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicio6_7 ejercicio = new ejercicio6_7();
            ejercicio.setVisible(true);
        });
    }
}