package mergeSortedArray;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as
 * one sorted array. Note: You may assume that nums1 has enough space (size that
 * is greater or equal to m + n) to hold additional elements from nums2. The
 * number of elements initialized in nums1 and nums2 are m and n respectively.
 * 
 * @author kai
 *
 */
public class Solution {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		// if (nums1.length < m+n) {
		// System.err.println("nums1 length illegal!"+nums1.length+" "+n);
		// return;
		// }
		int cursor_num2 = 0; // cursor of num1

		int swapTotalTime = m + n;
		int count = 0;
		int[] swap = new int[m + n];
		int cursor_swap_current = 0; // cursor of swap array
		int cursor_swap_tail = 0;
		while (count < swapTotalTime) {
			if (cursor_num2 < n) {
				if (count < m && (cursor_swap_tail - cursor_swap_current) <= 0) {

					if (nums1[count] > nums2[cursor_num2]) {
						swap[cursor_swap_tail] = nums1[count];
						cursor_swap_tail++;
						nums1[count] = nums2[cursor_num2];
						cursor_num2++; // move forward the cursor of num2
					}
				} else if (count >= m && (cursor_swap_tail - cursor_swap_current) <= 0) {
					nums1[count] = nums2[cursor_num2];
					cursor_num2++;
				} else if ((count >= m && (cursor_swap_tail - cursor_swap_current) > 0)) {
					if (swap[cursor_swap_current] <= nums2[cursor_num2]) {
						nums1[count] = swap[cursor_swap_current];
						cursor_swap_current++;
					} else {
						nums1[count] = nums2[cursor_num2];
						cursor_num2++;
					}
				}
				else if(count < m && (cursor_swap_tail - cursor_swap_current) > 0){

					swap[cursor_swap_tail] = nums1[count];
					cursor_swap_tail++;
					// then handle the comparison of swap and num2
					if (swap[cursor_swap_current] <= nums2[cursor_num2]) {
						nums1[count] = swap[cursor_swap_current];
						cursor_swap_current++;
					} else {
						nums1[count] = nums2[cursor_num2];
						cursor_num2++;
					}
				}
			} else if (cursor_swap_tail - cursor_swap_current > 0) {
				if (count < m) {
					if (nums1[count] > swap[cursor_swap_current]) {
						swap[cursor_swap_tail] = nums1[count];
						cursor_swap_tail++;
						nums1[count] = swap[cursor_swap_current];
						cursor_swap_current++;
					}
					
				} else{
					nums1[count] = swap[cursor_swap_current];
					cursor_swap_current++;
				}

			}
			count++;
		}
		System.out.println(nums1);

	}

}
