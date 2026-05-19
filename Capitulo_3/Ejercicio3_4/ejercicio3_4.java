package Ejercicio3_4;
import javax.swing.*;

public class ejercicio3_4 extends JFrame {
    
    public ejercicio3_4() {
        setTitle("Ejercicios 3.4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField n = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");

        submitButton.addActionListener(e -> {
            try {
                int num = Integer.parseInt(n.getText());
                resultLabel.setText("");
                for (int i = 1; i <= num; i++){
                    resultLabel.setText(resultLabel.getText() + i + " | ");
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Introduce un número");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Ingrese un Numero: "));
        panel.add(n);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(700, 200);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            ejercicio3_4 ejercicio = new ejercicio3_4();
            ejercicio.setVisible(true);
        });
    }
}