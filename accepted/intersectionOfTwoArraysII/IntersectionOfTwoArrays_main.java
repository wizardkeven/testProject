package intersectionOfTwoArraysII;

public class IntersectionOfTwoArrays_main {

	public static void main(String[] args) {
		int[] nums1={1,2};//2,5,3,5,2,15,3,7,24
		int[] nums2 = {1,1};
		Solution solution = new Solution();
		int[] res = solution.intersect(nums1, nums2);
		System.out.println(res);
	}

}
