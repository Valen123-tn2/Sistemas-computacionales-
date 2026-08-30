package IntegradorCAp_6;

import javax.swing.*;
import java.awt.*;

public class PanelContraseña extends JPanel {
    private String contrasena = "";

    public PanelContraseña(MenuPrincipal mainFrame) {
        setLayout(new GridLayout(9, 1, 5, 5));

        JPasswordField txtPass = new JPasswordField();
        JTextField txtIntento = new JTextField();
        JLabel lblPistas = new JLabel("", SwingConstants.CENTER);
        JLabel lblResultadoAlfa = new JLabel("", SwingConstants.CENTER);

        JButton btnSetPass = new JButton("Guardar Contraseña");
        JButton btnAdivinar = new JButton("Probar");

        btnSetPass.addActionListener(e -> {
            contrasena = new String(txtPass.getPassword()).trim();
            if (contrasena.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese una contraseña.");
                return;
            }
            lblPistas.setText("Longitud: " + contrasena.length() + 
                               " | Primer carácter: " + contrasena.charAt(0) + 
                               " | Último carácter: " + contrasena.charAt(contrasena.length() - 1));
            txtPass.setText("");
        });

        btnAdivinar.addActionListener(e -> {
            if (contrasena.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Primero debe ingresar una contraseña.");
                return;
            }

            String intento = txtIntento.getText().trim();

            if (intento.equals(contrasena)) {
                lblResultadoAlfa.setText("¡Correcto!");
                mainFrame.getJugador().sumarPuntos(50);
            } else {
                mainFrame.getJugador().restarPuntos(10);
                if (intento.compareTo(contrasena) > 0) {
                    lblResultadoAlfa.setText("La palabra introducida es alfabéticamente mayor que la contraseña.");
                } else {
                    lblResultadoAlfa.setText("La palabra introducida es alfabéticamente menor que la contraseña.");
                }
            }
            mainFrame.actualizarPuntaje();
        });

        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(e -> mainFrame.volverAlMenu());

        add(new JLabel("Contraseña (Jugador 1):"));
        add(txtPass);
        add(btnSetPass);
        add(lblPistas);
        add(new JLabel("Intento (Jugador 2):"));
        add(txtIntento);
        add(btnAdivinar);
        add(lblResultadoAlfa);
        add(btnVolver);
    }
}
