package Ejercicio4_5;
import javax.swing.*;

public class ejercicio4_5 extends JFrame {

    public ejercicio4_5() {
        setTitle("Ejercicio 4.5");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField inputField1 = new JTextField(10);
        JTextField inputField2 = new JTextField(10);
        JTextField inputField3 = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");

        submitButton.addActionListener(e -> {
            try {
                int num1 = Integer.parseInt(inputField1.getText());
                int num2 = Integer.parseInt(inputField2.getText());
                int num3 = Integer.parseInt(inputField3.getText());

                resultLabel.setText("El numero mayor es: " + maximo(num1,num2,num3));

            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Introduce números.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Escriba el primer numero: "));
        panel.add(inputField1);
        panel.add(new JLabel("Escriba el segundo numero: "));
        panel.add(inputField2);
        panel.add(new JLabel("Escriba el tercer numero: "));
        panel.add(inputField3);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 120);
        setLocationRelativeTo(null);
    }

    public static int maximo(int a, int b, int c) {
        int max;
        if (a > b){
            max = a;
        } else {
            max = b;
        }
        if (c > max){
            max = c;
        }
       return (max);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicio4_5 ejercicio = new ejercicio4_5();
            ejercicio.setVisible(true);
        });
    }
}
