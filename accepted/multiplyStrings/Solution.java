package multiplyStrings;

import java.util.Stack;

/**
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * Note:
 * The numbers can be arbitrarily large and are non-negative.
 * Converting the input string to integer is NOT allowed.
 * You should NOT use internal library such as BigInteger.		
 * @author kai
 *
 */

public class Solution {
    public String multiply(String num1, String num2) {
    	String result = "";
    	String multiplicand,multiplicator;//multiplicand is supposed to be equal to or larger than multiplicator
    	
    	if (num1.length()>=num2.length()) {
			multiplicand = num1;
			multiplicator = num2;
		}else {
			multiplicand = num2;
			multiplicator = num1;
		}
    	
    	for(int position = multiplicator.length()-1;position>=0;position--){
    		String factor = multiBitWithMultiplicand(multiplicator.charAt(position), multiplicand);
    		result = addFactorToResult(factor,multiplicator.length()-1-position, result);
    	}
    	
    	return result;
    }

	    /**
	     * Add factor to the result with its proper digit place
	     * @param factor
	     * @param position 
	     * @param result
	     * @return
	     */
		private String addFactorToResult(String factor, int digit_place, String result) {
			
			//Complement the missed post digits
			while(digit_place-->0){
				factor+=0;
			}
			
			String addent,postdent;
			String re = "";
			
			//Make addent always the largest number
			if (factor.length()>=result.length()) {
				addent = factor;
				postdent=result;
			}else {
				addent = result;
				postdent = factor;
			}
			
			int cursor_postdent = postdent.length()-1;
			int carry = 0;
			
			for(int position =addent.length()-1; position>=0;position--){
				int digit_addent = Integer.parseInt(addent.charAt(position)+"");
				int res;
				
				if (cursor_postdent>=0) { 			//if digit of postdent at this position exists
					int digit_postdent = Integer.parseInt(postdent.charAt(cursor_postdent)+"");
					res = digit_addent+digit_postdent+carry;
					cursor_postdent--;
				}else {								//otherwise, add addent and carry
					res = digit_addent+carry;
				}
				re=res +re;
				carry =0;//clear carry
				if (position>0 && res>=10) { //check if carry needed
					carry=1;
					re = re.substring(1);
				}
			}
			
	//		//Check the overflowed carry number
	//		if (carry>=0) {
	//			re = 1+re;
	//		}
			while(!re.isEmpty() && re.length()!=0 && re.startsWith("0"))
				re = re.substring(1);
			return re;
		}
	
		/**
		 * Multiply a digit string with a digit char
		 * @param charAt
		 * @param multiplicand
		 * @return
		 */
		private String multiBitWithMultiplicand(char charAt, String multiplicand) {
			
			int carry = 0;
			String result = "";
			int multi_int = Integer.parseInt(charAt+"");
			
			for(int digit_place = multiplicand.length()-1; digit_place>=0;digit_place--){
				
				int multi_digit = Integer.parseInt(multiplicand.charAt(digit_place)+"");
				int digit_res = multi_int*multi_digit+carry; //calculate multiplication
				result= digit_res +result;//Take only unit digit and add it to result
				carry = digit_res/10;
	
				if (digit_place>0 && digit_res>=10){
					result = result.substring(1);
				}
			}
			
	//		//If carry significant after the calculation loop, then add it as highest digit
	//		if (carry>0)
	//			result= carry+result;
	//		
			return result;
		}
}
