package Capitulo_7.Ejercicio7_11;
import javax.swing.*;
import java.awt.*;

public class ejercicio7_11 extends JFrame {

    private JTextField txtHora, txtMinuto, txtSegundo, txtN;
    private JTextArea txtResultado;
    private JButton btnGenerar;

    public ejercicio7_11() {
        setTitle("Ejercicio 7.11 - Clase Hora y Secuencia");
        setSize(500, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        crearInterfaz();
    }

    private void crearInterfaz() {
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel panelDatos = new JPanel(new GridLayout(4, 2, 5, 5));
        panelDatos.add(new JLabel("Hora (0-23):"));
        txtHora = new JTextField("23");
        panelDatos.add(txtHora);

        panelDatos.add(new JLabel("Minuto (0-59):"));
        txtMinuto = new JTextField("59");
        panelDatos.add(txtMinuto);

        panelDatos.add(new JLabel("Segundo (0-59):"));
        txtSegundo = new JTextField("58");
        panelDatos.add(txtSegundo);

        panelDatos.add(new JLabel("Cantidad de horas (n):"));
        txtN = new JTextField("5");
        panelDatos.add(txtN);

        panelPrincipal.add(panelDatos, BorderLayout.NORTH);

        btnGenerar = new JButton("Mostrar n Horas Siguientes");
        panelPrincipal.add(btnGenerar, BorderLayout.CENTER);

        txtResultado = new JTextArea(10, 40);
        txtResultado.setEditable(false);
        panelPrincipal.add(new JScrollPane(txtResultado), BorderLayout.SOUTH);

        btnGenerar.addActionListener(e -> {
            try {
                int h = Integer.parseInt(txtHora.getText().trim());
                int m = Integer.parseInt(txtMinuto.getText().trim());
                int s = Integer.parseInt(txtSegundo.getText().trim());
                int n = Integer.parseInt(txtN.getText().trim());

                Hora horaObj = new Hora(h, m, s);
                StringBuilder sb = new StringBuilder();
                sb.append("Hora Inicial: ").append(horaObj.mostrarInformacion()).append("\n-------------------------\n");

                for (int i = 1; i <= n; i++) {
                    horaObj.incrementarSegundo();
                    sb.append("+").append(i).append(" seg: ").append(horaObj.mostrarInformacion()).append("\n");
                }

                txtResultado.setText(sb.toString());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Valores numéricos no válidos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        add(panelPrincipal);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ejercicio7_11().setVisible(true));
    }
}