//Leer y almacenar n (ingresar por teclado la cantidad) números enteros 
//en una tabla, a partir de la que se construirán otras dos tablas con los 
//elementos con valores pares e impares de la primera, respectivamente.

package Ejercicio5_10;
import javax.swing.*;

public class ejercicio5_10 extends JFrame {

    private int cantidad = 0;
    private int indice = 0;
    private int[] t;
    private int[] pares;
    private int[] impares;
    private int contPares = 0;
    private int contImpares = 0;
    private boolean creado = false;

    public ejercicio5_10() {

        setTitle("Ejercicio 5.10");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField inputField1 = new JTextField(10);
        JTextField inputField2 = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");

        submitButton.addActionListener(e -> {

            try {
                 if (!creado) {
                    cantidad = Integer.parseInt(inputField1.getText());
                    if (cantidad <= 0) {
                        resultLabel.setText("La cantidad debe ser mayor que 0.");
                        return;
                    }
                    t = new int[cantidad];
                    pares = new int[cantidad];
                    impares = new int[cantidad];
                    creado = true;
                    inputField1.setEnabled(false);
                }
                int num = Integer.parseInt(inputField2.getText());
                t[indice] = num;
                indice++;

                if (indice == cantidad) {
                    separar();
                    resultLabel.setText("<html>"
                            + "Tabla: " + mostrar(t, cantidad) + "<br>"
                            + "Pares: " + mostrar(pares, contPares) + "<br>"
                            + "Impares: " + mostrar(impares, contImpares)
                            + "</html>");
                    submitButton.setEnabled(false);
                    inputField2.setEnabled(false);
                }
                inputField2.setText("");
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida.");
            }
        });

        JPanel panel = new JPanel();

        panel.add(new JLabel("Cantidad: "));
        panel.add(inputField1);
        panel.add(new JLabel("Numero: "));
        panel.add(inputField2);
        panel.add(submitButton);
        panel.add(resultLabel);
        add(panel);

        setSize(600, 120);
        setLocationRelativeTo(null);
    }

    public void separar() {
        for (int i = 0; i < cantidad; i++) {
            if (t[i] % 2 == 0) {
                pares[contPares] = t[i];
                contPares++;
            } else {
                impares[contImpares] = t[i];
                contImpares++;
            }
        }
    }

    public String mostrar(int[] tabla, int cantidad) {
        String texto = "";
        for (int i = 0; i < cantidad; i++) {
            texto += tabla[i] + " ";
        }
        return texto;
    }
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            ejercicio5_10 ejercicio = new ejercicio5_10();
            ejercicio.setVisible(true);
        });

    }
}