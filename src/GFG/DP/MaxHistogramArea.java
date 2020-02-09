package dynamicProgramming;

import java.util.Scanner;
import java.util.Stack;

class MaxHistogramArea {

	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(); // t<=60
		// sc.useDelimiter("\n");
		int[] s;
		while (t-- > 0) {
			final int g = sc.nextInt();
			s = new int[g];
			for (int i = 0; i < g; i++) {
				s[i] = sc.nextInt();
			}
			System.out.println(maxHistogram(s));

		}
		// System.exit(0);

	}

	private static int maxHistogram(int[] a) {
		// TODO Auto-generated method stub
		int max = 0;
		int area = 0;
		int top;
		final Stack<Integer> s = new Stack<>();
		int i;
		final int n = a.length;

		for (i = 0; i < n;) {
			// if stack is empty of element is bigger then insert
			if (s.isEmpty() || a[i] >= a[s.peek()]) {
				s.push(i++);
			} else {
				top = s.pop();
				if (s.isEmpty()) {
					// herei is the right index and s.peek() is the left index.for 1 bar, which is
					// at 4, i =5, s.peek = 3.we multi ply it by 1 5-3-1 .If stack is empty we take
					// s.peek = -1
					area = a[top] * i;
				} else {
					area = a[top] * (i - s.peek() - 1);
				}
				max = Math.max(area, max);
			}

		}
		while (!s.isEmpty()) {
			top = s.pop();
			if (s.isEmpty()) {
				// herei is the right index and s.peek() is the left index.for 1 bar, which is
				// at 4, i =5, s.peek = 3.we multi ply it by 1 5-3-1
				area = a[top] * i;
			} else {
				area = a[top] * (i - s.peek() - 1);
			}
			max = Math.max(area, max);

		}

		return max;
	}

}
