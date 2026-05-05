package Ejercicio2_10;
import javax.swing.*;

public class ejercicio2_10 extends JFrame {

    public ejercicio2_10() {
        setTitle("Ejercicios 2.10");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField n1 = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");


        submitButton.addActionListener(e -> {
            try {
                int num = Integer.parseInt(n1.getText());
                int dm = Integer.parseInt(n1.getText());
                int um = Integer.parseInt(n1.getText());
                int c = Integer.parseInt(n1.getText());
                int d = Integer.parseInt(n1.getText());
                int u = Integer.parseInt(n1.getText());
                boolean capicua = false;
                u = num % 10;
                num = num / 10;
                d = num % 10;
                num = num / 10;
                c = num % 10;
                num = num / 10;
                um = num % 10;
                num = num / 10;
                dm = num % 10;
                num = num / 10;
                if (dm !=0 && dm == u && um == d) {
                    capicua = true;
                }
                if (dm == 0 && um != 0 && um == u && c == d) {
                    capicua = true;
                }
                if (dm == 0 && um == 0 && c != 0 && c == u) {
                    capicua = true;
                }
                if (dm == 0 && um == 0 && c == 0 && d != 0 && d == u) {
                    capicua = true;
                }

                if (capicua) {
                    resultLabel.setText("El Numero es Capicua");
                } else {
                    resultLabel.setText("El Numero no es Capicua");
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada invalida. Introduce un numero");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Escriba un Numero: "));
        panel.add(n1);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 100);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicio2_10 ejercicio = new ejercicio2_10();
            ejercicio.setVisible(true);
        });
    }
}
    



