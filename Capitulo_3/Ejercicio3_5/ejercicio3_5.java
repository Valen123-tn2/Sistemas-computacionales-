package Ejercicio3_5;
import javax.swing.*;

public class ejercicio3_5 extends JFrame {
    
    public ejercicio3_5() {
        setTitle("Ejercicios 3.5");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField n = new JTextField(10);
        JTextField mi = new JTextField(10);
        JTextField ma = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");

        submitButton.addActionListener(e -> {
            try {
                int num = Integer.parseInt(n.getText());
                int min = Integer.parseInt(mi.getText());
                int max = Integer.parseInt(ma.getText());
                while (! (min <= num && num <= max)){
                    resultLabel.setText(num+ " No Pertenece al Rango");
                    break;
                }
                if (min <= num && num <= max){
                    resultLabel.setText(num+ " Pertenece al Rango");
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Introduce un número");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Valor Minimo del Rango: "));
        panel.add(mi);
        panel.add(new JLabel("Valor Maximo del Rango: "));
        panel.add(ma);
        panel.add(new JLabel("Ingrese un Numero: "));
        panel.add(n);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(700, 200);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            ejercicio3_5 ejercicio = new ejercicio3_5();
            ejercicio.setVisible(true);
        });
    }
}