package Capitulo_7.Ejercicios1_2_3_4_5;

import javax.swing.*;
import java.awt.*;

public class ejercicio7_2 extends JFrame {

    private JTextField txtNombre, txtDni, txtSaldoInicial, txtLimite;
    private JTextArea txtResultado;
    private JButton btnCrearCompleto, btnCrearSoloSaldo, btnCrearTresParams, btnLimpiar;
    private CuentaCorriente cuenta;

    public ejercicio7_2() {
        setTitle("Ejercicio 7.2 - Sobrecarga de Constructores");
        setSize(600, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        crearInterfaz();
    }

    private void crearInterfaz() {
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel panelDatos = new JPanel(new GridLayout(4, 2, 5, 5));
        panelDatos.add(new JLabel("Nombre:"));
        txtNombre = new JTextField("Juan Pérez");
        panelDatos.add(txtNombre);

        panelDatos.add(new JLabel("DNI:"));
        txtDni = new JTextField("12345678A");
        panelDatos.add(txtDni);

        panelDatos.add(new JLabel("Saldo Inicial:"));
        txtSaldoInicial = new JTextField("500");
        panelDatos.add(txtSaldoInicial);

        panelDatos.add(new JLabel("Límite Descubierto:"));
        txtLimite = new JTextField("-100");
        panelDatos.add(txtLimite);

        panelPrincipal.add(panelDatos, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel();
        btnCrearCompleto = new JButton("Nombre y DNI");
        btnCrearSoloSaldo = new JButton("Solo Saldo");
        btnCrearTresParams = new JButton("Saldo, Límite y DNI");
        btnLimpiar = new JButton("Limpiar");

        panelBotones.add(btnCrearCompleto);
        panelBotones.add(btnCrearSoloSaldo);
        panelBotones.add(btnCrearTresParams);
        panelBotones.add(btnLimpiar);
        panelPrincipal.add(panelBotones, BorderLayout.CENTER);

        txtResultado = new JTextArea(8, 40);
        txtResultado.setEditable(false);
        panelPrincipal.add(new JScrollPane(txtResultado), BorderLayout.SOUTH);

        btnCrearCompleto.addActionListener(e -> {
            cuenta = new CuentaCorriente(txtNombre.getText().trim(), txtDni.getText().trim());
            mostrar("Cuenta creada con (Nombre, DNI)");
        });

        btnCrearSoloSaldo.addActionListener(e -> {
            try {
                double s = Double.parseDouble(txtSaldoInicial.getText().trim());
                cuenta = new CuentaCorriente(s);
                mostrar("Cuenta creada con (Solo Saldo)");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Saldo no válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnCrearTresParams.addActionListener(e -> {
            try {
                double s = Double.parseDouble(txtSaldoInicial.getText().trim());
                double l = Double.parseDouble(txtLimite.getText().trim());
                String d = txtDni.getText().trim();
                cuenta = new CuentaCorriente(s, l, d);
                mostrar("Cuenta creada con (Saldo, Límite, DNI)");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Valores numéricos no válidos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnLimpiar.addActionListener(e -> {
            txtResultado.setText("");
            cuenta = null;
        });

        add(panelPrincipal);
    }

    private void mostrar(String msg) {
        if (cuenta != null) {
            txtResultado.setText(msg + "\n--------------------------------\n" + cuenta.mostrarInformacion());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ejercicio7_2().setVisible(true));
    }
}