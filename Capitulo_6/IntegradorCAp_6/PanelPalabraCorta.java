package IntegradorCAp_6;

import javax.swing.*;
import java.awt.*;

public class PanelPalabraCorta extends JPanel {
    public PanelPalabraCorta(MenuPrincipal mainFrame) {
        setLayout(new GridLayout(6, 1, 5, 5));

        JTextField txt1 = new JTextField();
        JTextField txt2 = new JTextField();
        JLabel lblResultado = new JLabel("", SwingConstants.CENTER);

        JButton btnComparar = new JButton("Comparar");
        btnComparar.addActionListener(e -> {
            String p1 = txt1.getText().trim();
            String p2 = txt2.getText().trim();

            if (p1.isEmpty() || p2.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Complete ambos campos.");
                return;
            }

            if (p1.length() < p2.length()) {
                lblResultado.setText(p1 + " posee menos caracteres.");
                mainFrame.getJugador().sumarPuntos(50);
            } else if (p2.length() < p1.length()) {
                lblResultado.setText(p2 + " posee menos caracteres.");
                mainFrame.getJugador().sumarPuntos(50);
            } else {
                lblResultado.setText("Ambas tienen la misma longitud.");
                mainFrame.getJugador().sumarPuntos(50);
            }
            mainFrame.actualizarPuntaje();
        });

        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(e -> mainFrame.volverAlMenu());

        add(new JLabel("Palabra 1:"));
        add(txt1);
        add(new JLabel("Palabra 2:"));
        add(txt2);
        add(btnComparar);
        add(lblResultado);
        add(btnVolver);
    }
}