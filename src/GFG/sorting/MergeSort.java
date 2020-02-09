package sorting;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int arr[] = new int[] { 6, 4, 3, 2, 1, 55, 6, 4, 22, 33, 4, -12, 0, 0, 0 };
		System.out.println(Arrays.toString(mergeSort(arr, 0, arr.length - 1)));
	}

	private static int[] mergeSort(int a[], int l, int h) {
		int m;
		if (l < h) {
			m = (l + h) / 2;
			mergeSort(a, l, m);
			mergeSort(a, m + 1, h);
			merge(a, l, m + 1, h);

		}

		return a;
	}

	private static void merge(int[] a, int l, int m, int h) {
		final int t[] = new int[h - l + 1];
		final int s1 = m - 1;
		final int low = l;
		final int high = h;

		int k = 0;
		while (l <= s1 && m <= h) {
			if (a[l] <= a[m]) {
				t[k++] = a[l++];
			} else {
				t[k++] = a[m++];
			}
		}
		while (l <= s1) {
			t[k++] = a[l++];
		}
		while (m <= h) {
			t[k++] = a[m++];
		}
		for (int i = low; i <= high; i++) {
			a[i] = t[i - low];
		}
	}
}
