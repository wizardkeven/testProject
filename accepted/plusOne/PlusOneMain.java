package plusOne;

public class PlusOneMain {

	public static void main(String[] args) {
		int[] digits = {9,3,2,4,8,9,5};
		Solution solution = new Solution();
		int[] re = solution.plusOne(digits);
		for (int i = re.length-1; i >=0; i--) {
			System.out.println(re[i]);
		}
	}

}
