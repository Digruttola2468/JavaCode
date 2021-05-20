package Imagenes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class VistaImagenDisco extends javax.swing.JFrame implements ActionListener{
	
	/**
	 * No se que es esto XD
	 */
	private static final long serialVersionUID = 1L;
	
	
	JLabel jlImagen;
	JButton jbCargar,jbMostrar;
	
	String destino = "C:/appjava/tmp/";
	
	public VistaImagenDisco() {
		setLayout(null);
		setTitle("Imagenes Disco");
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

	//Copiar la imagen seleccionada
	public static void copyFile_Java(String origen, String destino) {
		
		try {
			
			//Hace la copia
			Path FROM = Paths.get(origen);
			Path TO = Paths.get(destino);
			
			//Con algunas opciones
			CopyOption[] options = new CopyOption[] {
					//Si existen las reeplaza
				StandardCopyOption.REPLACE_EXISTING,
					//Copia los atributos
				StandardCopyOption.COPY_ATTRIBUTES
			};
			
			//Hace la copia
			Files.copy(FROM,TO,options);
			JOptionPane.showMessageDialog(null, "Imagen Guardada");
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al Guardar Imagen");
			System.err.println(e.toString());
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == jbCargar) {
			//Elegimos la imagen con filtro png
			JFileChooser fc = new JFileChooser();
	        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
	        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.PNG", "png");
	        fc.setFileFilter(filtro);
	        
	        //Si toco el boton aceptar
	        int seleccion = fc.showOpenDialog(this);
	        if (seleccion == JFileChooser.APPROVE_OPTION) {
	            File fichero = fc.getSelectedFile();
	            String ruta = fichero.getAbsolutePath();
	            String nombreArchivo = fichero.getName();
	            String archivo = destino + "" + nombreArchivo;

	            //Creamos el destino
	            File folder = new File(destino);
	            if (!folder.exists()) {
	                folder.mkdirs();
	            }
	            copyFile_Java(ruta, archivo);
	        }
			
		}
		
		if(e.getSource() == jbMostrar) {
			
			File dir = new File(destino);
			//Mostramos la lista de archivos que hay en destino
	        String[] ficheros = dir.list();
	        if (ficheros == null) {
	            JOptionPane.showMessageDialog(null, "No hay ficheros en el directorio especificado");
	        } else {
	        	//Obtenemos las dimenciones
	            int x = jlImagen.getWidth();
	            int y = jlImagen.getHeight();

	            //Mostramos la imagen
	            //Si hay mas imagenes en el destino , modificamos la parte fichero[1] por un 1
	            imageDisco Imagen = new imageDisco(x, y, destino + "" + ficheros[0]);
	            jlImagen.add(Imagen);
	            jlImagen.repaint();
	        }
			
		}
		
		
	}
	
	
	
	
}
