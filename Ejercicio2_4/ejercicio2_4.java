package Ejercicio2_4;
import javax.swing.*;

public class ejercicio2_4 extends JFrame {

    public ejercicio2_4() {
        setTitle("Ejercicios 2.4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField n1 = new JTextField(10);
        JTextField n2 = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");


        submitButton.addActionListener(e -> {
            try {
                int num1 = Integer.parseInt(n1.getText());
                int num2 = Integer.parseInt(n2.getText());
                if (num1 == num2){
                    resultLabel.setText( "Los Numeros son Iguales");    
                } if (num1 > num2){
                    resultLabel.setText( num1 + " es Mayor que " + num2);
                } else {
                    resultLabel.setText( num2 + " es Mayor que " + num1);
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada invalida. Introduce un numero");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Escriba el Primer Numero: "));
        panel.add(n1);
        panel.add(new JLabel("Escriba el Segundo Numero: "));
        panel.add(n2);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 100);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicio2_4 ejercicio = new ejercicio2_4();
            ejercicio.setVisible(true);
        });
    }
}
    