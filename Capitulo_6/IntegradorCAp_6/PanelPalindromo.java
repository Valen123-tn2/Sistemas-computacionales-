package IntegradorCAp_6;

import javax.swing.*;
import java.awt.*;

public class PanelPalindromo extends JPanel {
    public PanelPalindromo(MenuPrincipal mainFrame) {
        setLayout(new GridLayout(5, 1, 5, 5));

        JTextField txtFrase = new JTextField();
        JLabel lblResultado = new JLabel("", SwingConstants.CENTER);

        JButton btnComprobar = new JButton("Comprobar");
        btnComprobar.addActionListener(e -> {
            String frase = txtFrase.getText();
            
            // 1. Eliminar espacios
            String sinEspacios = "";
            for (int i = 0; i < frase.length(); i++) {
                if (frase.charAt(i) != ' ') {
                    sinEspacios += frase.charAt(i);
                }
            }

            // 2. Invertir la cadena
            String invertida = "";
            for (int i = sinEspacios.length() - 1; i >= 0; i--) {
                invertida += sinEspacios.charAt(i);
            }

            // 3. Comparar
            if (!sinEspacios.isEmpty() && sinEspacios.equalsIgnoreCase(invertida)) {
                lblResultado.setText("PALÍNDROMO");
                mainFrame.getJugador().sumarPuntos(50);
            } else {
                lblResultado.setText("NO ES PALÍNDROMO");
                mainFrame.getJugador().restarPuntos(10);
            }
            mainFrame.actualizarPuntaje();
        });

        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(e -> mainFrame.volverAlMenu());

        add(new JLabel("Frase:"));
        add(txtFrase);
        add(btnComprobar);
        add(lblResultado);
        add(btnVolver);
    }
}
