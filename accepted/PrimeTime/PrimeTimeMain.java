package PrimeTime;
import java.text.NumberFormat;
import java.text.ParsePosition;
/**
 * Have the function PrimeTime(num) take the num parameter 
 * being passed and return the string true if the parameter
 * is a prime number, otherwise return the string false. The
 * range will be between 1 and 2^16. Use the Parameter Testing
 * feature in the box below to test your code with different arguments.
 */
import java.util.Scanner;

public class PrimeTimeMain {

	public static void main(String[] args) {
		Scanner s;
		String yString;
		do {
		    s = new Scanner(System.in);
		    yString =s.nextLine().toString();
		    if (isNumeric(yString)) {
			    System.out.print(PrimeTime(Integer.parseInt(yString))+"\n");
			}

		} while (!yString.equalsIgnoreCase("quit"));
		s.close();
 
	}
	
	  private static boolean isNumeric(String s) {
		  NumberFormat format = NumberFormat.getInstance();
		  ParsePosition parsePosition = new ParsePosition(0);
		  format.parse(s, parsePosition);
		return s.length() == parsePosition.getIndex();
	}
	public static String PrimeTime(int num) { 
		  
		  if(num <=1) return "false";
		  boolean isPrime = true;
		  int tem = num/2;
		  while(tem>1){
		      if(num%tem ==0) return "false";
		      tem--;
		  }
		       
		    return "true";
		    
		  } 
}
