package dynamicProgramming;

import java.util.Scanner;

public class LongestPalindrameSubstring {
	static int[][] l;

	public static void main(String[] args) {
		// final char s[] = new char[] { 'a', 'g', 't', 'c', 'b', 'm', 'a', 'c', 't',
		// 'g', 'g', 'a', 'm' };
		final Scanner sc = new Scanner(System.in);
		final int t = sc.nextInt(); // t<=60
		sc.useDelimiter("\n");
		final String s[] = new String[t];
		for (int i = 0; i < t; i++) {
			s[i] = sc.next();
		}
		for (int i = 0; i < t; i++) {
			System.out.println(lps(s[i].toCharArray()));
		}
	}

	private static int lps(char[] s) {
		// TODO Auto-generated method stub
		final int n = s.length;
		if (n == 0) {
			return 0;
		}
		// lets keep l[i][j] such that i is the starting index and j is the end
		// index.and it denotes if a substring is a palindrame or not.
		l = new int[n][n];
		// subsequently , lps will be 1 && l[i+1][j-1] or 0
		int max = 1;
		for (int gap = 0; gap < n; gap++) {
			for (int i = 0, j = gap; j < n; j++, i++) {
				if (j == i) {
					// if we have length 1, ie i=j, then lps will be 1.

					l[i][j] = 1;
				} else {
					if (s[i] == s[j]) {
						if (j == i + 1) {
							l[i][j] = 1;
						} else {
							l[i][j] = 1 & l[i + 1][j - 1];
						}
					} else {
						l[i][j] = 0;
					}
				}

			}
		}
		// PrintDP.printDP(l);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (l[i][j] == 1) {
					if (Math.abs(i - j) > max) {
						max = Math.abs(i - j);
					}
				}
			}
		}
		return max + 1;
	}

}
