import java.io.File;
import java.util.Scanner;

public class Archivo {
    public void LecturaTxt(){
        Scanner archivo = null;
        try{
            archivo = new Scanner(new File("C:\\Users\\ivans\\Desktop\\Java\\Avanced\\Base De Datos\\Txt\\suma_txt\\prueba.txt"));
        }catch(Exception e){
            System.err.println("Archivo no encontrado");
        }
        int num = 0, count = 0;
        //	hasNext ---> Booleano
        while(archivo.hasNext()){		//leer todos los numeros del archivo
            
            num = archivo.nextInt();
            count = count + num;
            System.out.print(" " + num);
            
	}
        System.out.println("\nLa suma total es: " + count);
    }
}
