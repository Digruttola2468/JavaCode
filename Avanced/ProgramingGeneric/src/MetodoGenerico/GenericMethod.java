package MetodoGenerico;

import java.util.GregorianCalendar;

public class GenericMethod {
	
	public static void main(String[] args) {
		
		/*String nombre[] = { "Maria" , "Pepe" , "Jose" };
		System.out.println(MisMatrices.getMenor(nombre));
		*/
		
		GregorianCalendar fechas[] = 
			{
				 new GregorianCalendar(2015 , 07 , 12) ,  
				 new GregorianCalendar(2015 , 04 , 12) , 
				 new GregorianCalendar(2015 , 05 , 12) , 
			};
		
		System.out.println(MisMatrices.getMenor(fechas));
		
	}
	
}

class MisMatrices{
	
	public MisMatrices() {
		
	}
	
	
	
	public static <T extends Comparable> T getMenor( T[] is) {
		
		if( is == null || is.length == 0 ) 
			return null;
		
		T elementoMenor = is[0];
		for (int i=1 ; i<is.length ; i++) {
			
			if( elementoMenor.compareTo(is[i]) > 0 ) {
				elementoMenor = is[i];
			}
			
		}
		
		return elementoMenor;
		
	}
	
}
