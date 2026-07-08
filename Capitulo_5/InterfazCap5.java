import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class InterfazCap5 extends JFrame {

    JTextField Numero1 = new JTextField();
    JTextField Numero2 = new JTextField();
    JTextField Frase = new JTextField();
    JTextField Palabra = new JTextField();
    JTextArea Resultado = new JTextArea(12,40);

    JButton btn51 = new JButton("Ejercicio 5.1");
    JButton btn52 = new JButton("Ejercicio 5.2");
    JButton btn53 = new JButton("Ejercicio 5.3");
    JButton btn54 = new JButton("Ejercicio 5.4");
    JButton btn55 = new JButton("Ejercicio 5.5");
    JButton btn56 = new JButton("Ejercicio 5.6");
    JButton btn57 = new JButton("Ejercicio 5.7");
    JButton btn58 = new JButton("Ejercicio 5.8");
    JButton btn59 = new JButton("Ejercicio 5.9");
    JButton btn510 = new JButton("Ejercicio 5.10");
    JButton btn511 = new JButton("Ejercicio 5.11");
    JButton btn512 = new JButton("Ejercicio 5.12");
    JButton btn513 = new JButton("Ejercicio 5.13");
    JButton btn514 = new JButton("Ejercicio 5.14");
    JButton btn515 = new JButton("Ejercicio 5.15");

    private double[] reales = new double[5];
    private int indiceReales = 0;
    private int[] tabla = null;
    private int cantidad = 0;
    private int indice = 0;
    private int[] tabla3 = null;
    private int cantidad3 = 0;
    private int indice3 = 0;
    private int[] tabla4 = {5,12,7,20,8,15};
    private int cantidad4 = 6;
    private int[] tabla5 = new int[20];
    private int cantidad5 = 0;
    private int[] tablaOrdenada = new int[8];
    private int cantidad56 = 0;
    private int[] t1 = new int[6];
    private int[] t2 = new int[6];
    private int[] t3 = new int[12];
    private int cantidad1 = 0;
    private int cantidad2 = 0;
    private int cantidad58 = 0;
    private int[] secreto;
    private int[] intento;
    private boolean generado = false;
    private int[] tabla510 = new int[10];
    private int cantidad510 = 0;
    private int[] tabla511 = new int[10];
    private int cantidad511 = 0;
    private int[] tabla512 = new int[10];
    private int cantidad512 = 0;
    private int[] tabla514 = new int[10];
    private int cantidad514 = 0;
    private int[] tabla515 = new int[10];
    private int cantidad515 = 0;

    public InterfazCap5(){

        setTitle("Capítulo 5");
        setLayout(new BorderLayout(10,10));

        JPanel panelSuperior = new JPanel(new GridLayout(4,2,5,5));
        panelSuperior.setBorder(BorderFactory.createTitledBorder("Ingreso de Datos"));
        panelSuperior.add(new JLabel("Número 1"));
        panelSuperior.add(Numero1);
        panelSuperior.add(new JLabel("Número 2"));
        panelSuperior.add(Numero2);
        panelSuperior.add(new JLabel("Frase"));
        panelSuperior.add(Frase);
        panelSuperior.add(new JLabel("Palabra"));
        panelSuperior.add(Palabra);

        JPanel panelBotones = new JPanel(new GridLayout(5,3,5,5));
        panelBotones.setBorder(BorderFactory.createTitledBorder("Ejercicios"));
        panelBotones.add(btn51);
        panelBotones.add(btn52);
        panelBotones.add(btn53);
        panelBotones.add(btn54);
        panelBotones.add(btn55);
        panelBotones.add(btn56);
        panelBotones.add(btn57);
        panelBotones.add(btn58);
        panelBotones.add(btn59);
        panelBotones.add(btn510);
        panelBotones.add(btn511);
        panelBotones.add(btn512);
        panelBotones.add(btn513);
        panelBotones.add(btn514);
        panelBotones.add(btn515);

        JPanel panelResultado = new JPanel(new BorderLayout());
        panelResultado.setBorder(BorderFactory.createTitledBorder("Resultado"));
        Resultado.setEditable(false);
        Resultado.setFont(new Font("Monospaced",Font.PLAIN,14));
        panelResultado.add(new JScrollPane(Resultado));
        add(panelSuperior,BorderLayout.NORTH);
        add(panelBotones,BorderLayout.CENTER);
        add(panelResultado,BorderLayout.SOUTH);

        btn51.addActionListener(e -> ejercicio5_1());
        btn52.addActionListener(e -> ejercicio5_2());
        btn53.addActionListener(e -> ejercicio5_3());
        btn54.addActionListener(e -> ejercicio5_4());
        btn55.addActionListener(e -> ejercicio5_5());
        btn56.addActionListener(e -> ejercicio5_6());
        btn57.addActionListener(e -> ejercicio5_7());
        btn58.addActionListener(e -> ejercicio5_8());
        btn59.addActionListener(e -> ejercicio5_9());
        btn510.addActionListener(e -> ejercicio5_10());
        btn511.addActionListener(e -> ejercicio5_11());
        btn512.addActionListener(e -> ejercicio5_12());
        btn513.addActionListener(e -> ejercicio5_13());
        btn514.addActionListener(e -> ejercicio5_14());
        btn515.addActionListener(e -> ejercicio5_15());

        setSize(1000,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void ejercicio5_1(){
        try {
            double num = Double.parseDouble(Numero1.getText());
            reales[indiceReales] = num;
            indiceReales++;
            if(indiceReales == 5){
                String resultado = "Los números son:\n";
                for(int i=0;i<5;i++){
                    resultado += reales[i] + " | ";
                }
                Resultado.setText(resultado);
                indiceReales = 0;
            }
            Numero1.setText("");

        } catch(NumberFormatException ex){
            Resultado.setText("Entrada inválida.");
        }
    }

    private void ejercicio5_2(){
        try{
            if(tabla == null){
                cantidad = Integer.parseInt(Numero1.getText());
                tabla = new int[cantidad];
                indice = 0;
                Resultado.setText("Ingrese los " + cantidad + " números.");
                Numero1.setText("");
                return;
            }
            int num = Integer.parseInt(Numero1.getText());
            tabla[indice] = num;
            indice++;

            if(indice == cantidad){
                String texto = "Orden inverso:\n";
                for(int i=cantidad-1;i>=0;i--){
                    texto += tabla[i] + " | ";
                }
                Resultado.setText(texto);
                tabla = null;
                indice = 0;
            }
            Numero1.setText("");

        }catch(NumberFormatException ex){
            Resultado.setText("Entrada inválida.");
        }
    }

    private void ejercicio5_3(){
        try{
            if(tabla3 == null){
                cantidad3 = Integer.parseInt(Numero1.getText());
                tabla3 = new int[cantidad3];
                indice3 = 0;
                Resultado.setText("Ingrese los números.");
                Numero1.setText("");
                return;
            }
            tabla3[indice3] = Integer.parseInt(Numero1.getText());
            indice3++;

            if(indice3 == cantidad3){
                int sumaP = 0;
                int sumaN = 0;
                int contP = 0;
                int contN = 0;
                int contC = 0;
                for(int i=0;i<cantidad3;i++){
                    if(tabla3[i] > 0){
                        sumaP += tabla3[i];
                        contP++;
                    }
                    else if(tabla3[i] < 0){
                        sumaN += tabla3[i];
                        contN++;
                    }
                    else{
                        contC++;
                    }
                }
                String texto = "";

                if(contP>0){
                    texto += "Media positivos: "+(double)sumaP/contP+"\n";
                } else {
                    texto += "No hay positivos\n";
                }
                if(contN>0){
                    texto += "Media negativos: "+(double)sumaN/contN+"\n";
                } else {
                    texto += "No hay negativos\n";
                }
                texto += "Cantidad de ceros: "+contC;
                Resultado.setText(texto);
                tabla3 = null;
                indice3 = 0;
            }
            Numero1.setText("");

        }catch(NumberFormatException ex){
            Resultado.setText("Entrada inválida.");
        }
    }

    private void ejercicio5_4(){
        try{
            int indice = Integer.parseInt(Numero1.getText());
            if(indice<0 || indice>=cantidad4){
                Resultado.setText("Índice inválido.");
                return;
            }

            for(int i=indice;i<cantidad4-1;i++){
                tabla4[i]=tabla4[i+1];
            }
            cantidad4--;
            String texto="Tabla:\n";

            for(int i=0;i<cantidad4;i++){
                texto+=tabla4[i]+" | ";
            }
            Resultado.setText(texto);

        }catch(NumberFormatException ex){
            Resultado.setText("Entrada inválida.");
        }
    }

    private void ejercicio5_5(){
        try{
            int num = Integer.parseInt(Numero1.getText());
            int i = cantidad5-1;
            while(i>=0 && tabla5[i]>num){
                tabla5[i+1]=tabla5[i];
                i--;
            }
            tabla5[i+1]=num;
            cantidad5++;
            String texto="Tabla ordenada:\n";

            for(i=0;i<cantidad5;i++){
                texto+=tabla5[i]+" | ";
            }
            Resultado.setText(texto);
            Numero1.setText("");

        }catch(NumberFormatException ex){
            Resultado.setText("Entrada inválida.");
        }
    }

    private void ejercicio5_6() {
        try {
            int num = Integer.parseInt(Numero1.getText());
            if (cantidad56 == 8) {
                Resultado.setText("La tabla está completa.");
                return;
            }
            tablaOrdenada[cantidad56] = num;
            cantidad56++;
            ordenar(tablaOrdenada, cantidad56);
            Resultado.setText("Tabla ordenada:\n" + mostrar(tablaOrdenada, cantidad56));

        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada inválida.");
        }
    }

    private void ejercicio5_7() {
        try {
            int num = Integer.parseInt(Numero1.getText());
            if (cantidad1 < 6) {
                t1[cantidad1] = num;
                cantidad1++;
                if (cantidad1 == 6) {
                    ordenar(t1, 6);
                    Resultado.setText("Primera tabla cargada.\nAhora ingrese la segunda.");
                } else {
                    Resultado.setText("Tabla 1:\n" + mostrar(t1, cantidad1));
                }
            } else if (cantidad2 < 6) {
                t2[cantidad2] = num;
                cantidad2++;
                if (cantidad2 == 6) {
                    ordenar(t2, 6);
                    fusionar();
                    Resultado.setText(
                            "Tabla 1:\n" + mostrar(t1,6) +
                            "\nTabla 2:\n" + mostrar(t2,6) +
                            "\nFusion:\n" + mostrar(t3,12)
                    );
                } else {
                    Resultado.setText("Tabla 2:\n" + mostrar(t2,cantidad2));
                }
            }

        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada inválida.");
        }
    }

    private void fusionar() {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < 6 && j < 6) {
            if (t1[i] <= t2[j]) {
                t3[k] = t1[i];
                i++;
            } else {
                t3[k] = t2[j];
                j++;
            }
            k++;
        }

        while (i < 6) {
            t3[k] = t1[i];
            i++;
            k++;
        }

        while (j < 6) {
            t3[k] = t2[j];
            j++;
            k++;
        }

    }
    private void ejercicio5_8() {
        try {
            if (!generado) {
                cantidad58 = Integer.parseInt(Numero1.getText());
                secreto = new int[cantidad58];
                intento = new int[cantidad58];
                generar();
                generado = true;
                Resultado.setText("Combinación generada.\nIngrese " + cantidad58 + " dígitos en Datos.");
                return;
            }
            String numero = Numero2.getText();

            if (numero.length() != cantidad58) {
                Resultado.setText("Debe ingresar " + cantidad58 + " dígitos.");
                return;
            }
            boolean gano = true;
            String pista = "";

            for (int i = 0; i < cantidad58; i++) {
                intento[i] = Character.getNumericValue(numero.charAt(i));
                if (intento[i] > secreto[i]) {
                    pista += "Posición " + (i+1) + ": Menor\n";
                    gano = false;
                } else if (intento[i] < secreto[i]) {
                    pista += "Posición " + (i+1) + ": Mayor\n";
                    gano = false;
                } else {
                    pista += "Posición " + (i+1) + ": Igual\n";
                }
            }

            if (gano) {
                Resultado.setText("¡Combinación correcta!");
            } else {
                Resultado.setText(pista);
            }

        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada inválida.");
        }
    }

    private void generar() {
        Random random = new Random();
        for (int i = 0; i < cantidad58; i++) {
            secreto[i] = random.nextInt(5) + 1;
        }
    }   

    private void ejercicio5_9() {
        String frase = Frase.getText().trim();
        String palabra = Palabra.getText().trim();
        if (frase.isEmpty() || palabra.isEmpty()) {
            Resultado.setText("Complete ambos campos.");
            return;
        }
        int contador = 0;
        String[] palabras = frase.split(" ");

        for (int i = 0; i < palabras.length; i++) {
            if (palabras[i].equalsIgnoreCase(palabra)) {
                contador++;
            }
        }
        Resultado.setText("La palabra aparece " + contador + " veces.");
    }

    private void ejercicio5_10() {
        try {
            if (cantidad510 == 10) {
                ordenar(tabla510,10);
                Resultado.setText("Tabla ordenada:\n" + mostrar(tabla510,10));
                return;
            }
            tabla510[cantidad510] = Integer.parseInt(Numero1.getText());
            cantidad510++;
            Resultado.setText("Número guardado ("+cantidad510+"/10)");

        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada inválida.");
        }
    }
    private void ejercicio5_11() {
        try {
            if (cantidad511 == 10) {
                ordenar(tabla511,10);
                Resultado.setText("");

                for(int i=9;i>=0;i--){
                    Resultado.append(tabla511[i]+" ");
                }
                return;
            }
            tabla511[cantidad511]=Integer.parseInt(Numero1.getText());
            cantidad511++;
            Resultado.setText("Número guardado ("+cantidad511+"/10)");

        } catch(NumberFormatException ex){
            Resultado.setText("Entrada inválida.");
        }
    }

    private void ejercicio5_12(){
        try{
            if(cantidad512==10){
                int mayor=tabla512[0];
                int menor=tabla512[0];
                for(int i=1;i<10;i++){
                    if(tabla512[i]>mayor){
                        mayor=tabla512[i];
                    }
                    if(tabla512[i]<menor){
                        menor=tabla512[i];
                    }
                }
                Resultado.setText("Mayor: "+mayor+
                                "\nMenor: "+menor);
                return;
            }
            tabla512[cantidad512]=Integer.parseInt(Numero1.getText());
            cantidad512++;
            Resultado.setText("Número guardado ("+cantidad512+"/10)");

        }catch(NumberFormatException ex){
            Resultado.setText("Entrada inválida.");
        }
    }
    private void ejercicio5_13() {
        String frase = Frase.getText().trim().toLowerCase();
        if (frase.isEmpty()) {
            Resultado.setText("Debe ingresar una frase.");
            return;
        }
        int[] numVeces = new int[26];

        for (int i = 0; i < frase.length(); i++) {
            if (Character.isLetter(frase.charAt(i))) {
                numVeces[frase.charAt(i) - 'a']++;
            }
        }
        String resultado = "";

        for (int i = 0; i < 26; i++) {
            if (numVeces[i] != 0) {
                resultado += (char)(i + 'a') + ": "
                        + numVeces[i] + " veces\n";
            }
        }
        Resultado.setText(resultado);
    }
    
    private void ejercicio5_14(){
        try{
            if(cantidad514<10){
                tabla514[cantidad514]=Integer.parseInt(Numero1.getText());
                cantidad514++;
                Resultado.setText("Número guardado ("+cantidad514+"/10)");
                return;
            }
            int[] aux=new int[10];
            int cont=0;

            for(int i=0;i<10;i++){
                boolean repetido=false;
                for(int j=0;j<cont;j++){
                    if(tabla514[i]==aux[j]){
                        repetido=true;
                    }
                }
                if(!repetido){
                    aux[cont]=tabla514[i];
                    cont++;
                }
            }
            Resultado.setText("Sin repetidos:\n");

            for(int i=0;i<cont;i++){
                Resultado.append(aux[i]+" ");
            }

        }catch(NumberFormatException ex){
            Resultado.setText("Entrada inválida.");
        }
    }    

    private void ejercicio5_15(){
        try{
            if(cantidad515<10){
                tabla515[cantidad515]=Integer.parseInt(Numero1.getText());
                cantidad515++;
                Resultado.setText("Número guardado ("+cantidad515+"/10)");
                return;
            }
            int suma=0;
            int mayor=tabla515[0];
            int menor=tabla515[0];

            for(int i=0;i<10;i++){
                suma+=tabla515[i];
                if(tabla515[i]>mayor){
                    mayor=tabla515[i];
                }

                if(tabla515[i]<menor){
                    menor=tabla515[i];
                }
            }
            double media=(double)suma/10;
            Resultado.setText(
                    "Suma: "+suma+
                    "\nMedia: "+media+
                    "\nMayor: "+mayor+
                    "\nMenor: "+menor
            );

        }catch(NumberFormatException ex){
            Resultado.setText("Entrada inválida.");
        }
    }
    private void ordenar(int[] tabla,int cantidad){
        for(int i=0;i<cantidad-1;i++){
            for(int j=i+1;j<cantidad;j++){
                if(tabla[i]>tabla[j]){
                    int aux=tabla[i];
                    tabla[i]=tabla[j];
                    tabla[j]=aux;
                }
            }
        }
    }

    private String mostrar(int[] tabla,int cantidad){
        String texto="";
        for(int i=0;i<cantidad;i++){
            texto+=tabla[i]+" ";
        }
        return texto;
    }
    public static void main(String[] args) {
            new InterfazCap5();
    }
}
