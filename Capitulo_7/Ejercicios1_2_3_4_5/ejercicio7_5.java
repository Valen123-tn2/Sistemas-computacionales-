package Capitulo_7.Ejercicios1_2_3_4_5;

import javax.swing.*;
import java.awt.*;

public class ejercicio7_5 extends JFrame {

    private JTextField txtNuevoBanco;
    private JTextArea txtResultado;
    private JButton btnCambiarBanco;
    private CuentaCorriente c1 = new CuentaCorriente("Ana Gómez", "11111111");
    private CuentaCorriente c2 = new CuentaCorriente("Lucas Ramos", "22222222");

    public ejercicio7_5() {
        setTitle("Ejercicio 7.5 - Atributo Estático Banco");
        setSize(500, 320);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        crearInterfaz();
    }

    private void crearInterfaz() {
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel panelTop = new JPanel(new GridLayout(1, 2, 5, 5));
        panelTop.add(new JLabel("Nuevo Banco Global:"));
        txtNuevoBanco = new JTextField("Banco Santander");
        panelTop.add(txtNuevoBanco);

        panelPrincipal.add(panelTop, BorderLayout.NORTH);

        btnCambiarBanco = new JButton("Cambiar Banco Compartido");
        panelPrincipal.add(btnCambiarBanco, BorderLayout.CENTER);

        txtResultado = new JTextArea(8, 40);
        txtResultado.setEditable(false);
        panelPrincipal.add(new JScrollPane(txtResultado), BorderLayout.SOUTH);

        btnCambiarBanco.addActionListener(e -> {
            String nuevo = txtNuevoBanco.getText().trim();
            if (!nuevo.isEmpty()) {
                CuentaCorriente.setNombreBanco(nuevo);
                actualizarTexto();
            }
        });

        add(panelPrincipal);
        actualizarTexto();
    }

    private void actualizarTexto() {
        txtResultado.setText("=== ESTADO DE LAS CUENTAS ===\n"
                + c1.mostrarInformacion() + "\n--------------------------------\n"
                + c2.mostrarInformacion());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ejercicio7_5().setVisible(true));
    }
}