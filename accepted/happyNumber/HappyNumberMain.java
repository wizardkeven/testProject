package happyNumber;

/**
 * The key for this problem is that if a number is not a happy number, its recursive squared products must have a number sequence loop
 * So when we find the new product has appeared before, we can judge this number is not a happy number
 * @author kai
 *
 */
public class HappyNumberMain {

	public static void main(String[] args) {
		Solution solution = new Solution();
		boolean boo = solution.isHappy(20);
		System.out.println(boo);
	}

}
