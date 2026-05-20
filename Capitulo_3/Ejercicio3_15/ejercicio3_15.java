package Ejercicio3_15;
import javax.swing.*;

public class ejercicio3_15 extends JFrame {

    boolean primo;
    int cprimos = 0;
    
    public ejercicio3_15() {
        setTitle("Ejercicios 3.15");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField n = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");

        submitButton.addActionListener(e -> {
            try {
                int num = Integer.parseInt(n.getText());
                for (int i = 1; i <= num; i++){
                    primo = true;
                    int j = 2;
                    while (j <= i -1 && primo == true){
                        if (i % j == 0){
                            primo = false;
                        }
                        j++;
                    }
                    if (primo){
                        cprimos++;
                        resultLabel.setText(i+" es Primo");
                    }
                }
                resultLabel.setText("Del 1 a "+num+", Hay "+cprimos+" Numeros Primos");
                cprimos = 0;
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
        setSize(400, 400);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            ejercicio3_15 ejercicio = new ejercicio3_15();
            ejercicio.setVisible(true);
        });
    }
}
