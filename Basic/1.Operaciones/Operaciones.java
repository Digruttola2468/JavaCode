public class Operaciones{
   public static void main(String args[]){
      
      Operaciones opec = new Operaciones();

      int Valor1 = 10 , Valor2 = 10;
      
      opec.mensaje("\n" + "*******Suma*******");
      opec.mensaje("Valor1 + Valor2");
      
      System.out.println("Resultado: " + (Valor1 + Valor2) + "\n");
      
      
      opec.mensaje("*******Resta*******");
      opec.mensaje("Valor1 - Valor2");

      System.out.println("Resultado: " + (Valor1 - Valor2) + "\n");
      
      
      opec.mensaje("*******Multiplicar*******");
      opec.mensaje("Valor1 * Valor2");

      System.out.println("Resultado: " + (Valor1 * Valor2) + "\n");
      
      
      opec.mensaje("*******Dividir*******");
      opec.mensaje("Valor1 / Valor2");
      
      System.out.println("Resultado: " + (Valor1 / Valor2) );
   }

   private void mensaje(String mensaj){
	System.out.println(mensaj);}
}