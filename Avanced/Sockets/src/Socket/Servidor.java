package Socket;

import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Servidor {
	
	public static void main(String[] args) {
		MarcoServidor miMarco = new MarcoServidor();
		miMarco.setDefaultCloseOperation(3);
	}
	
}

class MarcoServidor extends JFrame implements Runnable{
	
	JTextArea areaTexto;
	
	public MarcoServidor() {
		
		setBounds(1200,300,280,350);
		
		JPanel miLamina = new JPanel();
		miLamina.setLayout(new BorderLayout());
		areaTexto = new JTextArea();
		
		miLamina.add(areaTexto,BorderLayout.CENTER);
		add(miLamina);
		
		
		setVisible(true);
		Thread miHilo = new Thread(this);
		
		miHilo.start();
	}

	@Override
	public void run() {
		
		try {
			
			ServerSocket server = new ServerSocket(10795);
			
			for(;;) {
				Socket miSocket = server.accept();
				
				
				//Flujo de datos de Entrada
				DataInputStream flujoEntrada = new DataInputStream(miSocket.getInputStream());
				String mensajeTexto = flujoEntrada.readUTF();
				
				
				areaTexto.append("\n" + mensajeTexto);
				
				
				miSocket.close();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
