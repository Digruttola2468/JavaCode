package Byte;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class AccesoFicheroByte {
	
	public static void main(String[] args) {
		
		new byteImagen();
		byteImagen.creaFichero( new byteImagen().Lectura() );
		
	}
	
}

class byteImagen{
	
	public int[] Lectura() {
		
		int datosEntrada[] = new int[84832];
		int contador = 0;
		try {
			
			FileInputStream Lectura = new FileInputStream("C:\\Users\\ivans\\Pictures\\Camera Roll\\bro.jpg");
			boolean finalArchivo = false;
			
			while ( !finalArchivo ) {
				
				int byteEntrada = Lectura.read();
				
				if( byteEntrada != -1 ) 
					datosEntrada[contador] = byteEntrada;
				else
					finalArchivo = true;

				System.out.println(datosEntrada[contador]);
				contador++;
			}
			
			System.err.println(contador);
			
			Lectura.close();
			
			
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		
		return datosEntrada;
	}
	
	static void creaFichero(int datosNuevoFichero[]) {
		
		try {
			
			FileOutputStream ficheroNuevo = new FileOutputStream("C:\\Users\\ivans\\Pictures\\broCopia.jpg");
			
			for ( int i=0 ; i<datosNuevoFichero.length ; i++ ) 
				ficheroNuevo.write( datosNuevoFichero[i] );
			
			ficheroNuevo.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		
	}
	
}
