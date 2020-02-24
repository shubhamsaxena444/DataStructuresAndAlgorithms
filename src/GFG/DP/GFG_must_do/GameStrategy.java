package GFG.DP.GFG_must_do;

import utils.Util;

public class GameStrategy {
	static int dp[][];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int a[] = new int[] { 2, 14, 3, 1 };
		final int n = a.length;
		dp = new int[n + 1][n + 1];
		System.out.println(maximiseValueTopDown(a, 0, 3));
	}

	private static int maximiseValueTopDown(int[] a, int i, int j) {
		final int n = a.length;
		Util.printDP(dp);
		if (i == j || i > j) {
			if (i >= 0 && j >= 0) {
				dp[i][j] = 0;
				return dp[i][j];

			} else {
				dp[0][0] = 0;
				return dp[0][0];
			}
		} else if (dp[i][j] == 0) {
			dp[i][j] = Math.max(
					a[i] + Math.min(maximiseValueTopDown(a, i + 2, j), maximiseValueTopDown(a, i + 1, j - 1)),
					a[j] + Math.min(maximiseValueTopDown(a, i + 1, j - 1), maximiseValueTopDown(a, i, j - 2)));
		}
		return dp[i][j];
	}

	private static int maximiseValue(int[] a) {
		// TODO Auto-generated method stub
		// lets keep a memoo table.m
		final int n = a.length;
		final int m[][] = new int[n][n];
		// here m[i][j] indicates the maximum value with start index i and end index j.
		// we will have to fill the array diagnally .This logic is important.
		for (int gap = 0; gap < n; gap++) {
			for (int i = 0, j = gap; j < n; j++, i++) {
				// we know that when i and j are same, then m[i][j] = a[i]
				if (j == i) {
					m[i][j] = a[i];
				} else if (j == i + 1) {
					m[i][j] = Math.max(a[i], a[j]);

				} else {

					// logic
					m[i][j] = Math.max(a[i] + Math.min(m[i + 1][j - 1], m[i + 2][j]),
							a[j] + Math.min(m[i + 1][j - 1], m[i][j - 2]));
				}

			}

		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print("    " + m[i][j]);
			}
			System.out.println();
		}

		return m[0][n - 1];
	}

}
