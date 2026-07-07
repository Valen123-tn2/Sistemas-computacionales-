//Diseñar un algoritmo que lea del teclado una frase e indique, 
//para la letras que aparecen en la frase, cuántas veces se repite cada una. 
//Se consideran iguales las letras mayúsculas y las minúsculas para realizar 
//la cuenta. Un ejemplo sería:
//Frase: En un lugar de la Mancha. Resultado:
//a: 4 veces
//d: 1 vez
//e: 2 veces

package Ejercicio6_13;
import javax.swing.*;

public class ejercicio6_13 extends JFrame {

    public ejercicio6_13() {

        setTitle("Ejercicio 6.13");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField inputField = new JTextField(30);
        JButton submitButton = new JButton("Contar");
        JLabel resultLabel = new JLabel("");

        submitButton.addActionListener(e -> {
            String frase = inputField.getText().trim().toLowerCase();
            if (frase.isEmpty()) {
                resultLabel.setText("Debe ingresar una frase.");
                return;
            }
            int[] numVeces = new int[26];

            for (int i = 0; i < frase.length(); i++) {
                if (Character.isLetter(frase.charAt(i))) {
                    numVeces[frase.charAt(i) - 'a']++;
                }
            }
            String resultado = "<html>";

            for (int i = 0; i < 26; i++) {
                if (numVeces[i] != 0) {
                    resultado += (char)(i + 'a') + ": "
                            + numVeces[i] + " veces<br>";
                }
            }
            resultado += "</html>";
            resultLabel.setText(resultado);
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Frase: "));
        panel.add(inputField);
        panel.add(submitButton);
        panel.add(resultLabel);
        add(panel);

        setSize(850, 250);
        setLocationRelativeTo(null);

    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicio6_13 ejercicio = new ejercicio6_13();
            ejercicio.setVisible(true);
        });
    }
}