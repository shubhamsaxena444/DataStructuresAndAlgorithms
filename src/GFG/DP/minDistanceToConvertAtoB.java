package dynamicProgramming;

import java.util.Scanner;

public class minDistanceToConvertAtoB {

	public static void main(String[] args) {

		final Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			final int m = sc.nextInt();
			final int n = sc.nextInt();
			String str1 = "";
			String str2 = "";

			str1 = sc.next();
			str2 = sc.next();
			System.out.println(editDist(str1, str2));

		}
		// System.out.println(editDist("ABC", "BAC"));
	}

	private static int editDist(String str1, String str2) {
		// Create a table to store results of subproblems
		final int m = str1.length();
		final int n = str2.length();
		final int dp[][] = new int[m + 1][n + 1];

		// Fill d[][] in bottom up manner
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				// If first string is empty, only option is to
				// isnert all characters of second string
				if (i == 0) {
					dp[i][j] = j; // Min. operations = j
				} else if (j == 0) {
					dp[i][j] = i; // Min. operations = i
				} else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = 1 + Math.min(dp[i][j - 1], // Insert
							Math.min(dp[i - 1][j], // Remove
									dp[i - 1][j - 1])); // Replace
				}
			}
		}
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				System.out.print("  " + dp[i][j]);
			}
			System.out.println();
		}
		return dp[m][n];
	}

}
