package utils;

import java.util.Scanner;

public class Util {
	/**
	 * this method is used to print dp table.
	 * 
	 * @param dp
	 */
	public static void printDP(int[][] dp) {
		System.out.println();
		final int n = dp.length;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print("  " + dp[i][j]);
			}
			System.out.println();
		}
	}

	/**
	 * @return
	 */
	public static int[][] inputTArraysShort() {
		final int T;
		final int input[][];
		final Scanner sc = new Scanner(System.in);
		// sc.useDelimiter("\n");
		T = sc.nextInt();
		input = new int[T][];
		int N;
		for (int i = 0; i < T; i++) {
			N = sc.nextInt();
			input[i] = new int[N];
			for (int j = 0; j < N; j++) {
				input[i][j] = sc.nextInt();
			}

		}
		return input;
	}
}
