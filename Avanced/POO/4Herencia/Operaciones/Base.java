package 4Herencia;

import java.util.Scanner;

public class Base{
   
   protected int valor1 , valor2 , Resultado;
   Scanner entrada = new Scanner(System.in);
   
   //Metodo: pide los valores al Ususario
   public void PedirDatos(){
      System.out.print("Dame el Primer valor: ");
      valor1 = entrada.nextInt();
      
      System.out.print("Dame el Segundo valor: ");
      valor2 = entrada.nextInt();
      
   }
   
   //Metodo: muestra el Resultado
   public void MostrarResultado(){
      System.out.println(Resultado);
   }

}