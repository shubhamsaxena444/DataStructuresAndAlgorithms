package GFG.graphs;

import java.util.Arrays;
import java.util.Scanner;

import utils.Util;

public class AdjacencyMatrix {
	static int v; // no of vertices
	static int e; // no of edges
	static int m[][];

	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);

		v = sc.nextInt();

		e = sc.nextInt();
		m = new int[v][v];
		final char[] ver = new char[v];
		int i = 0;
		while (v-- > 0) {
			final String f = sc.next();
			ver[i++] = f.charAt(0);
		}
		int ii;
		int j;
		while (e-- > 0) {
			ii = sc.nextInt();
			j = sc.nextInt();
			m[ii][j] = 1;
			m[j][ii] = 1;
		}
		System.out.println(Arrays.toString(ver));
		Util.printDP(m);
	}
}
