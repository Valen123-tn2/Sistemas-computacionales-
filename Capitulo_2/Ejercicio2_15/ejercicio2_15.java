package Ejercicio2_15;
import javax.swing.*;

public class ejercicio2_15 extends JFrame {

    public ejercicio2_15() {
        setTitle("Ejercicios 2.15");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField d = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");


        submitButton.addActionListener(e -> {
            try {
                int dia = Integer.parseInt(d.getText());
    
                switch (dia){
                    case 0:
                        resultLabel.setText("Dia Inexistente, Pruebe Otro");
                        break;
                    case 1:
                        resultLabel.setText("Lunes");
                        break;
                    case 2:
                        resultLabel.setText("Martes");
                        break;
                    case 3:
                        resultLabel.setText("Miercoles");
                        break;
                    case 4:
                        resultLabel.setText("Jueves");
                        break;
                    case 5:
                        resultLabel.setText("Viernes");
                        break;
                    case 6:
                        resultLabel.setText("Sabado");
                        break;
                    case 7:
                        resultLabel.setText("Domingo");
                        break;
                } 
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada invalida. Introduce un numero");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Escriba un Numero del 1 al 7: "));
        panel.add(d);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 100);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicio2_15 ejercicio = new ejercicio2_15();
            ejercicio.setVisible(true);
        });
    }
}
    

