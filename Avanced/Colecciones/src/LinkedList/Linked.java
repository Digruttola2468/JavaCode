package LinkedList;

import java.util.LinkedList;

public class Linked {
	
	public static void main(String[] args) {
		LinkedList<String> personas = new LinkedList<String>();
		
		personas.add("Ivan");
		personas.add("Sandra");
		personas.add("Ana");
		personas.add("Laura");
		
		for ( String nombres : personas ) 
			System.out.println(nombres);
		
		
		
	}
	
}
