package Ejercicio4_7;
import javax.swing.*;

public class ejercicio4_7 extends JFrame {

    public ejercicio4_7() {
        setTitle("Ejercicio 4.7");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField inputField = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");

        submitButton.addActionListener(e -> {
            try {
                int num1 = Integer.parseInt(inputField.getText());
                if (esPrimo(num1)){
                    resultLabel.setText("El numero es primo");
                } else {
                    resultLabel.setText("El numero no es primo");
                }  

            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Introduce una sola letra.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Escriba un numero: "));
        panel.add(inputField);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 120);
        setLocationRelativeTo(null);
    }

    public static boolean esPrimo(int a) {
        boolean primo = true;
        int i = 2;
        if (a < 2){
            primo = false;
        } 
        while (i < a && primo == true){
            if (a % i == 0){
                primo = false;
            }
            i++;
        }
       return (primo);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicio4_7 ejercicio = new ejercicio4_7();
            ejercicio.setVisible(true);
        });
    }
}

