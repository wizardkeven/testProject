package singleNumber;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * @author kai
 *
 */
public class Solution {
    public int singleNumber(int[] nums) {
//    	int[] compare = new int[nums.length];
//    	int index = 0;
    	TreeSet<Integer> intContainer = new TreeSet<>();
    	int count = 0;
    	for(int element: nums){
    		if (!intContainer.add(element)) 
    			intContainer.remove(element);
    	}
    	
		return intContainer.first();
        
    }
}
