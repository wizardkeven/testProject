package plusOne;

/**
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 * @author kai
 *
 */
public class Solution {
    public int[] plusOne(int[] digits) {
    	int cursor = digits.length-1;
    	int[] overflow = new int[digits.length+1];
    	if (digits[cursor]<9) {
    		digits[cursor]+=1;
			return digits;
		}
    	overflow[cursor+1]=0;
    	digits[cursor]=0;
    	cursor--;

    	while(cursor>=0){
    		if (digits[cursor]<9) {
				digits[cursor]+=1;
				return digits;
			}else {
				overflow[cursor+1]=0;
				digits[cursor]=0;
			}
    		cursor--;
    	}
    	overflow[cursor+1]=1;
		return overflow;     
    }
}
