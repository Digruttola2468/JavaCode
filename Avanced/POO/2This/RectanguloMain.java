import java.util.Scanner;

public class RectanguloMain{
   public static void main(String args[]){
      Scanner teclado = new Scanner(System.in);
      
      System.out.print("Dame Base: ");
      int base = teclado.nextInt();
      
      System.out.print("\nDame Altura: ");
      int altura = teclado.nextInt();
      
      Operacion valores = new Operacion(base,altura);
      valores.Imprimir();
   }
}