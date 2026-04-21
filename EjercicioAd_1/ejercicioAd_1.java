package EjercicioAd_1;
import javax.swing.*;

public class ejercicioAd_1 extends JFrame {

    public ejercicioAd_1() {
        setTitle("Ejercicio Adicional 1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField inputField = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("Grados Centigrados Serian: ");


        submitButton.addActionListener(e -> {
            try {
                double c= Double.parseDouble(inputField.getText());
                double Fare = 32 + (9*c/5);
                resultLabel.setText( c + " Grados Centigrados Seriam: " + Fare + " Grados Fahrenheit");
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada invalida. Introduce un numero");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Escriba los Grados Centigrados: "));
        panel.add(inputField);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 100);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicioAd_1 ejercicio = new ejercicioAd_1();
            ejercicio.setVisible(true);
        });
    }
}
    