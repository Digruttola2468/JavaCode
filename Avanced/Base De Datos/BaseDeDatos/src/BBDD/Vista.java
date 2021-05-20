package BBDD;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Vista extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;

	JButton button;
	
	//Conexion hacia mi servidor de la base de datos
	public static final String URL = "jdbc:mysql://localhost:3306/ejemploescuela";
	//Usuario de mySql
	public static final String USERNAME = "root";
	//Contraseña de MySql
	public static final String PASSWORD = "autito84";
	
	public Vista() {
		setLayout(null);
		setSize(500,500);
		setTitle("MySQL");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		button = new JButton("Conectar");
		button.setBounds(10,10,200,30);
		button.setBackground(Color.white);
		button.setForeground(Color.BLACK);
		button.addActionListener(this);
		add(button);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == button) {
			
			try {
				//Nos conectamos a MySql
				Connection con = null;
				con = getConection();
				
				//**************2 Crear un objeto Statement **************************
				//Variable para hacer transacciones
				PreparedStatement ps;
				//
				ResultSet res;
				
				//Conectamos a la tabla persona
				ps = con.prepareStatement("SELECT * FROM persona");
				
				//**************3.Ejecutar sentencia SQL **************************
				res = ps.executeQuery();
				
				//Evaluamos si esta consulta tiene resultados
				if(res.next()) {
					//4.Leemos el ResultSet
					JOptionPane.showMessageDialog(null, res.getString("Nombre") + " " + 
												        res.getInt("Edad") + " " + 
												        res.getString("Genero"));
				}else
					JOptionPane.showMessageDialog(null, "No existen Datos");
				
				
				//Cerramos la coneccion
				con.close();
			} catch (Exception e2) {
				System.err.println(e2);
			}
		}
		
	}
	
	
	//1.Establecer conexcion con la BBDD 
	public static Connection getConection() {
		
		//Variable de tipo connection
		Connection con = null;
		
		try {
			//Nos Conectamos a MySql
			Class.forName("com.mysql.cj.jdbc.Driver"); //com.mysql.jdbc.Driver
			con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			JOptionPane.showMessageDialog(null, "Conexion Exitosa");
		} catch (Exception e) {
			System.err.println(e);
		}
		
		//Retornamos la conneccion
		return con;
	}
	
	
}
