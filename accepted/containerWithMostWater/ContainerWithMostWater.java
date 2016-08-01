package containerWithMostWater;

import java.awt.geom.Area;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		int[] test = {5,2,12,1,5,3,4,11,9,4};
		Solution solution = new Solution();
		int max_maxArea = solution.maxArea(test);
		System.out.println(max_maxArea);

	}

}
