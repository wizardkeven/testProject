package rakuten;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Random;

public class Solution {
	public void quickSort(int[] A, int start, int end) {

		// Condition to return
		if (start >= end) {
			return;
		}

		int pivot = partition(A, start, end);
		quickSort(A, start, pivot);
		quickSort(A, pivot + 1, end);
	}

	// Choose a pivot from A
	// And Partition A to left smaller than pivot part and
	// right larger or equal to pivot part
	public int partition(int[] A, int start, int end) {
		int pivot;
		Random rm = new Random();
		pivot = start + rm.nextInt(end - start);
		// Switch the pivot to the end of the array to avoid unnecessary process
		swap(A, pivot, end);
		pivot = end;
		int i = start;
		int index = start;
		while (i < end) {
			if (A[i] < A[pivot]) {
				swap(A, index, i);
				index++;
			}
			i++;
		}

		swap(A, index, pivot);
		pivot = index;
		return pivot;
	}

	public void swap(int[] A, int a, int b) {
		int temp = A[a];
		A[a] = A[b];
		A[b] = temp;
	}
}
