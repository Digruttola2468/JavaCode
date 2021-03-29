import java.util.Scanner;
public class Main{
   public static void main(String[] args){

      ArchivosTxt archivos = new ArchivosTxt();
      Scanner teclado = new Scanner(System.in);

      for(int i=0 ; i<10 ; i++){
	 System.out.println("\n1.Crear un archivo" + "\n2.Crear una Carpeta" +
			 "\n3.Leer un archivo" + "\n4.Escribir un archivo" + "\n5.Salir");
	 System.out.print("\nElegir: ");
         int eleccion = teclado.nextInt();

         switch(eleccion){
	    case 1:
		   archivos.CrearFicheros();
		   break;
	    case 2:
		   archivos.CrearCarpetas();
		   break;
	    case 3:
		   archivos.leeTxt();
		   break;
	    case 4:
		   archivos.EscribirFichero();
		   break;
	    case 5:
		   break;
	    default:
		   System.err.println("\nJajaja sos re trol pa , Error al elegir");
		   break;
         }
         if(eleccion == 5)
		break;
      }
   }
}