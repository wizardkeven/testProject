package BinarySearchTreeLCA;

import java.util.Scanner;

public class LCAMain {

	public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
	    String[] trStrings = new String[]{"A","B","C"};
	    System.out.print(BinarySearchTreeLCA(trStrings)); 
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
}
