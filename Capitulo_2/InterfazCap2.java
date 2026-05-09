import javax.swing.*; //Libreria necesaria para swing
import java.awt.*; // Libreria necesaria para los layouts

public class InterfazCap2 extends JFrame {

    JTextField Numero1 = new JTextField(); //Se crean los campos de texto donde va a ir lo necesario 
    JTextField Numero2 = new JTextField(); //para que funcionen los calculos.
    JTextField Numero3 = new JTextField(); 

    JTextField Dia = new JTextField();
    JTextField Mes = new JTextField();
    JTextField Año = new JTextField();

    JTextArea Resultado = new JTextArea(); //Se crea donde van a ir los resultados.

    // Se Crean los botones que van a ir en la interfaz, se les pone un nombre y el texto que se va a mostrar
    JButton btnParImpar = new JButton("Par o Impar");
    JButton btnComparar = new JButton("Comparar");
    JButton btnMayor = new JButton("Mayor");
    JButton btnIgualMayor = new JButton("Iguales o Mayor");
    JButton btnCasiCero = new JButton("Casi Cero");
    JButton btnMayorMenor = new JButton("Mayor y Menor");
    JButton btnOrdenar = new JButton("Ordenar 3");
    JButton btnNota = new JButton("Clasificar Nota");
    JButton btnFecha = new JButton("Validar Fecha");

    public InterfazCap2() {
        setTitle("Capitulo 2"); // Se le pone un titulo
        setLayout(new BorderLayout(10,10)); //Se divide la ventana en secciones ara poder modificar las ubicaciones

        JPanel panelSuperior = new JPanel(new GridLayout(6, 2, 5, 5)); // Se crea un panel para la parte de arriba y se establece la cantidad de filas y columnas, y la separacion que van a tener 
        panelSuperior.setBorder(BorderFactory.createTitledBorder("Ingreso de Datos")); // Se crea un borde que va a ir marcado por el texto, va a ir arriba de los campos de texto
        panelSuperior.add(new JLabel("Número 1:")); //Se añaden los campos con sus respectivos textos a el panelSuperior
        panelSuperior.add(Numero1);
        panelSuperior.add(new JLabel("Número 2:"));
        panelSuperior.add(Numero2);
        panelSuperior.add(new JLabel("Número 3:"));
        panelSuperior.add(Numero3);
        panelSuperior.add(new JLabel("Día:"));
        panelSuperior.add(Dia);
        panelSuperior.add(new JLabel("Mes:"));
        panelSuperior.add(Mes);
        panelSuperior.add(new JLabel("Año:"));
        panelSuperior.add(Año);

        JPanel panelBotones = new JPanel(new GridLayout(2, 5, 5, 5));  //Se crea un panel para los botones y se seleccionan la cantidad de filas y columnas, y la separacion que van a tener
        panelBotones.setBorder( BorderFactory.createTitledBorder("Botones")); // Se crea un borde que va a ir marcado por el texto, va a ir arriba de los campos de texto
        panelBotones.add(btnParImpar); //Se añaden los botones al panelBotones
        panelBotones.add(btnComparar);
        panelBotones.add(btnMayor);
        panelBotones.add(btnIgualMayor);
        panelBotones.add(btnCasiCero);
        panelBotones.add(btnMayorMenor);
        panelBotones.add(btnOrdenar);
        panelBotones.add(btnNota);
        panelBotones.add(btnFecha);

        JPanel panelResultados = new JPanel(new GridLayout(6, 2, 5, 5));
        panelResultados.setBorder(BorderFactory.createTitledBorder("Resultados"));
        panelResultados.add(new JScrollPane(Resultado));

        add(panelSuperior, BorderLayout.NORTH); //se le dice al panel en que parte de la ventana tiene que estar
        add(panelBotones, BorderLayout.CENTER);
        add(panelResultados, BorderLayout.SOUTH);
        
        btnParImpar.addActionListener(e -> parImpar());             //Se llama al modulo cuando se apreta el boton 
        btnComparar.addActionListener(e -> compararNumeros());      //y se ejecuta el codigo de ese modulo 
        btnMayor.addActionListener(e -> mayorNumero());
        btnIgualMayor.addActionListener(e -> igualesOMayor());
        btnCasiCero.addActionListener(e -> casiCero());
        btnMayorMenor.addActionListener(e -> mayorMenor());
        btnOrdenar.addActionListener(e -> ordenarTres());
        btnNota.addActionListener(e -> clasificarNota());
        btnFecha.addActionListener(e -> validarFecha());

        setSize(900, 600);  //se decide el tamaño de la interfaz
        setLocationRelativeTo(null); //Donde va a ir ubicada la ventana al abrirse
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Ordena que se cierre todo el programa al apretar x 
        setVisible(true); //Permite que se vea la ventana
    }

