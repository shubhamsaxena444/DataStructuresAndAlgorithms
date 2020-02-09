package chap10;

public class SearchRotated {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(searchRetated(new int[] { 15, 16, 9, 20, 25, 1, 3, 4, 5, 7, 10, 14 }, 0, 11, 5));
	}

	public static int searchRetated(int a[], int l, int h, int k) {
		final int m = (l + h) / 2;
		if (a[m] == k) {
			return m;
		} else if (a[m] < k) {
			if (a[h] > k) {
				return searchRetated(a, m + 1, h, k);
			} else {
				return searchRetated(a, l, m - 1, k);
			}
		} else {
			if (a[l] < k) {
				return searchRetated(a, l, m - 1, k);
			} else {
				return searchRetated(a, m + 1, h, k);
			}

		}

	}

}
