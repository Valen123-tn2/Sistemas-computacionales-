package Ejercicio1_8;
import javax.swing.*;

public class ejercicio1_8 extends JFrame {

    public ejercicio1_8() {
        setTitle("Ejercicio 1.8");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField m1t = new JTextField(10);
        JTextField m2t = new JTextField(10);
        JTextField m3t = new JTextField(10);
        JTextField m4t = new JTextField(10);
        JTextField p1t = new JTextField(10);
        JTextField p2t = new JTextField(10);
        JTextField p3t = new JTextField(10);
        JTextField p4t = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("Redondeado es: ");


        submitButton.addActionListener(e -> {
            try {
                final double PM = 2.35;
                final double PP = 1.95;
                int vm1t = Integer.parseInt(m1t.getText());
                int vm2t = Integer.parseInt(m2t.getText());
                int vm3t = Integer.parseInt(m3t.getText());
                int vm4t = Integer.parseInt(m4t.getText());
                int vp1t = Integer.parseInt(p1t.getText());
                int vp2t = Integer.parseInt(p2t.getText());
                int vp3t = Integer.parseInt(p3t.getText());
                int vp4t = Integer.parseInt(p4t.getText());
                double ImpTotal = ((vm1t + vm2t + vm3t + vm4t)* PM) + ((vp1t + vp2t + vp3t + vp4t)* PP);
                resultLabel.setText("El importe total es de: " + ImpTotal + "Pesos");
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada invalida. Introduce un numero");
            }
        });

        JPanel panel = new JPanel(); 
        panel.add(new JLabel("Manzanas: ")); 
        panel.add(new JLabel("Venta Primer trimestre: "));
        panel.add(m1t);
        panel.add(new JLabel("Venta Segundo trimestre: "));
        panel.add(m2t);
        panel.add(new JLabel("Venta Tercer trimestre: "));
        panel.add(m3t);
        panel.add(new JLabel("Venta Cuarto trimestre: "));
        panel.add(m4t);
        panel.add(new JLabel("Peras: "));
        panel.add(new JLabel("Venta Primer trimestre: "));
        panel.add(p1t);
        panel.add(new JLabel("Venta Segundo trimestre: "));
        panel.add(p2t);
        panel.add(new JLabel("Venta Tercer trimestre: "));
        panel.add(p3t);
        panel.add(new JLabel("Venta Cuarto trimestre: "));
        panel.add(p4t);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 400);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicio1_8 ejercicio = new ejercicio1_8();
            ejercicio.setVisible(true);
        });
    }
}
    
