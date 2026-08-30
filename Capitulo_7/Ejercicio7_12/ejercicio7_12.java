package Capitulo_7.Ejercicio7_12;
import Capitulo_7.Lista;
import javax.swing.*;
import java.awt.*;

public class ejercicio7_12 extends JFrame {

    private JTextField txtValor, txtIndice;
    private JTextArea txtResultado;
    private JButton btnInsFin, btnInsIni, btnInsInd, btnEliminar, btnBuscar;
    private Lista lista = new Lista(5);

    public ejercicio7_12() {
        setTitle("Ejercicio 7.12 - Clase Lista Dinámica");
        setSize(550, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        crearInterfaz();
    }

    private void crearInterfaz() {
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel panelDatos = new JPanel(new GridLayout(2, 2, 5, 5));
        panelDatos.add(new JLabel("Número (Integer):"));
        txtValor = new JTextField();
        panelDatos.add(txtValor);

        panelDatos.add(new JLabel("Índice:"));
        txtIndice = new JTextField();
        panelDatos.add(txtIndice);

        panelPrincipal.add(panelDatos, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel(new GridLayout(2, 3, 5, 5));
        btnInsFin = new JButton("Insertar Final");
        btnInsIni = new JButton("Insertar Inicio");
        btnInsInd = new JButton("Insertar en Índice");
        btnEliminar = new JButton("Eliminar por Índice");
        btnBuscar = new JButton("Buscar Valor");

        panelBotones.add(btnInsFin);
        panelBotones.add(btnInsIni);
        panelBotones.add(btnInsInd);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnBuscar);
        panelPrincipal.add(panelBotones, BorderLayout.CENTER);

        txtResultado = new JTextArea(8, 40);
        txtResultado.setEditable(false);
        panelPrincipal.add(new JScrollPane(txtResultado), BorderLayout.SOUTH);

        btnInsFin.addActionListener(e -> {
            try {
                lista.insertarFinal(Integer.parseInt(txtValor.getText().trim()));
                actualizar();
            } catch (NumberFormatException ex) {
                mostrarError();
            }
        });

        btnInsIni.addActionListener(e -> {
            try {
                lista.insertarPrincipio(Integer.parseInt(txtValor.getText().trim()));
                actualizar();
            } catch (NumberFormatException ex) {
                mostrarError();
            }
        });

        btnInsInd.addActionListener(e -> {
            try {
                int val = Integer.parseInt(txtValor.getText().trim());
                int idx = Integer.parseInt(txtIndice.getText().trim());
                if (!lista.insertarEnIndice(idx, val)) {
                    JOptionPane.showMessageDialog(this, "Índice fuera de rango.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
                actualizar();
            } catch (NumberFormatException ex) {
                mostrarError();
            }
        });

        btnEliminar.addActionListener(e -> {
            try {
                int idx = Integer.parseInt(txtIndice.getText().trim());
                Integer elem = lista.eliminar(idx);
                if (elem == null) {
                    JOptionPane.showMessageDialog(this, "Índice no válido.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    actualizar();
                }
            } catch (NumberFormatException ex) {
                mostrarError();
            }
        });

        btnBuscar.addActionListener(e -> {
            try {
                int val = Integer.parseInt(txtValor.getText().trim());
                int idx = lista.buscar(val);
                JOptionPane.showMessageDialog(this, idx != -1 ? "Encontrado en el índice: " + idx : "No se encuentra en la lista.");
            } catch (NumberFormatException ex) {
                mostrarError();
            }
        });

        add(panelPrincipal);
        actualizar();
    }

    private void actualizar() {
        txtResultado.setText("Elementos en la lista (" + lista.getNumElementos() + "):\n" + lista.mostrarInformacion());
    }

    private void mostrarError() {
        JOptionPane.showMessageDialog(this, "Introduce valores válidos.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ejercicio7_12().setVisible(true));
    }
}