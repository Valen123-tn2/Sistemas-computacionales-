package Ejercicio3_3;
import javax.swing.*;

public class ejercicio3_3 extends JFrame {
    
    int numse = (int) (Math.random()*100+1);

    public ejercicio3_3() {
        setTitle("Ejercicios 3.3");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField n = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");

        submitButton.addActionListener(e -> {
            try {
                int num = Integer.parseInt(n.getText());
                while (numse != num && num != -1) {
                    if (numse < num){
                        resultLabel.setText("Menor");
                    } else {
                        resultLabel.setText("Mayor");
                    } 
                    n.setText("");
                    break;
                }
                if (numse == num){
                    resultLabel.setText("Adivinaste");
                } else if (num == -1) {
                     resultLabel.setText("En Otro Momento Sera");
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Introduce un número");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Ingrese un Numero|Ingrese -1 para Rendirse: "));
        panel.add(n);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(700, 200);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            ejercicio3_3 ejercicio = new ejercicio3_3();
            ejercicio.setVisible(true);
        });
    }
}