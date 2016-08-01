package addTwoNumbers;

/**
 * You are given two linked lists representing two non-negative numbers.
 *  The digits are stored in reverse order and each of their nodes contain 
 *  a single digit. Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * @author kai
 */
import java.util.Stack;

public class Solution {
	
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	    	long val1,val2;
	    	val1 = hasNext(l1);
	    	val2= hasNext(l2);
	    	val1+=val2;
	    	
			return rollBack(val1);
	        
	    }

	    /**
	     * Roll back an integer to a ListNode
	     * @param val1
	     * @return
	     */
		private ListNode rollBack(long val1) {
			ListNode result = null;
			
			int digit;//Current positioned digit
			int i=0;//i-nth position of this digit

			char[] resultChars = String.valueOf(val1).toCharArray();
//			i=resultChars.length-1;
			if (val1<0) {
				return result;
			}
			while(i<resultChars.length && i>=0){
				ListNode tem = new ListNode(0);
				digit = Integer.parseInt(String.valueOf(resultChars[i]));
//				int curPower = (int) Math.pow(10, i);
//				if (val1/curPower>=10) {
//					digit = (int) ((val1-val1/curPower*curPower)/Math.pow(10, i-1));
//				}
//				else if (val1/curPower==0) {
//					digit = 0;
//				}
//				else {
//					digit=(int) (val1/Math.pow(10, i));
//				}
				tem.val = digit;
				tem.next= result;//Concatenate lower position digit to the higher position nodeList
				result=tem;//Adjust pointer
				i++;
			}

			return result;
		}

		/**
		 * Expand a ListNode to a normal integer
		 * @param l1
		 * @return
		 */
		private long hasNext(ListNode l1) {
			long expected = 0;
			Stack<Integer> expected_stack = new Stack<>();
			while(l1!=null){
				expected_stack.push(l1.val);
				l1=l1.next;
			}
			
			boolean isFirst = true;
			int powNum =0;
			String mun = "";
			while (!expected_stack.isEmpty()) {
				mun = mun.concat(expected_stack.pop().toString());
//				if (!isFirst) {
//					expected+=expected_stack.pop()*Math.pow(10, powNum);
//				}else {
//					expected=expected_stack.pop();
//					isFirst=false;
//				}
//				powNum++;
			}
			if (mun.isEmpty()) {
				return 0;
			}
			expected = Long.parseLong(mun);
			return  expected;
		}
}
