package addBinary;

import java.util.BitSet;

/**
 * Given two binary strings, return their sum (also a binary string). For
 * example, a = "11" b = "1" Return "100".
 * 
 * @author kai
 *
 */
public class Solution {
	public String addBinary(String a, String b) {

		String addent, postdent;
		String bi_sum = "";
		if (a.length() > b.length()) {
			addent = a;
			postdent = b;
		} else {
			addent = b;
			postdent = a;
		}
		int cursor_a = addent.length() - 1;
		int cursor_b = postdent.length() - 1;
		int carry = 0;

		while (cursor_a >= 0) {

			if (cursor_b >= 0) { 						// b has not reached out its size

				if (postdent.charAt(cursor_b) == '1') { 
					if (addent.charAt(cursor_a) == '1') { 
						if (carry == 0) 				//1,1,0
							bi_sum = "0" + bi_sum;
						else 							// 1,1,1
							bi_sum = "1" + bi_sum;
						carry = 1; // carry
					} else 
					if (carry == 0) 					// 1,0,0
						bi_sum = "1" + bi_sum;
					else { 								// 1,0,1
						bi_sum = "0" + bi_sum;
						carry = 1; // carry
					}
				} else {
					if (addent.charAt(cursor_a) == '1') { 
						if (carry == 0) 				//0,1,0
							bi_sum = "1" + bi_sum;
						else { 							//0,1,1
							bi_sum = "0" + bi_sum;
							carry = 1; // carry
						}
					} else 
					if (carry == 0) 					// 0,0,0
						bi_sum = "0" + bi_sum;
					else{								// 0,0,1
						bi_sum = "1" + bi_sum;
						carry =0;
					}
						
				}
				cursor_b--;
			} else { 									// b has reached out its size
				if (addent.charAt(cursor_a) == '1') {
					if (carry == 1) {					// ,1,1
						bi_sum ="0"+bi_sum;
						carry =1;
					}else {								// ,1,0
						bi_sum="1"+bi_sum;
					}
				}else {
					if (carry == 1) {					// ,0,1
						bi_sum="1"+bi_sum;
						carry = 0;
					}else {								// ,0,0
						bi_sum="0"+bi_sum;
					}
				}
			}
			cursor_a--;
		}
		if (carry==1)
			bi_sum = "1"+bi_sum;
		return bi_sum;
	}

}
