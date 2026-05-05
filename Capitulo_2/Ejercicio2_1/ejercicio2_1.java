package Ejercicio2_1;
import javax.swing.*;

public class ejercicio2_1 extends JFrame {

    public ejercicio2_1() {
        setTitle("Ejercicio 2.1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField InputField = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");


        submitButton.addActionListener(e -> {
            try {
                int num = Integer.parseInt(InputField.getText());
                if (num %2 == 0){
                    resultLabel.setText( "Su Numero es Par");    
                } else {
                    resultLabel.setText( "Su Numero es Impar");
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
            ejercicio2_1 ejercicio = new ejercicio2_1();
            ejercicio.setVisible(true);
        });
    }
}
    