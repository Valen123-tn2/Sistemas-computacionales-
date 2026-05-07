package Ejercicio2_14;
import javax.swing.*;

public class ejercicio2_14 extends JFrame {

    public ejercicio2_14() {
        setTitle("Ejercicios 2.14");
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
                int dmes = 0;

                if (mes == 2){
                    dmes = 28;
                } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11){
                    dmes = 30;
                } else if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10|| mes == 12){
                    dmes = 31;
                } else {
                    resultLabel.setText("Entrada invalida. Introduce una Fecha Real");
                }

                dia++; 

                if (dia < dmes){
                    dia = 1; 
                    mes++;

                    if (mes > 12){
                        mes = 1;
                        año++;
                    }
                }
                if (año == 0){
                    año = 1;
                }
                resultLabel.setText(dia + "/" + mes + "/" + año);
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
            ejercicio2_14 ejercicio = new ejercicio2_14();
            ejercicio.setVisible(true);
        });
    }
}
    
