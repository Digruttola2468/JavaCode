import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.Color;

public class Boton extends javax.swing.JFrame implements java.awt.event.ActionListener{
    
    private JButton Aceptar;    
    
    public Boton(){
       setLayout(null);
       setTitle("Botones");
       
       Aceptar = new JButton("Mostrar");  
       Aceptar.setBounds(10,10,200,30);
       Aceptar.setForeground(Color.WHITE);
       Aceptar.setBackground(Color.BLACK);
       Aceptar.addActionListener(this);
       add(Aceptar);
    }
    public void actionPerformed(java.awt.event.ActionEvent e){
       if(e.getSource() == Aceptar){
          JOptionPane.showMessageDialog(null,"Has Aceptado");
       }
    }

    public static void main(String args[]){
       Boton bot = new Boton();
       bot.setBounds(0,0,300,300);
       bot.setLocationRelativeTo(null);
       bot.setResizable(false);
       bot.setVisible(true);
    }
}