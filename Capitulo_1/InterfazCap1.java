import javax.swing.*; //Libreria necesaria para swing
import java.awt.*; // Libreria necesaria para los layouts
import Ejercicio1_8.ejercicio1_8;
import Ejercicio1_9.ejercicio1_9;

public class InterfazCap1 extends JFrame {

    JTextField Valor1 = new JTextField(); //Se crean los campos de texto donde va a ir lo necesario 
    JTextField Valor2 = new JTextField(); //para que funcionen los calculos.
    JTextField Valor3 = new JTextField();

    JTextField Dia = new JTextField();
    JTextField Mes = new JTextField();
    JTextField Año = new JTextField();

    JTextArea Resultado = new JTextArea(); //Se crea donde van a ir los resultados.

    // Se Crean los botones que van a ir en la interfaz, se les pone un nombre y el texto que se va a mostrar
    JButton btnRedondeo = new JButton("Redondeo");
    JButton btnVentasFijas = new JButton("Ventas Fijas");
    JButton btnVentasVariables = new JButton("Ventas Variables");
    JButton btnCircunferencia = new JButton("Circunferencia");
    JButton btnTemperatura = new JButton("Celsius a Fahrenheit");
    JButton btnVelocidad = new JButton("Km/h a m/s");
    JButton btnHipotenusa = new JButton("Hipotenusa");
    JButton btnAreaT = new JButton("Área de un Triángulo");
    JButton btnDescomponer = new JButton("Descomponer Número");
    JButton btnNSuerte = new JButton("Número de la Suerte");

    public InterfazCap1() {
        setTitle("Capitulo 1"); // Se le pone un titulo
        setLayout(new BorderLayout(10,10)); //Se divide la ventana en secciones ara poder modificar las ubicaciones

        JPanel panelSuperior = new JPanel(new GridLayout(6, 2, 5, 5)); // Se crea un panel para la parte de arriba y se establece la cantidad de filas y columnas, y la separacion que van a tener 
        panelSuperior.setBorder(BorderFactory.createTitledBorder("Ingreso de Datos")); // Se crea un borde que va a ir marcado por el texto, va a ir arriba de los campos de texto
        panelSuperior.add(new JLabel("Valor 1:")); //Se añaden los campos con sus respectivos textos a el panelSuperior
        panelSuperior.add(Valor1);
        panelSuperior.add(new JLabel("Valor 2:"));
        panelSuperior.add(Valor2);
        panelSuperior.add(new JLabel("Valor 3:"));
        panelSuperior.add(Valor3);
        panelSuperior.add(new JLabel("Día:"));
        panelSuperior.add(Dia);
        panelSuperior.add(new JLabel("Mes:"));
        panelSuperior.add(Mes);
        panelSuperior.add(new JLabel("Año:"));
        panelSuperior.add(Año);

        JPanel panelBotones = new JPanel(new GridLayout(2, 5, 5, 5));  //Se crea un panel para los botones y se seleccionan la cantidad de filas y columnas, y la separacion que van a tener
        panelBotones.setBorder( BorderFactory.createTitledBorder("Botones")); // Se crea un borde que va a ir marcado por el texto, va a ir arriba de los campos de texto
        panelBotones.add(btnRedondeo); //Se añaden los botones al panelBotones
        panelBotones.add(btnVentasFijas);
        panelBotones.add(btnVentasVariables);
        panelBotones.add(btnCircunferencia);
        panelBotones.add(btnTemperatura);
        panelBotones.add(btnVelocidad);
        panelBotones.add(btnHipotenusa);
        panelBotones.add(btnAreaT);
        panelBotones.add(btnDescomponer);
        panelBotones.add(btnNSuerte);

        JPanel panelResultados = new JPanel(new GridLayout(6, 2, 5, 5));
        panelResultados.setBorder(BorderFactory.createTitledBorder("Resultados"));
        panelResultados.add(new JScrollPane(Resultado));

        add(panelSuperior, BorderLayout.NORTH); //se le dice al panel en que parte de la ventana tiene que estar
        add(panelBotones, BorderLayout.CENTER);
        add(panelResultados, BorderLayout.SOUTH);
        
        btnRedondeo.addActionListener(e -> redondearNumero());      //Se llama al metodo cuando se apreta el boton 
        btnVentasFijas.addActionListener(e -> ventasFijas());       //y se ejecuta el codigo de ese metodo 
        btnVentasVariables.addActionListener(e -> ventasVariables());
        btnCircunferencia.addActionListener(e -> calcularCircunferencia());
        btnTemperatura.addActionListener(e -> convertirTemperatura());
        btnVelocidad.addActionListener(e -> convertirVelocidad());
        btnHipotenusa.addActionListener(e -> calcularHipotenusa());
        btnAreaT.addActionListener(e -> areaTriangulo());
        btnDescomponer.addActionListener(e -> descomponerNumero());
        btnNSuerte.addActionListener(e -> numeroSuerte());

        setSize(900, 600);  //se decide el tamaño de la interfaz
        setLocationRelativeTo(null); //Donde va a ir ubicada la ventana al abrirse
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Ordena que se cierre todo el programa al apretar x 
        setVisible(true); //Permite que se vea la ventana
    }

