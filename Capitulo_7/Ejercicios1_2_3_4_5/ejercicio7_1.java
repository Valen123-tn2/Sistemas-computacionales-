package Capitulo_7.Ejercicios1_2_3_4_5;
import javax.swing.*;
import java.awt.*;

public class ejercicio7_1 extends JFrame {

    private JTextField txtNombre;
    private JTextField txtDni;
    private JTextField txtLimite;
    private JTextField txtImporte;
    private JTextArea txtResultado;
    private JButton btnCrear;
    private JButton btnIngreso;
    private JButton btnEgreso;
    private JButton btnMostrar;
    private JButton btnLimpiar;
    private CuentaCorriente cuenta;

    public ejercicio7_1() {
        setTitle("Cuenta Corriente");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        crearInterfaz();
    }

    private void crearInterfaz() {
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout(10, 10));
        panelPrincipal.setBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );

        JPanel panelDatos = new JPanel();
        panelDatos.setLayout(new GridLayout(4, 2, 5, 5));
        panelDatos.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelDatos.add(txtNombre);
        panelDatos.add(new JLabel("DNI:"));
        txtDni = new JTextField();
        panelDatos.add(txtDni);
        panelDatos.add(new JLabel("Límite descubierto:"));
        txtLimite = new JTextField("-100");
        panelDatos.add(txtLimite);
        panelDatos.add(new JLabel("Importe:"));
        txtImporte = new JTextField();
        panelDatos.add(txtImporte);
        panelPrincipal.add(panelDatos, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel();
        btnCrear = new JButton("Crear cuenta");
        btnIngreso = new JButton("Ingresar dinero");
        btnEgreso = new JButton("Retirar dinero");
        btnMostrar = new JButton("Mostrar información");
        btnLimpiar = new JButton("Limpiar");
        panelBotones.add(btnCrear);
        panelBotones.add(btnIngreso);
        panelBotones.add(btnEgreso);
        panelBotones.add(btnMostrar);
        panelBotones.add(btnLimpiar);
        panelPrincipal.add(panelBotones, BorderLayout.CENTER);

        txtResultado = new JTextArea();
        txtResultado.setEditable(false);
        txtResultado.setLineWrap(true);
        txtResultado.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(txtResultado);
        panelPrincipal.add(scroll, BorderLayout.SOUTH);


        btnCrear.addActionListener(e -> crearCuenta());
        btnIngreso.addActionListener(e -> realizarIngreso());
        btnEgreso.addActionListener(e -> realizarEgreso());
        btnMostrar.addActionListener(e -> mostrarInformacion());
        btnLimpiar.addActionListener(e -> limpiar());
        add(panelPrincipal);
    }

    private void crearCuenta() {
        String nombre = txtNombre.getText().trim();
        String dni = txtDni.getText().trim();

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Debe ingresar el nombre.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        if (dni.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Debe ingresar el DNI.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        cuenta = new CuentaCorriente(nombre, dni);
        try {
            double limite = Double.parseDouble(
                    txtLimite.getText()
            );
            cuenta.limite = limite;

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    this,
                    "El límite debe ser un número.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        JOptionPane.showMessageDialog(
                this,
                "Cuenta creada correctamente.",
                "Información",
                JOptionPane.INFORMATION_MESSAGE
        );
        mostrarInformacion();
    }

    private void realizarIngreso() {
        if (cuenta == null) {
            JOptionPane.showMessageDialog(
                    this,
                    "Primero debe crear una cuenta.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        try {
            double importe = Double.parseDouble(
                    txtImporte.getText()
            );

            if (importe <= 0) {
                JOptionPane.showMessageDialog(
                        this,
                        "El importe debe ser mayor que cero.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            cuenta.ingreso(importe);
            JOptionPane.showMessageDialog(
                    this,
                    "Ingreso realizado correctamente.",
                    "Operación exitosa",
                    JOptionPane.INFORMATION_MESSAGE
            );
            mostrarInformacion();


        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Debe ingresar un importe numérico.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void realizarEgreso() {
        if (cuenta == null) {
            JOptionPane.showMessageDialog(
                    this,
                    "Primero debe crear una cuenta.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        try {
            double importe = Double.parseDouble(
                    txtImporte.getText()
            );

            if (importe <= 0) {
                JOptionPane.showMessageDialog(
                        this,
                        "El importe debe ser mayor que cero.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            boolean operacionPosible = cuenta.egreso(importe);
            if (operacionPosible) {
                JOptionPane.showMessageDialog(
                        this,
                        "Retiro realizado correctamente.",
                        "Operación exitosa",
                        JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "No hay dinero suficiente.\n"
                        + "El límite de descubierto sería superado.",
                        "Operación rechazada",
                        JOptionPane.WARNING_MESSAGE
                );
            }
            mostrarInformacion();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Debe ingresar un importe numérico.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void mostrarInformacion() {
        if (cuenta == null) {
            txtResultado.setText(
                    "No existe ninguna cuenta creada."
            );
            return;
        }
        txtResultado.setText(
                cuenta.mostrarInformacion()
        );
    }

    private void limpiar() {
        txtNombre.setText("");
        txtDni.setText("");
        txtLimite.setText("-100");
        txtImporte.setText("");
        txtResultado.setText("");
        cuenta = null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicio7_1 ventana = new ejercicio7_1();
            ventana.setVisible(true);
        });
    }
}