package Ejercicio3_11;
import javax.swing.*;

public class ejercicio3_11 extends JFrame {
    
    public ejercicio3_11() {
        setTitle("Ejercicios 3.11");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton submitButton = new JButton("Enviar");
        JTextArea resultArea = new JTextArea(15, 40);
        resultArea.setEditable(false);

        submitButton.addActionListener(e -> {
            try {
                resultArea.setText("");
                for (int tabla = 1; tabla <= 10; tabla++){
                    for (int i = 1; i <= 10; i++){
                        resultArea.append(tabla +" x "+ i + " = "+ tabla*i+ " | "+"\t"); 
                    }

                    resultArea.append("\n");
                }
            } catch (NumberFormatException ex) {
                resultArea.setText("Entrada inválida. Introduce un número");
            }
        });

        JPanel panel = new JPanel();
        panel.add(submitButton);
        panel.add(resultArea);

        add(panel);
        setSize(900, 400);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            ejercicio3_11 ejercicio = new ejercicio3_11();
            ejercicio.setVisible(true);
        });
    }
}
