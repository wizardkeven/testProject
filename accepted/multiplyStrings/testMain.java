package multiplyStrings;

import java.nio.charset.StandardCharsets;

public class testMain {

	public static void main(String[] args) {
		String op1 = "562";
		String op2 = "362541";
		
		Solution solution = new Solution();
		String reString = solution.multiply(op1, op2);
		System.out.print(reString);
	}

}
