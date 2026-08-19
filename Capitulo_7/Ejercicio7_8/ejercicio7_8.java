package Capitulo_7.Ejercicio7_8;

import javax.swing.*;
import java.awt.*;

public class ejercicio7_8 extends JFrame {

    private JLabel lblFrecuencia;
    private JButton btnUp, btnDown;
    private SintonizadorFM sintonizador = new SintonizadorFM();

    public ejercicio7_8() {
        setTitle("Ejercicio 7.8 - Sintonizador FM");
        setSize(350, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        crearInterfaz();
    }

    private void crearInterfaz() {
        JPanel panelPrincipal = new JPanel(new BorderLayout(15, 15));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        lblFrecuencia = new JLabel("80.0 MHz", SwingConstants.CENTER);
        lblFrecuencia.setFont(new Font("Monospaced", Font.BOLD, 28));
        panelPrincipal.add(lblFrecuencia, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel(new GridLayout(1, 2, 10, 10));
        btnDown = new JButton("<< -0.5 MHz");
        btnUp = new JButton("+0.5 MHz >>");

        panelBotones.add(btnDown);
        panelBotones.add(btnUp);
        panelPrincipal.add(panelBotones, BorderLayout.CENTER);

        btnUp.addActionListener(e -> {
            sintonizador.up();
            actualizar();
        });

        btnDown.addActionListener(e -> {
            sintonizador.down();
            actualizar();
        });

        add(panelPrincipal);
    }

    private void actualizar() {
        lblFrecuencia.setText(String.format("%.1f MHz", sintonizador.getFrecuencia()));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ejercicio7_8().setVisible(true));
    }
}