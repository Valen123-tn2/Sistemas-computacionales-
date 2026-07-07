//Definir una función que tome como parámetros dos tablas, 
//la primera con los 6 números de una apuesta de la primitiva, y la segunda 
//con los 6 números de la combinación ganadora. La función devolverá el número de 
//aciertos.

package Ejercicio5_14;
import java.util.Arrays;
import javax.swing.*;

public class ejercicio5_14 extends JFrame {

    private int[] apuesta = new int[6];
    private int[] ganadora = new int[6];
    private int cantidad = 0;
    private int etapa = 1;

    public ejercicio5_14() {

        setTitle("Ejercicio 5.14");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField inputField = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");

        submitButton.addActionListener(e -> {
            try {
                int num = Integer.parseInt(inputField.getText());
                if (etapa == 1) {
                    apuesta[cantidad] = num;
                    cantidad++;
                    if (cantidad == 6) {
                        etapa = 2;
                        cantidad = 0;
                        resultLabel.setText("Ingrese los 6 números de la combinación ganadora.");
                    }

                } else {
                    ganadora[cantidad] = num;
                    cantidad++;
                    if (cantidad == 6) {
                        Arrays.sort(ganadora);
                        int aciertos = primitiva(apuesta, ganadora);
                        resultLabel.setText("Aciertos: " + aciertos);
                        submitButton.setEnabled(false);
                        inputField.setEnabled(false);
                    }
                }
                inputField.setText("");

            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Numero:"));
        panel.add(inputField);
        panel.add(submitButton);
        panel.add(resultLabel);
        add(panel);

        setSize(600, 120);
        setLocationRelativeTo(null);
    }

    public int primitiva(int apuesta[], int premiado[]) {
        int aciertos = 0;
        for (int a : apuesta) {
            if (Arrays.binarySearch(premiado, a) >= 0) {
                aciertos++;
            }
        }
        return aciertos;
    }
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            ejercicio5_14 ejercicio = new ejercicio5_14();
            ejercicio.setVisible(true);
        });

    }
}