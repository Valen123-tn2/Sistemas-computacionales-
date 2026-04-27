package EjercicioAd2_2;
import javax.swing.*;

public class ejercicioAd2_2 extends JFrame {

    public ejercicioAd2_2() {
        setTitle("Ejercicios Adicionales 2.2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField inputField = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");


        submitButton.addActionListener(e -> {
            try {
                int num = Integer.parseInt(inputField.getText());
                int c1 = num/100;
                int c2 = (num/10)%10;
                int c3 = num%10;
                resultLabel.setText( "Las Cifras de "+ num +" son: "+ c1 + "" + c2 + "" + c3);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada invalida. Introduce un numero");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Escriba un Numero de Tres Cifras: "));
        panel.add(inputField);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 100);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicioAd2_2 ejercicio = new ejercicioAd2_2();
            ejercicio.setVisible(true);
        });
    }
}
    