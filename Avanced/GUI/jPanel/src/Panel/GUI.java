package Panel;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI extends javax.swing.JFrame{
	
	public GUI() {
		
		Screen();
		
		ImageIcon image = new ImageIcon("muy.png");
		
		JLabel label = new JLabel();
		label.setText("HI");
		label.setIcon(image);
		label.setVerticalAlignment(JLabel.TOP);
		label.setHorizontalAlignment(JLabel.RIGHT);
		label.setBounds(0,0,75,75);
		
		JPanel redpanel = new JPanel();
		redpanel.setBackground(Color.red);
		redpanel.setBounds(5,5,250,250);
		redpanel.add(label);
		redpanel.setLayout(null);
		
		JPanel bluepanel = new JPanel();
		bluepanel.setBackground(Color.blue);
		bluepanel.setBounds(260,5,250,250);
		bluepanel.setLayout(null);
		
		JPanel greenpanel = new JPanel();
		greenpanel.setBackground(Color.green);
		greenpanel.setBounds(5,260,250,250);
		greenpanel.setLayout(null);

		greenpanel.add(label);
		
		JPanel yellowpanel = new JPanel();
		yellowpanel.setBackground(Color.yellow);
		yellowpanel.setBounds(260,260,250,250);
		yellowpanel.setLayout(null);
		
		
		this.add(redpanel);
		this.add(bluepanel);
		this.add(greenpanel);
		this.add(yellowpanel);
	}
	
	private void Screen() {
		
		this.setDefaultCloseOperation(3);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setSize(650,650);
		this.setVisible(true);
		
	}
	
}
