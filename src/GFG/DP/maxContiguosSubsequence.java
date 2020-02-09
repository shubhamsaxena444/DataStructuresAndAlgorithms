package dynamicProgramming;

import java.util.Arrays;
import java.util.OptionalInt;

public class maxContiguosSubsequence {

	public static void main(String[] args) {
		final int arr[] = new int[] { -2, -11, -1, -13, -5, -2 };
		System.out.println(maxContiguosSubsequenceUsingDP1(arr));
	}

	private static int maxContiguosSubsequenceUsingDP(int[] arr) {

		// m[0] = max{a[i] ,if i==0}
		// m[1]= max{a[1]+m[0],0}
		// m[i]=max{a[i]+m[i-1],0}
		// here m[i] denotes sum_ending here for i=0 to i
		// more over , if the sum ending here becomes <0we update it as 0 else,let it
		// flow.
		final int n = arr.length;
		if (n == 0) {
			return -1;
		}

		final int m[] = new int[n];
		m[0] = Math.max(0, arr[0]);
		for (int i = 1; i < n; i++) {
			m[i] = Math.max(arr[i] + m[i - 1], 0);

		}

		return m[n - 1];
	}

	private static OptionalInt maxContiguosSubsequenceUsingDP1(int[] arr) {

		// m[0] = max{a[i] ,if i==0}
		// m[1]= max{a[1]+m[0],0}
		// m[i]=max{a[i]+m[i-1],0}
		// here m[i] denotes sum_ending here for i=i to n
		// more over , if the sum ending here becomes <0we update it as 0 else,let it
		// flow.
		if (Arrays.stream(arr).allMatch(x -> x < 0)) {
			return Arrays.stream(arr).max();
		}
		final int n = arr.length;
		if (n == 0) {
			return null;
		}

		final int m[] = new int[n];
		m[n - 1] = Math.max(0, arr[n - 1]);
		for (int i = n - 2; i >= 0; i--) {
			m[i] = Math.max(arr[i] + m[i + 1], 0);

		}

		return Arrays.stream(m).max();
	}
}
