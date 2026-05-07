package Ejercicio2_13;
import javax.swing.*;

public class ejercicio2_13 extends JFrame {

    public ejercicio2_13() {
        setTitle("Ejercicios 2.13");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField s = new JTextField(10);
        JTextField m = new JTextField(10);
        JTextField h = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");


        submitButton.addActionListener(e -> {
            try {
                int seg = Integer.parseInt(s.getText());
                int min = Integer.parseInt(m.getText());
                int hora = Integer.parseInt(h.getText());
                seg++;
                if (seg > 59) {
                    seg = 0;
                    min++;
                    if (min > 59){
                        min = 0;
                        hora++;
                    } 
                    if (hora > 23){
                        hora = 0;
                    } 
                }
                else {
                    resultLabel.setText("Entrada invalida. Introduce una Hora Real");
                }
                resultLabel.setText("Hora + 1 Segundo: " + hora + ":" + min + ":" + seg);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada invalida. Introduce un numero");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Escriba los Segundos: "));
        panel.add(s);
        panel.add(new JLabel("Escriba Los Minutos: "));
        panel.add(m);
        panel.add(new JLabel("Escriba las Horas: "));
        panel.add(h);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 100);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicio2_13 ejercicio = new ejercicio2_13();
            ejercicio.setVisible(true);
        });
    }
}
    
