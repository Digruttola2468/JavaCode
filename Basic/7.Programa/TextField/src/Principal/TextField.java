package Principal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class TextField extends javax.swing.JFrame implements ActionListener{

	JButton button = new JButton("Submit");
	JTextField text = new JTextField();
	
	public TextField() {
		
		this.setDefaultCloseOperation(3);
		this.setLayout(new FlowLayout());
		
		text.setPreferredSize(new Dimension(250,40));
		text.setFont(new Font("Consolas",Font.PLAIN , 20));
		text.setForeground(new Color(0x00FF00));
		text.setBackground(Color.black);
		text.setCaretColor(Color.WHITE);
		text.setText("UserName");
		
		button.addActionListener(this);
		
		this.add(button);
		this.add(text);
		this.pack();
		this.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == button) {
			System.out.println("Welcome " + text.getText());
			button.setEnabled(false);
			text.setEditable(false);
		}
		
	}
	
}
