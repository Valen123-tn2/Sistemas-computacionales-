package Capitulo_7.Ejercicio7_10;

import javax.swing.*;
import java.awt.*;

public class ejercicio7_10 extends JFrame {

    private JTextField txtCapMax, txtCapAct, txtMercancia;
    private JTextArea txtResultado;
    private JButton btnEnganchar;
    private Tren tren;

    public ejercicio7_10() {
        setTitle("Ejercicio 7.10 - Empresa Ferroviaria");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Mecanico mec = new Mecanico("Mario Pérez", "555-0192", "Motores Diesel");
        Locomotora loc = new Locomotora("LOC-901", 3000, 2018, mec);
        Maquinista maq = new Maquinista("Roberto Gómez", "11223344C", 2500.0, "Oficial 1ª");
        tren = new Tren(loc, maq);

        crearInterfaz();
    }

    private void crearInterfaz() {
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel panelDatos = new JPanel(new GridLayout(3, 2, 5, 5));
        panelDatos.add(new JLabel("Capacidad Máx (kg):"));
        txtCapMax = new JTextField("10000");
        panelDatos.add(txtCapMax);

        panelDatos.add(new JLabel("Capacidad Actual (kg):"));
        txtCapAct = new JTextField("5000");
        panelDatos.add(txtCapAct);

        panelDatos.add(new JLabel("Mercancía:"));
        txtMercancia = new JTextField("Cereal");
        panelDatos.add(txtMercancia);

        panelPrincipal.add(panelDatos, BorderLayout.NORTH);

        btnEnganchar = new JButton("Enganchar Vagón (Máx 5)");
        panelPrincipal.add(btnEnganchar, BorderLayout.CENTER);

        txtResultado = new JTextArea(8, 40);
        txtResultado.setEditable(false);
        panelPrincipal.add(new JScrollPane(txtResultado), BorderLayout.SOUTH);

        btnEnganchar.addActionListener(e -> {
            try {
                double max = Double.parseDouble(txtCapMax.getText().trim());
                double act = Double.parseDouble(txtCapAct.getText().trim());
                String merc = txtMercancia.getText().trim();

                if (tren.engancharVagon(max, act, merc)) {
                    txtResultado.append("\n✅ Vagón enganchado (" + merc + "). Total vagones: " + tren.getNumVagones());
                } else {
                    JOptionPane.showMessageDialog(this, "El tren ya alcanzó el límite máximo de 5 vagones.", "Límite Alcanzado", JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Valores numéricos no válidos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        add(panelPrincipal);
        txtResultado.setText("Tren listo.\nLocomotora: " + tren.locomotora.matricula + "\nMaquinista: " + tren.maquinistaResponsable.nombreCompleto);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ejercicio7_10().setVisible(true));
    }
}