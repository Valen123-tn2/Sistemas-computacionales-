//Leer una serie de 6 enteros que se almacenarán en una tabla que hay que ordenar y 
//mostrar. Leer otra serie de 6 enteros, que también se guardarán en una tabla y se 
//mostrarán ordenados. A continuación, fusionar las dos tablas en una tercera, 
//de forma que los 12 números sigan ordenados. Fusionar dos tablas ordenadas significa
//copiar en el orden correcto para que los datos resultantes continúen ordenados, 
//sin necesidad de volver a realizar una ordenación.

package Ejercicio5_7;
import javax.swing.*;

public class ejercicio5_7 extends JFrame {

    private int[] t1 = new int[6];
    private int[] t2 = new int[6];
    private int[] t3 = new int[12];
    private int cantidad1 = 0;
    private int cantidad2 = 0;

    public ejercicio5_7() {

        setTitle("Ejercicio 5.7");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField inputField = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");

        submitButton.addActionListener(e -> {

            try {
                int num = Integer.parseInt(inputField.getText());
                if (cantidad1 < 6) {
                    t1[cantidad1] = num;
                    cantidad1++;
                    if (cantidad1 == 6) {
                        ordenar(t1, 6);
                        resultLabel.setText("Tabla 1: " + mostrar(t1, 6) + " | Ingrese los 6 números de la segunda tabla.");
                    }
                } else if (cantidad2 < 6) {
                    t2[cantidad2] = num;
                    cantidad2++;
                    if (cantidad2 == 6) {
                        ordenar(t2, 6);
                        fusionar();
                        resultLabel.setText("Tabla 1: " + mostrar(t1, 6) + "Tabla 2: " + mostrar(t2, 6) + "Fusion: " + mostrar(t3, 12));
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

        panel.add(new JLabel("Numeros: "));
        panel.add(inputField);
        panel.add(submitButton);
        panel.add(resultLabel);
        add(panel);

        setSize(600, 120);
        setLocationRelativeTo(null);
    }

    public void ordenar(int[] t, int cantidad) {
        for (int i = 0; i < cantidad - 1; i++) {
            for (int j = i + 1; j < cantidad; j++) {
                if (t[i] > t[j]) {
                    int aux = t[i];
                    t[i] = t[j];
                    t[j] = aux;
                }
            }
        }
    }

    public void fusionar() {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < 6 && j < 6) {
            if (t1[i] <= t2[j]) {
                t3[k] = t1[i];
                i++;
            } else {
                t3[k] = t2[j];
                j++;
            }
            k++;
        }
        while (i < 6) {
            t3[k] = t1[i];
            i++;
            k++;
        }
        while (j < 6) {
            t3[k] = t2[j];
            j++;
            k++;
        }
    }

    public String mostrar(int[] t, int cantidad) {
        String texto = "";
        for (int i = 0; i < cantidad; i++) {
            texto += t[i] + " ";
        }
        return texto;
    }
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            ejercicio5_7 ejercicio = new ejercicio5_7();
            ejercicio.setVisible(true);
        });

    }
}