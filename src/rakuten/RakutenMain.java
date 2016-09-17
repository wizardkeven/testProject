package rakuten;

import java.math.BigInteger;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

import org.omg.CORBA.INTERNAL;

class TreeNode {
	public TreeNode left, right;
	public int val;

	public TreeNode(int val) {
		this.val = val;
	}
}

public class RakutenMain {

	static HashMap<String, Node> map = new HashMap<String, Node>();

	static Node node(String key) {
		return map.get(key);
	}

	public static void possibleCombinations(int coinNumber) {
		if(coinNumber<0)
			System.out.println("Coin number error!");
		if(coinNumber == 1) 
			System.out.println(1+ " possible ways!");
		 BigInteger t = BigInteger.ZERO;
		 for(int i=coinNumber%2==0?coinNumber/2:coinNumber/2+1; i>0; i--){
			 t = t.add(binomial(coinNumber-i+1, i));
		 }
		 t = t.add(BigInteger.ONE);
		 System.out.println(t+" possible ways!");
	}
	static BigInteger binomial(final int N, final int K) {
	    BigInteger ret = BigInteger.ONE;
	    for (int k = 0; k < K; k++) {
	        ret = ret.multiply(BigInteger.valueOf(N-k))
	                 .divide(BigInteger.valueOf(k+1));
	    } 
	    return ret;
	} 

	public static void main(String[] args) {
		possibleCombinations(5);
//		int para = 13;
//		for (int j = para; j >= para-6; j--) {
//			//
//			//
//			// ArrayList<String> answer = nodePath(node("a"));
//			//// for (int i = 0; i < answer.size(); i++) {
//			//// a[i] = rs.nextInt(10);
//			// System.out.println(BinarySearchTreeLCA(new String[] {"[3, 2, 1, 12,
//			// 4, 5, 13]", "5", "4"}));
//			//// }
//			// for (int i = 0; i < 10; i++) {
//			//		System.out.println(findNum(8181));
//			
//			ArrayList<Integer> aa = new ArrayList<>();
//			String ss = countSteps(j);
//			int demo = Integer.parseInt(ss);
//			while (demo > 0) {
//				int re = demo % 2;
//				aa.add(re);
//				demo = demo / 2;
//			}
//			ArrayList<Integer> sb = new ArrayList<>();
//			for (int i = 0; i < aa.size(); i++) {
//				sb.add(aa.get(aa.size() - i - 1));
//			}
//			System.out.println(j+":"+sb.toString());
//		}
//		System.out.println(getSteps(8));
//		System.out.println(countTS(40));
		// }

	}

	public static String findNum(int n) {
		if (n <= 0) {
			System.out.println("i:" + 0 + " fab:0");
			return n + "";
		}
		if (n == 1) {
			System.out.println("i:" + 1 + " fab:1");
			return "1";
		}
		BigInteger res = BigInteger.valueOf(1);
		BigInteger res0 = BigInteger.valueOf(0);
		BigInteger tem = BigInteger.valueOf(0);

		for (int i = 2; i <= n; i++) {
			tem = res;
			res = res.add(res0);
			res0 = tem;
		}

		return res.toString();
	}
	
	public void printTree(TreeNode tmpRoot) {
		 
        Queue<TreeNode> currentLevel = new LinkedList<TreeNode>();
        Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
 
        currentLevel.add(tmpRoot);
 
        while (!currentLevel.isEmpty()) {
            Iterator<TreeNode> iter = currentLevel.iterator();
            while (iter.hasNext()) {
                TreeNode currentNode = iter.next();
                if (currentNode.left != null) {
                    nextLevel.add(currentNode.left);
                } 
                if (currentNode.right != null) {
                    nextLevel.add(currentNode.right);
                } 
                System.out.print(currentNode.val + " ");
            } 
            System.out.println();
            currentLevel = nextLevel;
            nextLevel = new LinkedList<TreeNode>();
 
        } 
 
    } 
	
//	public static String countSteps(int step) {
//		if (step ==0) return "0";
//		BigInteger res = getSteps(step);
//		return res.toString();
//	}
	static BigInteger a0 = BigInteger.valueOf(0);
	static BigInteger a1 = BigInteger.valueOf(1);
	static BigInteger a2 = BigInteger.valueOf(2);
	static BigInteger a3 = BigInteger.valueOf(4);
	static BigInteger a4 = BigInteger.valueOf(8);
	static BigInteger a5 = BigInteger.valueOf(16);
	static BigInteger a6 = BigInteger.valueOf(32);
	
