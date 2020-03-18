package GFG.backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class permutationViaBacktracking {

	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);
		final String s = sc.nextLine();
		permutation(s.toCharArray(), 0, s.length() - 1);

	}

	private static void permutation(char[] s, int l, int h) {
		// if length is 1 ,then return the string;
		if (l == h) {
			System.out.println(Arrays.toString(s));
		}
		for (int i = l; i < s.length; i++) {
			swap(s, i, l);
			permutation(s, l + 1, s.length - 1);
			swap(s, l, i); // backtrack
		}
	}

	private static char[] swap(char[] c, int l, int i) {
		final char t = c[l];
		c[l] = c[i];
		c[i] = t;
		return c;
	}

}
