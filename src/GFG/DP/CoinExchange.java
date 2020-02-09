package dynamicProgramming;

import java.util.Arrays;

public class CoinExchange {

	public static void main(String[] args) {
		final int v[] = new int[] { 2, 3, 4, 13, 15 };
		final int s[] = new int[] { 1, 2, 5, 10, 20, 50, 100 };
		final int c = 1117;
		System.out.println(maxValWithCapCUnbounded(s, c));
	}

	private static int minCoins(int[] s, int c) {
		// let m[i] denote the min number of coins required to make change for i.
		// for i =0 , we need 0 coinsL
		final int m[] = new int[c + 1];
		final int n = s.length;
		for (int i = 1; i <= c; i++) {
			m[i] = Integer.MAX_VALUE;
			for (int j = 0; j < n; j++) {
				if (s[j] > 0) {
					m[i] = Math.min(m[i], i / s[j] + m[i % s[j]]);
				}

			}

		}
		System.out.println(Arrays.toString(m));
		return m[c];
	}

	private static int maxValWithCapCUnbounded(int[] s, int c) {
		final int n = s.length;
		final int v = -1;
		final int t[] = new int[c + 1]; // indicates,maxvalue of t[i] using all available items.
		// for bottom up approach , we start filling t[i] fro 0.
		t[0] = 0;
		for (int i = 1; i <= c; i++) {
			t[i] = Integer.MIN_VALUE;
			for (int j = 0; j < n; j++) // j is for the item we have,we may either include that ite, or not,
			{
				if (s[j] <= i) {
					t[i] = Math.max(t[i], v + t[i - s[j]]);
				}
			}

		}

		return Math.abs(t[c]);
	}

}
