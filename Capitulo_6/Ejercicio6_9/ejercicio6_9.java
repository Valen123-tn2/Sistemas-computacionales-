//Los habitantes de Javalandia tienen un idioma algo extraño; cuando hablan 
//siempre comienzan sus frases con "Javalín, javalón", para después hacer una 
//pausa más o menos larga (la pausa se representa mediante espacios en blanco o 
//tabuladores) y a continuación expresan el mensaje. Existe un dialecto que no 
//comienza sus frases con la muletilla anterior, pero siempre las terminan con un 
//silencio, más o menos prolongado y la coletilla "javalén, len, len". 
//Se pide diseñar un traductor que, en primer lugar, nos diga si la frase 
//introducida está escrita en el idioma de Javalandia (en cualquiera de sus 
//dialectos), y en caso afirmativo, nos muestre solo el mensaje sin muletillas.

package Ejercicio6_9;
import javax.swing.*;

public class ejercicio6_9 extends JFrame {

    public ejercicio6_9() {

        setTitle("Ejercicio 6.9");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField inputField = new JTextField(30);
        JButton submitButton = new JButton("Traducir");
        JLabel resultLabel = new JLabel("");

        submitButton.addActionListener(e -> {
            String frase = inputField.getText().trim();
            if (frase.isEmpty()) {
                resultLabel.setText("Debe ingresar una frase.");
                return;
            }

            if (frase.startsWith("Javalín, javalón")) {
                String mensaje = frase.substring("Javalín, javalón".length()).trim();
                resultLabel.setText("Mensaje: " + mensaje);
            } else if (frase.endsWith("javalén, len, len")) {
                String mensaje = frase.substring(0,
                        frase.length() - "javalén, len, len".length()).trim();
                resultLabel.setText("Mensaje: " + mensaje);
            } else {
                resultLabel.setText("La frase no pertenece al idioma de Javalandia.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Frase: "));
        panel.add(inputField);
        panel.add(submitButton);
        panel.add(resultLabel);
        add(panel);

        setSize(850, 120);
        setLocationRelativeTo(null);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicio6_9 ejercicio = new ejercicio6_9();
            ejercicio.setVisible(true);
        });
    }
}