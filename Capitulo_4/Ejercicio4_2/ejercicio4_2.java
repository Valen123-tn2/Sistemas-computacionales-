package Ejercicio4_2;
import javax.swing.*;

public class ejercicio4_2 extends JFrame {

    public ejercicio4_2() {
        setTitle("Ejercicio 4.2");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField inputField1 = new JTextField(10);
        JTextField inputField2 = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");

        submitButton.addActionListener(e -> {
            try {
                int n1 = Integer.parseInt(inputField1.getText());
                int n2 = Integer.parseInt(inputField2.getText());

                mostrar(n1, n2, resultLabel);

            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Introduce números.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Primer número: "));
        panel.add(inputField1);
        panel.add(new JLabel("Segundo número: "));
        panel.add(inputField2);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 120);
        setLocationRelativeTo(null);
    }

    public static void mostrar(int a, int b, JLabel label) {
        String texto = "";
        int menor = Math.min(a, b);
        int mayor = Math.max(a, b);
        for (int i = menor; i <= mayor; i++) {
            texto += i + " ";
        }
        label.setText(texto);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicio4_2 ejercicio = new ejercicio4_2();
            ejercicio.setVisible(true);
        });
    }
}