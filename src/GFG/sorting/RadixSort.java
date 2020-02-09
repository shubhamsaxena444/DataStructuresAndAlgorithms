package sorting;

import java.util.Arrays;

import utils.Util;

public class RadixSort {

	public static void main(String[] args) {
		final int T;
		final int input[][] = Util.inputTArraysShort();
		T = input.length;
		for (short i = 0; i < T; i++) {

			System.out.println(Arrays.toString(radixSort(input[i])));
		}
	}

	private static int[] radixSort(int[] a) {
		// call counting sort for digits starting from LSB to MSB.

		final int k = 9; // if base is 10
		final int n = a.length;
		// we use counting ort when n is almost equal to k.
		// usually used as a subroutine to radix sort.
		// output array
		int d = 1;
		while (0 < Arrays.stream(a).max().getAsInt() / d) {
			countSubroutine(a, k, n, d);
			d *= 10;
		}
		return a;
	}

	/**
	 * @param a
	 * @param k
	 * @param n
	 * @param d
	 */
	public static void countSubroutine(int[] a, final int k, final int n, int d) {
		final int b[] = new int[n];
		// used to store count and then actual position of the element.
		final int c[] = new int[k + 1];
		Arrays.fill(c, 0);
		for (int i = 0; i < n; i++) {

			c[a[i] / d % 10]++;
			// now c contains element frequency.
		}

		for (int i = 1; i <= k; i++) {
			c[i] = c[i - 1] + c[i];
			// now contains position
		}
		// time to fill output array. this is important the order of filling the array
		for (int i = n - 1; i >= 0; i--) {
			b[c[a[i] / d % 10] - 1] = a[i];// -1 is done for getting index
			c[a[i] / d % 10]--; // decrease the count of position for next duplicate element
		}

		for (int i = 0; i < n; i++) {
			a[i] = b[i];
			// free b
		}
	}
}