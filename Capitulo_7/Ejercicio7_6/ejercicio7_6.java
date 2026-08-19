package Capitulo_7.Ejercicio7_6;

import javax.swing.*;
import java.awt.*;

public class ejercicio7_6 extends JFrame {

    private JTextField txtLongitudMax, txtEntrada;
    private JTextArea txtResultado;
    private JButton btnCrear, btnAddIni, btnAddFin, btnVocales;
    private Texto t;

    public ejercicio7_6() {
        setTitle("Ejercicio 7.6 - Clase Texto");
        setSize(550, 380);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        crearInterfaz();
    }

    private void crearInterfaz() {
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel panelDatos = new JPanel(new GridLayout(2, 2, 5, 5));
        panelDatos.add(new JLabel("Capacidad Máxima:"));
        txtLongitudMax = new JTextField("15");
        panelDatos.add(txtLongitudMax);

        panelDatos.add(new JLabel("Texto / Caracter:"));
        txtEntrada = new JTextField();
        panelDatos.add(txtEntrada);

        panelPrincipal.add(panelDatos, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel();
        btnCrear = new JButton("Crear Objeto");
        btnAddIni = new JButton("Añadir al Inicio");
        btnAddFin = new JButton("Añadir al Final");
        btnVocales = new JButton("Contar Vocales");

        panelBotones.add(btnCrear);
        panelBotones.add(btnAddIni);
        panelBotones.add(btnAddFin);
        panelBotones.add(btnVocales);
        panelPrincipal.add(panelBotones, BorderLayout.CENTER);

        txtResultado = new JTextArea(8, 40);
        txtResultado.setEditable(false);
        panelPrincipal.add(new JScrollPane(txtResultado), BorderLayout.SOUTH);

        btnCrear.addActionListener(e -> {
            try {
                int max = Integer.parseInt(txtLongitudMax.getText().trim());
                t = new Texto(max);
                txtResultado.setText("Objeto Creado. Límite máximo: " + max);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Capacidad inválida.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnAddIni.addActionListener(e -> {
            if (t != null && t.adicionarCadenaPrincipio(txtEntrada.getText())) {
                txtResultado.setText("Cadena Actual: \"" + t.getCadena() + "\"");
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo agregar. Excede la capacidad.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        });

        btnAddFin.addActionListener(e -> {
            if (t != null && t.adicionarCadenaFinal(txtEntrada.getText())) {
                txtResultado.setText("Cadena Actual: \"" + t.getCadena() + "\"");
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo agregar. Excede la capacidad.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        });

        btnVocales.addActionListener(e -> {
            if (t != null) {
                JOptionPane.showMessageDialog(this, "Cantidad de vocales: " + t.contarVocales(), "Resultado", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        add(panelPrincipal);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ejercicio7_6().setVisible(true));
    }
}