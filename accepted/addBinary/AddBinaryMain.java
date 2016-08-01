package addBinary;

public class AddBinaryMain {

	public static void main(String[] args) {
		Solution solution = new Solution();
		String a = "1010";
		String b = "1011";
		String reString = solution.addBinary(a, b);
		
		System.out.println(reString);
	}

}
