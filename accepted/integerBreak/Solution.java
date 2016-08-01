package integerBreak;

import java.util.ArrayList;

/**
 * Given a positive integer n, break it into the sum of at least two positive 
 * integers and maximize the product of those integers. Return the maximum product you can get.
 * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
 * Note: you may assume that n is not less than 2.
 * @author kai
 *
 */
public class Solution {
	
	/**
	 * This problem should be analyzed mathematically before coding
	 * Cause any number can be broken into sum of 3s and 2s while among all the products of its broken arrays
	 * the product of most 3s with less 2s is the biggest
	 * @param n
	 * @return
	 */
    public int integerBreak(int n) {
//    	ArrayList<Integer> candidates = new ArrayList<>();

    	int ite_Temp = n;
    	
    	if (n==2)
    		return 1;
    	if (n==3)
    		return 2;

//    	while(ite_Temp>0){
    		int remainder = ite_Temp%3;
    		int result = ite_Temp/3;
    		if (remainder==0) {
				return (int) Math.pow(3,result);
			}else if (remainder==1) {
				return (int) (Math.pow(3, result-1)*4);
			}else {
				return (int) (Math.pow(3, result)*2);
			}
//    	}
    }
}
