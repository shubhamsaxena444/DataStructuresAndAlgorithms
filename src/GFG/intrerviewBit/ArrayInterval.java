package intrerviewBit;

import java.util.Scanner;

public class ArrayInterval {

	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);
		final int n = sc.nextInt();
		final int a[] = new int[n];
		final int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();

		}
		// input point
		final int x = sc.nextInt();
		final int y = sc.nextInt();
		// given that int points a[],b[] is sorted by start time.
		printMergedInterval(a, b, x, y, n);
	}

	private static void printMergedInterval(int[] a, int[] b, int x, int y, int n) {
		// find interval of x and y
		// binary search that returns index of interval.
		final int indexFirst = intervalBinarySearch(a, b, x, 0, n - 1);
		final int indexSecond = intervalBinarySearch(a, b, y, 0, n - 1);
		// new interval is non overlapping
		if (indexFirst == -1 && indexSecond == -1) {
			// find right position of x
			final int rpx = discreateIndexRightPosition(a, x, n);
			final int rpy = discreateIndexRightPosition(b, y, n);
			for (int i = 0; i < rpx; i++) {
				System.out.print(a[i] + " " + b[i] + " ");
			}
			// print x and y
			System.out.print(x + " " + y + " ");
			for (int i = rpy; i < n; i++) {
				System.out.print(a[i] + " " + b[i] + " ");
			}
		} else if (indexSecond == -1) {
			// first index lies somewhere
			final int rpy = discreateIndexRightPosition(b, y, n);

			for (int i = 0; i < indexFirst; i++) {
				System.out.print(a[i] + " " + b[i] + " ");
			}
			System.out.print(a[indexFirst] + " " + y + " ");
			for (int i = rpy; i < n; i++) {
				System.out.print(a[i] + " " + b[i] + " ");
			}
		} else if (indexFirst == -1) {
			// second index lies somewhere
			final int rpx = discreateIndexRightPosition(a, x, n);
			for (int i = 0; i < rpx; i++) {
				System.out.print(a[i] + " " + b[i] + " ");
			}
			System.out.print(x + " " + b[indexSecond] + " ");
			for (int i = indexSecond + 1; i < n; i++) {
				System.out.print(a[i] + " " + b[i] + " ");
			}
		} else {
			// both index lies somewhere
			for (int i = 0; i < indexFirst; i++) {
				System.out.print(a[i] + " " + b[i] + " ");
			}
			System.out.print(a[indexFirst] + " " + b[indexSecond] + " ");
			for (int i = indexSecond + 1; i < n; i++) {
				System.out.print(a[i] + " " + b[i] + " ");
			}
		}
		System.out.println();
	}

	private static int intervalBinarySearch(int[] a, int[] b, int x, int i, int j) {
		if (i <= j) {
			final int mid = (i + j) / 2;

			if (a[mid] <= x && x <= b[mid]) {
				// means we have found it
				return mid;

			} else if (x < a[mid]) {
				return intervalBinarySearch(a, b, x, i, mid - 1);
			} else {
				return intervalBinarySearch(a, b, x, mid + 1, j);
			}
		}
		return -1;
	}

	private static int discreateIndexRightPosition(int[] arr, int x, int n) {
		int i;
		for (i = 0; i < n && x > arr[i]; i++) {
			;
		}
		return i;
	}
}