package dynamicProgramming;

import java.util.Scanner;

public class TileDominoes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findMax(new Scanner(System.in).nextInt()));
	}

	private static int findMax(int n) {
		// TODO Auto-generated method stub
		// since height is fixed as 4
		if (n <= 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else if (n == 2) {
			return 5;
		} else {
			return 2 * findMax(n - 1) + 1 * findMax(n - 2);

		}
	}

}
