package countPrimes;

public class Solution {
	public int countPrimes(int n) {

		if (n <= 2) {
			return 0;
		}

		boolean[] primeTable = new boolean[n];
		for (int i = 2; i < n; i++)
			primeTable[i] = true;

		for (int j = 2; j <= Math.sqrt(n); j++) {
			if (primeTable[j])
				for (int i = j + j; i < n; i += j)
					primeTable[i] = false;
		}
		int count = 0;
		for (int i = 2; i < primeTable.length; i++) {
			if (primeTable[i]) {
				count++;
			}
		}
		return count;
	}
}
