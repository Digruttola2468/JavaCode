package Principal;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class GUI {
	
	public GUI() {
		
		//Mensaje();
		
		
		OptionDialog();
		
	}
	
	
	
	
	private void Mensaje() {
		JOptionPane.showMessageDialog(null, "this is some useless info","title",
				  JOptionPane.PLAIN_MESSAGE);

		JOptionPane.showMessageDialog(null, "Here is more useless info :D","title",
				JOptionPane.INFORMATION_MESSAGE);

		JOptionPane.showMessageDialog(null, "really?","title",
				JOptionPane.QUESTION_MESSAGE);

		JOptionPane.showMessageDialog(null, "you are computer has a Virus!!","title",
				JOptionPane.WARNING_MESSAGE);

		JOptionPane.showMessageDialog(null, "call tech support now or else !!","title",
				JOptionPane.ERROR_MESSAGE);

	}
	
	private void ConfirDialog() {
		int answer = JOptionPane.showConfirmDialog(null, "Bro, do you even code?","this is my title",
  				JOptionPane.YES_NO_CANCEL_OPTION);
		//if answer = 0 is true , answer = 1 is false , answer = 2 is cancel and answer = -1 is closeJOptionpane
	}
	
	
	
	
	private void InputDialog() {
		String name = JOptionPane.showInputDialog("What is your name?:");
		System.out.println( "Hello " + name);
	}
	
	
	private void OptionDialog() {
		String[] responses = {"No,You are awesome!" , "Thank you" , "*blush*"};
		ImageIcon icon = new ImageIcon("src/Principal/emonjiHappy.png");
		JOptionPane.showOptionDialog(null, 
				"you are awesome!", 
				"Secret menssage", JOptionPane.YES_NO_CANCEL_OPTION, 
				JOptionPane.INFORMATION_MESSAGE, icon,
				responses,
				0);
	}
}
