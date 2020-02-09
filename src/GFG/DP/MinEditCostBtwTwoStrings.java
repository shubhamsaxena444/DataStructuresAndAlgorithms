package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinEditCostBtwTwoStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// provided two strings
		final List<Character> A = new ArrayList<>(Arrays.asList('l', 'b', 'c'));
		final List<Character> B = new ArrayList<>(Arrays.asList('b', 'l', 'c'));
		final int ci = 1; // insert
		final int cr = 1; // replace
		final int cd = 1;// delete
		System.out.println(minCostPath(A, B, ci, cr, cd));
	}

	private static int minCostPath(List<Character> a, List<Character> b, int ci, int cr, int cd) {
		// TODO Auto-generated method stub
		// let m[i][j] denote the min cost of converting a of size i into b of size j.
		final int l1 = a.size();
		final int l2 = b.size();
		// there are three cases if size of a = b (cr), a>b (cd), a<b (ci)

		final int m[][] = new int[l1 + 1][l2 + 1];
		// base cases.
		// if both the lists have 0 size, then m[0][0] =0;
		// if a has 0 size, then m[0][j] = j*ci
		// if b has 0 size, then m[i][0] = i*cd
		for (int i = 0; i <= l1; i++) {
			for (int j = 0; j <= l2; j++) {
				if (i == 0 && j == 0) {
					m[i][j] = 0;
				} else if (i == 0) {
					m[0][j] = ci * j;
				} else if (j == 0) {
					m[i][0] = cd * i;
				} else if (a.get(i - 1) == b.get(j - 1)) {
					m[i][j] = m[i - 1][j - 1];
				} else {
					// case 1:same length
					// case 2:more length
					// case 3:less length
					m[i][j] = Math.min(ci * 1 + m[i][j - 1], Math.min(cd * 1 + m[i - 1][j], cr + m[i - 1][j - 1]));

				}
			}

		}

		for (int i = 0; i <= l1; i++) {
			for (int j = 0; j <= l2; j++) {
				System.out.print(" " + m[i][j]);
			}
			System.out.println();
		}
		return m[l1][l2];
	}

}
