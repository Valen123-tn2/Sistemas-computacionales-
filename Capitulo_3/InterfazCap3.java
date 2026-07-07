import javax.swing.*;
import java.awt.*;

public class InterfazCap3 extends JFrame {

    JTextField Numero1 = new JTextField();
    JTextField Numero2 = new JTextField();
    JTextField Numero3 = new JTextField();
    JTextArea Resultado = new JTextArea();

    JButton btn31 = new JButton("Ejercicio 3.1");
    JButton btn32 = new JButton("Ejercicio 3.2");
    JButton btn33 = new JButton("Ejercicio 3.3");
    JButton btn34 = new JButton("Ejercicio 3.4");
    JButton btn35 = new JButton("Ejercicio 3.5");
    JButton btn36 = new JButton("Ejercicio 3.6");
    JButton btn37 = new JButton("Ejercicio 3.7");
    JButton btn38 = new JButton("Ejercicio 3.8");
    JButton btn39 = new JButton("Ejercicio 3.9");
    JButton btn310 = new JButton("Ejercicio 3.10");
    JButton btn311 = new JButton("Ejercicio 3.11");
    JButton btn312 = new JButton("Ejercicio 3.12");
    JButton btn313 = new JButton("Ejercicio 3.13");
    JButton btn314 = new JButton("Ejercicio 3.14");
    JButton btn315 = new JButton("Ejercicio 3.15");

    private int sumed = 0;
    private int alumnos = 0;
    private int mayores = 0;
    private int numse = (int)(Math.random()*100+1);
    private int arbolmasalto = -1;
    private int etiquetaama = 0;
    private int etiqueta = 1;
    private int desaprobados = 0;
    private int c = 0;
    private int aprobados = 0;
    private int condicionados = 0;
    private boolean primo;
    private int cprimos = 0;
    private int positivos = 0;
    private int negativos = 0;
    private int ceros = 0;
    private int contador13 = 0;     

