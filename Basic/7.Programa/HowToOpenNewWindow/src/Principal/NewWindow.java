package Principal;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class NewWindow {
	
	JFrame frame = new JFrame();
	JLabel label = new JLabel("Hello!!");
	
	
	
	public NewWindow(){
		
		label.setBounds(0,0,100,50);
		label.setFont(new Font(null,Font.PLAIN,25));
		
		
		frame.setDefaultCloseOperation(3);
		frame.setSize(420,420);
		
		frame.add(label);
		frame.setVisible(true);
		
	}
	
}
