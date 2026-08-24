package Capitulo_7.Ejercicios7_17_18;
import javax.swing.*;
import java.awt.*;

public class ejercicio7_18 extends JFrame {

    private JTextField txtC1, txtC2;
    private JTextArea txtResultado;
    private JButton btnUnion, btnInterseccion, btnDiferencia, btnIncluido;

    public ejercicio7_18() {
        setTitle("Ejercicio 7.18 - Operaciones Estáticas entre Conjuntos");
        setSize(550, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        crearInterfaz();
    }

    private void crearInterfaz() {
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel panelDatos = new JPanel(new GridLayout(2, 2, 5, 5));
        panelDatos.add(new JLabel("Conjunto 1 (ej: 1, 2, 3, 4):"));
        txtC1 = new JTextField("1, 2, 3, 4");
        panelDatos.add(txtC1);

        panelDatos.add(new JLabel("Conjunto 2 (ej: 3, 4, 5, 6):"));
        txtC2 = new JTextField("3, 4, 5, 6");
        panelDatos.add(txtC2);

        panelPrincipal.add(panelDatos, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel(new GridLayout(2, 2, 5, 5));
        btnUnion = new JButton("Unión (c1 U c2)");
        btnInterseccion = new JButton("Intersección (c1 ∩ c2)");
        btnDiferencia = new JButton("Diferencia (c1 - c2)");
        btnIncluido = new JButton("¿c1 Incluido en c2?");

        panelBotones.add(btnUnion);
        panelBotones.add(btnInterseccion);
        panelBotones.add(btnDiferencia);
        panelBotones.add(btnIncluido);
        panelPrincipal.add(panelBotones, BorderLayout.CENTER);

        txtResultado = new JTextArea(10, 40);
        txtResultado.setEditable(false);
        panelPrincipal.add(new JScrollPane(txtResultado), BorderLayout.SOUTH);

        btnUnion.addActionListener(e -> {
            Conjunto c1 = parsearConjunto(txtC1.getText());
            Conjunto c2 = parsearConjunto(txtC2.getText());
            Conjunto res = Conjunto.union(c1, c2);
            txtResultado.setText("UNIÓN:\n" + res.mostrarInformacion());
        });

        btnInterseccion.addActionListener(e -> {
            Conjunto c1 = parsearConjunto(txtC1.getText());
            Conjunto c2 = parsearConjunto(txtC2.getText());
            Conjunto res = Conjunto.interseccion(c1, c2);
            txtResultado.setText("INTERSECCIÓN:\n" + res.mostrarInformacion());
        });

        btnDiferencia.addActionListener(e -> {
            Conjunto c1 = parsearConjunto(txtC1.getText());
            Conjunto c2 = parsearConjunto(txtC2.getText());
            Conjunto res = Conjunto.diferencia(c1, c2);
            txtResultado.setText("DIFERENCIA (c1 - c2):\n" + res.mostrarInformacion());
        });

        btnIncluido.addActionListener(e -> {
            Conjunto c1 = parsearConjunto(txtC1.getText());
            Conjunto c2 = parsearConjunto(txtC2.getText());
            boolean inc = Conjunto.incluido(c1, c2);
            txtResultado.setText("¿Conjunto 1 está totalmente incluido en Conjunto 2?: " + (inc ? "SÍ" : "NO"));
        });

        add(panelPrincipal);
    }

    private Conjunto parsearConjunto(String texto) {
        Conjunto c = new Conjunto();
        String[] partes = texto.split(",");
        for (String p : partes) {
            try {
                if (!p.trim().isEmpty()) {
                    c.insertar(Integer.parseInt(p.trim()));
                }
            } catch (NumberFormatException ignored) {
            }
        }
        return c;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ejercicio7_18().setVisible(true));
    }
}
