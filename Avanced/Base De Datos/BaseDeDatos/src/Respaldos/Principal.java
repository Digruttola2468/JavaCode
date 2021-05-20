package Respaldos;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

//Respaldo
public class Principal {
	
	public static void main(String[] args) {
		
		try {
			//Colocamos el codigo para que copie la base de datos de tienda
			Process p = Runtime.getRuntime().exec("mysqldump -u root -pautito84 tienda");
			
			//Comprobamos si no hay errores
			new HiloLector(p.getErrorStream()).start();
			
			InputStream is = p.getInputStream();
			
			//Creeamos una base de datos
			FileOutputStream fos = new FileOutputStream("backup_tienda.sql");
			
			//Colocamos el tamaño en bytes , en este caso 1kb
			byte[] buffer = new byte[1000];
			//Leemos en binario lo que contiene el InputStream
			int leido = is.read(buffer);
			
			//Si lo leido da mayor a 0
			while(leido > 0) {
				//Escribe
				fos.write(buffer , 0 , leido);
				//Lee de vuelta para el bucle
				leido = is.read(buffer);
			}
			
			//Cerramos
			fos.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
}
