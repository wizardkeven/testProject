package countAndSay;

public class Solution {
	public String countAndSay(int n) {
		String sayString = "";
		String countOnes = "";
		int conv = n;

		while (conv - 1 >= 0) {
			countOnes = countOnes.concat("1");
			conv-=1;
		}
		System.out.println(countOnes);
//		while (conv > 0) {
//			if (conv - 1 == 0) {
//				countOnes = countOnes.concat("11");
//				conv -= 1;
//			} else if ((conv - 2 >= 0) && (conv - 3 < 0)) {
//				countOnes = countOnes.concat("21");
//				conv -= 2;
//			} else if (conv - 3 >= 0) {
//				countOnes = countOnes.concat("1211");
//				conv -= 3;
//			}
//		}
		//
		 int flag = 0;
		// while (flag < countString.length()) {
		// int next = flag + 1;
		// if (next < countString.length())
		// if (countString.charAt(flag) == '1' && countString.charAt(next) ==
		// '1') {
		// sayString = sayString.concat("11");
		// flag = next + 1;
		// } else if (countString.charAt(flag) == '1' &&
		// countString.charAt(next) == '2') {
		// sayString = sayString.concat("1");
		// flag = next;
		// } else {
		// sayString = sayString.concat("2");
		// flag = next;
		// }
		// else {
		// if (countString.charAt(flag) == '1') {
		// sayString = sayString.concat("1");
		// } else {
		// sayString = sayString.concat("2");
		// }
		 
		// flag = next;
		// }
		// }
		return countOnes;
	}
}
