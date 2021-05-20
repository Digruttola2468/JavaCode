package CRUD;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

public class Vista extends javax.swing.JFrame implements ActionListener{
	
	JLabel jlClave,jlNombre,jlEdad,jlTelefono,jlGenero;
	JTextField txtClave,txtNombre,txtEdad,txtTelefono,txtGenero;
	JButton btGuardar,btModifica,btElimina,btLimpia,btBuscar;
	
	String ID = "";
	
	public Vista() {
		setLayout(null);
		setSize(600,300);
		setTitle("CRUD");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);
		setResizable(false);
		
		jlClave = new JLabel("Clave: ");
		jlClave.setBounds(10,15,70,30);
		add(jlClave);
		
		txtClave = new JTextField();
		txtClave.setBounds(90,20,100,20);
		add(txtClave);
		
		btBuscar = new JButton("Buscar");
		btBuscar.setBounds(240,20,100,30);
		btBuscar.addActionListener(this);
		add(btBuscar);
		
		jlNombre = new JLabel("Nombre: ");
		jlNombre.setBounds(10,50,70,30);
		add(jlNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(90,55,100,20);
		add(txtNombre);
		
		jlEdad = new JLabel("Edad: ");
		jlEdad.setBounds(10,80,70,30);
		add(jlEdad);
		
		txtEdad = new JTextField();
		txtEdad.setBounds(90,85,100,20);
		add(txtEdad);
		
		jlTelefono = new JLabel("Telefono: ");
		jlTelefono.setBounds(10,110,70,30);
		add(jlTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(90,115,100,20);
		add(txtTelefono);
		
		jlGenero = new JLabel("Genero: ");
		jlGenero.setBounds(10,140,70,30);
		add(jlGenero);
		
		txtGenero = new JTextField();
		txtGenero.setBounds(90,145,100,20);
		add(txtGenero);
		
		btGuardar = new JButton("Guardar");
		btGuardar.setBounds(30,190,100,30);
		btGuardar.addActionListener(this);
		add(btGuardar);
		
		btModifica = new JButton("Modificar");
		btModifica.setBounds(150,190,100,30);
		btModifica.addActionListener(this);
		add(btModifica);
		
		btElimina = new JButton("Eliminar");
		btElimina.setBounds(270,190,100,30);
		btElimina.addActionListener(this);
		add(btElimina);
		
		btLimpia = new JButton("Limpia");
		btLimpia.setBounds(400,190,100,30);
		btLimpia.addActionListener(this);
		add(btLimpia);
	}
	
	
	//Conexion hacia mi servidor de la base de datos
	public static final String URL = "jdbc:mysql://localhost:3306/ejemploescuela";
	//Usuario de mySql
	public static final String USERNAME = "root";
	//Contraseña de MySql
	public static final String PASSWORD = "autito84";
	
	PreparedStatement ps;
	ResultSet rs;
	
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
	
	private void LimpiaTxt() {
		txtClave.setText(null);
		txtEdad.setText(null);
		txtGenero.setText(null);
		txtNombre.setText(null);
		txtTelefono.setText(null);
	}
	
	
	//Funciones de los botones

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Botton Buscar
		if(e.getSource() == btGuardar) {
			
			Connection con = null;
			
			try {
				//Obtenemos la coneccion
				con = getConection();
				ps = con.prepareStatement("INSERT INTO persona (clave, nombre , edad , telefono , genero) VALUES(?,?,?,?,?)");
				
				//Preparar los elementos que le vamos a ingresar a MySQL
				ps.setString(1, txtClave.getText());
				ps.setString(2, txtNombre.getText());
				ps.setString(3, txtEdad.getText());
				ps.setString(4, txtTelefono.getText());
				ps.setString(5, txtGenero.getText());
				
				//Ejecutamos esta consulta
				int res = ps.executeUpdate();
				
				if(res > 0) {
					JOptionPane.showMessageDialog(null, "Persona Guardada");
					LimpiaTxt();
				}else
					JOptionPane.showMessageDialog(null, "Error al Guardar Persona");
				
				con.close();
				
			} catch (Exception e2) {
				System.err.println(e2);
			}
			
		}
		
		if(e.getSource() == btModifica) {
			Connection con = null;
			
			try {
				//Obtenemos la coneccion
				con = getConection();
				ps = con.prepareStatement("UPDATE persona SET clave=?, Nombre=?, Edad=?, Telefono=?, Genero=? WHERE ID=?");
				
				//Preparar los elementos que le vamos a ingresar
				ps.setString(1, txtClave.getText());
				ps.setString(2, txtNombre.getText());
				ps.setString(3, txtEdad.getText());
				ps.setString(4, txtTelefono.getText());
				ps.setString(5, txtGenero.getText());
				//Colocamos el numero del ID de persona
				//Esto lo podemos hacer con un txtID.getText()
				ps.setString(6, ID);
				
				
				//Ejecutamos esta consulta
				int res = ps.executeUpdate();
				
				if(res > 0) {
					JOptionPane.showMessageDialog(null, "Persona Modificada");
					LimpiaTxt();
				}else
					JOptionPane.showMessageDialog(null, "Error al Modificar Persona");
				
				con.close();
				
			} catch (Exception e2) {
				System.err.println(e2);
			}
		}
		
		if(e.getSource() == btElimina) {
			Connection con = null;
			
			try {
				//Obtenemos la coneccion
				con = getConection();
				ps = con.prepareStatement("DELETE FROM persona WHERE clave=?");
				ps.setString(1, txtClave.getText());
				
				//Ejecutamos esta consulta
				int res = ps.executeUpdate();
				
				if(res > 0) {
					JOptionPane.showMessageDialog(null, "Persona Eliminada");
					LimpiaTxt();
				}else
					JOptionPane.showMessageDialog(null, "Error al Eliminada Persona");
				
				con.close();
				
			} catch (Exception e2) {
				System.err.println(e2);
			}
		}
		
		if(e.getSource() == btBuscar) {
			Connection con = null;
			
			try {
				
				con = getConection();
				ps = con.prepareStatement("SELECT * FROM persona WHERE clave = ?");
				ps.setString(1, txtClave.getText());
				
				//Ejecutamos nuestra consulta
				rs = ps.executeQuery();
				
				//Validamos si nos trajo datos
				if(rs.next()) {
					txtNombre.setText(rs.getString("Nombre"));
					txtEdad.setText(rs.getString("Edad"));
					txtTelefono.setText(rs.getString("Telefono"));
					txtGenero.setText(rs.getString("Genero"));
					//nuevo
					ID = rs.getString("ID");
				}else
					JOptionPane.showMessageDialog(null, "No existe una Persona con esa clave");
				
			} catch (Exception e2) {
				System.err.println(e2);
			}
		}
		
		if(e.getSource() == btLimpia) {
			LimpiaTxt();
		}
		
		
	}
}
