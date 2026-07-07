 //Diseñar una función a la que se le pase una cadena de caracteres y la devuelva 
 //invertida. Un ejemplo, la cadena "Hola mundo" quedaría "odnum aloH".

package Ejercicio6_6;
import javax.swing.*;

public class ejercicio6_6 extends JFrame {

    public ejercicio6_6() {

        setTitle("Ejercicio 6.6");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField inputField = new JTextField(20);
        JButton submitButton = new JButton("Invertir");
        JLabel resultLabel = new JLabel("");

        submitButton.addActionListener(e -> {
            String cadena = inputField.getText();
            if (cadena.isEmpty()) {
                resultLabel.setText("Debe ingresar una cadena.");
                return;
            }
            resultLabel.setText(invertir(cadena));

        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Cadena: "));
        panel.add(inputField);
        panel.add(submitButton);
        panel.add(resultLabel);
        add(panel);

        setSize(650, 120);
        setLocationRelativeTo(null);

    }

    public String invertir(String cadena) {
        String invertida = "";
        for (int i = cadena.length() - 1; i >= 0; i--) {
            invertida += cadena.charAt(i);
        }
        return invertida;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicio6_6 ejercicio = new ejercicio6_6();
            ejercicio.setVisible(true);
        });
    }
}