	public static String getSteps(int n) {
		
		if(n <= 0) return "0";
		if(n == 1) return "1";
		if(n == 2) return "2";
		if(n == 3) return "4";
		if(n == 4) return "8";
		if(n == 5) return "16";
		if(n == 6) return "32";
		LinkedList<BigInteger> dices = new LinkedList<>(); 
		dices.add(a1);
		dices.add(a2);
		dices.add(a3);
		dices.add(a4);
		dices.add(a5);
		dices.add(a6);
		BigInteger sum = a6;
//		for(int i=7; i<=n; i++){
//			sum = a0;
//			for (BigInteger iterable_element : dices) {
//				sum = sum.add(iterable_element);
//			}
//			dices.remove();
//			dices.add(sum);
//		}
		
		return sum.toString();
	}
	
	public static BigInteger countTS(int n) {
		if(n <0) return BigInteger.valueOf(0);
		if(n == 1) return a1;
		if(n == 2) return a2;
		if(n == 3) return a3;
		if(n == 4) return a4;
		if(n == 5) return a5;
		if(n == 6) return a6;
		BigInteger tm = a0;
		BigInteger sum = a0;
		for(int i=6; i>=1; i--){
//			tm = sum;
//			if (n - i ==0) {
//				sum = sum.add(a1);
//			}else if(n -i <0){
//				continue;
//			}else {
//				sum = sum.add(countTS(n-i));
//			}
			int te = n-i;
			if (te <0) {
				continue;
			}
			switch (n-i) {
			case 1:
				sum = sum.add(a1);
				break;
			case 2:
				sum = sum.add(a2);
				break;
			case 3:
				sum = sum.add(a3);
				break;
			case 4:
				sum = sum.add(a4);
				break;
			case 5:
				sum = sum.add(a5);
				break;
			case 6:
				sum = sum.add(a6);
				break;
			default:
				sum = sum.add(countTS(n-i));
				break;
			}
//			if(sum.compareTo(tm)<0){
//				sum = tm;
//			}

		}
//		System.out.println(sum.toString()+" for:"+n);
		return sum;
	}
	
