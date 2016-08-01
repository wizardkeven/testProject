package mergeSort;

public class mergeSortClass {
	
	public void mergeMain(int[] A){
		if(A.length<2)
			return;
		int a_length = A.length;
		int mid = a_length/2;
		int[] left = new int[mid];
		int[] right = new int[a_length-mid];
		
		//Copy of left half array
		for(int i=0;i<mid; i++){
			left[i] = A[i];
		}
		//Copy of right half array
		for(int j=0;j<a_length-mid; j++){
			right[j] = A[mid+j];
		}
		mergeMain(left);
		mergeMain(right);
		merge(A, left,right);
	}
	
	public void merge(int[] A, int[] left, int[] right){
		//index trackers for these three arrays
		int a_index = 0;
		int l_index = 0;
		int r_index = 0;
		int l_length = left.length;
		int r_length = right.length;
		
		//compare and merge
		//If one of the sub-arrays exhausted first
		while(l_index<l_length && r_index < r_length){
			if(left[l_index]<=right[r_index]){
				A[a_index] = left[l_index];
				l_index ++;
			}else{
				A[a_index] = right[r_index];
				r_index++;
			}
			a_index++;
		}
		while(l_index<l_length){
			A[a_index] = left[l_index];
			l_index++;
			a_index++;
		}
		while(r_index<r_length){
			A[a_index] = right[r_index];
			r_index++;
			a_index++;
		}
	}
}
