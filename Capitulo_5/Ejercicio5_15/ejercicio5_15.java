//Escribir la función rellenaPares () a la que se le pasa como  parámetro  una  
//tabla que debe rellenar de la siguiente forma: se leerá por teclado una serie de 
//números, guardando en la tabla los pares hasta que esté llena, e ignorando los 
//impares. La función tiene que devolver la cantidad de impares desechados.

package Ejercicio5_15;
import javax.swing.*;

public class ejercicio5_15 extends JFrame {

    private int[] t = new int[6];
    private int cantidad = 0;
    private int impares = 0;

    public ejercicio5_15() {

        setTitle("Ejercicio 5.15");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField inputField = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");

        submitButton.addActionListener(e -> {
            try {
                int num = Integer.parseInt(inputField.getText());
                impares = rellenaPares(num);
                if (cantidad == t.length) {
                    resultLabel.setText("<html>" + "Tabla: " + mostrar() + "<br>Impares desechados: " + impares+ "</html>");
                    submitButton.setEnabled(false);
                    inputField.setEnabled(false);
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

    public int rellenaPares(int num) {
        if (num % 2 == 0) {
            t[cantidad] = num;
            cantidad++;
        } else {
            impares++;
        }
        return impares;
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
            ejercicio5_15 ejercicio = new ejercicio5_15();
            ejercicio.setVisible(true);
        });

    }
}