package EjercicioAd_4;
import javax.swing.*;

public class ejercicioAd_4 extends JFrame {

    public ejercicioAd_4() {
        setTitle("Ejercicio Adicional 4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField InputField = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");


        submitButton.addActionListener(e -> {
            try {
                double radio= Double.parseDouble(InputField.getText());
                double pi = 3.1416;
                double vol = (4.0 / 3.0) * pi * radio * radio * radio;
                resultLabel.setText("El Volumen de la Esfera es: " + vol);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada invalida. Introduce un numero");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Escriba la Longitud del Radio de la Esfera: "));
        panel.add(InputField);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 100);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicioAd_4 ejercicio = new ejercicioAd_4();
            ejercicio.setVisible(true);
        });
    }
}
    
    

