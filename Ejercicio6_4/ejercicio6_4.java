//Diseñar una aplicación que pida al usuario que introduzca una 
//frase por teclado e indique cuántos espacios en blanco tiene.

package Ejercicio6_4;
import javax.swing.*;

public class ejercicio6_4 extends JFrame {

    public ejercicio6_4() {

        setTitle("Ejercicio 6.4");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField inputField = new JTextField(20);
        JButton submitButton = new JButton("Contar");
        JLabel resultLabel = new JLabel("");

        submitButton.addActionListener(e -> {
            String frase = inputField.getText();
            if (frase.isEmpty()) {
                resultLabel.setText("Debe ingresar una frase.");
                return;
            }
            int espacios = 0;

            for (int i = 0; i < frase.length(); i++) {
                if (frase.charAt(i) == ' ') {
                    espacios++;
                }
            }
            resultLabel.setText("La frase tiene " + espacios + " espacios.");
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Frase: "));
        panel.add(inputField);
        panel.add(submitButton);
        panel.add(resultLabel);
        add(panel);

        setSize(650, 120);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicio6_4 ejercicio = new ejercicio6_4();
            ejercicio.setVisible(true);
        });
    }
}