package Principal;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

public class RadioBu extends javax.swing.JFrame implements ActionListener{

	
	JRadioButton pizzaButton = new JRadioButton("Pizza");
	JRadioButton hamburgerButton = new JRadioButton("Hamburger");
	JRadioButton hotdogButton = new JRadioButton("hotdog");
	
	ImageIcon pizzaICon;
	
	public RadioBu() {
		
		this.setDefaultCloseOperation(3);
		this.setLayout(new FlowLayout());
		
		pizzaICon = new ImageIcon("src/Principal/Pizza.png");
		
		ButtonGroup group = new ButtonGroup();
		group.add(hotdogButton);
		group.add(hamburgerButton);
		group.add(pizzaButton);
		
		pizzaButton.addActionListener(this);
		hamburgerButton.addActionListener(this);
		hotdogButton.addActionListener(this);
		
		pizzaButton.setIcon(pizzaICon);
		
		this.add(pizzaButton);
		this.add(hamburgerButton);
		this.add(hotdogButton);
		
		this.pack();
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == pizzaButton) {
			System.out.println("You ordered Pizza");
		}
		if(e.getSource() == hamburgerButton) {
			System.out.println("You ordered a hamburguer");
		}
		if(e.getSource() == hotdogButton) {
			System.out.println("You ordered a hotDog");
		}
		
	}
	
}
