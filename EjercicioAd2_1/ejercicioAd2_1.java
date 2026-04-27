package EjercicioAd2_1;
import javax.swing.*;

public class ejercicioAd2_1 extends JFrame {

    public ejercicioAd2_1() {
        setTitle("Ejercicios Adicionales 2.1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField l1 = new JTextField(10);
        JTextField l2 = new JTextField(10);
        JTextField l3 = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");


        submitButton.addActionListener(e -> {
            try {
                double la1 = Double.parseDouble(inputField.getText());
                double la2 = Double.parseDouble(inputField.getText());
                double la3 = Double.parseDouble(inputField.getText());
                double p = (la1 + la2 + la3)/2;
                double area = math.sqrt(p*(p-a)*(p-b)*(p-c));
                resultLabel.setText( "El Area del Triangulo es: " + area);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada invalida. Introduce un numero");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Escriba el primer lado: "));
        panel.add(l1);
        panel.add(new JLabel("Escriba el segundo lado: "));
        panel.add(l2);
        panel.add(new JLabel("Escriba el tercer lado: "));
        panel.add(l3);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 100);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicioAd2_1 ejercicio = new ejercicioAd2_1();
            ejercicio.setVisible(true);
        });
    }
}
    