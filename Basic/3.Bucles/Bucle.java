import java.util.Scanner;

public class Bucle {
   public static void main(String[] arg){
      Bucle buc = new Bucle();
      Scanner teclado = new Scanner(System.in);
      
      System.out.print("Conteo de numeros: ");
      int numero = teclado.nextInt();
      


      buc.Mensaje("\n***********Bucle For***********");
      for(int i = 0 ; i <= numero ; i++){
         System.out.print(i + " ");
      }



      buc.Mensaje("\n\n***********Bucle While***********");
      int i=0;
      while(i <= numero){
	 System.out.print(i + " ");
 	 i++;
      }

      buc.Mensaje("\n\n***********Bucle do_While***********");
      i = 0;
      do{
	 System.out.print(i + " ");
	 i++;
      }while(i <= numero);

      buc.Mensaje("");
   }
   private void Mensaje(String mensaje){
      System.out.println(mensaje);
   }
}