package Ejercicio2_16;
import javax.swing.*;

public class ejercicio2_16 extends JFrame {

    public ejercicio2_16() {
        setTitle("Ejercicios 2.16");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField n = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("");


        submitButton.addActionListener(e -> {
            try {
                String texto = "";

                int num = Integer.parseInt(n.getText());

                if (10 <= num && num <= 15) {
                    switch (num)  {
                        case 10: 
                           texto = "Diez";
                           break;
                        case 11: 
                           texto = "Once";
                           break; 
                        case 12: 
                           texto = "Doce";
                           break; 
                        case 13: 
                           texto = "Trece";
                           break; 
                        case 14: 
                           texto = "Catorce";
                           break; 
                        case 15: 
                           texto = "Quince";
                           break;  
                    }
                } else {
                    int unidades = num % 10;
                    int decenas = num / 10;
                
                    switch (decenas){
                        case 0:
                            texto = "";
                            break;
                        case 1:
                            texto = "Dieci";
                            break;
                        case 2:
                            texto = "Veinti";
                            break;
                        case 3:
                            texto = "Treinta";
                            break;
                        case 4:
                            texto = "Cuarenta";
                            break;
                        case 5:
                            texto = "Cincuenta";
                            break;
                        case 6:
                            texto = "Sesenta";
                            break;
                        case 7:
                            texto = "Setenta";
                            break;
                        case 8:
                            texto = "Ochenta";
                            break;
                        case 9:
                            texto = "Noventa";
                            break;
                    } 

                    if (decenas != 0 && decenas != 1 && decenas != 2 && unidades != 0){
                        texto += " y ";
                    }

                    switch (unidades){
                        case 1:
                            texto += "uno";
                            break;
                        case 2:
                            texto += "dos";
                            break;
                        case 3:
                            texto += "tres";
                            break;
                        case 4:
                            texto += "cuatro";
                            break;
                        case 5:
                            texto += "cinco";
                            break;
                        case 6:
                            texto += "seis";
                            break;
                        case 7:
                            texto += "siete";
                            break;
                        case 8:
                            texto += "ocho";
                            break;
                        case 9:
                            texto += "nueve";
                            break;
                    }
                }
                resultLabel.setText(texto);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada invalida. Introduce un numero");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Escriba un Numero del 1 al 99: "));
        panel.add(n);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 100);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ejercicio2_16 ejercicio = new ejercicio2_16();
            ejercicio.setVisible(true);
        });
    }
}
    

