
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AccesoFichero {
	
	public static void main(String[] args) {
		
		//new Escribiendo().escribir();
		//new LeerFichero().lee();
	}
	
}

class LeerFichero {
	
	public void lee() {
		
		try {
			
			FileReader entrada = new FileReader( "C:\\Users\\ivans\\Desktop\\nuevo.txt" );
			BufferedReader bufEntrada = new BufferedReader( entrada );
			
			String linea = "";
			while( linea != null ) {
				
				linea = bufEntrada.readLine();
				if(linea != null) 
					System.out.println(linea);
				
			}
			
			entrada.close();
			bufEntrada.close();
			
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		
	}
	
}

class Escribiendo {
	
	
	public void escribir() {
		
		String frase = "Tu mama en tanga paaa";
		try {
			//Si colocas True , nos permite agregar mas lineas en la mismo archivo
			//Si colocas False, nos permite borrar lo que tenia para agregar el nuevo texto en el archivo
			FileWriter salida = new FileWriter( "C:\\Users\\ivans\\Desktop\\nuevo.txt" , true);
			BufferedWriter bufSalida = new BufferedWriter( salida );
			
			salida.write(frase);
			
			salida.close();
			bufSalida.close();
			
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		
	}
	
	
}