    private void redondearNumero(){ //Se crean los metodos y se les pone el nombre que van a usar 
        try {
            double n = Double.parseDouble(Valor1.getText());
            int redondeo = (int) (n + 0.5); //hace que el numero sea considerado como un entero, y despues le agrega 0,5 para rednodearlo
                Resultado.setText( n + " Redondeado es: " + redondeo);
        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada invalida. Introduce un numero"); //Si el capo eta vacio o si algo no funciona salta el mensaje de error
        }
    }
    private void ventasFijas() {
        ejercicio1_8 ventana = new ejercicio1_8(); //"Llama" al ejercicio y crea una ventana donde se ejecute el codigo de ese archivo
        ventana.setVisible(true); //permite que la ventana se vea
    };
    
    private void ventasVariables(){
        ejercicio1_9 ventana = new ejercicio1_9(); //"Llama" al ejercicio y crea una ventana donde se ejecute el codigo de ese archivo
        ventana.setVisible(true); //permite que la ventana se vea
    };
    
    private void calcularCircunferencia() {
        try {
            final double PI = 3.14; //Establece a pi como variable y le da un numero
            double radio = Double.parseDouble(Valor1.getText()); //Se agrega el numero correspondiante a esta variable
            double longitud = 2 * PI * radio; //se lo multipica por dos y por PI para sacar la longitud
            double area = PI * radio * radio; //se lo multiplica al nuemro al cuadrado con PI para sacar el area
            Resultado.setText( "La longitud del Circulo es: " + longitud + " El Area de la Circunferencia es: " + area);
        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada invalida. Introduce un numero");
        }
    }
    private void convertirTemperatura() {
        try {
            double c= Double.parseDouble(Valor1.getText()); //Se almacena el numero en la variable
            double Fare = 32 + (9*c/5); //Se sacan los grados farenheit multiplicando el numero por 9, dividindolo por 5 y sumandole 32
            Resultado.setText( c + " Grados Centigrados Serian: " + Fare + " Grados Fahrenheit");
        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada invalida. Introduce un numero");
        }
    }
    private void convertirVelocidad() {
         try {
            double v= Double.parseDouble(Valor1.getText()); //Se almacena el numero en la variable
            double ms = v/3.6; //Se sacan los metros por segundo dividiendo la velocidad dada por 3.6
            Resultado.setText( v + " Kilometros por Hora Serian: " + ms + " Metros por Segundo");
        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada invalida. Introduce un numero");
        }
    }
    private void calcularHipotenusa() {
        try {
            double c1= Double.parseDouble(Valor1.getText()); //se almacenan los dos numeros en sus respectivas variables
            double c2 = Double.parseDouble(Valor2.getText());
            double hipotenusa = Math.sqrt(c1*c1 + c2*c2); //Se calcula la hipotenusa sacando la raiz cuadrada con Math.sqrt de los ods valoreas al cuadrado sumados
            Resultado.setText("La longitud de la Hipotenusa es: " + hipotenusa);
        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada invalida. Introduce un numero");
        }
    }
    private void areaTriangulo() {
        try {
            double la1 = Double.parseDouble(Valor1.getText()); //se almacenan los tres numeros en sus respectivas variables
            double la2 = Double.parseDouble(Valor2.getText());
            double la3 = Double.parseDouble(Valor3.getText());
            double p = (la1 + la2 + la3)/2; //se suman los lados y se los almacena en esta variable
            double area = Math.sqrt(p*(p-la1)*(p-la2)*(p-la3)); //se restan los lados al total y se los multiplica entre ellos y por el total. y se hace la raiz cuadrada com Mat.sqrt
            Resultado.setText( "El Area del Triangulo es: " + area);
        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada invalida. Introduce un numero");
        }
    }
    private void descomponerNumero() {
        try {
            int num = Integer.parseInt(Valor1.getText()); //Se almacena el numero en la variable
            int c1 = num/100; //Se sacan las centenas dividiendo el numero por 100
            int c2 = (num/10)%10; //Se sacan las decenas dividiendo el numero por 10 y obteniendo el ultimo numero del resto
            int c3 = num%10; //se sacan las unidades con el resto
            Resultado.setText( "Las Cifras de "+ num +" son: "+ c1 + "," + c2 + "," + c3);
        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada invalida. Introduce un numero");
        }
    }
    private void numeroSuerte() {
        try {
            int dia = Integer.parseInt(Dia.getText());  //Se almacena el numero en la variable que corresponde 
            int mes = Integer.parseInt(Mes.getText());
            int año = Integer.parseInt(Año.getText());
            int nac = dia + mes + año; //Se suman los numeros de las variables
            int c1 = (nac / 1000) % 10; //Se extraen las cifras
            int c2 = (nac / 100) % 10;
            int c3 = (nac / 10) % 10;
            int c4 = nac % 10;
            int total = c1 + c2 + c3 + c4; //se suman las cifras y ese seria el numero de la suerte
            Resultado.setText( "Su Numero de la Suerte es: " + total );
        } catch (NumberFormatException ex) {
            Resultado.setText("Entrada invalida. Introduce un numero");
        }
    }

    public static void main(String[] args) {
        new InterfazCap1();
    }
}