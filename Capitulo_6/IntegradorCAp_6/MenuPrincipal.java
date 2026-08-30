package IntegradorCAp_6;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame {
    private Jugador jugador;
    private JLabel lblJugador;
    private JLabel lblPuntaje;
    private JPanel panelContenido;
    private CardLayout cardLayout;

    public MenuPrincipal() {
        pedirNombreJugador();
        initUI();
    }

    private void pedirNombreJugador() {
        String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del jugador:", "Nuevo Jugador", JOptionPane.QUESTION_MESSAGE);
        if (nombre == null || nombre.trim().isEmpty()) {
            nombre = "Jugador 1";
        }
        this.jugador = new Jugador(nombre.trim());
    }

    private void initUI() {
        setTitle("JAVA STRING GAMES");
        setSize(500, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // --- BARRA SUPERIOR (Jugador y Puntaje) ---
        JPanel panelInfo = new JPanel(new GridLayout(2, 1));
        lblJugador = new JLabel();
        lblPuntaje = new JLabel();
        actualizarPuntaje();
        panelInfo.add(lblJugador);
        panelInfo.add(lblPuntaje);
        add(panelInfo, BorderLayout.NORTH);

        // --- BARRA DE MENÚ ---
        JMenuBar menuBar = new JMenuBar();
        
        JMenu menuOpciones = new JMenu("Opciones");
        JMenuItem itemNuevoJugador = new JMenuItem("Nuevo jugador");
        JMenuItem itemSalir = new JMenuItem("Salir");

        itemNuevoJugador.addActionListener(e -> {
            pedirNombreJugador();
            actualizarPuntaje();
        });
        itemSalir.addActionListener(e -> System.exit(0));

        menuOpciones.add(itemNuevoJugador);
        menuOpciones.add(itemSalir);

        JMenu menuJuegos = new JMenu("Juegos");
        for (int i = 1; i <= 9; i++) {
            final int index = i;
            JMenuItem itemJuego = new JMenuItem("Juego " + index);
            itemJuego.addActionListener(e -> cardLayout.show(panelContenido, "J" + index));
            menuJuegos.add(itemJuego);
        }

        JMenu menuAyuda = new JMenu("Ayuda");
        JMenuItem itemAyuda = new JMenuItem("Ver Ayuda");
        itemAyuda.addActionListener(e -> 
            JOptionPane.showMessageDialog(this, "Seleccione un juego del menú o de la lista de botones.", "Ayuda", JOptionPane.INFORMATION_MESSAGE)
        );
        menuAyuda.add(itemAyuda);

        menuBar.add(menuOpciones);
        menuBar.add(menuJuegos);
        menuBar.add(menuAyuda);
        setJMenuBar(menuBar);

        // --- PANEL DE NAVEGACIÓN ---
        cardLayout = new CardLayout();
        panelContenido = new JPanel(cardLayout);

        panelContenido.add(crearPanelMenu(), "MENU");
        panelContenido.add(new PanelPalabraCorta(this), "J1");
        panelContenido.add(new PanelContraseña(this), "J2");
        panelContenido.add(new PanelEspejo(this), "J3");
        panelContenido.add(new PanelBuscador(this), "J4");
        panelContenido.add(new PanelPalindromo(this), "J5");
        panelContenido.add(new PanelJavalandia(this), "J6");
        panelContenido.add(new PanelAnagramas(this), "J7");
        panelContenido.add(new PanelContadorLetras(this), "J8");
        panelContenido.add(new PanelAnagramaFinal(this), "J9");

        add(panelContenido, BorderLayout.CENTER);
    }

    private JPanel crearPanelMenu() {
        JPanel panel = new JPanel(new GridLayout(10, 1, 5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("MENÚ DE JUEGOS"));

        String[] nombresJuegos = {
            "Palabra más corta", "Acierta la contraseña", "Espejo",
            "Buscador de palabras", "Palíndromo", "Traductor Javalandia",
            "Anagramas", "Contador de letras", "Juego del anagrama"
        };

        for (int i = 0; i < nombresJuegos.length; i++) {
            final int index = i + 1;
            JButton btn = new JButton(nombresJuegos[i]);
            btn.addActionListener(e -> cardLayout.show(panelContenido, "J" + index));
            panel.add(btn);
        }

        JButton btnSalir = new JButton("SALIR");
        btnSalir.addActionListener(e -> System.exit(0));
        panel.add(btnSalir);

        return panel;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void actualizarPuntaje() {
        lblJugador.setText("Jugador: " + jugador.getNombre());
        lblPuntaje.setText("Puntaje: " + jugador.getPuntaje());
    }

    public void volverAlMenu() {
        cardLayout.show(panelContenido, "MENU");
    }
}
