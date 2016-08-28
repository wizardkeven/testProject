package rakuten;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

 class TreeNode { 
    public TreeNode left, right;
    public int val;
 
    public TreeNode(int val) {
        this.val = val;
    } 
} 
public class RakutenMain {

	static HashMap<String, Node> map = new HashMap<String, Node>();
	static Node node(String key) { return map.get(key); }
	public static void main(String[] args) {
//	
        
        ArrayList<String> answer = nodePath(node("a"));
//		for (int i = 0; i < answer.size(); i++) {
//			a[i] = rs.nextInt(10);
			System.out.println(BinarySearchTreeLCA(new String[] {"[3, 2, 1, 12, 4, 5, 13]", "5", "4"}));
//		}
	}
	
	  public static String BinarySearchTreeLCA(String[] strArr) { 
		  
		  int sl = strArr.length;
		  if(sl !=3) return null;
		  String pp = strArr[0];
		  
		  String[] ps = pp.split(",");
		  
		  int le = ps.length;
		  Integer[] ss = new Integer[le];
		  for (int i = 0; i < le; i++) {
			  
			 String loa = ps[i].trim();
			 if(i ==0){
				 loa = loa.substring(1);
			 }else if (i == le -1) {
				 loa = loa.substring(0, loa.length()-1);
			}
			 if (loa != null) {
				 char as = loa.charAt(0);
				  if (Character.isDigit(as)) {
					  ss[i] = Integer.parseInt(loa);
				}else {
					ss[i] = (int) as;
				}
			} 
			    
		  }
		  int left, right;
		 String tleft = strArr[1].trim();
		 String tright = strArr[2].trim();

		 char l = tleft.toCharArray()[0];
		 
		 char r = tright.toCharArray()[0];
		 
		 if (Character.isDigit(l)) {
			left = Integer.parseInt(strArr[1]);
		}else {
			left = (int)l;
		}
		 if (Character.isDigit(r)) {
			right = Integer.parseInt(strArr[2]);
		}else {
			right = (int)r;
		}
		  TreeNode root = createTreeNode(ss);
//		  TreeNode left = new TreeNode(Integer.parseInt(strArr[1]));
//		  TreeNode right = new TreeNode(Integer.parseInt(strArr[2]));
		    return LCA(root,right, left);
		    
		  } 

		 
		 
		public static String LCA(TreeNode root, int i, int j) {
			if((root.left != null || root.right != null )&&root.val > Math.max(i, j)){
				return LCA(root.left, i, j);
			}else if((root.left != null || root.right != null )&&root.val < Math.min(i, j) ){
				return LCA(root.right, i, j);
			}else {
				return root.val+"";
			}
	}
		public static TreeNode createTreeNode(Integer[] input){
			int lo = input.length;
		    if(lo>0){
		    	TreeNode t = new TreeNode(input[0]);
		    	int i =1;
		    	while(i <lo ){
		    		addNode(t, input[i]);
		    		i++;
		    	}
		    	return t;
		    } 
		    return null; 
		} 
	
	  private static void addNode(TreeNode t, Integer no) {
			if (no > t.val && t.right == null) {
				TreeNode node = new TreeNode(no);
				t.right = node;
			}else if (no < t.val && t.left == null) {
				TreeNode node = new TreeNode(no);
				t.left = node;
			}else if (no > t.val && t.right != null) {
				addNode(t.right, no);
			}else if (no < t.val && t.left != null) {
				addNode(t.left, no);
			}
		}
	public static String LetterCount(String str) { 
		  
		  if(str.length()<=0) return "-1";
		  
		  String[] aa = str.split("\\s+");
		  int ll = aa.length;
		  int maxre = 1;
		  int mm_index = 0;
		  int repeat =0;
		  for(int i=0;i<ll;i++){
		      int la = aa[i].length();
		      String ls = aa[i];
		      int local = 0;
//		      if(la>1){//more than one element in i-th substring
		      HashMap<Character, Integer> mm = new HashMap();
		         
		        for(int j=0;j<la;j++){
		              mm.put(ls.charAt(j), 0);
		          }
		        if (mm.size() == la) {
					repeat++;
				}else{
			        for(int j=0;j<la;j++){
			              mm.put(ls.charAt(j), mm.get(ls.charAt(j))+1);
			          }

			        int maxx = 1;;
					for(Character c: mm.keySet()){
			              if(mm.get(c)>maxx ){
			                  maxx = mm.get(c);
			              }
			          }
			        if(maxx > maxre){
			        	maxre = maxx;
			            mm_index = i;
			        }
				}
//		      }
		      
		  }
		  if (repeat == ll) {
			return "-1";
		}else {
		    return aa[mm_index];
		}

		    
		  } 
	
