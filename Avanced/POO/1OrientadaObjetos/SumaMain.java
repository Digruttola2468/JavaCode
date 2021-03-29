import java.util.Scanner;

public class SumaMain{
   public static void main(String args[]){
      Scanner teclado = new Scanner(System.in);
      
      System.out.print("Dame Valor1: ");
      int valor1 = teclado.nextInt();
      
      System.out.print("\nDame Valor2: ");
      int valor2 = teclado.nextInt();
      
      //Enviar datos atraves de argumentos
      Suma valores = new Suma(valor1,valor2);
      
      valores.Imprimir();
   }
}