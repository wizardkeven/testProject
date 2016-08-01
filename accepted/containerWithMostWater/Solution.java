package containerWithMostWater;

import javax.lang.model.element.Element;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 * Note: You may not slant the container.
 * 
 * Solution
 * Delete all the elements aj such that ai >= aj =< ak and i > j < k. This can be done in linear time.
 * Find the maximum value am
 * Let as = a1
 * For j = 2 through m-1, if as >= aj, delete aj, else as = aj
 * Let as = an
 * For j = n-1 through m+1, if as >= aj, delete aj, else as = aj
 * Notice that the resulting values look like a pyramid, that is, all the elements on 
 * the left of the maximum are strictly increasing and on the right are strictly decreasing.
 * i=1, j=n. m is location of max.
 * While i<=m and j>=m
 * Find area between ai and aj and keep track of the max
 * If ai < aj, i+=1, else j-=1
 * Complexity is linear (O(n))
 * @author kai
 *
 */
public class Solution {

	public int maxArea(int[] height) {
		if (height.length == 1) {
			return 0;
		}
		
		//First step: find the highest point in the map
		int maxArea = 0;
		int maxHeight = 0;
		int indexOfMaxHeight =0;
		for(int i=0; i<height.length;i++){
			if (height[i]>maxHeight) {
				maxHeight = height[i];
				indexOfMaxHeight = i;
			}
		}
		
		//Make map as a pyramid
		int vernier =0;
		for(int i=1; i<indexOfMaxHeight;i++){
			if (height[i]<height[vernier]) {
				height[i]=0;
			}else {
				vernier =i;
			}
		}
		vernier = height.length-1;
		for(int i=height.length-2; i>indexOfMaxHeight;i--){
			if (height[i]<height[vernier]) {
				height[i]=0;
			}else {
				vernier = i;
			}
		}
		
		int vernier_right = 0, vernier_left = height.length-1;
		while(vernier_right<=indexOfMaxHeight&&vernier_left>=indexOfMaxHeight){
			
			if (height[vernier_right]<height[vernier_left]) {
				vernier_right++;
			}else{
				vernier_left--;
			}
			int temp_Area = (height[vernier_right]>height[vernier_left]?height[vernier_left]:height[vernier_right])*(vernier_left-vernier_right);
			if (temp_Area >maxArea) {
				maxArea = temp_Area;
			}
		}
		
		return maxArea;
	}
}