	 public static ArrayList<String> nodePath(Node node) {
	        if(node == null){
	          return null;
	        } 
	        ArrayList<String> answer = new ArrayList<>();
	       
	      //add current node name into list
	      	answer.add(node.getName());
	      //
	      int tt = node.nodeCount();
	      HashMap<Character, Integer> ss = new HashMap<>();
	      ArrayList<Integer> sArrayList = (ArrayList<Integer>) ss.values();
	 
	      //see if this node contains other nodes
	      if(tt>0){
	            for(int count = 0; count<tt;count++){
	              //get all son nodes
	            	ArrayList<String> local = nodePath(node.getNode(count));
	            		if(local != null){
	              			answer.addAll(local);
	            		}
	        	}
	      }

	        return answer;
	    }
	
	 public static int countCoinExchange(int price, int[] coins) {
	      if(price == 0) return 0;
	      if(coins.length <=0) return 0;
	        
//	      Arrays.sort(coins);
	      
//	        if(price < coins[0]) return 0;
	        return count(coins, coins.length, price);
	    }
	  
	  public static int count(int[] s, int m, int n){
		  if(n == 0) return 0;
	          if(n < 0) return 0;
	       // If there are no coins and n is greater than 0, then no solution exist
	    if (m <=0 && n >= 1)
	        return 0;
	 
	    // count is sum of solutions (i) including S[m-1] (ii) excluding S[m-1]
	    return count( s, m - 1, n ) + count( s, m, n-s[m-1] );
	  
	  }
	 public static String timeDiff(int time1, int time2) {
	      int re = time2 - time1;
	      int dl = 24*60*60;//day boundary
	      int hl = 60*60; //hour boundary
	      int ml = 60;//minit boundary
	      
	      if(re < 0){
	      	return "";
	      }
	      if(re >dl ){
	      	return re/dl +"日前";
	      }else if(re<=dl && re >hl){
	      	return re/hl +"時間前";
	      }else if(re<=hl && re>ml){
	      	return re/ml +"分前";
	      }else{
	      	return re + "秒前";
	      }
	    }
	public static void BubbleSort(int[] A) {

		int len = A.length;

		for (int i = 0; i < len - 1; i++) {

			for (int j = 1; j < len - i; j++) {

				if (A[j - 1] > A[j]) {
					int temp = A[j];
					A[j] = A[j - 1];
					A[j - 1] = temp;
				}

			}

		}

	}
	
	//Give an array of length n, find the maximum sum of products defined as following:
	//1. choose the x-th element from array, calculate the product of x-1 and x+1
	//2. delete this element from array
	//3. repeat this operation
	//Maximize the sum of these products
	//maxP(n) = maxP(n-1)+max(a[i-1]*a[i+1]) where i -> 1~a.length-2
	//Basically, this problem can be tackled by recursive algorithm

	public static int findMaxSumOfProducts(int[] a){
		
		int la = a.length;
		
		if(la < 3) return 0;
		if(la ==3) return a[0]*a[2];
		
		int[] na = new int[la-1];
		int best = 1;
		int bv = a[0]*a[2];
		for(int i=2 ; i < la-1; i++){ 
			if( bv < a[i-1]*a[i+1] ){
				bv = a[i-1]*a[i+1];
				best = i;
			}
			
		}
		boolean pass = false;
		for(int j = 0; j<la-1;j++){
			if(j != best && !pass) na[j] = a[j];
			else if(j == best && !pass) pass = true;
		
			if(pass) na[j] = a[j+1];
			
		}
		return bv + findMaxSumOfProducts(na);	
		
	}

	public static String FindLSubStringIn2Strings(String a, String b) {

		if (a.length() == 0 || b.length() == 0)
			return null;

		int la = a.length();
		int lb = b.length();
		int[][] LCSuffix = new int[la][lb];
		for (int i = 0; i < la; i++) {
			for (int j = 0; j < lb; j++) {
				if (a.charAt(i) == b.charAt(j)) {
					if (i > 0 && j > 0) {
						LCSuffix[i][j] = LCSuffix[i - 1][j - 1] + 1;
					} else {
						LCSuffix[i][j] = 1;
					}

				}

			}
		}
		// Find the longest length in this matrix
		int aFlag = 0;
		int maxLength = LCSuffix[0][0];
		for (int i = 0; i < la; i++) {
			for (int j = 1; j < lb; j++) {
				if (LCSuffix[i][j] > maxLength) {
					aFlag = i;
					maxLength = LCSuffix[i][j];
				}
			}
		}
		return a.substring(aFlag - maxLength + 1, aFlag + 1);
	}

}
