package Capitulo_7;
import javax.swing.*;
import java.awt.*;

public class ejercicio7_2 extends JFrame {

    private JTextField txtNombre;
    private JTextField txtDni;
    private JTextField txtSaldoInicial;
    private JTextField txtLimite;
    private JTextArea txtResultado;
    private JButton btnCrearCompleto;
    private JButton btnCrearSoloSaldo;
    private JButton btnCrearTresParams;
    private JButton btnLimpiar;
    private CuentaCorriente cuenta;

    public ejercicio7_2() {
        setTitle("Ejercicio 7.2 - Sobrecarga de Constructores");
        setSize(650, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        crearInterfaz();
    }

    private void crearInterfaz() {
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel panelDatos = new JPanel(new GridLayout(4, 2, 5, 5));
        panelDatos.add(new JLabel("Nombre (opcional según constr.):"));
        txtNombre = new JTextField("Juan Pérez");
        panelDatos.add(txtNombre);

        panelDatos.add(new JLabel("DNI (opcional según constr.):"));
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
        txtResultado.setLineWrap(true);
        txtResultado.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(txtResultado);
        panelPrincipal.add(scroll, BorderLayout.SOUTH);

        btnCrearCompleto.addActionListener(e -> crearNombreDni());
        btnCrearSoloSaldo.addActionListener(e -> crearSoloSaldo());
        btnCrearTresParams.addActionListener(e -> crearTresParametros());
        btnLimpiar.addActionListener(e -> limpiar());

        add(panelPrincipal);
    }

    private void crearNombreDni() {
        String nombre = txtNombre.getText().trim();
        String dni = txtDni.getText().trim();
        if (nombre.isEmpty() || dni.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese Nombre y DNI.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        cuenta = new CuentaCorriente(nombre, dni);
        mostrarInformacion("Cuenta creada con (Nombre, DNI)");
    }

    private void crearSoloSaldo() {
        try {
            double saldo = Double.parseDouble(txtSaldoInicial.getText().trim());
            cuenta = new CuentaCorriente(saldo);
            mostrarInformacion("Cuenta creada con (Solo Saldo)");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Saldo inválido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void crearTresParametros() {
        try {
            double saldo = Double.parseDouble(txtSaldoInicial.getText().trim());
            double limite = Double.parseDouble(txtLimite.getText().trim());
            String dni = txtDni.getText().trim();

            if (dni.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese el DNI.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            cuenta = new CuentaCorriente(saldo, limite, dni);
            mostrarInformacion("Cuenta creada con (Saldo, Límite, DNI)");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Valores numéricos inválidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mostrarInformacion(String mensaje) {
        if (cuenta != null) {
            txtResultado.setText(mensaje + "\n--------------------------------\n" + cuenta.mostrarInformacion());
        }
    }

    private void limpiar() {
        txtNombre.setText("");
        txtDni.setText("");
        txtSaldoInicial.setText("");
        txtLimite.setText("-100");
        txtResultado.setText("");
        cuenta = null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ejercicio7_2().setVisible(true));
    }
}