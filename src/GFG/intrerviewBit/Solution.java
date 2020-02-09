package intrerviewBit;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	public static void main(String a[]) {
		final Solution s = new Solution();
		System.out.println("z" + s.plusOne(new ArrayList(Arrays.asList(9, 9, 0, 9, 8))));
	}

	public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
		// the idea is to reverse the array.
		A = reverse(A);
		int carry = (1 + A.get(0)) / 10;
		A.set(0, (A.get(0) + 1) % 10);
		// add 1 maintaining a carry .
		int sum;
		for (int i = 1; i < A.size(); i++) {
			sum = carry + A.get(i);
			A.set(i, sum % 10);
			carry = sum / 10;

		}

		// if we are left with carry 1 and size of array is exhauted we insert 1 .
		if (carry == 1) {
			A.add(carry);
		}
		// remove last 0 .
		int n = A.size();
		while (n > 1 && A.get(n - 1) == 0) {
			A.remove(n - 1);
			n = n - 1;
		}
		// again reverse the array.
		return reverse(A);
	}

	private ArrayList<Integer> reverse(ArrayList<Integer> A) {
		for (int i = 0, j = A.size() - 1; i < j; i++, j--) {
			final int temp = A.get(i);
			A.set(i, A.get(j));
			A.set(j, temp);
		}
		A.sort(null);
		final Integer a[] = (Integer[]) A.toArray();
		return A;
	}
}
