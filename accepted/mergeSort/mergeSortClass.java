package mergeSort;

public class mergeSortClass {
	public void mergeSort(int[] A){
	    int len_A = A.length;
	    int mid = len_A/2;
	    int[] left = new int[mid];
	    int[] right = new int[len_A - mid];
	    //divide A to left and right
	    
	    for(int i=0;i<mid; i++){
	        left[i] = A[i];
	    }
	    for(int j=0;j<len_A - mid; j++){
	        right[j] = A[mid+j];
	    }
	    
	    mergeSort(left);
	    mergeSort(right);
	    merge(A, left, right);
	}

	public void merge(int[] A, int[] left, int[] right){
	    //I need three flags for each of these arrays
	    int f1=0;
	    int f2=0;
	    int f3 = 0;
	    int l2 = left.length;
	    int l3 = right.length;
	    //start to compare and merge
	    while(f2 < l2 && f3 < l3){
	    if(left[f2]<riht[f3]){
	        A[f1] = left[f2];
	        f2++;
	    }else{
	        A[f1] = right[f3];
	        f3++;
	    }
	    f1++;
	    }
	    //left not finished
	    while(f2<l2){
	        A[f1] = left[f2];
	        f1++;
	        f2++;
	    }
	    //right not finished
	    while(f3 < l3){
	        A[f1] = right[f3];
	        f1++;
	        f3++;
	    }
	}
}
