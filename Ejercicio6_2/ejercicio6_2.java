//Diseñar el juego acierta la contraseña. La mecánica del juego es la siguiente: 
//el pri­mer jugador introduce la contraseña; a continuación, el segundo 
//jugador debe teclear palabras hasta que la acierte. Realizar dos versiones; en
//la primera las únicas pistas que se proporcionan son el número de caracteres y 
//cuáles son el primer y el último carácter de la contraseña. En la segunda versión 
//se facilita el juego indicando si la palabra introducida es mayor o menor, 
//alfabéticamente, que la contraseña.

package Ejercicio6_2;
import javax.swing.*;

public class ejercicio6_2 extends JFrame {

    private String password = "";
    private boolean guardada = false;

    public ejercicio6_2() {

        setTitle("Ejercicio 6.2");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField inputField = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("Jugador 1: Ingrese la contraseña.");

        submitButton.addActionListener(e -> {
            String texto = inputField.getText();
            if (!guardada) {
                if (texto.isEmpty()) {
                    resultLabel.setText("Debe ingresar una contraseña.");
                    return;
                }
                password = texto;
                guardada = true;
                resultLabel.setText("Pistas: Longitud = " + password.length()+ ", Primer carácter = " + password.charAt(0)+ ", Último carácter = " + password.charAt(password.length() - 1));
                inputField.setText("");

            } else {
                if (texto.equals(password)) {
                    resultLabel.setText("¡Felicitaciones! Adivinó la contraseña.");
                    submitButton.setEnabled(false);
                    inputField.setEnabled(false);

                } else {
                    resultLabel.setText("Contraseña incorrecta. Intente nuevamente.");
                    inputField.setText("");
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Texto: "));
        panel.add(inputField);
        panel.add(submitButton);
        panel.add(resultLabel);
        add(panel);

        setSize(700, 120);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicio6_2 ejercicio = new ejercicio6_2();
            ejercicio.setVisible(true);
        });
    }
}