import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.ImageIcon;

public class myFrame extends javax.swing.JFrame{

    public myFrame(){
        createGUIWindow();
        createLogo();
        this.getContentPane().setBackground(Color.GREEN);          //Change color of background
    }

    private void createGUIWindow(){
        this.setTitle("Frame title goes here");                    //sets title of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       //exit out of application
        this.setResizable(false);                                  //prevent frame from being resized
        this.setLocationRelativeTo(null);                          //Place GUI in the middle
        this.setSize(420,420);                                     //sets x-dimencion and y-dimension of frame
        this.setVisible(true);                                     //Make frame visible
    }

    private void createLogo(){
        ImageIcon image = new ImageIcon( "src/LogoPepsi.png" );      //Create an ImageIcon
        this.setIconImage(image.getImage());                       //Change icon of frame
    }
}
