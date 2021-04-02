package gridLayout;

import java.awt.GridLayout;

import javax.swing.JButton;

public class GUI extends javax.swing.JFrame{
	
	public GUI() {
		
		this.setDefaultCloseOperation(3);
		this.setSize(500,500);
		this.setLayout(new GridLayout(3,3,10,10));	//Horizontal, Vertical , spaceHorizontal, spaceVertical
		
		this.add(new JButton("1"));
		this.add(new JButton("2"));
		this.add(new JButton("3"));
		this.add(new JButton("4"));
		this.add(new JButton("5"));
		this.add(new JButton("6"));
		this.add(new JButton("7"));
		this.add(new JButton("8"));
		this.add(new JButton("9"));
		this.add(new JButton("10"));

		this.setVisible(true);
	}
	
}
