package dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int A[] = new int[] { 1, 3, 4, 5, 6, 7, 8, 3, 2, 32, 4, 56, 67, 234 };
		final int B[] = new int[] { 1234, 5, 6, 723, 3, 2, 32, 2323, 56, 673, 234 };

		System.out.println(LCSLength(A, B));

	}

	private static List<Integer> LCSLength(int[] a, int[] b) {
		final List<Integer> list = new ArrayList<>();
		final int n = a.length;
		final int m = b.length;
		final int memo[][] = new int[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				if (i == 0 || j == 0) {
					memo[i][j] = 0;
				} else if (a[i - 1] == b[j - 1]) {
					memo[i][j] = 1 + memo[i - 1][j - 1];
					// list.add(a[i - 1]);
				} else {
					memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
				}

			}
		}
		for (int i = n; i > 0;) {
			for (int j = m; j > 0;) {
				if (i > 0 && memo[i][j] == memo[i - 1][j - 1] + 1 && a[i - 1] == b[j - 1]) {
					list.add(a[i - 1]);
					i--;
					j--;
				} else if (i > 0 && memo[i][j] == memo[i - 1][j]) {
					i--;
				} else {
					j--;
				}
			}

		}
		return list;
	}

}
