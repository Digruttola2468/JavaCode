
import javax.imageio.*;
import java.io.*;
import java.awt.image.*;
import javax.swing.*;

public class Imagen {
    
    BufferedImage imagen = null;

    public void CopiarImagen(String rutaImagen){
        try {
            File archivoImagen = new File(rutaImagen);

            imagen = ImageIO.read(archivoImagen);                               //Leemos la imagen
            
            System.out.println("Se ha leido correctamente la imagen\n");    

            String nombreCopia = JOptionPane.showInputDialog("Digite el nombre de la Copia de la foto");

            ImageIO.write(imagen,"jfif",new File(rutaImagen + nombreCopia));    //Creamos una copia de la imagen leida

            System.out.println("Se ha echo una Copia correctamente la imagen");
        } catch (Exception e) {
            System.err.println("Error en la Lectura");
        }
    }

}
