//Implementar el juego del anagrama, que consiste en que un jugador escribe una 
//palabra o frase, y la aplicación muestra un anagrama (transposición de los 
//caracteres) del texto introducido generado al azar. A continuación otro jugador 
//tiene que acertar cuál es el texto original. La aplicación no debe permitir que 
//el texto introducido por el jugador 1 sea la cadena vacía. Por ejemplo, si el 
//jugador 1 escribe "teclado", la aplicación muestra como pista un anagrama al azar:
//"etcloda".

package Ejercicio6_14;
import javax.swing.*;
import java.util.Random;

public class ejercicio6_14 extends JFrame {

    String textoOriginal = "";

    public ejercicio6_14() {

        setTitle("Ejercicio 6.14");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField inputField = new JTextField(30);
        JTextField inputField2 = new JTextField(30);
        JButton submitButton = new JButton("Generar anagrama");
        JButton submitButton2 = new JButton("Adivinar");
        JLabel resultLabel = new JLabel("");
        JLabel resultLabel2 = new JLabel("");
        JPanel panelJugador1 = new JPanel();
        JPanel panelPista = new JPanel();


        submitButton.addActionListener(e -> {
            String texto = inputField.getText().trim();
            if (texto.isEmpty()) {
                resultLabel.setText("Debe ingresar una palabra o frase.");
                return;
            }
            textoOriginal = texto;
            String anagrama = generarAnagrama(texto);
            resultLabel.setText("Pista: " + anagrama);
            inputField.setEditable(false);
            panelJugador1.setVisible(false);
        });

        submitButton2.addActionListener(e -> {
            String respuesta = inputField2.getText().trim();
            if (respuesta.isEmpty()) {
                resultLabel2.setText("Debe ingresar una respuesta.");
                return;
            }
            if (respuesta.equalsIgnoreCase(textoOriginal)) {
                resultLabel2.setText("Correcto, has acertado.");
            } else {
                resultLabel2.setText("Incorrecto, prueba otra vez.");
            }
        });

        panelJugador1.add(new JLabel("Texto jugador 1: "));
        panelJugador1.add(inputField);
        panelJugador1.add(submitButton);
        panelPista.add(resultLabel);

        JPanel panel = new JPanel();
        panel.add(panelJugador1);
        panel.add(panelPista);
        panel.add(new JLabel("Texto jugador 2: "));
        panel.add(inputField2);
        panel.add(submitButton2);
        panel.add(resultLabel2);
        add(panel);

        setSize(850, 180);
        setLocationRelativeTo(null);

    }


    public String generarAnagrama(String texto) {
        char[] caracteres = texto.toCharArray();
        Random random = new Random();
        for (int i = 0; i < caracteres.length; i++) {
            int posicion = random.nextInt(caracteres.length);
            char aux = caracteres[i];
            caracteres[i] = caracteres[posicion];
            caracteres[posicion] = aux;
        }
        return new String(caracteres);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicio6_14 ejercicio = new ejercicio6_14();
            ejercicio.setVisible(true);
        });
    }
}