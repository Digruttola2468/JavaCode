package Principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class LaunchPage implements ActionListener{
	
	JFrame frame = new JFrame();
	JButton myButton = new JButton("New Window");
	
	public LaunchPage() {
		
		myButton.setBounds(100,160,200,40);
		myButton.setFocusable(false);
		myButton.addActionListener(this);
		
		
		frame.setDefaultCloseOperation(3);
		frame.setSize(420,420);
		frame.setLayout(null);
		
		frame.add(myButton);
		
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == myButton) {
			NewWindow window = new NewWindow();
			frame.dispose();
			window.frame.setVisible(true);
		}
	}
	
	
	
}

