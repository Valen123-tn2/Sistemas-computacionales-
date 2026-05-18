package Ejercicio3_1;
import javax.swing.*;

public class ejercicio3_1 extends JFrame {

    public ejercicio3_1() {
        setTitle("Ejercicios 3.1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField n = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");

        submitButton.addActionListener(e -> {
            try {
                int num = Integer.parseInt(n.getText());
                while (num != 0) {
                    boolean par = num % 2 == 0 ? true : false;
                    boolean positivo =  num >= 0 ? true : false;
                    resultLabel.setText("Es Par?: "+par+" Es Positivo?: "+positivo+" Su Cuadrado es: "+ num*num);
                    num = Integer.parseInt(n.getText());  
                    n.setText("");
                    break;
                }
               
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada invalida. Introduce un numero");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Ingrese un numero: "));
        panel.add(n);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 200);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicio3_1 ejercicio = new ejercicio3_1();
            ejercicio.setVisible(true);
        });
    }
}
