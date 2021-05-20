package Respaldos;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Restauracion {
	
	public static void main(String[] args) {
		
		
		try {
			//Creamos en MySQLWork una base de datos , en este caso tienda_ok
			Process p = Runtime.getRuntime().exec("mysql -u root -pautito84 tienda_ok");
			OutputStream os = p.getOutputStream();
			//Colocamos el nombre del archivo para leer
			FileInputStream fis = new FileInputStream("backup_tienda.sql");
			
			//Colocamos el tamaño
			byte[] buffer = new byte[1000];
			//Leemos
			int leido = fis.read(buffer);
			
			//Si lo leido es mayor a 0
			while(leido > 0) {
				os.write(buffer , 0 , leido);
				leido = fis.read(buffer);
			}
			
			//Vaciar el bufer de salida
			os.flush();
			
			//Cerramos
			os.close();
			fis.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
	}
	
	
}
