import java.util.Scanner;

public class Teclado{
   public static void main(String args[]){
      Teclado teclado = new Teclado();
      
      Scanner tecla = new Scanner(System.in);
      
      System.out.print("\nValor1: ");
      float Valor1 = tecla.nextFloat();
      
      System.out.print("Valor2: ");
      float Valor2 = tecla.nextFloat();
      
      teclado.mensaje("\n1.Suma - 2.Resta" + 
                         "\n3.Multiplicar - 4.Dividir\n" +
                         "5.Salir");
      
      System.out.print("Elejir: ");
      int Eleccion = tecla.nextInt();
      
      switch(Eleccion){
         case 1: 
   		 teclado.mensaje("\n*****Suma*****");
		 teclado.mensaje("Valor1 + Valor2");
		 
		 System.out.println("Resultado: " + (Valor1 + Valor2) );
                 break;
         case 2: 
		 teclado.mensaje("\n*****Resta*****");
		 teclado.mensaje("Valor1 - Valor2");
		 
		 System.out.println("Resultado: " + (Valor1 - Valor2) );
                 break;
         case 3: 
		 teclado.mensaje("\n*****Multiplicar*****");
		 teclado.mensaje("Valor1 * Valor2");
		 
		 System.out.println("Resultado: " + (Valor1 * Valor2) );
                 break;
         case 4: 
                 teclado.mensaje("\n*****Dividir*****");
		 teclado.mensaje("Valor1 / Valor2");
		 
		 System.out.println("Resultado: " + (Valor1 / Valor2) );
                 break;
         
         case 5: break;
         
         default: break;
      }
   }
   
   private void mensaje(String mens){
      System.out.println(mens);
   }
}