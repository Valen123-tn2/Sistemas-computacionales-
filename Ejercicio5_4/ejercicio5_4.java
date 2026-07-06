// Implementar un programa que inicialice una tabla con nuestros números favoritos.
// A continuación, pedir al usuario el índice de un elemento que será eliminado de la 
// tabla. Continuaremos eliminando elementos hasta que el índice introducido sea 
// negativo o hasta que no existan más elementos que borrar. Es imprescindible 
// controlar que el índice leído corresponde a un dato válido.

package Ejercicio5_4;
import javax.swing.*;

public class ejercicio5_4 extends JFrame {

    private int cantidad = 6;
    private int[] t = {5, 12, 7, 20, 8, 15}; 
    private int indice = 1;

    public ejercicio5_4() {

        setTitle("Ejercicio 5.4");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField inputField1 = new JTextField(10);
        JButton submitButton = new JButton("Eliminar");
        JLabel resultLabel = new JLabel(mostrar());

        submitButton.addActionListener(e -> {

            try {
                int num = Integer.parseInt(inputField1.getText());
                if (num < 0) {
                    resultLabel.setText("Programa finalizado.");
                    submitButton.setEnabled(false);
                    return;
                }
                indice = num - 1;
                if (cantidad == 0) {
                    resultLabel.setText("No quedan elementos.");
                    submitButton.setEnabled(false);
                    return;
                }

                if (indice >= cantidad) {
                    resultLabel.setText("Índice inválido. " + mostrar());
                    return;
                }
                eliminar(indice);

                if (cantidad == 0) {
                    resultLabel.setText("No quedan elementos.");
                    submitButton.setEnabled(false);
                } else {
                    resultLabel.setText(mostrar());
                }

            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida.");
            }

        });

        JPanel panel = new JPanel();

        panel.add(new JLabel("Índice: "));
        panel.add(inputField1);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);

        setSize(600, 120);
        setLocationRelativeTo(null);
    }

    public void eliminar(int indice) {
        for (int i = indice; i < cantidad - 1; i++) {
            t[i] = t[i + 1];
        }
        t[cantidad - 1] = 0;
        cantidad--;
    }

    public String mostrar() {
        String texto = "Arreglo: ";
        for (int i = 0; i < cantidad; i++) {
            texto += t[i] + " ";
        }
        return texto;
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            ejercicio5_4 ejercicio = new ejercicio5_4();
            ejercicio.setVisible(true);
        });

    }
}