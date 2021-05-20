import java.util.Scanner;

public class Cadena{
   
   public static void main(String args[]){
      Cadena cad = new Cadena();
      Scanner teclado = new Scanner(System.in);
      
      
      String original = "" , substraccion = "";
      int num = 0 , desde = 0 , hasta = 0;
      
           
      System.out.print("Introduce Cadena de Caracteres: ");
      original = teclado.nextLine();
      
      //Metodo length devuelve en numeros
      num = original.length();
      
      cad.Mensaje("\nContiene: " + num + " Caracteres " + "la palabra " + original);
      
      
      System.out.print("\n\nDesde que caracter queres que empezemos a sacar?: ");
      desde = teclado.nextInt();
      
      System.out.print("\n\nHasta que caracter queres que terminemos?: ");
      hasta = teclado.nextInt();
      
      
      //Metodo substring
      substraccion = original.substring(desde,hasta);

      cad.Mensaje("\n\nLa cadena nueva es: " + substraccion);
   }
   
   private void Mensaje(String mensaje){
      System.out.println(mensaje);
   }
}