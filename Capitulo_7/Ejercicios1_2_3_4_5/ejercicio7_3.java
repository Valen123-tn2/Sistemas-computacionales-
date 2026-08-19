package Capitulo_7.Ejercicios1_2_3_4_5;

import javax.swing.*;
import java.awt.*;

public class ejercicio7_3 extends JFrame {

    private JTextField txtSaldoInicial, txtLimite, txtDni, txtImporte;
    private JTextArea txtResultado;
    private JButton btnCrear, btnIngreso, btnEgreso;
    private CuentaCorriente cuenta;

    public ejercicio7_3() {
        setTitle("Ejercicio 7.3 - Probar Operaciones");
        setSize(550, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        crearInterfaz();
    }

    private void crearInterfaz() {
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel panelDatos = new JPanel(new GridLayout(4, 2, 5, 5));
        panelDatos.add(new JLabel("Saldo Inicial:"));
        txtSaldoInicial = new JTextField("500");
        panelDatos.add(txtSaldoInicial);

        panelDatos.add(new JLabel("Límite Descubierto:"));
        txtLimite = new JTextField("-100");
        panelDatos.add(txtLimite);

        panelDatos.add(new JLabel("DNI:"));
        txtDni = new JTextField("12345678A");
        panelDatos.add(txtDni);

        panelDatos.add(new JLabel("Importe a operar:"));
        txtImporte = new JTextField();
        panelDatos.add(txtImporte);

        panelPrincipal.add(panelDatos, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel();
        btnCrear = new JButton("Inicializar Cuenta");
        btnIngreso = new JButton("Ingresar");
        btnEgreso = new JButton("Retirar");

        panelBotones.add(btnCrear);
        panelBotones.add(btnIngreso);
        panelBotones.add(btnEgreso);
        panelPrincipal.add(panelBotones, BorderLayout.CENTER);

        txtResultado = new JTextArea(8, 40);
        txtResultado.setEditable(false);
        panelPrincipal.add(new JScrollPane(txtResultado), BorderLayout.SOUTH);

        btnCrear.addActionListener(e -> {
            try {
                double s = Double.parseDouble(txtSaldoInicial.getText().trim());
                double l = Double.parseDouble(txtLimite.getText().trim());
                String d = txtDni.getText().trim();
                cuenta = new CuentaCorriente(s, l, d);
                txtResultado.setText("Cuenta Creada Exitosamente:\n" + cuenta.mostrarInformacion());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Valores numéricos no válidos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnIngreso.addActionListener(e -> {
            if (validarCuenta()) {
                try {
                    double imp = Double.parseDouble(txtImporte.getText().trim());
                    cuenta.ingreso(imp);
                    txtResultado.setText("Ingreso Exitoso.\n\n" + cuenta.mostrarInformacion());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Importe no válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnEgreso.addActionListener(e -> {
            if (validarCuenta()) {
                try {
                    double imp = Double.parseDouble(txtImporte.getText().trim());
                    boolean ok = cuenta.egreso(imp);
                    if (ok) {
                        txtResultado.setText("Retiro Exitoso.\n\n" + cuenta.mostrarInformacion());
                    } else {
                        JOptionPane.showMessageDialog(this, "Operación denegada: Excede el límite descubierto.", "Aviso", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Importe no válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        add(panelPrincipal);
    }

    private boolean validarCuenta() {
        if (cuenta == null) {
            JOptionPane.showMessageDialog(this, "Primero debe inicializar la cuenta.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ejercicio7_3().setVisible(true));
    }
}