    private void parImpar(){
        try {
            int num = Integer.parseInt(Numero1.getText());
            if (num %2 == 0){
                Resultado.setText( "Su Numero es Par");    
            } else {
                Resultado.setText( "Su Numero es Impar");
            }
        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada invalida. Introduce un numero");
        }
    }
    private void compararNumeros() {
        try {
            int num1 = Integer.parseInt(Numero1.getText());
            int num2 = Integer.parseInt(Numero2.getText());
            if (num1 == num2){
                Resultado.setText( "Los Numeros son Iguales");    
            } else {
                Resultado.setText( "Los Numeros no son Iguales");
            }
        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada invalida. Introduce un numero");
        }
    }
    private void mayorNumero(){
        try {
            int num1 = Integer.parseInt(Numero1.getText());
            int num2 = Integer.parseInt(Numero2.getText());   
            if (num1 > num2){
                Resultado.setText( num1 + " es Mayor que " + num2);
            } else {
                Resultado.setText( num2 + " es Mayor que " + num1);
            }
        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada invalida. Introduce un numero");
        }
    }
    private void igualesOMayor() {
        try {
            int num1 = Integer.parseInt(Numero1.getText());
            int num2 = Integer.parseInt(Numero2.getText());
            if (num1 == num2){
                Resultado.setText( "Los Numeros son Iguales");    
            } else if (num1 > num2){
                Resultado.setText( num1 + " es Mayor que " + num2);
            } else {
                Resultado.setText( num2 + " es Mayor que " + num1);
            }
        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada invalida. Introduce un numero");
        }
    }
    private void casiCero() {
        try {
            double num = Double.parseDouble(Numero1.getText());
            if (-1 < num && num != 0 && num < 1){
                Resultado.setText( "El Numero es Casi-Cero");    
            } else {
                Resultado.setText("El Numero No es Casi-Cero ");
            }
        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada invalida. Introduce un numero");
        }
    }
    private void mayorMenor() {
        try {
            double num1 = Double.parseDouble(Numero1.getText());
            double num2 = Double.parseDouble(Numero2.getText());
            double mayor = num1 > num2 ? num1 : num2;
            double menor = num1 < num2 ? num1 : num2;
            Resultado.setText(mayor + ", " + menor);
        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada invalida. Introduce un numero");
        }
    }
    private void ordenarTres() {
        try {
            int num1 = Integer.parseInt(Numero1.getText());
            int num2 = Integer.parseInt(Numero2.getText());
            int num3 = Integer.parseInt(Numero3.getText());

            if (num1 > num2 && num2 > num3) {
                Resultado.setText(num1 + ", " + num2 + ", " + num3);
            } else if (num1 > num3 && num3 > num2) {
                Resultado.setText(num1 + ", " + num3 + ", " + num2);
            } else if (num2 > num1 && num1 > num3) {
                Resultado.setText(num2 + ", " + num1 + ", " + num3);
            } else if (num2 > num3 && num3 > num1) {
                Resultado.setText(num2 + ", " + num3 + ", " + num1);
            } else if (num3 > num1 && num1 > num2) {
                Resultado.setText(num3 + ", " + num1 + ", " + num2);
            } else if (num3 > num2 && num2 > num1) {
                Resultado.setText(num3 + ", " + num2 + ", " + num1);
            } else {
                Resultado.setText("Entrada invalida. Introduce un numero");
            }
        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada invalida. Introduce un numero");
        }
    }
    private void clasificarNota() {
        try {
            int nota = Integer.parseInt(Numero1.getText());
            if (0<= nota && nota < 5) {
                Resultado.setText("Insuficiente");
            } else if (nota == 5){
                Resultado.setText("Suficiente");
            } else if (nota == 6){
                Resultado.setText("Bien");
            } else if (nota == 7 || nota == 8){
                Resultado.setText("Notable");
            } else if (nota == 9 || nota == 10){
                Resultado.setText("Sobresaliente");
            }
        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada invalida. Introduce un numero");
        }
    }
    private void validarFecha() {
        try {
            int dia = Integer.parseInt(Dia.getText());
            int mes = Integer.parseInt(Mes.getText());
            int año = Integer.parseInt(Año.getText());
            if (año == 0) {
                Resultado.setText("Fecha incorrecta");
            } else if (mes == 2 && (1 <= dia && dia <=28)){
                Resultado.setText("La Fecha es Correcta");
            } else if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && (1 <= dia && dia <= 30)){
                Resultado.setText("La Fecha es Correcta");
            } else if ((mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10|| mes == 12) && (1 <= dia && dia <= 31)){
                Resultado.setText("La Fecha es Correcta");
            } else {
                Resultado.setText("Entrada invalida. Introduce una Fecha Real");
            }
        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada invalida. Introduce un numero");
        }
    }

    public static void main(String[] args) {
        new InterfazCap2();
    }
}