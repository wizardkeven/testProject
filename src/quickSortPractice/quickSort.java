package quickSortPractice;

import java.util.Random;

public class quickSort {
	
	public void quickSortMethod(int[] A, int start, int end){
		//end point for recursive calls
		if(start < end){
			int p_index = partition(A, start, end);
			quickSortMethod(A, start, p_index-1);
			quickSortMethod(A, p_index+1, end);
		}
		}
		
		public int partition(int[] A, int start, int end){
			Random random = new Random();
			//Choosing a pivot randomly
			int pivot = start+random.nextInt(end - start);

			int index = start;
			
			for(; start <= end; start++){
				if(A[start] < A[pivot]){
					if(A[index] == A[pivot]){
						pivot = start;
					}
					swap(A,index, start);
					index++;
				}
			}
			swap(A, pivot, index);
			return index;
		}
		
		public void swap(int[] A, int num1, int num2){
			int temp = A[num1];
			A[num1] = A[num2];
			A[num2] = temp;
		}
}
