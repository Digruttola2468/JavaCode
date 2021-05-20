package CRUD_MVC;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionModelo {
	private final String base = "tienda";
	private final String user = "root";
	private final String password = "autito84";
	private final String url = "jdbc:mysql://localhost:3306/" + base;

	private Connection con = null;
	
	//Obtenemos la conexion
	public Connection getConexion() {
		try {
			//Nuestro controlador para realizar la operacion
			
			Class.forName("com.mysql.cj.jdbc.Driver");	//Este driver No tiene Errores
			//Existen dos Driver
			//com.mysql.cj.jdbc.Driver
			//com.mysql.jdbc.Driver
			
			//Colocamos el DriveManager para usar la ruta con el usuario y contra
			con = DriverManager.getConnection(this.url,this.user,this.password);
		} catch (Exception e) {
			System.err.println(e);
		}
		return con;
	}
	
	
	
}
