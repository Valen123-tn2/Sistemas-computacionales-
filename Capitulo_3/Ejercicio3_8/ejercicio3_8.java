package Ejercicio3_8;
import javax.swing.*;

public class ejercicio3_8 extends JFrame {
    
    public ejercicio3_8() {
        setTitle("Ejercicios 3.8");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField n = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");

        submitButton.addActionListener(e -> {
            try {
                int num = Integer.parseInt(n.getText());
                double facto = 1; 
                for (int i = num; i > 0; i--){
                    facto *= i;
                    resultLabel.setText("El Factorial de "+num+" es: "+facto);
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

            ejercicio3_8 ejercicio = new ejercicio3_8();
            ejercicio.setVisible(true);
        });
    }
}