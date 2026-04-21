package EjercicioAd_2;
import javax.swing.*;

public class ejercicioAd_2 extends JFrame {

    public ejercicioAd_2() {
        setTitle("Ejercicio Adicional 2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField inputField = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");


        submitButton.addActionListener(e -> {
            try {
                double v= Double.parseDouble(inputField.getText());
                double ms = v/3.6;
                resultLabel.setText( v + " Kilometros por Hora Serian: " + ms + " Metros por Segundo");
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada invalida. Introduce un numero");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Escriba la Velocidad(km/h): "));
        panel.add(inputField);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 100);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicioAd_2 ejercicio = new ejercicioAd_2();
            ejercicio.setVisible(true);
        });
    }
}
    
    

