package Ejercicio4_10;
import javax.swing.*;

public class ejercicio4_10 extends JFrame {

    public ejercicio4_10() {
        setTitle("Ejercicio 4.10");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField inputField1 = new JTextField(10);
        JTextField inputField2 = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");

        submitButton.addActionListener(e -> {
            try {
                int num1 = Integer.parseInt(inputField1.getText());
                int num2 = Integer.parseInt(inputField2.getText());
                if (amigos(num1,num2)){
                    resultLabel.setText(num1 +" y " + num2 + " son amigos");  
                } else {
                    resultLabel.setText(num1 +" y " + num2 + " no son amigos");
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Introduce numeros validos.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Escriba un numero: "));
        panel.add(inputField1);
        panel.add(new JLabel("Escriba otro numero: "));
        panel.add(inputField2);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 120);
        setLocationRelativeTo(null);
    }

    public static boolean amigos(int a, int b){
        boolean amigos;
        if  (a == sumaDP(b) && b == sumaDP(a)) {
            amigos = true;
        } else {
            amigos = false;
        }
        return (amigos);
    }

    public static int sumaDP(int num){
        int suma = 0;
        for (int i = 1; i < num; i++){
            if (num % i == 0){
                suma += i;
            }
        }
        return (suma);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicio4_10 ejercicio = new ejercicio4_10();
            ejercicio.setVisible(true);
        });
    }
}


