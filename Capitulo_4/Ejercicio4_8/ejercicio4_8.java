package Ejercicio4_8;
import javax.swing.*;

public class ejercicio4_8 extends JFrame {

    public ejercicio4_8() {
        setTitle("Ejercicio 4.8");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField inputField = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");

        submitButton.addActionListener(e -> {
            try {
                int num1 = Integer.parseInt(inputField.getText());
                resultLabel.setText("Los divisores primos de "+ num1 + " son: " + numDP(num1));
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
    public static int numDP(int num){
        int cont;
        cont = 1;
        for (int i = 2; i <= num; i++ ){
            if (esPrimo(i) && num % i == 0){
                cont++;
            }
        }
        return (cont);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicio4_8 ejercicio = new ejercicio4_8();
            ejercicio.setVisible(true);
        });
    }
}

