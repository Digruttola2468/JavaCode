import javax.swing.*;

public class Interfas extends JFrame{
   
   public Interfas(){
      setLayout(null);
      setTitle("Interfas Grafica");
   }
   
   public static void main(String args[]){
      Interfas inter = new Interfas();
      inter.setBounds(0,0,200,300);		//Tamaño de la Interfas
      inter.setVisible(true);			//Hacer visible la interfa
      inter.setLocationRelativeTo(null);	//Colocarlo en el medio
   }

}