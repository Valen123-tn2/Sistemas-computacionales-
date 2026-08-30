package IntegradorCAp_6;

import javax.swing.*;
import java.awt.*;

public class PanelAnagramaFinal extends JPanel {
    private String textoOriginal = "";
    private int intentos = 3;

    public PanelAnagramaFinal(MenuPrincipal mainFrame) {
        setLayout(new GridLayout(9, 1, 5, 5));

        JTextField txtOriginal = new JTextField();
        JTextField txtIntento = new JTextField();
        JLabel lblAnagrama = new JLabel("", SwingConstants.CENTER);
        JLabel lblIntentos = new JLabel("Intentos restantes: 3", SwingConstants.CENTER);

        JButton btnGenerar = new JButton("Generar anagrama");
        JButton btnAdivinar = new JButton("Probar respuesta");
        JButton btnNuevoJuego = new JButton("Nueva partida");

        btnGenerar.addActionListener(e -> {
            textoOriginal = txtOriginal.getText().trim();
            if (textoOriginal.isEmpty()) {
                JOptionPane.showMessageDialog(this, "El texto no puede estar vacío.");
                return;
            }

            char[] caracteres = textoOriginal.toCharArray();
            for (int i = 0; i < caracteres.length; i++) {
                int j = (int) (Math.random() * caracteres.length);
                char temp = caracteres[i];
                caracteres[i] = caracteres[j];
                caracteres[j] = temp;
            }

            lblAnagrama.setText("Anagrama: " + new String(caracteres));
            intentos = 3;
            lblIntentos.setText("Intentos restantes: " + intentos);
        });

        btnAdivinar.addActionListener(e -> {
            if (textoOriginal.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Primero debe generar un anagrama.");
                return;
            }

            String intento = txtIntento.getText().trim();

            if (intento.equalsIgnoreCase(textoOriginal)) {
                JOptionPane.showMessageDialog(this, "¡Correcto! Has descubierto la palabra.");
                mainFrame.getJugador().sumarPuntos(100);
            } else {
                intentos--;
                mainFrame.getJugador().restarPuntos(10);
                if (intentos <= 0) {
                    JOptionPane.showMessageDialog(this, "¡Sin intentos restantes! El texto era: " + textoOriginal);
                } else {
                    lblIntentos.setText("Incorrecto. Intentos restantes: " + intentos);
                }
            }
            mainFrame.actualizarPuntaje();
        });

        btnNuevoJuego.addActionListener(e -> {
            textoOriginal = "";
            intentos = 3;
            txtOriginal.setText("");
            txtIntento.setText("");
            lblAnagrama.setText("");
            lblIntentos.setText("Intentos restantes: 3");
        });

        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(e -> mainFrame.volverAlMenu());

        add(new JLabel("Texto original (Jugador 1):"));
        add(txtOriginal);
        add(btnGenerar);
        add(lblAnagrama);
        add(new JLabel("Intento (Jugador 2):"));
        add(txtIntento);
        add(btnAdivinar);
        add(lblIntentos);
        add(btnNuevoJuego);
        add(btnVolver);
    }
}