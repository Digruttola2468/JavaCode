package Botton;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUI extends javax.swing.JFrame implements ActionListener {
	
	JButton button;
	JLabel label;
	
	public GUI() {
		
		ImageIcon icon = new ImageIcon("src/Botton/Milk.png");
		ImageIcon icon2 = new ImageIcon("src/Botton/emonjiHappy.png");
		
		label = new JLabel();
		label.setIcon(icon2);
		label.setBounds(150,25,150,150);
		label.setVisible(false);
		
	    button = new JButton();
		button.setBounds(200,100,250,100);
		button.setText("Im a button!");
		button.setFocusable(false);
		button.setIcon(icon);
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setVerticalTextPosition(JButton.BOTTOM);
		button.setFont(new Font("Comic Sans", Font.BOLD , 25));
		button.setIconTextGap(+15);
		button.setForeground(Color.cyan);
		button.setBackground(Color.lightGray);
		button.setBorder(BorderFactory.createEtchedBorder());
		//button.setEnabled(false);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(500,500);
		this.setVisible(true);
		
		//button.addActionListener(e -> System.out.println("POO"));
		button.addActionListener(this);
		this.add(button);
		this.add(label);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == button) {
			//System.out.println("POO");
			label.setVisible(true);
		}
		
		
	}
	
	
}
