//Crear una tabla bidimensional de tamaño 5 x 5 y rellenarla de la siguiente forma: 
//la posición [n, m] debe contener n + m. Después se debe mostrar su contenido.

package Ejercicio5_12;
import javax.swing.*;

public class ejercicio5_12 extends JFrame {

    private int[][] t = new int[5][5];

    public ejercicio5_12() {

        setTitle("Ejercicio 5.12");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");

        submitButton.addActionListener(e -> {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                t[i][j] = i + j;
                }
            }
            String texto = "<html>";
            for (int i = 4; i >= 0; i--) {
                for (int j = 0; j < 5; j++) {
                    texto += t[i][j] + " ";
                }
                texto += "<br>";
            }
            texto += "</html>";
            resultLabel.setText(texto);
            submitButton.setEnabled(false);
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel());
        panel.add(submitButton);
        panel.add(resultLabel);
        add(panel);

        setSize(400, 220);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            ejercicio5_12 ejercicio = new ejercicio5_12();
            ejercicio.setVisible(true);
        });

    }
}