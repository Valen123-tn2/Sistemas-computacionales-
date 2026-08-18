package Capitulo_7;
import javax.swing.*;
import java.awt.*;

public class ejercicio7_3 extends JFrame {

    private JTextField txtSaldoInicial;
    private JTextField txtLimite;
    private JTextField txtDni;
    private JTextField txtImporte;
    private JTextArea txtResultado;
    private JButton btnCrear;
    private JButton btnIngreso;
    private JButton btnEgreso;
    private JButton btnLimpiar;
    private CuentaCorriente cuenta;

    public ejercicio7_3() {
        setTitle("Ejercicio 7.3 - Probar Operaciones");
        setSize(600, 480);
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
        btnLimpiar = new JButton("Limpiar");

        panelBotones.add(btnCrear);
        panelBotones.add(btnIngreso);
        panelBotones.add(btnEgreso);
        panelBotones.add(btnLimpiar);
        panelPrincipal.add(panelBotones, BorderLayout.CENTER);

        txtResultado = new JTextArea(8, 40);
        txtResultado.setEditable(false);
        JScrollPane scroll = new JScrollPane(txtResultado);
        panelPrincipal.add(scroll, BorderLayout.SOUTH);

        btnCrear.addActionListener(e -> crearCuenta());
        btnIngreso.addActionListener(e -> realizarIngreso());
        btnEgreso.addActionListener(e -> realizarEgreso());
        btnLimpiar.addActionListener(e -> limpiar());

        add(panelPrincipal);
    }

    private void crearCuenta() {
        try {
            double saldo = Double.parseDouble(txtSaldoInicial.getText().trim());
            double limite = Double.parseDouble(txtLimite.getText().trim());
            String dni = txtDni.getText().trim();

            cuenta = new CuentaCorriente(saldo, limite, dni);
            txtResultado.setText("Cuenta creada con éxito.\n" + cuenta.mostrarInformacion());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Revise los campos numéricos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void realizarIngreso() {
        if (validarCuenta()) {
            try {
                double imp = Double.parseDouble(txtImporte.getText().trim());
                cuenta.ingreso(imp);
                txtResultado.setText("Ingreso realizado exitosamente.\n\n" + cuenta.mostrarInformacion());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Importe no válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void realizarEgreso() {
        if (validarCuenta()) {
            try {
                double imp = Double.parseDouble(txtImporte.getText().trim());
                boolean ok = cuenta.egreso(imp);
                if (ok) {
                    txtResultado.setText("Egreso realizado correctamente.\n\n" + cuenta.mostrarInformacion());
                } else {
                    JOptionPane.showMessageDialog(this, "Operación denegada: Excede el límite de descubierto.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Importe no válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean validarCuenta() {
        if (cuenta == null) {
            JOptionPane.showMessageDialog(this, "Primero cree la cuenta.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private void limpiar() {
        txtSaldoInicial.setText("500");
        txtLimite.setText("-100");
        txtDni.setText("");
        txtImporte.setText("");
        txtResultado.setText("");
        cuenta = null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ejercicio7_3().setVisible(true));
    }
}