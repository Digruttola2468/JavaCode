import java.util.Scanner;

public class Matri {
   public static void main(String[] args){

      Scanner teclado = new Scanner(System.in);
      
      //Pedimos Filas y Columnas
      System.out.print("\nCantidad Filas: ");
      int filas = teclado.nextInt();

      System.out.print("Cantidad Columnas: ");
      int colum = teclado.nextInt();      
      System.out.println();

      int numeros[][] = new int[filas][colum];


      //Pedimos los datos
      for(int i=0 ; i<filas ; i++){
         for(int j=0 ; j<colum ; j++){
            System.out.print("[" + (i+1) + "]" + "[" + (j+1) + "]" + ".Dame un valor: ");
 	    int aux = teclado.nextInt();
	    numeros[i][j] = aux;
         }   
      }
      
      System.out.println();
      
      //Mostramos los datos
      for(int i=0 ; i<filas ; i++){
	 for(int j=0 ; j<colum ; j++){
	    System.out.print("[" + numeros[i][j] + "] ");
	 }
	 System.out.println("");
      }
      
      
   }

}