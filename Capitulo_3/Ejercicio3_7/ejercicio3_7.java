package Ejercicio3_7;
import javax.swing.*;

public class ejercicio3_7 extends JFrame {
    
    public ejercicio3_7() {
        setTitle("Ejercicios 3.7");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");

        submitButton.addActionListener(e -> {
            try {
                double producto = 1;
                for (int i = 1; i < 20; i+= 2){
                    producto = producto * i;
                }
                resultLabel.setText("El Producto de los 10 Primeros Numeros Impares es: "+producto);
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

            ejercicio3_7 ejercicio = new ejercicio3_7();
            ejercicio.setVisible(true);
        });
    }
}