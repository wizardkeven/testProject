package happyNumber;

import java.util.ArrayList;

/**
 * Write an algorithm to determine if a number is "happy".
 * A happy number is a number defined by the following process: 
 * Starting with any positive integer, replace the number by the sum
 *  of the squares of its digits, and repeat the process until the number 
 *  equals 1 (where it will stay), or it loops endlessly in a cycle
 *   which does not include 1. Those numbers for which this process 
 *   ends in 1 are happy numbers.
 *   Example: 19 is a happy number
 *   12 + 92 = 82
 *   82 + 22 = 68
 *   62 + 82 = 100
 *   12 + 02 + 02 = 1
 * @author kai
 *
 */
public class Solution {
	ArrayList<Integer> recursive_number = new ArrayList<>();
    public boolean isHappy(int n) {
    	if (n == 1) {
			return true;
		}
    	String nString = String.valueOf(n);
    	char[] n_charArray = nString.toCharArray();
    	int[] n_Array = new int[nString.length()];
    	int test = 0;
    	int zero_count = 0;
    	int sqred_result = 0;
    	for(int i=0;i<nString.length();i++){
    		n_Array[i] = Integer.parseInt(n_charArray[i]+"");
    		test+= n_Array[i];
    		sqred_result+=Math.pow(n_Array[i], 2);
    		if (n_Array[i]==0) {
				zero_count++;
			}
    	}
    	
    	if (test==1) {
			return true;
		}
    	else if (!recursive_number.isEmpty()&&recursive_number.contains(n)) {
			return false;
		}
    	else {
    		recursive_number.add(n);
			return isHappy(sqred_result);
		}
        
    }
}
