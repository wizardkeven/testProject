package addTwoNumbers;

import java.util.Stack;

public class TestMain {

	public static void main(String[] args) {
		Solution sol= new Solution();
		ListNode l1,l2,t1,t2;
		l1 = new ListNode(1);
		t1 = new ListNode(8);
//		t1.next = new ListNode(3);
		l1.next=t1;
		l2 = new ListNode(0);
//		t2 = new ListNode(6);
//		t2.next = new ListNode(4);
//		l2.next = t2;
		ListNode res = ((Solution) sol).addTwoNumbers(l1, l2);
		while (res.next!=null) {
			System.out.println(res.val);
			ListNode temp = res.next;
			res = temp;
		}
		System.out.println(res.val);
	}
	

}
/**
 * Definition
 *  for singly-linked list.
  **/

//  public class ListNode {
//      int val;
//      ListNode next;
//      ListNode(int x) { val = x; }
//  }

//public class Solution {
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//    	int val1,val2;
//    	val1 = hasNext(l1);
//    	val2= hasNext(l2);
//    	val1+=val2;
//    	
//		return rollBack(val1);
//        
//    }
//
//    /**
//     * Roll back an integer to a ListNode
//     * @param val1
//     * @return
//     */
//	private ListNode rollBack(int val1) {
//		ListNode result = null;
//		
//		int digit;//Current positioned digit
//		int i=1;//i-nth position of this digit
//		i=String.valueOf(val1).length();//length of this integer
//		while(i>=0){
//			ListNode tem = new ListNode(0);
//			int curPower = (int) Math.pow(10, i);
//			if (val1/curPower>=10) {
//				digit = (int) ((val1-val1/curPower*curPower)/Math.pow(10, i-1));
//			}else if (val1/curPower==0) {
//				digit = val1;
//			}else {
//				digit=(int) (val1/Math.pow(10, i));
//			}
//			tem.val = digit;
//			tem.next= result;//Concatenate lower position digit to the higher position nodeList
//			result=tem;//Adjust pointer
//			i--;
//		}
//
//		return result;
//	}
//
//	/**
//	 * Expand a ListNode to a normal integer
//	 * @param l1
//	 * @return
//	 */
//	private int hasNext(ListNode l1) {
//		int expected = 0;
//		Stack<Integer> expected_stack = new Stack<>();
//		while(l1.next!=null){
//			expected_stack.push(l1.val);
//			l1=l1.next;
//		}
//		
//		boolean isFirst = true;
//		while (!expected_stack.isEmpty()) {
//
//			if (!isFirst) {
//				expected+=expected_stack.pop()*10;
//			}else {
//				expected=expected_stack.pop();
//				isFirst=false;
//			}
//		}
//		return expected;
//	}
//}

