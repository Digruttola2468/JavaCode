import javax.swing.*;
import java.awt.event.*;

public class CampoTexto extends JFrame implements ActionListener{
   
   private JTextField texto;
   private JButton boton;
   private JLabel etiqueta;
   
   public CampoTexto(){
      setLayout(null);
      setTitle("Campo de Texto");
      
      texto = new JTextField("");
      texto.setBounds(10,10,100,20);
      add(texto);

      boton = new JButton("Agregar");
      boton.setBounds(10,40,100,30);
      boton.addActionListener(this);
      add(boton);
      
      etiqueta = new JLabel("");
      etiqueta.setBounds(10,80,200,30);
      add(etiqueta);
   }

   public void actionPerformed(ActionEvent e){
      if(e.getSource() == boton){
         if(!texto.getText().equals("")){
            etiqueta.setText(texto.getText());
         }
      }
   }

   public static void main(String args[]){
      CampoTexto text = new CampoTexto();
      text.setBounds(0,0,200,160);
      text.setLocationRelativeTo(null);
      text.setResizable(true);
      text.setVisible(true);
   }

}