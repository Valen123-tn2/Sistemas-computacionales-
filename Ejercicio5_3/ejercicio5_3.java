// Introducir por teclado un número n; a continuación solicitar al usuario que teclee
// n números. Realizar la media de los números positivos, la media de los negativos 
// y contar el número de ceros introducidos.

package Ejercicio5_3;
import javax.swing.*;

public class ejercicio5_3 extends JFrame {

    private int cantidad = 0;
    private int[] t;
    private int indice = 0;
    private int sumaP = 0, contP = 0, sumaN = 0, contN = 0, contC = 0; 

    public ejercicio5_3() {
        setTitle("Ejercicio 5.3");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField inputField1 = new JTextField(10);
        JTextField inputField2 = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabelP = new JLabel("");
        JLabel resultLabelN = new JLabel("");
        JLabel resultLabelC = new JLabel("");

        submitButton.addActionListener(e -> {
            try {
                largo(inputField1); 
                int num = Integer.parseInt(inputField2.getText());
                agregar(num);

                if (indice == cantidad){
                    for (int x : t) {
                        if (x == 0){
                            contC++;
                        } else {
                            if (x > 0){
                                sumaP += x;
                                contP++;
                            } else {
                                sumaN += x;
                                contN++;
                            }
                        } 
                    }
                }
                if (contP == 0) {
                    resultLabelP.setText("No es posible realizar la media de los positivos");
                } else {
                    resultLabelP.setText("Media de los positivos: "+ (double) sumaP / contP);
                } 
                if (contN == 0) {
                    resultLabelN.setText("No es posible realizar la media de los negativos");
                } else {
                    resultLabelN.setText("Media de los negativos: "+ (double) sumaN / contN);
                }
                resultLabelC.setText("Cantidad de ceros: "+ contC);                
            } catch (NumberFormatException ex) {
                resultLabelP.setText("Entrada inválida. Introduce un numero valido.");
                resultLabelN.setText("Entrada inválida. Introduce un numero valido.");
                resultLabelC.setText("Entrada inválida. Introduce un numero valido.");
            }

        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Escriba un numero: "));
        panel.add(inputField1);
        panel.add(new JLabel("Escriba un numero: "));
        panel.add(inputField2);
        panel.add(submitButton);
        panel.add(resultLabelP);
        panel.add(resultLabelN);
        panel.add(resultLabelC);

        add(panel);
        setSize(600, 120);
        setLocationRelativeTo(null);
    }

    public void largo(JTextField inputField1){
        if (t == null){
            cantidad = Integer.parseInt(inputField1.getText());
            t = new int[cantidad];
        }

    }
    public void agregar(int num){
        if (indice < cantidad){
            t[indice] = num;
            indice++;
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicio5_3 ejercicio = new ejercicio5_3();
            ejercicio.setVisible(true);
        });
    }
}



