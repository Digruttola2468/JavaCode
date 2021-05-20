package Imagenes;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class imageDisco extends javax.swing.JPanel{
	
	String ruta;
	
	public imageDisco(int x, int y,String ruta) {
		this.setSize(x,y);
		this.ruta = ruta;
	}
	
	public void paint(Graphics grafico) {
		//Dimensiones
        Dimension height = getSize();
        
        System.out.println(ruta);
        
        //Se selecciona la imagen que tenemos en el paquete de la //ruta del programa
        Image imagenExterna = new ImageIcon(ruta).getImage();

        //se dibuja la imagen que tenemos en el paquete Images //dentro de un panel
        grafico.drawImage(imagenExterna, 0, 0, height.width, height.height, null);

        setOpaque(false);
        super.paintComponent(grafico);
    }
	
}
