package Imagenes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class VistaImageMySQL extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel jlImagen;
	JButton jbCargar,jbMostrar;
	
	public VistaImageMySQL() {
		setLayout(null);
		setTitle("Imagenes MySQL");
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(3);
		setSize(500,450);
		
		jlImagen = new JLabel();
		jlImagen.setBounds(10,10,300,300);
		add(jlImagen);
		
		jbCargar = new JButton("Cargar");
		jbCargar.setBounds(30,350,100,20);
		jbCargar.addActionListener(this);
		add(jbCargar);
		
		jbMostrar = new JButton("Mostrar");
		jbMostrar.setBounds(150,350,100,20);
		jbMostrar.addActionListener(this);
		add(jbMostrar);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == jbCargar) {
			
			//Abrimos una pestaña para elegir fotos
			JFileChooser fc = new JFileChooser();
			//Colocamos la direccion por defecto
			fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			//Denominamos que tipo de archivos se pueden interactuar
			FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.PNG", "png");
			fc.setFileFilter(filtro);
			
			//Si el usuario toca aceptar al elegir una imagen
			int seleccion = fc.showOpenDialog(this);
			
			//Variables de MySQL
			PreparedStatement ps;
			ResultSet rs;
			//Obtenemos la conexion
			ConexionModelo objcon = new ConexionModelo();
			
			if(seleccion == JFileChooser.APPROVE_OPTION) {
				File archivo = fc.getSelectedFile();
				String ruta = archivo.getAbsolutePath();
				
				try {
					FileInputStream fis = new FileInputStream(archivo);
					Connection con = objcon.getConexion();
					
					try {
						
						ps = con.prepareStatement("INSERT INTO datos (imagen) VALUES (?)");
						ps.setBinaryStream(1, fis , (int) archivo.length());
						ps.execute();
						JOptionPane.showMessageDialog(null, "Imagen Guardada");
						
					} catch (SQLException e1) {
						System.err.println(e1);
						JOptionPane.showMessageDialog(null, "Error Imagen");
					}
					
				} catch (FileNotFoundException e1) {
					System.err.println(e1);
				}
				
			}
			
		}
		
		if(e.getSource() == jbMostrar) {
			
			PreparedStatement ps;
			ResultSet rs;
			
			try {
				Connection con = new ConexionModelo().getConexion();
				//Traemos la imagen
				ps = con.prepareStatement("SELECT imagen FROM datos WHERE ID=?");
				ps.setInt(1, 1);
				rs = ps.executeQuery();
				
				BufferedImage buffing = null;
				byte[] image = null;
				
				//Sacamos los resultados de la consulta
				while ( rs.next() ) {
					
					//Extraigo lo que tiene el campo imagen de MySQL
					image = rs.getBytes("imagen");
					//Convertimos la imagen en binario
					InputStream img = rs.getBinaryStream(1);
					
					try {
						//Realizo la conversion
						buffing = ImageIO.read(img);
						imageMySQL imagen = new imageMySQL(jlImagen.getHeight() , jlImagen.getWidth(),buffing);
						
						jlImagen.add(imagen);
						jlImagen.repaint();
						
					} catch (Exception e2) {
						System.err.println(e2);
					}
					
				}
				rs.close();
			} catch (Exception e2) {
				System.err.println(e2);
			}
			
		}
		
		
	}
	
	
	
	
}
