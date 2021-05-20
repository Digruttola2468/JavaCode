package MVC;

import javax.swing.*;

public class Vista extends javax.swing.JFrame {
	
	protected JTextField txtValor1,txtValor2,txtResultado;
	protected JLabel jlX;
	protected JButton btMultiplicar;
	
	public Vista() {
		setLayout(null);
		setTitle("MVC");
		setSize(420,200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);
		setResizable(false);
		
		txtValor1 = new JTextField();
		txtValor1.setBounds(10,10,100,20);
		add(txtValor1);
		
		jlX = new JLabel("X");
		jlX.setBounds(120,10,40,20);
		add(jlX);
		
		txtValor2 = new JTextField();
		txtValor2.setBounds(140,10,100,20);
		add(txtValor2);
		
		btMultiplicar = new JButton("Multiplicar");
		btMultiplicar.setBounds(270,10,100,20);
		add(btMultiplicar);
		
		txtResultado = new JTextField();
		txtResultado.setBounds(75,50,100,20);
		add(txtResultado);
		
	}
	
}
