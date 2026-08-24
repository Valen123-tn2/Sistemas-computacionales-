package Capitulo_7.Ejercicio7_16;
import javax.swing.*;
import java.awt.*;

public class ejercicio7_16 extends JFrame {

    private JTextField txtValor;
    private JTextArea txtResultado;
    private JButton btnEncolar, btnDesencolar;
    private ColaLista cola = new ColaLista();

    public ejercicio7_16() {
        setTitle("Ejercicio 7.16 - ColaLista (Usa Lista 7.12)");
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
        btnEncolar = new JButton("Encolar");
        btnDesencolar = new JButton("Desencolar");
        panelBotones.add(btnEncolar);
        panelBotones.add(btnDesencolar);
        panelPrincipal.add(panelBotones, BorderLayout.CENTER);

        txtResultado = new JTextArea(6, 30);
        txtResultado.setEditable(false);
        panelPrincipal.add(new JScrollPane(txtResultado), BorderLayout.SOUTH);

        btnEncolar.addActionListener(e -> {
            try {
                int val = Integer.parseInt(txtValor.getText().trim());
                cola.encolar(val);
                actualizar("Elemento " + val + " encolado.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnDesencolar.addActionListener(e -> {
            Integer elem = cola.desencolar();
            if (elem != null) {
                actualizar("Elemento " + elem + " desencolado.");
            } else {
                JOptionPane.showMessageDialog(this, "La cola está vacía.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        });

        add(panelPrincipal);
        actualizar("ColaLista lista.");
    }

    private void actualizar(String msg) {
        txtResultado.setText(msg + "\nEstado de la cola (Frente a la izquierda):\n" + cola.mostrarInformacion());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ejercicio7_16().setVisible(true));
    }
}