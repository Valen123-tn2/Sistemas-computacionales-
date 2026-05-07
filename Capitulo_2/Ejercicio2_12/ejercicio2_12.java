package Ejercicio2_12;
import javax.swing.*;

public class ejercicio2_12 extends JFrame {

    public ejercicio2_12() {
        setTitle("Ejercicios 2.12");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField d = new JTextField(10);
        JTextField m = new JTextField(10);
        JTextField a = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");


        submitButton.addActionListener(e -> {
            try {
                int dia = Integer.parseInt(d.getText());
                int mes = Integer.parseInt(m.getText());
                int año = Integer.parseInt(a.getText());
                if (año == 0) {
                    resultLabel.setText("Fecha incorrecta");
                } else if (mes == 2 && (1 <= dia && dia <=28)){
                    resultLabel.setText("La Fecha es Correcta");
                } else if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && (1 <= dia && dia <= 30)){
                    resultLabel.setText("La Fecha es Correcta");
                } else if ((mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10|| mes == 12) && (1 <= dia && dia <= 31)){
                    resultLabel.setText("La Fecha es Correcta");
                } else {
                    resultLabel.setText("Entrada invalida. Introduce una Fecha Real");
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada invalida. Introduce un numero");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Escriba el Dia: "));
        panel.add(d);
        panel.add(new JLabel("Escriba el Mes: "));
        panel.add(m);
        panel.add(new JLabel("Escriba el Año: "));
        panel.add(a);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 100);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicio2_12 ejercicio = new ejercicio2_12();
            ejercicio.setVisible(true);
        });
    }
}
    

