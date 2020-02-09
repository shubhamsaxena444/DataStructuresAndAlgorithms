package sorting;

import java.util.Arrays;

import utils.Util;

public class CountingSort {

	public static void main(String[] args) {
		final int T;
		final int input[][] = Util.inputTArraysShort();
		T = input.length;
		for (short i = 0; i < T; i++) {

			System.out.println(Arrays.toString(countSort(input[i])));
		}
	}

	private static int[] countSort(int[] a) {
		final int k = Arrays.stream(a).max().getAsInt();
		final int n = a.length;
		// we use counting ort when n is almost equal to k.
		// usually used as a subroutine to radix sort.
		// output array
		final int b[] = new int[n];
		// used to store count and then actual position of the element.
		final int c[] = new int[k + 1];
		Arrays.fill(c, 0);
		for (int i = 0; i < n; i++) {

			c[a[i]]++;
			// now c contains element frequency.
		}

		for (int i = 1; i <= k; i++) {
			c[i] = c[i - 1] + c[i];
			// now contains position
		}
		// time to fill output array.
		for (int i = n - 1; i >= 0; i--) {
			b[c[a[i]] - 1] = a[i];// -1 is done for getting index
			c[a[i]]--;
		}
		for (int i = n - 1; i >= 0; i--) {
			a[i] = b[i];
			// free b
		}
		return a;
	}

}
