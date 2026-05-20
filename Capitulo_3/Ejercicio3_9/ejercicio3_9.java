package Ejercicio3_9;
import javax.swing.*;

public class ejercicio3_9 extends JFrame {
    int etiqueta = 0;
    int arbolmasalto = -1; 
    int etiquetaama = 0;
    
    public ejercicio3_9() {
        setTitle("Ejercicios 3.9");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField n = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");

        submitButton.addActionListener(e -> {
            try {
                int altura = Integer.parseInt(n.getText());
                while (altura > arbolmasalto){
                    arbolmasalto = altura;
                    etiquetaama = etiqueta;
                    break;
                }
                etiqueta++;
                if (arbolmasalto == -1){
                    resultLabel.setText("No hay Ningun Arbol");
                } else {
                    resultLabel.setText("El Arbol mas Alto Mide: "+arbolmasalto+" Metros Y es el Arbol con la Etiqueta: "+etiquetaama);
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Introduce un número");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Ingrese la Altura del Arbol: "));
        panel.add(n);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(700, 200);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            ejercicio3_9 ejercicio = new ejercicio3_9();
            ejercicio.setVisible(true);
        });
    }
}