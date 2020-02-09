package dynamicProgramming;

public class MinJumps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minJumps(new int[] { 4, 3, 1, 1, 3, 24, 41, 2, 3, 4, 5, 5, 34, 54, 2, 2, 3, 2, 2, 222, 4 }));
	}

	private static int minJumps(int[] a) {
		// TODO Auto-generated method stub
		final int n = a.length;
		final int[] l = new int[n];
		for (int k = 0; k < n; k++) {
			l[k] = Integer.MAX_VALUE;
		}
		if (n == 0) {
			return 0;
		}
		// lets keep a l[] sch that l[i] represents min jumps to reach at ith index.
		for (int i = 0; i < n; i++) {
			if (i == 0) {

				l[i] = 0;
			} else {

				for (int j = 0; j < i; j++) {
					if (a[j] >= i - j) {
						l[i] = Math.min(1 + l[j], l[i]);
					}

				}
			}

		}
		return l[n - 1];
	}

}
