package sorting;

import java.util.Arrays;

public class QuickSort {
	public static void main(String a[]) {
		final int arr[] = new int[] { 3, 30, 34, 5, 9 };
		System.out.println(Arrays.toString(quickSort(arr, 0, arr.length - 1)));
	}

	private static int[] quickSort(int a[], final int l, final int h) {
		int p;
		if (l < h) {
			p = partition(a, l, h);
			quickSort(a, l, p - 1);
			quickSort(a, p + 1, h);
		}
		return a;
	}

	private static int partition(int[] A, final int low, final int high) {
		int left, right;
		final int pivot_item = A[low];
		left = low;
		right = high;
		while (left < right) {
			// Move left while item < pivot
			while (A[left] <= pivot_item) {
				left++;
			}
			// Move right while item > pivot
			while (A[right] > pivot_item) {
				right--;
			}
			if (left < right) {
				swap(A, left, right);
			}
		}
		// right is final position for the pivot
		A[low] = A[right];
		A[right] = pivot_item;
		return right;
	}

	static int partition2(int arr[], int low, int high) {
		final int pivot = arr[high];
		int i = low - 1; // index of smaller element
		for (int j = low; j < high; j++) {
			// If current element is smaller than or
			// equal to pivot
			if (myCompare(arr[j], pivot)) {
				i++;

				// swap arr[i] and arr[j]
				final int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		// swap arr[i+1] and arr[high] (or pivot)
		final int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		return i + 1;
	}

	private static void swap(int[] A, int left, int right) {
		int temp = 0;
		temp = A[left];
		A[left] = A[right];
		A[right] = temp;
	}

	private static boolean myCompare(Integer a, Integer b) {
		// appending 2 integers may cause overflow so we keep the result in long

		final Long ab = Long.parseLong(a + "" + b);
		final Long ba = Long.parseLong(b + "" + a);
		if (ab >= ba) {
			return true;
		} else {
			return false;
		}
	}
}
