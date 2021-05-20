import javax.swing.*;
import java.awt.event.*;

public class CampoArea extends JFrame implements ActionListener{
   
   private JTextArea campo,Mostrar;
   private JLabel etiqueta;
   private JButton boton;
   
   
   
   public CampoArea(){
      setLayout(null);
      setTitle("Campo Texto");
      
      campo = new JTextArea("");
      campo.setBounds(10,10,200,100);
      add(campo);
      
      Mostrar = new JTextArea("");
      Mostrar.setBounds(230,10,200,100);
      add(Mostrar);
      
      boton = new JButton("Agregar");
      boton.setBounds(10,130,100,20);
      boton.addActionListener(this);
      add(boton);
   }
   
   public void actionPerformed(ActionEvent e){
      if(e.getSource() == boton){
         Mostrar.setText(campo.getText());
         campo.setText("");
      }
   }
   
   public static void main(String args[]){
      CampoArea area = new CampoArea();
      area.setBounds(0,0,500,300);
      area.setLocationRelativeTo(null);
      area.setResizable(false);
      area.setVisible(true);   
   }
}