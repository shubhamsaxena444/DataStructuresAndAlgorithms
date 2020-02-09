package dynamicProgramming;

import java.util.Scanner;

public class a2oj1JoystickProbllem {
	// Top down recursion.
	final static int dp[][] = new int[101][101];
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		System.out.println(joystick(sc.nextInt(), sc.nextInt()));
	}

	private static int joystick(int n, int m) {
		if (n > 100) {
			n = 100;
		}
		if (m > 100) {
			m = 100;
		}
		if (n <= 0 || m <= 0) {
			dp[0][0] = 0;
			return 0;
		} else if (n == 1 && m == 1) {
			dp[n][m] = 0;
		} else if (dp[n][m] == 0) {
			dp[n][m] = 1 + Math.max(joystick(n - 2, m + 1), joystick(n + 1, m - 2));
		}
		return dp[n][m];
	}

}
