//Escribir un programa que solicite los elementos de una matriz de tamaño 4 x 4. 
//La aplicación debe decidir si la matriz introducida corresponde a una matriz 
//mágica, que es aquella donde la suma de lo elementos de cualquier fila o de 
//cualquier columna vale lo mismo.

package Ejercicio5_11;
import javax.swing.*;

public class ejercicio5_11 extends JFrame {

    private int[][] matriz = new int[4][4];
    private int fila = 0;
    private int columna = 0;

    public ejercicio5_11() {

        setTitle("Ejercicio 5.11");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField inputField = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");

        submitButton.addActionListener(e -> {

            try {
                int num = Integer.parseInt(inputField.getText());
                matriz[fila][columna] = num;
                columna++;
                if (columna == 4) {
                    columna = 0;
                    fila++;
                }

                if (fila == 4) {
                    if (esMagica()) {
                        resultLabel.setText("La matriz es mágica.");
                    } else {
                        resultLabel.setText("La matriz no es mágica.");
                    }
                    submitButton.setEnabled(false);
                    inputField.setEnabled(false);
                }
                inputField.setText("");
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida.");
            }
        });

        JPanel panel = new JPanel();

        panel.add(new JLabel("Numero: "));
        panel.add(inputField);
        panel.add(submitButton);
        panel.add(resultLabel);
        add(panel);

        setSize(600, 120);
        setLocationRelativeTo(null);
    }

     public boolean esMagica() {
        int suma = 0;
        for (int j = 0; j < 4; j++) {
            suma += matriz[0][j];
        }

        for (int i = 1; i < 4; i++) {
            int sumaFila = 0;
            for (int j = 0; j < 4; j++) {
                sumaFila += matriz[i][j];
            }
            if (sumaFila != suma) {
                return false;
            }
        }

        for (int j = 0; j < 4; j++) {
            int sumaColumna = 0;
            for (int i = 0; i < 4; i++) {
                sumaColumna += matriz[i][j];
            }
            if (sumaColumna != suma) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            ejercicio5_11 ejercicio = new ejercicio5_11();
            ejercicio.setVisible(true);
        });

    }
}