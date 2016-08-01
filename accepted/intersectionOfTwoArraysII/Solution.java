package intersectionOfTwoArraysII;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Given two arrays, write a function to compute their intersection.
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * 
 * Note:
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 * @author kai
 *
 */
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
    	
    	int[] smaller,bigger;
    	
    	//make nums1 always a smaller array between the two
    	if (nums1.length>nums2.length) {
    		bigger = nums1;
    		smaller = nums2;	
		}else {
			smaller = nums1;
			bigger=nums2;
		}
    	int biggest =0;
    	for(int mem: bigger){
    		if (mem> biggest) {
				biggest = mem;
			}
    	}
    	
    	//Store occurrence times for each member of nums2
    	int[] indexized_nums2 = new int[biggest+1];
    	
    	for(int mem: bigger){
    		indexized_nums2[mem]++;
    	}
    	
    	int iteNum =0;
    	ArrayList<Integer> tem = new ArrayList<>();

		for(int mem:smaller){
			if (mem<=indexized_nums2.length&&indexized_nums2[mem]-->0) {
				tem.add(mem);
			}
		}
		int[] res = new int[tem.size()];
		for(int i=0;i< tem.size();i++)
			res[i]=tem.get(i);
		return res;
        
    }
}
