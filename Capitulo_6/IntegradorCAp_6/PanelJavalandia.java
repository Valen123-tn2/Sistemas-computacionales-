package IntegradorCAp_6;

import javax.swing.*;
import java.awt.*;

public class PanelJavalandia extends JPanel {
    public PanelJavalandia(MenuPrincipal mainFrame) {
        setLayout(new GridLayout(5, 1, 5, 5));

        JTextField txtFrase = new JTextField();
        JLabel lblResultado = new JLabel("", SwingConstants.CENTER);

        JButton btnTraducir = new JButton("Traducir");
        btnTraducir.addActionListener(e -> {
            String frase = txtFrase.getText();
            String inicio = "Javalin, javalón";
            String fin = "javalén, len, len";

            if (frase.startsWith(inicio)) {
                lblResultado.setText(frase.substring(inicio.length()).trim());
                mainFrame.getJugador().sumarPuntos(50);
            } else if (frase.endsWith(fin)) {
                lblResultado.setText(frase.substring(0, frase.length() - fin.length()).trim());
                mainFrame.getJugador().sumarPuntos(50);
            } else {
                lblResultado.setText("La frase no pertenece al idioma Javalandia.");
                mainFrame.getJugador().restarPuntos(10);
            }
            mainFrame.actualizarPuntaje();
        });

        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(e -> mainFrame.volverAlMenu());

        add(new JLabel("Frase en Javalandia:"));
        add(txtFrase);
        add(btnTraducir);
        add(lblResultado);
        add(btnVolver);
    }
}