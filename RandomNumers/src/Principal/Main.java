package Principal;

import java.util.Random;	//import the method RandomNumers

public class Main {
	
	
	public static void main(String[] args) {
		
		Main principal = new Main();
		
		principal.RandomNumers();
		
	}
	
	//Random Numbers Method
	private void RandomNumers() {
		
		Random random = new Random();			//Add the Random 
		
		int x = random.nextInt(6);				//Random Variable whole numbers
		double y = random.nextDouble();			//Random Variable Double
		boolean z = random.nextBoolean();		//Random Variable Boolean return true or false
		
		System.out.println(z);					//Show on screen
	}
	
}
