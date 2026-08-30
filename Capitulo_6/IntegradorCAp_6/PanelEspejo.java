package IntegradorCAp_6;

import javax.swing.*;
import java.awt.*;

public class PanelEspejo extends JPanel {
    public PanelEspejo(MenuPrincipal mainFrame) {
        setLayout(new GridLayout(5, 1, 5, 5));

        JTextField txtEntrada = new JTextField();
        JLabel lblResultado = new JLabel("", SwingConstants.CENTER);

        JButton btnInvertir = new JButton("Invertir");
        btnInvertir.addActionListener(e -> {
            String texto = txtEntrada.getText();
            String invertida = "";
            for (int i = texto.length() - 1; i >= 0; i--) {
                invertida += texto.charAt(i);
            }
            lblResultado.setText("Resultado: " + invertida);
            mainFrame.getJugador().sumarPuntos(50);
            mainFrame.actualizarPuntaje();
        });

        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(e -> mainFrame.volverAlMenu());

        add(new JLabel("Entrada:"));
        add(txtEntrada);
        add(btnInvertir);
        add(lblResultado);
        add(btnVolver);
    }
}
