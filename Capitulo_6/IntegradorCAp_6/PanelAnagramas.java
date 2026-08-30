package IntegradorCAp_6;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class PanelAnagramas extends JPanel {
    public PanelAnagramas(MenuPrincipal mainFrame) {
        setLayout(new GridLayout(6, 1, 5, 5));

        JTextField txt1 = new JTextField();
        JTextField txt2 = new JTextField();
        JLabel lblResultado = new JLabel("", SwingConstants.CENTER);

        JButton btnVerificar = new JButton("Verificar");
        btnVerificar.addActionListener(e -> {
            String p1 = txt1.getText().trim().toLowerCase();
            String p2 = txt2.getText().trim().toLowerCase();

            if (p1.isEmpty() || p2.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Complete ambos campos.");
                return;
            }

            char[] c1 = p1.toCharArray();
            char[] c2 = p2.toCharArray();
            Arrays.sort(c1);
            Arrays.sort(c2);

            if (Arrays.equals(c1, c2)) {
                lblResultado.setText("SON ANAGRAMAS");
                mainFrame.getJugador().sumarPuntos(50);
            } else {
                lblResultado.setText("NO SON ANAGRAMAS");
                mainFrame.getJugador().restarPuntos(10);
            }
            mainFrame.actualizarPuntaje();
        });

        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(e -> mainFrame.volverAlMenu());

        add(new JLabel("Palabra 1:"));
        add(txt1);
        add(new JLabel("Palabra 2:"));
        add(txt2);
        add(btnVerificar);
        add(lblResultado);
        add(btnVolver);
    }
}
