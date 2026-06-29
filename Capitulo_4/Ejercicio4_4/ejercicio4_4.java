package Ejercicio4_4;
import javax.swing.*;

public class ejercicio4_4 extends JFrame {

    public ejercicio4_4() {
        setTitle("Ejercicio 4.4");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField inputField1 = new JTextField(10);
        JTextField inputField2 = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");

        submitButton.addActionListener(e -> {
            try {
                int num1 = Integer.parseInt(inputField1.getText());
                int num2 = Integer.parseInt(inputField2.getText());

                resultLabel.setText("El numero mayor es: " + maximo(num1,num2));

            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Introduce números.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Escriba el primer numero: "));
        panel.add(inputField1);
        panel.add(new JLabel("Escriba el segundo numero: "));
        panel.add(inputField2);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 120);
        setLocationRelativeTo(null);
    }

    public static int maximo(int a, int b) {
        int max;
        if (a > b){
            max = a;
        } else {
            max = b;
        }
       return (max);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicio4_4 ejercicio = new ejercicio4_4();
            ejercicio.setVisible(true);
        });
    }
}