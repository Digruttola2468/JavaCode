import java.util.Scanner;

public class Condicionale{
   public static void main(String args[]){
      Scanner teclado = new Scanner(System.in);
      
      System.out.println("Rango: 1-10");
      System.out.print("Dame un numero dentro del rango: ");
      int rango = teclado.nextInt();
      
      //si rango es mayor o igual a 1 y que si rango es menor o igual a 10
      if(rango >= 1 && rango<=10)
         System.out.println("\nDentro del rango felicidades :)");
      else
	 System.out.println("\nAfuera del rango :(");
   }
}