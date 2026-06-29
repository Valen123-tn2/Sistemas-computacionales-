package Ejercicio4_9;
import javax.swing.*;

public class ejercicio4_9 extends JFrame {

    public ejercicio4_9() {
        setTitle("Ejercicio 4.9");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField inputField = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");

        submitButton.addActionListener(e -> {
            try {
                int num = Integer.parseInt(inputField.getText());
                divisoresPrimosO(num, resultLabel);
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
    public static void divisoresPrimosO(int num, JLabel label){
        String texto = "Los divisores primos de "+ num + " son: ";
        for (int i = 1; i <= num; i++ ){
            if (esPrimo(i) && num % i == 0){
                texto += i + ", ";
            }
        }
        label.setText(texto);  
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicio4_9 ejercicio = new ejercicio4_9();
            ejercicio.setVisible(true);
        });
    }
}

