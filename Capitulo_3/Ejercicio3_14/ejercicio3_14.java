package Ejercicio3_14;
import javax.swing.*;

public class ejercicio3_14 extends JFrame {
    
    public ejercicio3_14() {
        setTitle("Ejercicios 3.14");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField n = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JTextArea resultArea = new JTextArea(15, 20);
        resultArea.setEditable(false);

        submitButton.addActionListener(e -> {
            try {
                int num = Integer.parseInt(n.getText());
                resultArea.setText("");
                for (int fila = 1; fila <= num; fila++){
                    for (int col = fila; col <= num; col++){
                        resultArea.append("* ");
                    }
                    resultArea.append("\n");
                }
            } catch (NumberFormatException ex) {
                resultArea.setText("Entrada inválida. Introduce un número");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Ingrese un Numero: "));
        panel.add(n);
        panel.add(submitButton);
        panel.add(resultArea);

        add(panel);
        setSize(400, 400);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            ejercicio3_14 ejercicio = new ejercicio3_14();
            ejercicio.setVisible(true);
        });
    }
}
