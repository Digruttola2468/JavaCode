
public class printf {

	public static void main(String[] args) {
		/*
		 * printf() = an optional method to control,format,and display text to the console window
		 * 			  two argument = format string + (subject/variable/value)
		 * 			  % [flags][precision][width][conversion-character]		 
		 * 			  %d
		 * */
		
		//System.out.printf("%d this is a format string ",123);
		
		// [Conversion-Character]
		boolean myBoolean = true;
		char myChar = '@';
		String myString = "Ivan";
		int myInt = 17;
		double myDouble = 1000;
		
		//System.out.printf("%b",myBoolean);
		//System.out.printf("%c",myChar);
		//System.out.printf("%s",myString);
		//System.out.printf("%d",myInt);
		//System.out.printf("%f",myDouble);
		
		//[Width]
		//minimum number of characters to be written as output
		//System.out.printf("Hello %-10s",myString);
		
		
		//[precision]
		//sets number of digits of precision when outputting floating-point values
		//System.out.printf("you have this mucho money %.2f",myDouble);
	
		
		//[flags]
		//adds an effect to output based on the flag added to format specifier
		// - : left-justify
		// + : output a plus (+) or minus (-) sign for a numeric value
		// 0 : numeric values are zero-padded
		// , : comma grouping separator if numbers > 1000
		
		System.out.printf("you have this much money %,f",myDouble);
		
	}
}
