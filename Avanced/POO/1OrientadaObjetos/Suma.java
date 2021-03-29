public class Suma{
   private int vUno , vDos , Resultado;
   
   //Constructor
   public Suma(int valorUno, int valorDos){
      this.vUno = valorUno; //Hace referencia a la clase que estamos utilizando
      this.vDos = valorDos;
   }

   public void Operacion(){
      Resultado = vUno + vDos;
   }

   public void Imprimir(){
      Operacion();
      System.out.println("\nEl resultado de la Suma: " + Resultado);
   }
}