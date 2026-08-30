package IntegradorCAp_6;

import javax.swing.*;
import java.awt.*;

public class PanelBuscador extends JPanel {
    public PanelBuscador(MenuPrincipal mainFrame) {
        setLayout(new GridLayout(6, 1, 5, 5));

        JTextField txtFrase = new JTextField();
        JTextField txtPalabra = new JTextField();
        JLabel lblResultado = new JLabel("", SwingConstants.CENTER);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(e -> {
            String frase = txtFrase.getText();
            String palabra = txtPalabra.getText();

            if (palabra.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese una palabra.");
                return;
            }

            int contador = 0;
            int posicion = frase.indexOf(palabra);

            while (posicion != -1) {
                contador++;
                posicion = frase.indexOf(palabra, posicion + palabra.length());
            }

            lblResultado.setText("La palabra aparece " + contador + " veces.");
            mainFrame.getJugador().sumarPuntos(50);
            mainFrame.actualizarPuntaje();
        });

        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(e -> mainFrame.volverAlMenu());

        add(new JLabel("Frase:"));
        add(txtFrase);
        add(new JLabel("Palabra:"));
        add(txtPalabra);
        add(btnBuscar);
        add(lblResultado);
        add(btnVolver);
    }
}