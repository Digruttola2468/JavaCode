public class SetGet{

   public static void main(String[] args){
      
      Clase objeto = new Clase();
      
      //Definimos con los Metodos Setter      
      objeto.setNombre("Ivan");
      objeto.setEdad(10);

      //Mostramos con los Metodos Getter
      System.out.println("El nombre es: " + objeto.getNombre());
      System.out.println("La edad es: " + objeto.getEdad());
   }

}