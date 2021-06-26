package Socket;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Cliente {
	
	public static void main(String[] args) {
		
		MarcoCliente miMarco = new MarcoCliente();
		miMarco.setDefaultCloseOperation(3);
		
	}
	
}

class MarcoCliente extends JFrame{
	
	public MarcoCliente() {
		setBounds(600,300,250,350);
		
		LaminaMarcoCliente miLamina = new LaminaMarcoCliente();
		add(miLamina);
		setVisible(true);
	}
	
}

class LaminaMarcoCliente extends JPanel{
	
	private JTextField campo1;
	private JButton miBoton;
	
	public LaminaMarcoCliente() {
		
		JLabel texto = new JLabel("CLIENTE");
		add(texto);
		
		campo1 = new JTextField(20);
		add(campo1);
		
		miBoton = new JButton("Enviar");
		miBoton.addActionListener(new EnviaTexto());
		add(miBoton);
		
	}
	
	private class EnviaTexto implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				
				Socket miSocket = new Socket("192.168.0.231" , 3245);
				
				//Flujos de Datos
				DataOutputStream flujoSalida = new DataOutputStream(miSocket.getOutputStream());
				
				flujoSalida.writeUTF(campo1.getText().toString());
				
				flujoSalida.close();
				
			} catch (IOException e2) {
				System.err.println(e2.getMessage());
			}
		}
		
	}
	
}

