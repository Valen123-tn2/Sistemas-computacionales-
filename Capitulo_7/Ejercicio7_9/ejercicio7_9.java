package Capitulo_7.Ejercicio7_9;

import javax.swing.*;
import java.awt.*;

public class ejercicio7_9 extends JFrame {

    private Bombilla b1 = new Bombilla();
    private Bombilla b2 = new Bombilla();
    private JLabel lbl1, lbl2;
    private JButton btnB1, btnB2, btnGeneral;
    private boolean generalON = true;

    public ejercicio7_9() {
        setTitle("Ejercicio 7.9 - Sistema Bombillas");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        crearInterfaz();
    }

    private void crearInterfaz() {
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        lbl1 = new JLabel("", SwingConstants.CENTER);
        btnB1 = new JButton("Interruptor B1");
        lbl2 = new JLabel("", SwingConstants.CENTER);
        btnB2 = new JButton("Interruptor B2");
        btnGeneral = new JButton("Cortar Fusible General");

        panel.add(lbl1); panel.add(btnB1);
        panel.add(lbl2); panel.add(btnB2);
        panel.add(new JLabel("General:", SwingConstants.CENTER)); panel.add(btnGeneral);

        btnB1.addActionListener(e -> {
            if (b1.estaEncendida()) b1.apagar(); else b1.encender();
            actualizar();
        });

        btnB2.addActionListener(e -> {
            if (b2.estaEncendida()) b2.apagar(); else b2.encender();
            actualizar();
        });

        btnGeneral.addActionListener(e -> {
            generalON = !generalON;
            if (generalON) {
                Bombilla.reponerLuzGeneral();
                btnGeneral.setText("Cortar Fusible General");
            } else {
                Bombilla.cortarLuzGeneral();
                btnGeneral.setText("Reponer Fusible General");
            }
            actualizar();
        });

        add(panel);
        actualizar();
    }

    private void actualizar() {
        lbl1.setText("B1: " + (b1.estaEncendida() ? "Prendida" : "Apagada "));
        lbl2.setText("B2: " + (b2.estaEncendida() ? "Prendida" : "Apagada "));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ejercicio7_9().setVisible(true));
    }
}