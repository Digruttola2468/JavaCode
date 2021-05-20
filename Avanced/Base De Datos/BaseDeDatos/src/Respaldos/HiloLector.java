package Respaldos;

import java.io.InputStream;

public class HiloLector extends Thread{
	
	private final InputStream is;
	
	//Constructor que recibe un InputStream
	public HiloLector( InputStream is ) {
		this.is = is;
	}
	
	@Override
	//Ejecute este proceso
	public void run() {
		
		try {
			//Tamaño
			byte[] buffer = new byte[1000];
			//Leemos
			int leido = is.read(buffer);
			
			//Si lo leido es mayor a 0
			while (leido > 0) {
				
				String texto = new String (buffer , 0 , leido);
				System.out.print(texto);
				leido = is.read(buffer);
				
			}
			
			
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		
	}
	
}
