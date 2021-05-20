package Imagenes;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;


public class imageMySQL extends javax.swing.JLabel{
	
	BufferedImage ruta;
	
	public imageMySQL(int x,int y, BufferedImage ruta) {
		this.setSize(x,y);
		this.ruta = ruta;
	}
	
	//Se crea un método cuyo parámetro debe ser un objeto Graphics
	public void paint(Graphics grafico) {
		//Obtenemos las dimenciones
		Dimension height = getSize();
		BufferedImage img = ruta;
	   
		//Si hay imagenes
		if(img != null) {
			grafico.drawImage(img, 0, 0, height.width, height.height, null);
		}

		setOpaque(false);
		super.paintComponent(grafico);
	}
	
}
