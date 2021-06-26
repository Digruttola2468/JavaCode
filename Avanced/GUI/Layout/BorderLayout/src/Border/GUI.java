package Border;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends javax.swing.JFrame{
	
	public GUI() {
		
		this.setDefaultCloseOperation(3);
		this.setSize(500,500);
		this.setLayout(new BorderLayout(10,10));
		
		JPanel Panel1 = new JPanel();
		JPanel Panel2 = new JPanel();
		JPanel Panel3 = new JPanel();
		JPanel Panel4 = new JPanel();
		JPanel Panel5 = new JPanel();
		
		Panel1.setBackground(Color.red);
		Panel2.setBackground(Color.green);
		Panel3.setBackground(Color.yellow);
		Panel4.setBackground(Color.magenta);
		Panel5.setBackground(Color.blue);
		
		Panel1.setPreferredSize(new Dimension(100,100));
		Panel2.setPreferredSize(new Dimension(100,100));
		Panel3.setPreferredSize(new Dimension(100,100));
		Panel4.setPreferredSize(new Dimension(100,100));
		Panel5.setPreferredSize(new Dimension(100,100));
		
		//---------------------- sub panels ----------------------
		
		JPanel Panel6 = new JPanel();
		JPanel Panel7 = new JPanel();
		JPanel Panel8 = new JPanel();
		JPanel Panel9 = new JPanel();
		JPanel Panel10 = new JPanel();
		
		Panel6.setBackground(Color.black);
		Panel7.setBackground(Color.darkGray);
		Panel8.setBackground(Color.gray);
		Panel9.setBackground(Color.LIGHT_GRAY);
		Panel10.setBackground(Color.white);
		
		Panel5.setLayout(new BorderLayout());
		
		Panel6.setPreferredSize(new Dimension(100,100));
		Panel7.setPreferredSize(new Dimension(100,100));
		Panel8.setPreferredSize(new Dimension(100,100));
		Panel9.setPreferredSize(new Dimension(100,100));
		Panel10.setPreferredSize(new Dimension(100,100));
		
		Panel5.add(Panel6,BorderLayout.NORTH);
		Panel5.add(Panel7,BorderLayout.WEST);
		Panel5.add(Panel8,BorderLayout.EAST);
		Panel5.add(Panel9,BorderLayout.SOUTH);
		Panel5.add(Panel10,BorderLayout.CENTER);
		
		
		//---------------------- sub panels ----------------------
		
		this.add(Panel1,BorderLayout.NORTH);
		this.add(Panel2,BorderLayout.WEST);
		this.add(Panel3,BorderLayout.EAST);
		this.add(Panel4,BorderLayout.SOUTH);
		this.add(Panel5,BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	
}
