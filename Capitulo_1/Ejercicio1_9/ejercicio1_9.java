package Ejercicio1_9;
import javax.swing.*;
import java.awt.*;

public class ejercicio1_9 extends JFrame {

    public ejercicio1_9() {
        setTitle("Ejercicio 1.9");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField pm = new JTextField(10);
        JTextField pp = new JTextField(10);
        JTextField m1t = new JTextField(10);
        JTextField m2t = new JTextField(10);
        JTextField m3t = new JTextField(10);
        JTextField m4t = new JTextField(10);
        JTextField p1t = new JTextField(10);
        JTextField p2t = new JTextField(10);
        JTextField p3t = new JTextField(10);
        JTextField p4t = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");
        JTextField resultados = new JTextField(40);


        submitButton.addActionListener(e -> {
            try {
                double PM = Double.parseDouble(pm.getText());
                double PP = Double.parseDouble(pp.getText());
                int vm1t = Integer.parseInt(m1t.getText());
                int vm2t = Integer.parseInt(m2t.getText());
                int vm3t = Integer.parseInt(m3t.getText());
                int vm4t = Integer.parseInt(m4t.getText());
                int vp1t = Integer.parseInt(p1t.getText());
                int vp2t = Integer.parseInt(p2t.getText());
                int vp3t = Integer.parseInt(p3t.getText());
                int vp4t = Integer.parseInt(p4t.getText());
                double ImpTotal = ((vm1t + vm2t + vm3t + vm4t)* PM) + ((vp1t + vp2t + vp3t + vp4t)* PP);
                resultados.setText("El importe total es de: " + ImpTotal + " Pesos");
            } catch (NumberFormatException ex) {
                resultados.setText("Entrada invalida. Introduce un numero");
            }
        });

        JPanel panelCentro = new JPanel(new GridLayout(1, 2, 20, 10));

        JPanel panelPrecio = new JPanel(new GridLayout(3, 2, 5, 5));
        panelPrecio.setBorder(BorderFactory.createTitledBorder("Precios")); 
        panelPrecio.add(new JLabel("Escriba el Precio de las Manzanas: "));
        panelPrecio.add(pm);
        panelPrecio.add(new JLabel("Escriba el Precio de las Peras: "));
        panelPrecio.add(pp);

        JPanel panelManzanas = new JPanel(new GridLayout(5, 2, 5, 5)); 
        panelManzanas.setBorder(BorderFactory.createTitledBorder("Manzanas"));
        panelManzanas.add(new JLabel("Venta Primer trimestre: "));
        panelManzanas.add(m1t);
        panelManzanas.add(new JLabel("Venta Segundo trimestre: "));
        panelManzanas.add(m2t);
        panelManzanas.add(new JLabel("Venta Tercer trimestre: "));
        panelManzanas.add(m3t);
        panelManzanas.add(new JLabel("Venta Cuarto trimestre: "));
        panelManzanas.add(m4t);
       
        JPanel panelPeras = new JPanel(new GridLayout(5, 2, 5, 5));
        panelPeras.setBorder(BorderFactory.createTitledBorder("Peras"));
        panelPeras.add(new JLabel("Venta Primer trimestre: "));
        panelPeras.add(p1t);
        panelPeras.add(new JLabel("Venta Segundo trimestre: "));
        panelPeras.add(p2t);
        panelPeras.add(new JLabel("Venta Tercer trimestre: "));
        panelPeras.add(p3t);
        panelPeras.add(new JLabel("Venta Cuarto trimestre: "));
        panelPeras.add(p4t);

        panelCentro.add(panelPrecio);
        panelCentro.add(panelManzanas);
        panelCentro.add(panelPeras);
        add(panelCentro, BorderLayout.CENTER);

        JPanel panelBoton = new JPanel();
        panelBoton.add(submitButton);
        add(panelBoton, BorderLayout.NORTH);

        JPanel panelResultado = new JPanel();
        panelResultado.setBorder(BorderFactory.createTitledBorder("Resultado"));
        panelResultado.add(resultLabel);
        panelResultado.add(resultados);
        add(panelResultado, BorderLayout.SOUTH);

        setSize(1400, 300);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicio1_9 ejercicio = new ejercicio1_9();
            ejercicio.setVisible(true);
        });
    }
}
    
