package dynamicProgramming;

import java.util.Arrays;
import java.util.OptionalInt;

public class MaxSumWithNoTwoContiguos {

	public static void main(String[] args) {
		final int arr[] = new int[] { -2, -11, -4, -13, -5, 2, 0, 1 };
		System.out.println(maxContiguosSubsequenceUsingDP2(arr));
	}

	private static OptionalInt maxContiguosSubsequenceUsingDP2(int[] arr) {

		// m[0] = max{a[i] ,if i==0}
		// m[1]= max{a[1],a[0]}
		// m[i]=max{a[i]+m[i-2],m[i-1]}
		// here m[i] denotes sum_ending here for i=i to n
		// more over , if the sum ending here becomes <0we update it as 0 else,let it
		// flow.
		final int n = arr.length;
		if (n == 0) {
			return null;
		}

		final int m[] = new int[n];
		m[0] = arr[0];
		m[1] = Math.max(arr[0], arr[1]);

		for (int i = 2; i < n; i++) {
			m[i] = Math.max(arr[i] + m[i - 2], m[i - 1]);

		}

		return Arrays.stream(m).max();
	}
}
