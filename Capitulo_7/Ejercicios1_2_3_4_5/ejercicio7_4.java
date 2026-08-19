package Capitulo_7.Ejercicios1_2_3_4_5;

import javax.swing.*;

import Capitulo_7.Ejercicios1_2_3_4_5.ejercicio7_4;

import java.awt.*;

public class ejercicio7_4 extends JFrame {

    private JTextField txtNombre, txtDni, txtSaldo, txtLimite;
    private JTextArea txtResultado;
    private JButton btnComprobar;
    private CuentaCorriente cuenta;

    public ejercicio7_4() {
        setTitle("Ejercicio 7.4 - Visibilidad de Atributos");
        setSize(500, 380);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        crearInterfaz();
    }

    private void crearInterfaz() {
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel panelDatos = new JPanel(new GridLayout(4, 2, 5, 5));
        panelDatos.add(new JLabel("Nombre:"));
        txtNombre = new JTextField("Carlos");
        panelDatos.add(txtNombre);

        panelDatos.add(new JLabel("DNI:"));
        txtDni = new JTextField("87654321");
        panelDatos.add(txtDni);

        panelDatos.add(new JLabel("Saldo:"));
        txtSaldo = new JTextField("300.0");
        panelDatos.add(txtSaldo);

        panelDatos.add(new JLabel("Límite:"));
        txtLimite = new JTextField("-50.0");
        panelDatos.add(txtLimite);

        panelPrincipal.add(panelDatos, BorderLayout.NORTH);

        btnComprobar = new JButton("Acceder Directamente a Atributos");
        panelPrincipal.add(btnComprobar, BorderLayout.CENTER);

        txtResultado = new JTextArea(8, 40);
        txtResultado.setEditable(false);
        panelPrincipal.add(new JScrollPane(txtResultado), BorderLayout.SOUTH);

        btnComprobar.addActionListener(e -> {
            try {
                cuenta = new CuentaCorriente(txtNombre.getText().trim(), txtDni.getText().trim());
                cuenta.saldo = Double.parseDouble(txtSaldo.getText().trim());
                cuenta.limite = Double.parseDouble(txtLimite.getText().trim());

                String info = "Acceso directo realizado:\n"
                            + " - Nombre: " + cuenta.nombre + "\n"
                            + " - DNI: " + cuenta.dni + "\n"
                            + " - Saldo: $" + cuenta.saldo + "\n"
                            + " - Límite: $" + cuenta.limite;

                txtResultado.setText(info);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Valores numéricos no válidos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        add(panelPrincipal);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ejercicio7_4().setVisible(true));
    }
}