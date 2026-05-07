import javax.swing.*;
import java.awt.*;

public class InterfazCap2 extends JFrame {

    // ================= CAMPOS =================

    JTextField txtNumero1 = new JTextField();
    JTextField txtNumero2 = new JTextField();
    JTextField txtNumero3 = new JTextField();

    JTextField txtDia = new JTextField();
    JTextField txtMes = new JTextField();
    JTextField txtAnio = new JTextField();

    // ================= AREA RESULTADOS =================

    JTextArea areaResultado = new JTextArea();

    // ================= BOTONES =================

    JButton btnParImpar = new JButton("Par o Impar");
    JButton btnComparar = new JButton("Comparar");
    JButton btnMayor = new JButton("Mayor");
    JButton btnIgualMayor = new JButton("Iguales o Mayor");
    JButton btnCasiCero = new JButton("Casi Cero");
    JButton btnMayorMenor = new JButton("Mayor y Menor");
    JButton btnOrdenar = new JButton("Ordenar 3");
    JButton btnNota = new JButton("Clasificar Nota");
    JButton btnFecha = new JButton("Validar Fecha");
    JButton btnLimpiar = new JButton("Limpiar");

    public InterfazCap2() {

        // ================= CONFIGURACION VENTANA =================

        setTitle("TP Condicionales - Swing");

        setSize(900, 600);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout(10,10));

        // ================= PANEL SUPERIOR =================

        JPanel panelSuperior = new JPanel();

        panelSuperior.setLayout(new GridLayout(6, 2, 5, 5));

        panelSuperior.setBorder(
                BorderFactory.createTitledBorder("Ingreso de Datos")
        );

        panelSuperior.add(new JLabel("Número 1:"));
        panelSuperior.add(txtNumero1);

        panelSuperior.add(new JLabel("Número 2:"));
        panelSuperior.add(txtNumero2);

        panelSuperior.add(new JLabel("Número 3:"));
        panelSuperior.add(txtNumero3);

        panelSuperior.add(new JLabel("Día:"));
        panelSuperior.add(txtDia);

        panelSuperior.add(new JLabel("Mes:"));
        panelSuperior.add(txtMes);

        panelSuperior.add(new JLabel("Año:"));
        panelSuperior.add(txtAnio);

        // ================= PANEL BOTONES =================

        JPanel panelBotones = new JPanel();

        panelBotones.setLayout(new GridLayout(5, 2, 10, 10));

        panelBotones.setBorder(
                BorderFactory.createTitledBorder("Funciones")
        );

        panelBotones.add(btnParImpar);
        panelBotones.add(btnComparar);

        panelBotones.add(btnMayor);
        panelBotones.add(btnIgualMayor);

        panelBotones.add(btnCasiCero);
        panelBotones.add(btnMayorMenor);

        panelBotones.add(btnOrdenar);
        panelBotones.add(btnNota);

        panelBotones.add(btnFecha);
        panelBotones.add(btnLimpiar);

        // ================= AREA RESULTADO =================

        areaResultado.setEditable(false);

        areaResultado.setFont(new Font("Arial", Font.PLAIN, 16));

        areaResultado.setMargin(new Insets(10,10,10,10));

        JScrollPane scroll = new JScrollPane(areaResultado);

        scroll.setBorder(
                BorderFactory.createTitledBorder("Resultados")
        );

        // ================= AGREGAR COMPONENTES =================

        add(panelSuperior, BorderLayout.NORTH);

        add(panelBotones, BorderLayout.CENTER);

        add(scroll, BorderLayout.SOUTH);

        // ================= BOTON LIMPIAR =================

        btnLimpiar.addActionListener(e -> limpiarCampos());

        // ================= VISIBILIDAD =================

        setVisible(true);
    }

    // ================= METODO LIMPIAR =================

    private void limpiarCampos() {

        txtNumero1.setText("");
        txtNumero2.setText("");
        txtNumero3.setText("");

        txtDia.setText("");
        txtMes.setText("");
        txtAnio.setText("");

        areaResultado.setText("");

    }

    // ================= MAIN =================

    public static void main(String[] args) {

        new InterfazCap2();

    }
}