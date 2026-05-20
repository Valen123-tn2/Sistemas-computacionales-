package Ejercicio3_13;
import javax.swing.*;

public class ejercicio3_13 extends JFrame {

    int aprobados = 0;
    int desaprobados = 0;
    int condicionados = 0;
    int c = 0;
    
    public ejercicio3_13() {
        setTitle("Ejercicios 3.13");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField n = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");

        submitButton.addActionListener(e -> {
            try {
                for (int i = 1; i <= 6; i++){
                    int nota = Integer.parseInt(n.getText());
                    if (nota == 4){
                        condicionados++;
                        resultLabel.setText("Nota Guardada");
                    } else if (nota >= 5){
                        aprobados++;
                        resultLabel.setText("Nota Guardada");
                    } else if (nota <= 4){
                        desaprobados++;
                        resultLabel.setText("Nota Guardada");
                    }
                    c++;
                    break;
                }
                if (c == 6){
                    resultLabel.setText("Aprobados: "+aprobados+" | Desaprobados: "+desaprobados+" | Condicionados: "+condicionados);
                }
                n.setText("");
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Introduce un número");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Ingrese la Nota: "));
        panel.add(n);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(400, 200);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            ejercicio3_13 ejercicio = new ejercicio3_13();
            ejercicio.setVisible(true);
        });
    }
}