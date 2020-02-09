package dynamicProgramming;

import java.util.Scanner;

import utils.Util;

class MAtrixChainMultiplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Scanner sc = new Scanner(System.in);
		int t;
		final int TC = sc.nextInt();
		final int p[][] = new int[TC][];
		for (int k = 0; k < TC; k++) {
			t = sc.nextInt(); // t<=60
			p[k] = new int[t];
			for (int i = 0; i < t; i++) {
				p[k][i] = sc.nextInt();
			}
		}
		for (int k = 0; k < TC; k++) {

			System.out.println(findCost(p[k]));
		}
	}

	public static int findCost(int arr[]) {
		final int temp[][] = new int[arr.length][arr.length];
		int q = 0;
		for (int l = 2; l < arr.length; l++) {
			for (int i = 0; i < arr.length - l; i++) {
				final int j = i + l;
				temp[i][j] = Integer.MAX_VALUE;
				for (int k = i + 1; k < j; k++) {
					q = temp[i][k] + temp[k][j] + arr[i] * arr[k] * arr[j];
					if (q < temp[i][j]) {
						temp[i][j] = q;
						Util.printDP(temp);
						System.out.println("*******************************************");
					}
				}
			}
		}
		return temp[0][arr.length - 1];
	}

	private static int minCost(int[] p) {

		// TODO Auto-generated method stub
		// lets maintain a table l[i][j], such that l[i][j] represents the min cost to
		// multiply matrix between i and j.
		// ex., we have ABCD l[0][1] is the min cost to mulity AB.. and so on and so
		// forth.

		// our matrix p[i] represents matrices from i+1, therefore each matrix a[i] has
		// dimentions p[i-1] and p[i].
		final int n = p.length - 1; // its the number of matrices we have.
		if (n <= 1) {
			return 0;
		}
		final int L[][] = new int[n][n];
		for (int gap = 0; gap < n; gap++) {
			for (int i = 0, j = gap; j < n; i++, j++) {
				// for every i ==j , we have cost =0;
				if (j == i) {
					L[i][j] = 0;
				} else {
					// done carefully.assumption A[i] = p[i+1] and dimentions are p[i] and p[i+1]
					L[i][j] = Integer.MAX_VALUE;
					for (int k = i + 1; k < j; k++) {
						L[i][j] = Math.min(L[i][j], L[i][k] + L[k][j] + p[i] * p[k] * p[j + 1]);

					}

					// L[i][j] = Math.min(L[i][j - 1] + p[i] * p[j] * p[j + 1], p[i] * p[i + 1] *
					// p[j + 1] + L[i + 1][j]);
				}

			}

		}
		Util.printDP(L);
		return L[0][n - 1];
	}

}
