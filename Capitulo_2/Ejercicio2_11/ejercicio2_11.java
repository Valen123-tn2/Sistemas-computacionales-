package Ejercicio2_11;
import javax.swing.*;

public class ejercicio2_11 extends JFrame {

    public ejercicio2_11() {
        setTitle("Ejercicios 2.11");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField n1 = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");


        submitButton.addActionListener(e -> {
            try {
                int nota = Integer.parseInt(n1.getText());
                if (0<= nota && nota < 5) {
                    resultLabel.setText("Insuficiente");
                } else if (nota == 5){
                    resultLabel.setText("Suficiente");
                } else if (nota == 6){
                    resultLabel.setText("Bien");
                } else if (nota == 7 || nota == 8){
                    resultLabel.setText("Notable");
                } else if (nota == 9 || nota == 10){
                    resultLabel.setText("Sobresaliente");
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada invalida. Introduce un numero");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Escriba La Nota: "));
        panel.add(n1);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 100);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicio2_11 ejercicio = new ejercicio2_11();
            ejercicio.setVisible(true);
        });
    }
}
    
