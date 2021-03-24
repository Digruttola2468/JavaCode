package forEach;

import java.util.ArrayList;

public class loop {
	
	public static void main(String[] args) {
		/*
		 * 
		 * for - each = traversing technique to iterate through the elements in an array/Collection
		 * 				less steps , more readable
		 * 				less flexible
		 * 
		 * */
		
		//Array
		//String[] animals = {"cat","Dog","rat","bird"};
		
		//Collection
		ArrayList<String> animals = new ArrayList<String>();
		
		animals.add("Cat");
		animals.add("Rat");
		animals.add("Dog");
		animals.add("Bird");
		
		//for - each
		for(String i : animals) {
			System.out.println(i);
		}
		
	}
	
}
