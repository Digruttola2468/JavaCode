import java.util.Scanner;

public class Mate{
   public static void main(String[] args){
      Scanner teclado = new Scanner(System.in);
      Mate mate = new Mate();


      System.out.print("Dame un valor: ");
      float valor = teclado.nextFloat();
      
      System.out.println("\n1.Valor Absoluto" + "\n2.Arcotangente" + "\n3.Seno" +
			 "\n4.Coseno" + "\n5.Tangente" + "\n6.Potencia" + "\n7.Raiz" +
			 "\n8.Redondeo" + "\n9.Numero Aleatorio");
      
      System.out.print("Elegir: ");
      int eleccion = teclado.nextInt();

      mate.mensaje("");
      
      switch(eleccion){
         case 1: 
		 mate.mensaje("Valor: " + valor);
		 int abs = Math.abs((int)valor);
         	 mate.mensaje("Valor Absoluto es: " + abs);
		 break;
         case 2:
		 mate.mensaje("Valor: " + valor);
		 double arco = Math.atan(valor);
		 mate.mensaje("Arcotangente: " + arco); 
		 break;
	 case 3:
		 mate.mensaje("Valor: " + valor);
		 double seno = Math.sin(valor);
		 mate.mensaje("Seno: " + seno);
         	 break;
	 case 4:
		 mate.mensaje("Valor: " + valor);
		 double coseno = Math.cos(valor);
		 mate.mensaje("Coseno: " + coseno);
		 break;
	 case 5:
		 mate.mensaje("Valor: " + valor);
		 double tangente = Math.tan(valor);
		 mate.mensaje("Tangente: " + tangente);
		 break;

	 case 6:
		 mate.mensaje("Valor: " + valor);
		 System.out.print("Elevado: ");
		 int elevar = teclado.nextInt();
		 double pot = Math.pow(valor,elevar);
		 mate.mensaje("Potencia: " + pot);
		 break;

	 case 7:
		 mate.mensaje("Valor: " + valor);
		 double rai = Math.sqrt(valor);
		 mate.mensaje("Raiz: " + rai);
		 break;
	 
	 case 8:
		 mate.mensaje("Valor: " + valor);
		 double redond = Math.round(valor);
		 mate.mensaje("Redondeo: " + redond);
		 break;
	 
	 case 9: 
		 double y = Math.random();
		 mate.mensaje("Numero aleatorio: " + y);
      }
      
   }

   private void mensaje(String mensaje){
	System.out.println(mensaje);
   }
}