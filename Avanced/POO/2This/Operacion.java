public class Operacion{
   private int base , altura , Resultado;

   public Operacion(int base , int altura){
      this.base = base;
      this.altura = altura;
   }

   public void Calculo(){
      Resultado = base * altura;
   }
   
   public void Imprimir(){
      Calculo();
      System.out.println("\nArea: " + Resultado);
   }

}