	public static String BinarySearchTreeLCA(String[] strArr) {

		int sl = strArr.length;
		if (sl != 3)
			return null;
		String pp = strArr[0];

		String[] ps = pp.split(",");

		int le = ps.length;
		Integer[] ss = new Integer[le];
		for (int i = 0; i < le; i++) {

			String loa = ps[i].trim();
			if (i == 0) {
				loa = loa.substring(1);
			} else if (i == le - 1) {
				loa = loa.substring(0, loa.length() - 1);
			}
			if (loa != null) {
				char as = loa.charAt(0);
				if (Character.isDigit(as)) {
					ss[i] = Integer.parseInt(loa);
				} else {
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
		} else {
			left = (int) l;
		}
		if (Character.isDigit(r)) {
			right = Integer.parseInt(strArr[2]);
		} else {
			right = (int) r;
		}
		TreeNode root = createTreeNode(ss);
		// TreeNode left = new TreeNode(Integer.parseInt(strArr[1]));
		// TreeNode right = new TreeNode(Integer.parseInt(strArr[2]));
		return LCA(root, right, left);

	}

	public static String LCA(TreeNode root, int i, int j) {
		if ((root.left != null || root.right != null) && root.val > Math.max(i, j)) {
			return LCA(root.left, i, j);
		} else if ((root.left != null || root.right != null) && root.val < Math.min(i, j)) {
			return LCA(root.right, i, j);
		} else {
			return root.val + "";
		}
	}

	public static TreeNode createTreeNode(Integer[] input) {
		int lo = input.length;
		if (lo > 0) {
			TreeNode t = new TreeNode(input[0]);
			int i = 1;
			while (i < lo) {
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
		} else if (no < t.val && t.left == null) {
			TreeNode node = new TreeNode(no);
			t.left = node;
		} else if (no > t.val && t.right != null) {
			addNode(t.right, no);
		} else if (no < t.val && t.left != null) {
			addNode(t.left, no);
		}
	}

	public static String LetterCount(String str) {

		if (str.length() <= 0)
			return "-1";

		String[] aa = str.split("\\s+");
		int ll = aa.length;
		int maxre = 1;
		int mm_index = 0;
		int repeat = 0;
		for (int i = 0; i < ll; i++) {
			int la = aa[i].length();
			String ls = aa[i];
			int local = 0;
			// if(la>1){//more than one element in i-th substring
			HashMap<Character, Integer> mm = new HashMap();

			for (int j = 0; j < la; j++) {
				mm.put(ls.charAt(j), 0);
			}
			if (mm.size() == la) {
				repeat++;
			} else {
				for (int j = 0; j < la; j++) {
					mm.put(ls.charAt(j), mm.get(ls.charAt(j)) + 1);
				}

				int maxx = 1;
				;
				for (Character c : mm.keySet()) {
					if (mm.get(c) > maxx) {
						maxx = mm.get(c);
					}
				}
				if (maxx > maxre) {
					maxre = maxx;
					mm_index = i;
				}
			}
			// }

		}
		if (repeat == ll) {
			return "-1";
		} else {
			return aa[mm_index];
		}

	}

	public static ArrayList<String> nodePath(Node node) {
		if (node == null) {
			return null;
		}
		ArrayList<String> answer = new ArrayList<>();

		// add current node name into list
		answer.add(node.getName());
		//
		int tt = node.nodeCount();
		HashMap<Character, Integer> ss = new HashMap<>();
		ArrayList<Integer> sArrayList = (ArrayList<Integer>) ss.values();

		// see if this node contains other nodes
		if (tt > 0) {
			for (int count = 0; count < tt; count++) {
				// get all son nodes
				ArrayList<String> local = nodePath(node.getNode(count));
				if (local != null) {
					answer.addAll(local);
				}
			}
		}

		return answer;
	}

	public static int countCoinExchange(int price, int[] coins) {
		if (price == 0)
			return 0;
		if (coins.length <= 0)
			return 0;

		// Arrays.sort(coins);

		// if(price < coins[0]) return 0;
		return count(coins, coins.length, price);
	}

	public static int count(int[] s, int m, int n) {
		if (n == 0)
			return 0;
		if (n < 0)
			return 0;
		// If there are no coins and n is greater than 0, then no solution exist
		if (m <= 0 && n >= 1)
			return 0;

		// count is sum of solutions (i) including S[m-1] (ii) excluding S[m-1]
		return count(s, m - 1, n) + count(s, m, n - s[m - 1]);

	}

	public static String timeDiff(int time1, int time2) {
		int re = time2 - time1;
		int dl = 24 * 60 * 60;// day boundary
		int hl = 60 * 60; // hour boundary
		int ml = 60;// minit boundary

		if (re < 0) {
			return "";
		}
		if (re > dl) {
			return re / dl + "日前";
		} else if (re <= dl && re > hl) {
			return re / hl + "時間前";
		} else if (re <= hl && re > ml) {
			return re / ml + "分前";
		} else {
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

	// Give an array of length n, find the maximum sum of products defined as
	// following:
	// 1. choose the x-th element from array, calculate the product of x-1 and
	// x+1
	// 2. delete this element from array
	// 3. repeat this operation
	// Maximize the sum of these products
	// maxP(n) = maxP(n-1)+max(a[i-1]*a[i+1]) where i -> 1~a.length-2
	// Basically, this problem can be tackled by recursive algorithm

	public static int findMaxSumOfProducts(int[] a) {

		int la = a.length;

		if (la < 3)
			return 0;
		if (la == 3)
			return a[0] * a[2];

		int[] na = new int[la - 1];
		int best = 1;
		int bv = a[0] * a[2];
		for (int i = 2; i < la - 1; i++) {
			if (bv < a[i - 1] * a[i + 1]) {
				bv = a[i - 1] * a[i + 1];
				best = i;
			}

		}
		boolean pass = false;
		for (int j = 0; j < la - 1; j++) {
			if (j != best && !pass)
				na[j] = a[j];
			else if (j == best && !pass)
				pass = true;

			if (pass)
				na[j] = a[j + 1];

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
