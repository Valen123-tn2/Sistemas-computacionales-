package Capitulo_7;

import javax.swing.*;
import java.awt.*;

public class ejercicio7_4 extends JFrame {

    private JTextField txtNombre;
    private JTextField txtDni;
    private JTextField txtSaldo;
    private JTextField txtLimite;
    private JTextArea txtResultado;
    private JButton btnComprobar;
    private VisibilidadAtributos cuenta;

    public ejercicio7_4() {
        setTitle("Ejercicio 7.4 - Visibilidad de Atributos");
        setSize(550, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        crearInterfaz();
    }

    private void crearInterfaz() {
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel panelDatos = new JPanel(new GridLayout(4, 2, 5, 5));
        panelDatos.add(new JLabel("Nombre (Público):"));
        txtNombre = new JTextField("Carlos");
        panelDatos.add(txtNombre);

        panelDatos.add(new JLabel("DNI (Package-Private):"));
        txtDni = new JTextField("87654321B");
        panelDatos.add(txtDni);

        panelDatos.add(new JLabel("Saldo (Privado):"));
        txtSaldo = new JTextField("300.0");
        panelDatos.add(txtSaldo);

        panelDatos.add(new JLabel("Límite (Privado):"));
        txtLimite = new JTextField("-50.0");
        panelDatos.add(txtLimite);

        panelPrincipal.add(panelDatos, BorderLayout.NORTH);

        btnComprobar = new JButton("Comprobar Acceso a Atributos");
        panelPrincipal.add(btnComprobar, BorderLayout.CENTER);

        txtResultado = new JTextArea(8, 40);
        txtResultado.setEditable(false);
        JScrollPane scroll = new JScrollPane(txtResultado);
        panelPrincipal.add(scroll, BorderLayout.SOUTH);

        btnComprobar.addActionListener(e -> comprobarVisibilidad());
        add(panelPrincipal);
    }

    private void comprobarVisibilidad() {
        try {
            cuenta = new VisibilidadAtributos(
                txtNombre.getText().trim(),
                txtDni.getText().trim(),
                Double.parseDouble(txtSaldo.getText().trim()),
                Double.parseDouble(txtLimite.getText().trim())
            );

            StringBuilder sb = new StringBuilder();
            sb.append("--- ACCESO DIRECTO ---\n");
            sb.append("Nombre (Public): ").append(cuenta.nombre).append("\n");
            sb.append("DNI (Package-Private): ").append(cuenta.dni).append("\n");

            sb.append("\n--- ACCESO POR GETTERS (Atributos Privados) ---\n");
            sb.append("Saldo (Private): $").append(cuenta.getSaldo()).append("\n");
            sb.append("Límite (Private): $").append(cuenta.getLimite());

            txtResultado.setText(sb.toString());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Revise los valores numéricos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ejercicio7_4().setVisible(true));
    }
}