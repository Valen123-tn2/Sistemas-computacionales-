package Ejercicio2_17;
import javax.swing.*;

public class ejercicio2_17 extends JFrame {

    public ejercicio2_17() {
        setTitle("Ejercicios 2.17");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField c = new JTextField(10);
        JTextField n = new JTextField(10);
        JTextField k = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");


        submitButton.addActionListener(e -> {
            try {
                double cd = Double.parseDouble(c.getText());
                double na = Double.parseDouble(n.getText());
                double kpa = Double.parseDouble(k.getText());
                double total = na * kpa;

                if (cd == 0 || total == 0) {
                    resultLabel.setText("No se Puede Dividir por Cero");
                } else {
                    double t = cd/total;
                    if (t >= 1) {
                        resultLabel.setText("Hay Comida Suficiente");
                    } else if (t < 1){
                        resultLabel.setText("No Hay Comida Suficiente, Se le debe dar " + t + " Kilos de Comida a Cada Uno"); 
                    }   
                } 
                
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada invalida. Introduce un numero");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Escriba la Cantidad de Comida Diaria: "));
        panel.add(c);
        panel.add(new JLabel("Escriba el Numero de Animales a Alimentar: "));
        panel.add(n);
        panel.add(new JLabel("Escriba la Media que Come Cada Animal: "));
        panel.add(k);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 200);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicio2_17 ejercicio = new ejercicio2_17();
            ejercicio.setVisible(true);
        });
    }
}
