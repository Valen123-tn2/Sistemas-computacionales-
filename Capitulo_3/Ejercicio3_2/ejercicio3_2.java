package Ejercicio3_2;
import javax.swing.*;

public class ejercicio3_2 extends JFrame {

    public ejercicio3_2() {
        setTitle("Ejercicios 3.2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField n = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");

        submitButton.addActionListener(e -> {
            try {
                int sumed = 0;
                int alumnos = 0;
                int mayores = 0;
                double media;
                int edad = Integer.parseInt(n.getText());
                while (edad >= 0) {
                    sumed += edad;
                    alumnos++;
                    if (edad >= 18){
                        mayores++;
                    }
                    edad = Integer.parseInt(n.getText());
                    
                    n.setText("");
                    break;
                }
                media = (double) sumed / alumnos;
                resultLabel.setText("Suma de todas las edades: "+ sumed+ 
                "  Media: "+ media
                );
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada invalida. Introduce un numero");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Ingrese un numero: "));
        panel.add(n);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 200);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicio3_2 ejercicio = new ejercicio3_2();
            ejercicio.setVisible(true);
        });
    }
}
