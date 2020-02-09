package dynamicProgramming;

import java.util.Arrays;

public class ZeroOneKnapsackWithoutDuplicate {

	public static void main(String[] args) {
		final int v[] = new int[] { 2, 3, 4, 13, 15 };
		final int s[] = new int[] { 1, 2, 3, 4, 5 };
		final int c = 11;
		System.out.println(maxValWithCapC(v, s, c));
	}

	private static int maxValWithCapC(int[] v, int[] s, int c) {
		// TODO Auto-generated method stub
		if (c <= 0) {
			return 0;
		}
		final int n = s.length;
		final int T[][] = new int[c + 1][n + 1];
		// i denotes the size available
		for (int i = 0; i <= c; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					T[i][j] = 0;
				} else {

					// either to include i element or not
					// if included max(v[i]+ t[i-s[i]],t[i-1])
					if (s[j - 1] <= i) {
						T[i][j] = Math.max(v[j - 1] + T[i - s[j - 1]][j - 1], T[i][j - 1]);
					} else {
						T[i][j] = T[i][j - 1];
					}
				}
			}
		}
		for (int h = 0; h <= c; h++) {
			System.out.println(Arrays.toString(T[h]));
		}
		return T[c][n];

	}

}
