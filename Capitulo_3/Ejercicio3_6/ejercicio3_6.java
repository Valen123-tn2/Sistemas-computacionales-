package Ejercicio3_6;
import javax.swing.*;

public class ejercicio3_6 extends JFrame {
    
    public ejercicio3_6() {
        setTitle("Ejercicios 3.6");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");

        submitButton.addActionListener(e -> {
            try {
                resultLabel.setText("");
                for (int i = 0; i < 100; i+= 7){
                    resultLabel.setText(resultLabel.getText() + i + " | ");
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Introduce un número");
            }
        });

        JPanel panel = new JPanel();
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(700, 200);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            ejercicio3_6 ejercicio = new ejercicio3_6();
            ejercicio.setVisible(true);
        });
    }
}