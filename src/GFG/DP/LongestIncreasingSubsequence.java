package dynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		final int s[] = new int[] { 5, 6, 2, 3, 4, 1, 9, 9, 8, 9, 5 };
		System.out.println(lis(s));
	}

	private static int lis(int[] s) {
		final int n = s.length;
		// here m[i] denotes the length of lis starting from i=0and ending at i
		final int m[] = new int[n + 1];
		// the length will at least be 1
		for (int i = 0; i < n; i++) {
			m[i] = 1;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (s[i] > s[j]) {
					m[i] = Math.max(m[i], m[j] + 1);

				}
			}
		}
		System.out.println(Arrays.toString(m));
		return Arrays.stream(m).max().getAsInt();
	}

}
