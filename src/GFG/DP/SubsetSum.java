package dynamicProgramming;

public class SubsetSum {

	public static void main(String[] args) {
		final int s[] = new int[] { 1, 2, 3, 4, 5 };
		final int c = 21;
		System.out.println(subsetSum(s, c));
	}

	private static boolean subsetSum(int[] a, int k) {
		// TODO Auto-generated method stub

		final int n = a.length;

		final boolean[][] m = new boolean[n + 1][k + 1];
		// the definition of m[i][j] is that where the subset exists at i,j with i as
		// the no of elements available frm left to right and j
		for (int i = 0; i <= n; i++) {

			for (int j = 0; j <= k; j++) {
				if (i == 0 && j == 0) {
					m[0][0] = true;
				} else if (i == 0) {
					m[0][j] = false;

				} else if (j == 0) {
					m[i][0] = true;
				} else if (j >= a[i - 1]) {
					m[i][j] = m[i - 1][j] || m[i - 1][j - a[i - 1]];
				} else {
					m[i][j] = m[i - 1][j];
				}

			}
		}
		return m[n][k];
	}
}
