package Principal;

public class Main {
	
	public static void main(String[] args) {
		
		String name = "Ivan";
		
		//Validation the String 
		boolean Validation = name.equals("Ivan");
		boolean result = name.equalsIgnoreCase("Ivan");
		
		//Number of chains
		int chains = name.length();
		
		//shows the letter it has in that location
		char Ubicacion = name.charAt(0);
		
		//shows the location it has in that letter
		int Posicion = name.indexOf("I");
		
		//is empty the string name
		boolean empty = name.isEmpty();
		
		//capitalize name
		String capitalize = name.toUpperCase();
		
		//lower case
		String lower = name.toLowerCase();
		
		//if have space
		String DeleteSpace = name.trim();
		
		//Replace
		String Replace = name.replace('I','Y');
		
		
		System.out.println(result);
	}
	
	
}
