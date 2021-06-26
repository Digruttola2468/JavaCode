import javax.swing.JLabel;	//Etiqueta
import java.awt.Color;		//Colores 
import java.awt.Font;		//Tipo de letra

public class Etiqueta extends javax.swing.JFrame{
   
   //Mensionamos a la etiqueta
   private JLabel etique,etique1,etique2;
   
   public Etiqueta(){
      setLayout(null);
      setTitle("Etiqueta");
      setDefaultOptionClose(EXIT_ON_CLOSE);
      
      etique = new JLabel("Etiqueta 1");
      etique.setBounds(10,10,200,35);
      etique.setFont(new Font(Font.SERIF,Font.BOLD,12));
      etique.setForeground(Color.red);
      add(etique);
      
      etique1 = new JLabel("Etiqueta 2");
      etique1.setBounds(10,36,200,35);
      etique1.setFont(new Font(Font.DIALOG,Font.PLAIN,14));
      etique1.setForeground(Color.black);
      add(etique1);    

      etique2 = new JLabel("Etiqueta 3");
      etique2.setBounds(10,60,200,35);
      etique2.setFont(new Font(Font.MONOSPACED,Font.ITALIC,16));
      etique2.setForeground(Color.blue);
      add(etique2);
   }
   
   public static void main(String args[]){
      Etiqueta e = new Etiqueta();
      e.setBounds(0,0,200,200);
      e.setLocationRelativeTo(null);
      e.setVisible(true);
   }
}