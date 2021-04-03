package Principal;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class CheckB extends javax.swing.JFrame implements ActionListener{
	
	private JCheckBox check;
	private JButton button;
	ImageIcon xIcon;
	ImageIcon checkIcon;
	
	public CheckB() {
		
		this.setDefaultCloseOperation(3);
		this.setLayout(new FlowLayout());
		
		xIcon = new ImageIcon("src/Principal/Correcto.png");
		checkIcon = new ImageIcon("src/Principal/Incorrecto.png");
		
		button = new JButton();
		button.setText("Submit");
		button.addActionListener(this);
		
		check = new JCheckBox();
		check.setText("Im not a robot");
		check.setFocusable(false);
		check.setFont(new Font("Consolas",Font.PLAIN , 25));
		check.setIcon(checkIcon);
		check.setSelectedIcon(xIcon);
		
		this.add(button);
		this.add(check);
		this.pack();
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == button) {
			System.out.println(check.isSelected());
		}
		
	}
	
	
	
}
