package ejercicio1_4;
import javax.swing.*;

public class Ejercicio1_4 extends JFrame {

    public Ejercicio1_4() {
        setTitle("Ejercicios 1.4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField n1 = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");
        JLabel resultLabel1 = new JLabel("");
        JLabel resultLabel2 = new JLabel("");
        JLabel resultLabel3 = new JLabel("");

        submitButton.addActionListener(e -> {
            try {
                short num = Short.parseShort(n1.getText());

                resultLabel.setText("Ingresado: " + num);

                resultLabel1.setText("Valor máximo para short: " + Short.MAX_VALUE);
                resultLabel2.setText("Valor mínimo para short: " + Short.MIN_VALUE);

                num++;
                resultLabel3.setText("Después de incrementar: " + num);

            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Introduce un número");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Escriba un Numero: "));
        panel.add(n1);
        panel.add(submitButton);
        panel.add(resultLabel);
        panel.add(resultLabel1);
        panel.add(resultLabel2);
        panel.add(resultLabel3);


        add(panel);
        setSize(600, 100);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Ejercicio1_4 ejercicio = new Ejercicio1_4();
            ejercicio.setVisible(true);
        });
    }
}
