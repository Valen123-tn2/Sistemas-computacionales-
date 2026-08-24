package Capitulo_7.Ejercicios7_17_18;
import javax.swing.*;
import java.awt.*;

public class ejercicio7_17 extends JFrame {

    private JTextField txtValor;
    private JTextArea txtResultado;
    private JButton btnInsertar, btnEliminar, btnPertenece;
    private Conjunto conjunto = new Conjunto();

    public ejercicio7_17() {
        setTitle("Ejercicio 7.17 - Estructura Conjunto");
        setSize(480, 320);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        crearInterfaz();
    }

    private void crearInterfaz() {
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel panelTop = new JPanel(new GridLayout(1, 2, 5, 5));
        panelTop.add(new JLabel("Número (Integer):"));
        txtValor = new JTextField();
        panelTop.add(txtValor);

        panelPrincipal.add(panelTop, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel();
        btnInsertar = new JButton("Insertar");
        btnEliminar = new JButton("Eliminar");
        btnPertenece = new JButton("Pertenece?");

        panelBotones.add(btnInsertar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnPertenece);
        panelPrincipal.add(panelBotones, BorderLayout.CENTER);

        txtResultado = new JTextArea(7, 35);
        txtResultado.setEditable(false);
        panelPrincipal.add(new JScrollPane(txtResultado), BorderLayout.SOUTH);

        btnInsertar.addActionListener(e -> {
            try {
                int val = Integer.parseInt(txtValor.getText().trim());
                if (conjunto.insertar(val)) {
                    actualizar("Elemento " + val + " insertado.");
                } else {
                    JOptionPane.showMessageDialog(this, "El elemento " + val + " ya existe en el conjunto.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnEliminar.addActionListener(e -> {
            try {
                int val = Integer.parseInt(txtValor.getText().trim());
                if (conjunto.eliminar(val)) {
                    actualizar("Elemento " + val + " eliminado.");
                } else {
                    JOptionPane.showMessageDialog(this, "El elemento " + val + " no pertenece al conjunto.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnPertenece.addActionListener(e -> {
            try {
                int val = Integer.parseInt(txtValor.getText().trim());
                boolean resp = conjunto.pertenece(val);
                txtResultado.append("\nEl elemento " + val + (resp ? " SÍ pertenece." : " NO pertenece."));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        add(panelPrincipal);
        actualizar("Conjunto inicializado.");
    }

    private void actualizar(String msg) {
        txtResultado.setText(msg + "\nContenido actual (Elementos: " + conjunto.getNumElementos() + "):\n" + conjunto.mostrarInformacion());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ejercicio7_17().setVisible(true));
    }
}