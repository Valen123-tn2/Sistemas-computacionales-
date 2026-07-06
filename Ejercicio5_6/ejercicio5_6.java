//Diseñar una aplicación para gestionar un campeonato de programación, 
//donde se introducen la puntuación (enteros) obtenidos por 5 programadores, 
//conforme van terminando su prueba. La aplicación debe mostrar las puntuaciones 
//ordenadas de los 5 participantes. En ocasiones, cuando finalizan los 5 participantes 
//anteriores, se suman al campeonato un máximo de 3 programadores de exhibición, 
//cuyos puntos se incluyen con el resto. La forma de especificar que no intervienen 
//más programadores de exhibición es introducir como puntuación un -1(menos 1) 
//La aplicación debe mostrar, finalmente, los puntos ordenados de todos los 
//participantes.

package Ejercicio5_6;
import javax.swing.*;

public class ejercicio5_6 extends JFrame {

    private int[] t = new int[8];
    private int cantidad = 0;

    public ejercicio5_6() {

        setTitle("Ejercicio 5.6");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField inputField = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");

        submitButton.addActionListener(e -> {

            try {
                int num = Integer.parseInt(inputField.getText());
                if (cantidad < 5) {
                    t[cantidad] = num;
                    cantidad++;
                    ordenar();
                    if (cantidad == 5) {
                        resultLabel.setText("Primeros 5 cargados. Puede ingresar hasta 3 de exhibición (-1 para terminar).");
                    } else {
                        resultLabel.setText(mostrar());
                    }

                } else {
                    if (num == -1) {
                        resultLabel.setText("Puntuaciones finales: " + mostrar());
                        submitButton.setEnabled(false);
                        inputField.setEnabled(false);
                        return;
                    }

                    if (cantidad == 8) {
                        resultLabel.setText("Ya se alcanzó el máximo de participantes.");
                        submitButton.setEnabled(false);
                        inputField.setEnabled(false);
                        return;
                    }
                    t[cantidad] = num;
                    cantidad++;
                    ordenar();
                    resultLabel.setText(mostrar());

                    if (cantidad == 8) {
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

        panel.add(new JLabel("Puntuacion: "));
        panel.add(inputField);
        panel.add(submitButton);
        panel.add(resultLabel);
        add(panel);

        setSize(600, 120);
        setLocationRelativeTo(null);
    }

    public void ordenar() {
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

    public String mostrar() {
        String texto = "";
        for (int i = 0; i < cantidad; i++) {
            texto += t[i] + " ";
        }
        return texto;
    }
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            ejercicio5_6 ejercicio = new ejercicio5_6();
            ejercicio.setVisible(true);
        });

    }
}