package Principal;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class ComboBox extends javax.swing.JFrame implements ActionListener{

	JComboBox combo;
	
	public ComboBox() {
		
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);
		this.setLayout(new FlowLayout());
		
		String[] animals = {"dog","cat","bird"};
		
		combo = new JComboBox(animals);
		combo.addActionListener(this);
		//combo.setEditable(true);
		//System.out.println(combo.getItemCount());
		//combo.addItem("horse");
		//combo.insertItemAt("Pig", 0);
		//combo.setSelectedIndex(2);
		//combo.removeItem("cat");
		//combo.removeItem(0);
		//combo.removeAll();
		
		
		this.add(combo);
		this.pack();
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == combo) {
			System.out.println(combo.getSelectedItem());
			//System.out.println(combo.getSelectedIndex());
		}
		
	}

}
