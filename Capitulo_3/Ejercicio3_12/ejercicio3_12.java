package Ejercicio3_12;
import javax.swing.*;

public class ejercicio3_12 extends JFrame {

    int desaprobados = 0;
    int c = 0;

    public ejercicio3_12() {
        setTitle("Ejercicios 3.12");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField n = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");

        submitButton.addActionListener(e -> {
            try {
                for (int i = 0; i <= 5; i++){
                    int nota = Integer.parseInt(n.getText());
                    if (nota < 4){
                        desaprobados += 1;
                        resultLabel.setText("Nota Guardada");
                    }
                    c++;
                    break;
                }
                
                if (c == 5){
                    if (desaprobados > 0){
                        resultLabel.setText("Hay "+desaprobados+" Alumnos Desaprobados con menos de 4"); 
                    } else {
                        resultLabel.setText("No Hay Alumnos Desaprobados");
                    }
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
        setSize(700, 200);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicio3_12 ejercicio = new ejercicio3_12();
            ejercicio.setVisible(true);
        });
    }
}
