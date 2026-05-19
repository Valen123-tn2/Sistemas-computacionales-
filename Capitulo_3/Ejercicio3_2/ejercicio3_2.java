package Ejercicio3_2;
import javax.swing.*;

public class ejercicio3_2 extends JFrame {
    
    int sumed = 0;
    int alumnos = 0;
    int mayores = 0;

    public ejercicio3_2() {
        setTitle("Ejercicios 3.2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField n = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");

        submitButton.addActionListener(e -> {
            try {
                int edad = Integer.parseInt(n.getText());
                while (edad >= 0) {
                    sumed += edad;
                    alumnos++;
                    if (edad >= 18) {
                        mayores++;
                    }
                    double media = (double) sumed / alumnos;
                    resultLabel.setText("Suma: " + sumed +" | Media: " + media +" | Alumnos: " + alumnos +" | Mayores: " + mayores);
                    n.setText("");
                    break;
                }
                if (edad < 0) {
                    double media = (double) sumed / alumnos;
                    JOptionPane.showMessageDialog(null,"RESULTADOS FINALES\n\n" +"Suma edades: " + sumed +"\nMedia: " + media +"\nCantidad alumnos: " + alumnos +"\nMayores de edad: " + mayores);
                }

            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Introduce un número");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Ingrese una edad: "));
        panel.add(n);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(700, 200);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            ejercicio3_2 ejercicio = new ejercicio3_2();
            ejercicio.setVisible(true);
        });
    }
}