//Diseñar un programa que solicite al usuario que introduzca por teclado 5 números 
//decimales a continuación, debe mostrar los números en el mismo orden que se han 
//introducido.

package Ejercicio5_1;
import javax.swing.*;

public class ejercicio5_1 extends JFrame {

    private double[] t = new double[5];
    private int indice = 0;

    public ejercicio5_1() {
        setTitle("Ejercicio 5.1");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField inputField = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");

        submitButton.addActionListener(e -> {
            try {
                double num = Double.parseDouble(inputField.getText());
                t[indice] = num;
                indice++;
                String resultado = "Los números son: ";
                if (indice >= 5){
                    for (int i = 0; i < 5; i++){
                    resultado += t[i] + " | ";
                    }
                    resultLabel.setText(resultado);
                }              
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Introduce un numero valido.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Escriba un numero: "));
        panel.add(inputField);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 120);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicio5_1 ejercicio = new ejercicio5_1();
            ejercicio.setVisible(true);
        });
    }
}



