package Ejercicio4_11;
import javax.swing.*;

public class ejercicio4_11 extends JFrame {

    public ejercicio4_11() {
        setTitle("Ejercicio 4.11");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField inputField1 = new JTextField(10);
        JTextField inputField2 = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");

        submitButton.addActionListener(e -> {
            try {
                double base = Double.parseDouble(inputField1.getText());
                int exp = Integer.parseInt(inputField2.getText());
                double res = aElevadoN(base, exp);
                resultLabel.setText(base + " elevado a " + exp + " = " + res);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Introduce numeros validos.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Escriba la base: "));
        panel.add(inputField1);
        panel.add(new JLabel("Escriba el exponente: "));
        panel.add(inputField2);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 120);
        setLocationRelativeTo(null);
    }

    public static double aElevadoN(double a, int n){
        double res = 1;
        if (n == 0){
            res += 1;     
        } else {
            for (int i = 1; i <= n; i++){
                res = res * a;
            }
        }
        return (res);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicio4_11 ejercicio = new ejercicio4_11();
            ejercicio.setVisible(true);
        });
    }
}


