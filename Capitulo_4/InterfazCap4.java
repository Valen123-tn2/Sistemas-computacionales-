import javax.swing.*;
import java.awt.*;

public class InterfazCap4 extends JFrame {

    JTextField Numero1 = new JTextField();
    JTextField Numero2 = new JTextField();
    JTextField Numero3 = new JTextField();
    JTextField Caracter = new JTextField();

    JTextArea Resultado = new JTextArea();

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

    public static void eco(int a) {
        Resultado.setText("");
        for (int i = 0; i < a; i++) {
           Resultado.append("Eco...\n");
        }
    }

    public static void mostrar(int a, int b) {
        Resultado.setText("");
        int menor = Math.min(a, b);
        int mayor = Math.max(a, b);
        for (int i = menor; i <= mayor; i++) {
           Resultado.append(i + " ");
        }
    }
    private void ejercicio4_1(){
        try {
            int n = Integer.parseInt(Numero1.getText());
            eco(n);
        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada inválida. Introduce un número");
        }
    }

    private void ejercicio4_2(){
        try {
            int n1 = Integer.parseInt(Numero1.getText());
            int n2 = Integer.parseInt(Numero2.getText());
            mostrar(n1, n2, Resultado);

            } catch (NumberFormatException ex) {
                Resultado.setText("Entrada inválida. Introduce números.");
            }
    }

    private void ejercicio4_3(){
        try {
            double rad = Double.parseDouble(Numero1.getText());
            double alt = Double.parseDouble(Numero2.getText());
            int tipoc = Integer.parseInt(Numero3.getText());
            areaVolumencilidro(rad, alt, tipoc, Resultado);

        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada inválida. Introduce números.");
        }

        public static void areaVolumencilidro(double radio, double altura, int opcion, JLabel label) {
            String texto = "";
            Double volumen, area;
            switch (opcion) {
                case 1:
                    volumen = Math.PI *(radio * radio) * altura;
                    texto += "El volumen es de: " + volumen;
                    break;
                case 2:
                    area = 2 * Math.PI * radio * (altura+radio);
                    texto += "El area es de: " + area;
                    break;
            }
            label.setText(texto);
        } 
    }  

    private void ejercicio4_4(){
        try {
            int num1 = Integer.parseInt(Numero1.getText());
            int num2 = Integer.parseInt(Numero2.getText());
            Resultado.setText("El numero mayor es: " + maximo(num1,num2));

        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada inválida. Introduce números.");
        }

        public static int maximo(int a, int b) {
        int max;
        if (a > b){
            max = a;
        } else {
            max = b;
        }
       return (max);
        }
    }

    private void ejercicio4_5(){
        try {
            int num1 = Integer.parseInt(Numero1.getText());
            int num2 = Integer.parseInt(Numero2.getText());
            int num3 = Integer.parseInt(Numero3.getText());
            Resultado.setText("El numero mayor es: " + maximo(num1,num2,num3));

        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada inválida. Introduce números.");
        }
        public static int maximo(int a, int b, int c) {
        int max;
        if (a > b){
            max = a;
        } else {
            max = b;
        }
        if (c > max){
            max = c;
        }
        return (max);
        }
    }

    private void ejercicio4_6(){
        try {
            String texto = Numero1.getText();
            char letra = texto.charAt(0);
            if (esVocal(letra)){
                Resultado.setText("Es una vocal");
            } else {
                Resultado.setText("No es una vocal");
            }  
        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada inválida. Introduce una sola letra.");
        }

        public static boolean esVocal(char c) {
        boolean resultado;
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || 
        c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'){
            resultado = true;
        } else {
            resultado = false;
        }
        return (resultado);
        }
    }

    private void ejercicio4_7(){
        try {
            int num1 = Integer.parseInt(Numero1.getText());
            if (esPrimo(num1)){
                Resultado.setText("El numero es primo");
            } else {
                Resultado.setText("El numero no es primo");
            }  

        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada inválida. Introduce una sola letra.");
        }
        public static boolean esPrimo(int a) {
        boolean primo = true;
        int i = 2;
        if (a < 2){
            primo = false;
        } 
        while (i < a && primo == true){
            if (a % i == 0){
                primo = false;
            }
            i++;
        }
        return (primo);
        }

    }

    private void ejercicio4_8(){
        try {
            int num1 = Integer.parseInt(Numero1.getText());
            Resultado.setText("Los divisores primos de "+ num1 + " son: " + numDP(num1));
        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada inválida. Introduce una sola letra.");
        }
        public static boolean esPrimo(int a) {
        boolean primo = true;
        int i = 2;
        if (a < 2){
            primo = false;
        } 
        while (i < a && primo == true){
            if (a % i == 0){
                primo = false;
            }
            i++;
        }
       return (primo);
    }
    public static int numDP(int num){
        int cont;
        cont = 1;
        for (int i = 2; i <= num; i++ ){
            if (esPrimo(i) && num % i == 0){
                cont++;
            }
        }
        return (cont);
    }

    }

    private void ejercicio4_9(){
        try {
            int num = Integer.parseInt(inputField.getText());
            divisoresPrimosO(num, resultLabel);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Entrada inválida. Introduce una sola letra.");
        }
         public static boolean esPrimo(int a) {
        boolean primo = true;
        int i = 2;
        if (a < 2){
            primo = false;
        } 
        while (i < a && primo == true){
            if (a % i == 0){
                primo = false;
            }
            i++;
        }
       return (primo);
    }
    public static void divisoresPrimosO(int num, JLabel label){
        String texto = "Los divisores primos de "+ num + " son: ";
        for (int i = 1; i <= num; i++ ){
            if (esPrimo(i) && num % i == 0){
                texto += i + ", ";
            }
        }
        label.setText(texto);  
    }

    }

    private void ejercicio4_10(){
         try {
                int num1 = Integer.parseInt(inputField1.getText());
                int num2 = Integer.parseInt(inputField2.getText());
                if (amigos(num1,num2)){
                    resultLabel.setText(num1 +" y " + num2 + " son amigos");  
                } else {
                    resultLabel.setText(num1 +" y " + num2 + " no son amigos");
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Introduce numeros validos.");
            }
            public static boolean amigos(int a, int b){
        boolean amigos;
        if  (a == sumaDP(b) && b == sumaDP(a)) {
            amigos = true;
        } else {
            amigos = false;
        }
        return (amigos);
    }

    public static int sumaDP(int num){
        int suma = 0;
        for (int i = 1; i < num; i++){
            if (num % i == 0){
                suma += i;
            }
        }
        return (suma);
    }

    }

    private void ejercicio4_11(){
         try {
                double base = Double.parseDouble(inputField1.getText());
                int exp = Integer.parseInt(inputField2.getText());
                double res = aElevadoN(base, exp);
                resultLabel.setText(base + " elevado a " + exp + " = " + res);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Introduce numeros validos.");
            }
            public static double aElevadoN(double a, int n){
        double res = 1;
        if (n == 0){
            res += 1;     
        } else {
            for (int i = 1; i <= n; i++){
                res = res * a;
            }
        }
        return (res);
    }
    }

    public static void main(String[] args) {

    new InterfazCap4();
    }
}