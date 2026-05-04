package Ejercicio2_5;
import javax.swing.*;

public class ejercicio2_5 extends JFrame {

    public ejercicio2_5() {
        setTitle("Ejercicios 2.5");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField InputField = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");


        submitButton.addActionListener(e -> {
            try {
                double num = Double.parseDouble(InputField.getText());
                if (-1 < num && num != 0){
                    resultLabel.setText( "El Numero es Casi-Cero");    
                } else {
                    resultLabel.setText("El Numero No es Casi-Cero ");
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada invalida. Introduce un numero");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Escriba un Numero: "));
        panel.add(InputField);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 100);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicio2_5 ejercicio = new ejercicio2_5();
            ejercicio.setVisible(true);
        });
    }
}
    