    public InterfazCap3() {

        setTitle("Capítulo 3");
        setLayout(new BorderLayout(10,10));

        JPanel panelSuperior = new JPanel(new GridLayout(4,2,5,5));
        panelSuperior.setBorder(BorderFactory.createTitledBorder("Ingreso de Datos"));
        panelSuperior.add(new JLabel("Número 1:"));
        panelSuperior.add(Numero1);
        panelSuperior.add(new JLabel("Número 2:"));
        panelSuperior.add(Numero2);
        panelSuperior.add(new JLabel("Número 3:"));
        panelSuperior.add(Numero3);

        JPanel panelBotones = new JPanel(new GridLayout(5,3,5,5));
        panelBotones.setBorder(BorderFactory.createTitledBorder("Ejercicios"));
        panelBotones.add(btn31);
        panelBotones.add(btn32);
        panelBotones.add(btn33);
        panelBotones.add(btn34);
        panelBotones.add(btn35);
        panelBotones.add(btn36);
        panelBotones.add(btn37);
        panelBotones.add(btn38);
        panelBotones.add(btn39);
        panelBotones.add(btn310);
        panelBotones.add(btn311);
        panelBotones.add(btn312);
        panelBotones.add(btn313);
        panelBotones.add(btn314);
        panelBotones.add(btn315);

        JPanel panelResultado = new JPanel(new BorderLayout());
        panelResultado.setBorder(BorderFactory.createTitledBorder("Resultado"));
        Resultado.setEditable(false);
        panelResultado.add(new JScrollPane(Resultado));
        add(panelSuperior, BorderLayout.NORTH);
        add(panelBotones, BorderLayout.CENTER);
        add(panelResultado, BorderLayout.SOUTH);

        btn31.addActionListener(e -> ejercicio3_1());
        btn32.addActionListener(e -> ejercicio3_2());
        btn33.addActionListener(e -> ejercicio3_3());
        btn34.addActionListener(e -> ejercicio3_4());
        btn35.addActionListener(e -> ejercicio3_5());
        btn36.addActionListener(e -> ejercicio3_6());
        btn37.addActionListener(e -> ejercicio3_7());
        btn38.addActionListener(e -> ejercicio3_8());
        btn39.addActionListener(e -> ejercicio3_9());
        btn310.addActionListener(e -> ejercicio3_10());
        btn311.addActionListener(e -> ejercicio3_11());
        btn312.addActionListener(e -> ejercicio3_12());
        btn313.addActionListener(e -> ejercicio3_13());
        btn314.addActionListener(e -> ejercicio3_14());
        btn315.addActionListener(e -> ejercicio3_15());

        setSize(1000,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    private void ejercicio3_1(){
        int num = Integer.parseInt(Numero1.getText());
        while (num != 0) {
            boolean par = num % 2 == 0 ? true : false;
            boolean positivo =  num >= 0 ? true : false;
            Resultado.setText("Es Par?: "+par+" Es Positivo?: "+positivo+" Su Cuadrado es: "+ num*num);
            num = Integer.parseInt(Numero1.getText());  
            Numero1.setText("");
            break;
        }

    }

    private void ejercicio3_2(){
        try {
            int edad = Integer.parseInt(Numero1.getText());
            while (edad >= 0) {
                sumed += edad;
                alumnos++;
                if (edad >= 18) {
                    mayores++;
                }
                double media = (double) sumed / alumnos;
                Resultado.setText("Suma: " + sumed +" | Media: " + media +" | Alumnos: " + alumnos +" | Mayores: " + mayores);
                Numero1.setText("");
                break;
            }
            if (edad < 0) {
                double media = (double) sumed / alumnos;
                JOptionPane.showMessageDialog(null,"RESULTADOS FINALES\n\n" +"Suma edades: " + sumed +"\nMedia: " + media +"\nCantidad alumnos: " + alumnos +"\nMayores de edad: " + mayores);
                sumed = 0;
                alumnos = 0;
                mayores = 0;
            }

        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada inválida. Introduce un número");
        }
    }

    private void ejercicio3_3(){
        try {
            int num = Integer.parseInt(Numero1.getText());
            while (numse != num && num != -1) {
                if (numse < num){
                    Resultado.setText("Menor");
                } else {
                    Resultado.setText("Mayor");
                } 
                Numero1.setText("");
                break;
            }
            if (numse == num){
                Resultado.setText("Adivinaste");
                numse = (int)(Math.random()*100+1);
            } else if (num == -1) {
                Resultado.setText("En Otro Momento Sera");
            }
        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada inválida. Introduce un número");
        }
    }

    private void ejercicio3_4(){
        try {
            int num = Integer.parseInt(Numero1.getText());
            Resultado.setText("");
            for (int i = 1; i <= num; i++){
                Resultado.setText(Resultado.getText() + i + " | ");
            }
        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada inválida. Introduce un número");
        }
    }

    private void ejercicio3_5(){
        try {
            int num = Integer.parseInt(Numero1.getText());
            int min = Integer.parseInt(Numero2.getText());
            int max = Integer.parseInt(Numero3.getText());
            while (! (min <= num && num <= max)){
                Resultado.setText(num+ " No Pertenece al Rango");
                break;
            }
            if (min <= num && num <= max){
                Resultado.setText(num+ " Pertenece al Rango");
            }
        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada inválida. Introduce un número");
        }
    }

    private void ejercicio3_6(){
        try {
            Resultado.setText("");
            for (int i = 7; i < 100; i += 7){
                Resultado.setText(Resultado.getText() + i + " | ");
            }
        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada inválida. Introduce un número");
        }
    }

    private void ejercicio3_7(){
        try {
            double producto = 1;
            for (int i = 1; i < 20; i+= 2){
                producto = producto * i;
            }
            Resultado.setText("El Producto de los 10 Primeros Numeros Impares es: "+producto);
        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada inválida. Introduce un número");
        }
    }

    private void ejercicio3_8(){
        try {
            int num = Integer.parseInt(Numero1.getText());
            double facto = 1; 
            for (int i = num; i > 0; i--){
                facto *= i;
            }
            Resultado.setText("El Factorial de "+num+" es: "+facto);

        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada inválida. Introduce un número");
        }
    }

    private void ejercicio3_9(){
        try {
            int altura = Integer.parseInt(Numero1.getText());
            while (altura > arbolmasalto){
                arbolmasalto = altura;
                etiquetaama = etiqueta;
                break;
            }
            etiqueta++;
            if (arbolmasalto == -1){
                Resultado.setText("No hay Ningun Arbol");
            } else {
                Resultado.setText("El Arbol mas Alto Mide: "+arbolmasalto+" Metros Y es el Arbol con la Etiqueta: "+etiquetaama);
            }
        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada inválida. Introduce un número");
        }
    }

    private void ejercicio3_10(){
        try {
            int num = Integer.parseInt(Numero1.getText());
            while (1<= num && num <= 10){
                Resultado.setText("");
                for (int i = 1; i <= 10; i++){
                    Resultado.setText(Resultado.getText() + num+" x "+ i + " = "+ num*i+ " | "); 
                } 
                break;
            }
            if (!(1 <= num && num <= 10)){
                Resultado.setText("Ingrese un Numero 1 al 10"); 
            }
        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada inválida. Introduce un número");
        }
    }

    private void ejercicio3_11(){
        try {
            Resultado.setText("");
            for (int tabla = 1; tabla <= 10; tabla++){
                for (int i = 1; i <= 10; i++){
                    Resultado.append(tabla +" x "+ i + " = "+ tabla*i+ " | "+"\t"); 
                }
                Resultado.append("\n");
            }
        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada inválida. Introduce un número");
        }
    }

    private void ejercicio3_12(){
        try {
            for (int i = 0; i < 5; i++){
                int nota = Integer.parseInt(Numero1.getText());
                if (nota < 4){
                    desaprobados += 1;
                    Resultado.setText("Nota Guardada");
                }
                c++;
                break;
            }   
            if (c == 5){
                if (desaprobados > 0){
                    Resultado.setText("Hay "+desaprobados+" Alumnos Desaprobados con menos de 4"); 
                } else {
                    Resultado.setText("No Hay Alumnos Desaprobados");
                }
            }
            Numero1.setText("");
        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada inválida. Introduce un número");
        }
    }

    private void ejercicio3_13(){
        try {
            int num = Integer.parseInt(Numero1.getText());
            if (num > 0) {
                positivos++;
            } else if (num < 0) {
                negativos++;
            } else {
                ceros++;
            }
            contador13++;
            if (contador13 < 10) {
                Resultado.setText("Número guardado (" + contador13 + "/10)");
            } else {
                Resultado.setText("Positivos: " + positivos +"\nNegativos: " + negativos +"\nCeros: " + ceros);
            positivos = 0;
            negativos = 0;
            ceros = 0;
            contador13 = 0;
        }
        Numero1.setText("");

        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada inválida. Introduce un número");
        }
    }

    private void ejercicio3_14() {
        try {
            int num = Integer.parseInt(Numero1.getText());
            Resultado.setText("");
            for (int i = 2; i <= num; i++) {
                boolean primo = true;
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                    primo = false;
                    break;
                    }
                }
                if (primo) {
                Resultado.append(i + " ");
                }
            }

        } catch (NumberFormatException ex) {
        Resultado.setText("Entrada inválida. Introduce un número");
        }
    }

    private void ejercicio3_15(){
        try {
            int num = Integer.parseInt(Numero1.getText());
            for (int i = 1; i <= num; i++){
                primo = true;
                int j = 2;
                while (j <= i -1 && primo == true){
                    if (i % j == 0){
                        primo = false;
                    }
                    j++;
                }
                if (primo){
                    cprimos++;
                    Resultado.setText(i+" es Primo");
                }
            }
            Resultado.setText("Del 1 a "+num+", Hay "+cprimos+" Numeros Primos");
            cprimos = 0;

        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada inválida. Introduce un número");
        }
    }

    public static void main(String[] args) {

        new InterfazCap3();

    }

}