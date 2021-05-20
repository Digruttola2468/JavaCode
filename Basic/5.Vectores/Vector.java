import java.util.Scanner;

public class Vector {
   public static void main(String args[]){
      Scanner teclado = new Scanner(System.in);
      
      System.out.print("\nCantidad de numeros para Guardar: ");
      int cantidad = teclado.nextInt();
      
      int numeros[] = new int[cantidad];
      
      //Guardando los vectores 
      int aux = 0;
      for(int i=0 ; i<cantidad ; i++){
         System.out.print( (i+1) + ".Dame un numero: ");
         aux = teclado.nextInt();
         numeros[i] = aux;
      }
      
      System.out.println("");
      
      //Mostrando los vectores
      for(int i=0 ; i<cantidad ; i++){
         System.out.print("[" + numeros[i] + "]" + "  ");
      }
      
      /* Otra manera de mostrar los vectores
      for(int num:numeros){
	 System.out.print("[" + num + "]" + "  ");
      }*/
      
      System.out.println("");
   }
}