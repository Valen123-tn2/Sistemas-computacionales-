package Ejercicio1_3;
import javax.swing.*;

public class ejercicio1_3 extends JFrame {

    public ejercicio1_3() {
        setTitle("Ejercicio 1.1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField inputField = new JTextField(10);
        JTextField inputField2 = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("Tu Edad es: ");

        submitButton.addActionListener(e -> {
            try {
                int numAc = Integer.parseInt(inputField.getText());
                int num = Integer.parseInt(inputField2.getText());
                resultLabel.setText("Tu Edad es: " + (num - numAc));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada invalida. Introduce un numero");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Escriba el Año actual: "));
        panel.add(inputField2);
        panel.add(submitButton);
        panel.add(resultLabel);
        panel.add(new JLabel("Escriba su Año de Nacimiento: "));
        panel.add(inputField);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 100);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
           ejercicio1_3 ejercicio = new ejercicio1_3();
            ejercicio.setVisible(true);
        });
    }
}
    

