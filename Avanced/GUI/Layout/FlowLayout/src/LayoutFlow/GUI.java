package LayoutFlow;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GUI extends javax.swing.JFrame{
	
	public GUI() {
		
		this.setDefaultCloseOperation(3);
		this.setSize(500,500);
		this.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));	//.LEADING,CENTER,TRAILING , Horizontal , Vertical
		
		JPanel panel1 = new JPanel();
		panel1.setPreferredSize(new Dimension(100,250));
		panel1.setBackground(Color.lightGray);
		panel1.setLayout(new FlowLayout());
		
		panel1.add(new JButton("1"));
		panel1.add(new JButton("2"));
		panel1.add(new JButton("3"));
		panel1.add(new JButton("4"));
		panel1.add(new JButton("5"));
		panel1.add(new JButton("6"));
		panel1.add(new JButton("7"));
		panel1.add(new JButton("8"));
		panel1.add(new JButton("9"));
		
		this.add(panel1);
		this.setVisible(true);
		
	}
}
