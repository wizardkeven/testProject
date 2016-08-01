package quickSortPractice;

import java.util.Random;
/**
 * There are two ways to crack down quick sorting
 * I.  We choose the last element in each sub array
 * 	   in this case, we compare element till the one just before this pivot
 * II. We choose the pivot randomly in the sub array every time, thus, there may happen the case where 
 * 	   the pivot one will be swapped due to it being greater than the comparing element. In this case.
 * 	   the current index element == pivot, while this pivot will be swapped to the position of current 
 * 	   comparing element. So we should modify the pivot(index of pivot) equal to this current comparing
 * 	   element. 
 * @author kai
 *
 */
public class quickSortPractice {
	public static void main(String[] args){
//		int[] B = new int[20];
		int[] B = {7,2,1,6,8,5,3,4};
//		int i = 0;
//		Random res = new Random();
//		
//		while(i<20){
//			B[i] = res.nextInt(100);
//			i++;
//		}
		
		quickSort exam = new quickSort();
		exam.quickSortMethod(B, 0, B.length-1);
		for(int j = 0; j< B.length; j++){
			System.out.println(B[j]);
		}
	}
	
}
