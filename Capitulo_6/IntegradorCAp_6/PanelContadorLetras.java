package IntegradorCAp_6;

import javax.swing.*;
import java.awt.*;

public class PanelContadorLetras extends JPanel {
    public PanelContadorLetras(MenuPrincipal mainFrame) {
        setLayout(new BorderLayout(5, 5));

        JTextField txtFrase = new JTextField();
        JTextArea txtArea = new JTextArea();
        txtArea.setEditable(false);

        JButton btnContar = new JButton("Contar letras");
        btnContar.addActionListener(e -> {
            String frase = txtFrase.getText().toLowerCase();
            int[] contador = new int[256];

            for (int i = 0; i < frase.length(); i++) {
                char c = frase.charAt(i);
                if (Character.isLetter(c)) {
                    contador[c]++;
                }
            }

            String resultado = "";
            for (int i = 0; i < contador.length; i++) {
                if (contador[i] > 0) {
                    resultado += (char) i + ": " + contador[i] + "\n";
                }
            }

            txtArea.setText(resultado);
            mainFrame.getJugador().sumarPuntos(50);
            mainFrame.actualizarPuntaje();
        });

        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(e -> mainFrame.volverAlMenu());

        JPanel panelArriba = new JPanel(new GridLayout(3, 1));
        panelArriba.add(new JLabel("Frase:"));
        panelArriba.add(txtFrase);
        panelArriba.add(btnContar);

        add(panelArriba, BorderLayout.NORTH);
        add(new JScrollPane(txtArea), BorderLayout.CENTER);
        add(btnVolver, BorderLayout.SOUTH);
    }
}