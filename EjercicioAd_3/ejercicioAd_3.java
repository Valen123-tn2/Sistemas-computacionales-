package EjercicioAd_3;
import javax.swing.*;

public class ejercicioAd_3 extends JFrame {

    public ejercicioAd_3() {
        setTitle("Ejercicio Adicional 3");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField ca1 = new JTextField(10);
        JTextField ca2 = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");


        submitButton.addActionListener(e -> {
            try {
                double c1= Double.parseDouble(ca1.getText());
                double c2 = Double.parseDouble(ca2.getText());
                double hipotenusa = Math.sqrt(c1*c1 + c2*c2);
                resultLabel.setText("La longitud de la Hipotenusa es: " + hipotenusa);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada invalida. Introduce un numero");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Escriba el Cateto 1: "));
        panel.add(ca1);
        panel.add(new JLabel("Escriba el Cateto 2: "));
        panel.add(ca2);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 100);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicioAd_3 ejercicio = new ejercicioAd_3();
            ejercicio.setVisible(true);
        });
    }
}
    
    

