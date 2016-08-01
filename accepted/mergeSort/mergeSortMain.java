package mergeSort;

import java.util.Random;

public class mergeSortMain {

	public static void main(String[] args) {
		Random ran = new Random();
//		int[] A = {5,2,3,6,8,1,4,9,7};
		int[] A = new int[20];
		for(int i=0; i<20; i++){
			A[i] = ran.nextInt(100);
		}
		mergeSortClass mergeSortClass = new mergeSortClass();
		mergeSortClass.mergeMain(A);
		
		for(int j = 0; j< A.length; j++){
			System.out.println(A[j]);
		}
	}

}
