package GFG.DP.GFG_must_do;

public class UnboundedZeroOneKnapsack {

	public static void main(String[] args) {
		final int v[] = new int[] { 2, 3, 4, 13, 15 };
		final int s[] = new int[] { 1, 2, 3, 4, 5 };
		final int c = 11;
		System.out.println(maxValWithCapCUnbounded(v, s, c));
	}

	private static int maxValWithCapCUnbounded(int[] v, int[] s, int c) {
		final int n = s.length;
		final int t[] = new int[c + 1]; // indicates,maxvalue of t[i] using all available items.
		// for bottom up approach , we start filling t[i] fro 0.
		t[0] = 0;
		for (int i = 1; i <= c; i++) {

			for (int j = 0; j < n; j++) // j is for the item we have,we may either include that ite, or not,
			{
				if (s[j] <= i) {
					t[i] = Math.max(t[i], v[j] + t[i - s[j]]);
				}
			}

		}

		return t[c];
	}

}
