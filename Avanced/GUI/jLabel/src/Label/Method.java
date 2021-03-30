package Label;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class Method extends javax.swing.JFrame{
	
	
	public Method() {
		
		//JLabel
		JLabel etiqueta = new JLabel();					//Create a label
		etiqueta.setText("Bro, do you even code");		//set text of label
		
		//Image
		ImageIcon image = new ImageIcon("src/Label/tela.jpg");	//image
		etiqueta.setIcon(image);
		
		//Border
		Border borde = BorderFactory.createLineBorder(Color.GREEN);
		
		etiqueta.setHorizontalTextPosition(JLabel.CENTER);		//set text LEFT,CENTER,RIGHT of imageIcon
		etiqueta.setVerticalTextPosition(JLabel.TOP);			//set text TOP,CENTER,BOTTOM of imageIcon
		etiqueta.setForeground(Color.GREEN);					//Label color
		etiqueta.setFont(new Font("MV Boli",Font.PLAIN,20));	//set font color of text
		etiqueta.setIconTextGap(-15);							//set gap of text to image
		etiqueta.setBackground(Color.black);					//Set Background color
		etiqueta.setOpaque(true);								//Display Background Color
		
		etiqueta.setBorder(borde);
		etiqueta.setVerticalAlignment(JLabel.TOP);				//set vertical position of icon+text within label
		etiqueta.setHorizontalAlignment(JLabel.CENTER);			//set horizontal position of icon+text within label
		
		//etiqueta.setBounds(100,100,150,150);					//set x,y position within frame ad well ad dimension
		
		
		this.add(etiqueta);										//show the screen
		

		Screen();		//create the GUI Window
	}
	
	private void Screen() {
		this.setDefaultCloseOperation(3);
		//this.setSize(500,500);
		this.setLocationRelativeTo(null);
		this.pack();
		this.setVisible(true);
	}
	
}
