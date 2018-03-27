package niuke2016;

import org.junit.Test;

public class findMaxOnce {
	@Test
	static int[] findMaxOnceTest(int[] A, int n) {
		int[] res = null;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int max = A[j] - A[i];
				res[i] = Math.max(res[i], max);
			}
		}
		return res;
	}
}
