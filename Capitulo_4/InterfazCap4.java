import javax.swing.*;
import java.awt.*;

public class InterfazCap4 extends JFrame {

    JTextField Numero1 = new JTextField();
    JTextField Numero2 = new JTextField();
    JTextField Numero3 = new JTextField();
    JTextField Caracter = new JTextField();
    JTextArea Resultado = new JTextArea(10,10);

    JButton btn41 = new JButton("Ejercicio 4.1");
    JButton btn42 = new JButton("Ejercicio 4.2");
    JButton btn43 = new JButton("Ejercicio 4.3");
    JButton btn44 = new JButton("Ejercicio 4.4");
    JButton btn45 = new JButton("Ejercicio 4.5");
    JButton btn46 = new JButton("Ejercicio 4.6");
    JButton btn47 = new JButton("Ejercicio 4.7");
    JButton btn48 = new JButton("Ejercicio 4.8");
    JButton btn49 = new JButton("Ejercicio 4.9");
    JButton btn410 = new JButton("Ejercicio 4.10");
    JButton btn411 = new JButton("Ejercicio 4.11");

    public InterfazCap4() {

        setTitle("Capítulo 4");
        setLayout(new BorderLayout(10,10));

        JPanel panelSuperior = new JPanel(new GridLayout(4,2,5,5));
        panelSuperior.setBorder(BorderFactory.createTitledBorder("Ingreso de Datos"));
        panelSuperior.add(new JLabel("Número 1"));
        panelSuperior.add(Numero1);
        panelSuperior.add(new JLabel("Número 2"));
        panelSuperior.add(Numero2);
        panelSuperior.add(new JLabel("Número 3"));
        panelSuperior.add(Numero3);
        panelSuperior.add(new JLabel("Carácter"));
        panelSuperior.add(Caracter);

        JPanel panelBotones = new JPanel(new GridLayout(4,3,5,5));
        panelBotones.setBorder(BorderFactory.createTitledBorder("Ejercicios"));
        panelBotones.add(btn41);
        panelBotones.add(btn42);
        panelBotones.add(btn43);
        panelBotones.add(btn44);
        panelBotones.add(btn45);
        panelBotones.add(btn46);
        panelBotones.add(btn47);
        panelBotones.add(btn48);
        panelBotones.add(btn49);
        panelBotones.add(btn410);
        panelBotones.add(btn411);

        JPanel panelResultado = new JPanel(new BorderLayout());
        panelResultado.setBorder(BorderFactory.createTitledBorder("Resultado"));
        Resultado.setEditable(false);
        Resultado.setFont(new Font("Monospaced", Font.PLAIN, 14));
        panelResultado.add(new JScrollPane(Resultado));
        add(panelSuperior, BorderLayout.NORTH);
        add(panelBotones, BorderLayout.CENTER);
        add(panelResultado, BorderLayout.SOUTH);

        btn41.addActionListener(e -> ejercicio4_1());
        btn42.addActionListener(e -> ejercicio4_2());
        btn43.addActionListener(e -> ejercicio4_3());
        btn44.addActionListener(e -> ejercicio4_4());
        btn45.addActionListener(e -> ejercicio4_5());
        btn46.addActionListener(e -> ejercicio4_6());
        btn47.addActionListener(e -> ejercicio4_7());
        btn48.addActionListener(e -> ejercicio4_8());
        btn49.addActionListener(e -> ejercicio4_9());
        btn410.addActionListener(e -> ejercicio4_10());
        btn411.addActionListener(e -> ejercicio4_11());

        setSize(1000,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void ejercicio4_1() {
        try {
            int n = Integer.parseInt(Numero1.getText());
            eco(n);

        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada inválida.");
        }
    }

    private void eco(int n) {
        Resultado.setText("");
        for (int i = 0; i < n; i++) {
            Resultado.append("Eco...\n");
        }
    }

    private void ejercicio4_2() {
        try {
            int a = Integer.parseInt(Numero1.getText());
            int b = Integer.parseInt(Numero2.getText());
            mostrar(a, b);

        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada inválida.");
        }
    }

    private void mostrar(int a, int b) {
        Resultado.setText("");
        int menor = Math.min(a, b);
        int mayor = Math.max(a, b);
        for (int i = menor; i <= mayor; i++) {
            Resultado.append(i + " ");
        }
    }

    private void ejercicio4_3() {
        try {
            double radio = Double.parseDouble(Numero1.getText());
            double altura = Double.parseDouble(Numero2.getText());
            int opcion = Integer.parseInt(Numero3.getText());
            areaVolumenCilindro(radio, altura, opcion);

        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada inválida.");
        }
    }

    private void areaVolumenCilindro(double radio, double altura, int opcion) {
        if (opcion == 1) {
            double volumen = Math.PI * radio * radio * altura;
            Resultado.setText("Volumen = " + volumen);
        } else if (opcion == 2) {
            double area = 2 * Math.PI * radio * (radio + altura);
            Resultado.setText("Área = " + area);
        } else {
            Resultado.setText("Ingrese 1 para Volumen o 2 para Área.");
        }
    }

    private void ejercicio4_4() {
        try {
            int a = Integer.parseInt(Numero1.getText());
            int b = Integer.parseInt(Numero2.getText());
            Resultado.setText("El mayor es: " + maximo(a, b));

        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada inválida.");
        }
    }

    private int maximo(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    private void ejercicio4_5() {
        try {
            int a = Integer.parseInt(Numero1.getText());
            int b = Integer.parseInt(Numero2.getText());
            int c = Integer.parseInt(Numero3.getText());
            Resultado.setText("El mayor es: " + maximo(a, b, c));

        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada inválida.");
        }
    }

    private int maximo(int a, int b, int c) {
        int mayor = maximo(a, b);
        if (c > mayor) {
            mayor = c;
        }
        return mayor;
    }

    private void ejercicio4_6() {
        if (Caracter.getText().isEmpty()) {
            Resultado.setText("Ingrese un carácter.");
            return;
        }
        char letra = Caracter.getText().charAt(0);
        if (esVocal(letra)) {
            Resultado.setText("Es una vocal.");
        } else {
            Resultado.setText("No es una vocal.");
        }
    }

    public boolean esVocal(char c) {
        boolean resultado;
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || 
        c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'){
            resultado = true;
        } else {
            resultado = false;
        }
       return (resultado);
    }

    private void ejercicio4_7() {
        try {
            int num = Integer.parseInt(Numero1.getText());
            if (esPrimo(num)) {
                Resultado.setText("El número es primo.");
            } else {
                Resultado.setText("El número no es primo.");
            }

        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada inválida.");
        }
    }

    private void ejercicio4_8() {
        try {
            int num = Integer.parseInt(Numero1.getText());
            Resultado.setText("Cantidad de divisores primos: " + cantidadDivisoresPrimos(num));

        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada inválida.");
        }
    }

    private int cantidadDivisoresPrimos(int num) {
        int cont = 0;
        for (int i = 2; i <= num; i++) {
            if (esPrimo(i) && num % i == 0) {
                cont++;
            }
        }
        return cont;
    }

    private void ejercicio4_9() {
        try {
            int num = Integer.parseInt(Numero1.getText());
            Resultado.setText("Divisores primos:\n");
            for (int i = 2; i <= num; i++) {
                if (esPrimo(i) && num % i == 0) {
                    Resultado.append(i + "\n");
                }
            }

        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada inválida.");
        }
    }

    private void ejercicio4_10() {
        try {
            int a = Integer.parseInt(Numero1.getText());
            int b = Integer.parseInt(Numero2.getText());
            if (amigos(a, b)) {
                Resultado.setText(a + " y " + b + " son amigos.");
            } else {
                Resultado.setText(a + " y " + b + " no son amigos.");
            }

        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada inválida.");
        }
    }

    public boolean amigos(int a, int b){
        boolean amigos;
        if  (a == sumaDivisoresPropios(b) && b == sumaDivisoresPropios(a)) {
            amigos = true;
        } else {
            amigos = false;
        }
        return (amigos);
    }

    private int sumaDivisoresPropios(int num) {
        int suma = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                suma += i;
            }
        }
        return suma;
    }

    private void ejercicio4_11() {
        try {
            double base = Double.parseDouble(Numero1.getText());
            int exponente = Integer.parseInt(Numero2.getText());
            Resultado.setText(base + " elevado a " + exponente + " = " +
                    potencia(base, exponente));

        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada inválida.");
        }
    }

    private double potencia(double base, int exponente) {
        double resultado = 1;
        for (int i = 0; i < exponente; i++) {
            resultado *= base;
        }
        return resultado;
    }

    private boolean esPrimo(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        new InterfazCap4();
    }
}