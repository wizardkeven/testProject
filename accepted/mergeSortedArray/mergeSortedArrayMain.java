package mergeSortedArray;

public class mergeSortedArrayMain {

	public static void main(String[] args) {
		int[] nums1 = {1,2,4,5,6,0}; 
		int[] nums2 = {3};
		
		Solution solution = new Solution();
		solution.merge(nums1, 5, nums2, 1);
	}

}
