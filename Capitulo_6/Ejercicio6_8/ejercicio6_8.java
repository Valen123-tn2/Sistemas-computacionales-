//Realizar un programa que lea una frase del teclado y nos indique si es palíndroma, 
//es decir, que la frase sea igual leyendo de izquierda a derecha, que de derecha 
//a izquierda, sin tener en cuenta los espacios. Un ejemplo de frase palíndroma es: 
//Dábale arroz a la zorra el abad.
//Las vocales con tilde hacen que un algoritmo tome una frase palíndroma como si no 
//lo fuese. Por esto, supondremos que el usuario introduce la frase sin tildes.

package Ejercicio6_8;
import javax.swing.*;

public class ejercicio6_8 extends JFrame {

    public ejercicio6_8() {

        setTitle("Ejercicio 6.8");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField inputField = new JTextField(25);
        JButton submitButton = new JButton("Comprobar");
        JLabel resultLabel = new JLabel("");

        submitButton.addActionListener(e -> {
            String frase = inputField.getText();
            if (frase.isEmpty()) {
                resultLabel.setText("Debe ingresar una frase.");
                return;
            }
            frase = frase.replace(" ", "").toLowerCase();
            String invertida = invertir(frase);

            if (frase.equals(invertida)) {
                resultLabel.setText("La frase es palíndroma.");
            } else {
                resultLabel.setText("La frase no es palíndroma.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Frase: "));
        panel.add(inputField);
        panel.add(submitButton);
        panel.add(resultLabel);
        add(panel);

        setSize(700, 120);
        setLocationRelativeTo(null);

    }

    public String invertir(String frase) {
        String invertida = "";
        for (int i = frase.length() - 1; i >= 0; i--) {
            invertida += frase.charAt(i);
        }
        return invertida;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicio6_8 ejercicio = new ejercicio6_8();
            ejercicio.setVisible(true);
        });
    }
}