package EjercicioAd2_3;
import javax.swing.*;

public class ejercicioAd2_3 extends JFrame {

    public ejercicioAd2_3() {
        setTitle("Ejercicios Adicionales 2.3");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField inputField = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");
        JLabel resultLabel1 = new JLabel("");
        JLabel resultLabel2 = new JLabel("");
        JLabel resultLabel3 = new JLabel("");
        JLabel resultLabel4 = new JLabel("");
        JLabel resultLabel5 = new JLabel("");


        submitButton.addActionListener(e -> {
            try {
                int num = Integer.parseInt(inputField.getText());
                int c1 = num / 10000;
                int c2 = (num / 1000) % 10;
                int c3 = (num / 100) % 10;
                int c4 = (num / 10) % 10;
                int c5 = num % 10;
                resultLabel.setText( "Las Cifras de "+ num +" son: ");
                resultLabel1.setText(c1);
                resultLabel2.setText(c1 + c2);
                resultLabel3.setText(c1 + c2 + c3);
                resultLabel4.setText(c1 + c2 + c3 + c4);
                resultLabel5.setText(c1 + c2 + c3 + c4 + c5);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada invalida. Introduce un numero");
                resultLabel1.setText("Entrada invalida. Introduce un numero");
                resultLabel2.setText("Entrada invalida. Introduce un numero");
                resultLabel3.setText("Entrada invalida. Introduce un numero");
                resultLabel4.setText("Entrada invalida. Introduce un numero");
                resultLabel5.setText("Entrada invalida. Introduce un numero");

            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Escriba un Numero de Cinco Cifras: "));
        panel.add(inputField);
        panel.add(submitButton);
        panel.add(resultLabel);
        panel.add(resultLabel1);
        panel.add(resultLabel2);
        panel.add(resultLabel3);
        panel.add(resultLabel4);
        panel.add(resultLabel5);


        add(panel);
        setSize(600, 100);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicioAd2_3 ejercicio = new ejercicioAd2_3();
            ejercicio.setVisible(true);
        });
    }
}
    
    
