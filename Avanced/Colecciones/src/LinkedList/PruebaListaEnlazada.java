package LinkedList;

import java.util.LinkedList;
import java.util.ListIterator;

public class PruebaListaEnlazada {
	
	public static void main(String[] args) {
		
		LinkedList<String> paises = new LinkedList<String>();
		paises.add("España");
		
		paises.add("Colombia");
		paises.add("Mexico");
		paises.add("Argentina");
		
		LinkedList<String> capitales = new LinkedList<String>();
		capitales.add("Madrid");
		
		capitales.add("Bogota");
		
		capitales.add("Ciudad de Mexico");
		capitales.add("La plata");
		
		//System.out.println(paises);
		//System.out.println(ciudades);
		
		ListIterator<String> iterA = paises.listIterator();
		ListIterator<String> iterB = capitales.listIterator();
		
		while(iterB.hasNext()) {
			
			if(iterA.hasNext()) {
				iterA.next();
			}
			iterA.add(iterB.next());
		}
		
		System.out.println(paises);
		
		//index capitales reset
		iterB = capitales.listIterator();
		while(iterB.hasNext()) {
			
			iterB.next();
			if(iterB.hasNext()) {
				iterB.remove();
				iterB.next();
				
				iterB.next();
				iterB.remove();
			}
			
		}
		
		System.out.println(capitales);
		
		//Delete all from capitales
		paises.removeAll(capitales);
		System.out.println(paises);
		
	}
	
}
