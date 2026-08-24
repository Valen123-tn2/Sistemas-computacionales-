package Capitulo_7.Ejercicio7_14;
import javax.swing.*;
import java.awt.*;

public class ejercicio7_14 extends JFrame {

    private JTextField txtValor;
    private JTextArea txtResultado;
    private JButton btnApilar, btnDesapilar;
    private PilaLista pila = new PilaLista();

    public ejercicio7_14() {
        setTitle("Ejercicio 7.14 - PilaLista (Usa Lista 7.12)");
        setSize(400, 300);
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
        btnApilar = new JButton("Apilar (Push)");
        btnDesapilar = new JButton("Desapilar (Pop)");
        panelBotones.add(btnApilar);
        panelBotones.add(btnDesapilar);
        panelPrincipal.add(panelBotones, BorderLayout.CENTER);

        txtResultado = new JTextArea(6, 30);
        txtResultado.setEditable(false);
        panelPrincipal.add(new JScrollPane(txtResultado), BorderLayout.SOUTH);

        btnApilar.addActionListener(e -> {
            try {
                int val = Integer.parseInt(txtValor.getText().trim());
                pila.apilar(val);
                actualizar("Elemento " + val + " apilado.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnDesapilar.addActionListener(e -> {
            Integer elem = pila.desapilar();
            if (elem != null) {
                actualizar("Elemento " + elem + " desapilado.");
            } else {
                JOptionPane.showMessageDialog(this, "La pila está vacía.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        });

        add(panelPrincipal);
        actualizar("PilaLista inicializada.");
    }

    private void actualizar(String msg) {
        txtResultado.setText(msg + "\nContenido actual (Cima al final):\n" + pila.mostrarInformacion());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ejercicio7_14().setVisible(true));
    }
}