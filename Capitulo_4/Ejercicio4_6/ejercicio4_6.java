package Ejercicio4_6;
import javax.swing.*;

public class ejercicio4_6 extends JFrame {

    public ejercicio4_6() {
        setTitle("Ejercicio 4.6");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField inputField = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");

        submitButton.addActionListener(e -> {
            try {
                String texto = inputField.getText();
                char letra = texto.charAt(0);
                if (esVocal(letra)){
                    resultLabel.setText("Es una vocal");
                } else {
                    resultLabel.setText("No es una vocal");
                }  

            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Introduce una sola letra.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Escriba una letra: "));
        panel.add(inputField);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 120);
        setLocationRelativeTo(null);
    }

    public static boolean esVocal(char c) {
        boolean resultado;
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || 
        c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'){
            resultado = true;
        } else {
            resultado = false;
        }
       return (resultado);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicio4_6 ejercicio = new ejercicio4_6();
            ejercicio.setVisible(true);
        });
    }
}

