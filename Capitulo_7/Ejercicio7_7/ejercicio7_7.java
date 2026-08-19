package Capitulo_7.Ejercicio7_7;

import javax.swing.*;
import java.awt.*;

public class ejercicio7_7 extends JFrame {

    private JTextField txtNombre, txtCapital, txtDireccion;
    private JTextArea txtResultado;
    private JButton btnCrearDefault, btnCrearPersonalizado;
    private Banco banco;

    public ejercicio7_7() {
        setTitle("Ejercicio 7.7 - Clase Banco");
        setSize(500, 380);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        crearInterfaz();
    }

    private void crearInterfaz() {
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel panelDatos = new JPanel(new GridLayout(3, 2, 5, 5));
        panelDatos.add(new JLabel("Nombre:"));
        txtNombre = new JTextField("Banco Nación");
        panelDatos.add(txtNombre);

        panelDatos.add(new JLabel("Capital ($):"));
        txtCapital = new JTextField("10000000");
        panelDatos.add(txtCapital);

        panelDatos.add(new JLabel("Dirección Central:"));
        txtDireccion = new JTextField("Av. Rivadavia 123");
        panelDatos.add(txtDireccion);

        panelPrincipal.add(panelDatos, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel();
        btnCrearDefault = new JButton("Capital Defecto ($5.2M)");
        btnCrearPersonalizado = new JButton("Crear Completo");
        panelBotones.add(btnCrearDefault);
        panelBotones.add(btnCrearPersonalizado);
        panelPrincipal.add(panelBotones, BorderLayout.CENTER);

        txtResultado = new JTextArea(8, 40);
        txtResultado.setEditable(false);
        panelPrincipal.add(new JScrollPane(txtResultado), BorderLayout.SOUTH);

        btnCrearDefault.addActionListener(e -> {
            banco = new Banco(txtNombre.getText().trim(), txtDireccion.getText().trim());
            mostrar();
        });

        btnCrearPersonalizado.addActionListener(e -> {
            try {
                double cap = Double.parseDouble(txtCapital.getText().trim());
                banco = new Banco(txtNombre.getText().trim(), cap, txtDireccion.getText().trim());
                mostrar();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Capital no válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        add(panelPrincipal);
    }

    private void mostrar() {
        if (banco != null) {
            txtResultado.setText("DATOS DEL BANCO REGISTRADO:\n" + banco.mostrarInformacion());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ejercicio7_7().setVisible(true));
    }
}